package Model;
import java.awt.print.Book;
import java.io.Serializable;
import java.time.LocalDate;

import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
public class CTMuonTra implements ITableRowData {
	protected int IdPhieuMuon;
    protected int IDsach;
    protected int datra = 0;
    protected LocalDate ngayhentra;
    protected LocalDate ngaytra = null;
    protected String ghichu;
    public CTMuonTra()
    {
    	super();
    }

	public int getIdPhieuMuon() {
		return IdPhieuMuon;
	}

	public void setIdPhieuMuon(int idPhieuMuon) {
		IdPhieuMuon = idPhieuMuon;
	}

	public void setIDsach(int IDsach) throws RuntimeException {
	    var sach =	TongHopDuLieu.getKhoSach().getById(IDsach);
		if (sach.checkDangMuon())
			throw new RuntimeException("Sách đã được mượn");
		this.IDsach = IDsach;
		sach.setTheTVNguoiMuonId(IdPhieuMuon);
	}

	public LocalDate getNgayhentra() {
		return ngayhentra;
	}

	public void setNgayhentra(LocalDate ngayhentra) {
		this.ngayhentra = ngayhentra;
	}

	public LocalDate getNgaytra() {
		return ngaytra;
	}




	public CTMuonTra(int IdPhieuMuon, int IDsach, int datra, LocalDate ngayhentra, LocalDate ngaytra, String ghichu)
    {
    	this.IdPhieuMuon=IdPhieuMuon;
    	this.IDsach=IDsach;
    	this.datra=datra;
    	this.ngayhentra=ngayhentra;
    	this.ngaytra=null;
    	this.ghichu=ghichu;
    }
    public void nhapCTMuonTra()
    {

    	System.out.print("Nhập ngày hẹn trả(dd/MM/yyyy): ");
		String dateStr = "";
		do {
			dateStr = Helper.scanner.nextLine();
			if (Helper.checkNgayThang(dateStr)) {
				break;
			}
			System.out.println("nhập lại:");
		} while (true);
		this.ngayhentra = Helper.parseDate(dateStr);
		System.out.print("Nhập ghi chú: ");
		this.ghichu=Helper.scanner.nextLine();


    }
	@Override
	public String toString() {
		return "CTMuonTra [IdPhieuMuon=" + IdPhieuMuon + ", IDsach=" + IDsach + ", datra=" + datra + ", ghichu=" + ghichu + ", ngaytra=" + ngaytra + "]";
	}

	public int getIDsach() {
		return IDsach;
	}

	public void setMasach(int IDsach) {
		this.IDsach = IDsach;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public int getDatra() {
		return datra;
	}

	public void setDatra(int datra) {
		this.datra = datra;
	}
	@Override
	public String[] getRowData() {
	    return new String[]{
	    		this.IdPhieuMuon +"",
	    		this.IDsach+"", 
	    		this.datra+"",
	    		this.ngayhentra.format(Helper.DATE_FORMAT),
	    		this.ngaytra == null ? "Chưa trả" : this.ngaytra.format(Helper.DATE_FORMAT),
	    		this.ghichu
	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDmt","IDsach","Tình trạng", "Ngày hẹn trả","Ngày trả","Ghi chú"};
	 }

	public Sach getBook(){
		return TongHopDuLieu.getKhoSach().getById(this.IDsach);
	}
}
