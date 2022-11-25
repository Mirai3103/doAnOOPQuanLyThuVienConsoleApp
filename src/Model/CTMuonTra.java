package Model;
import java.awt.print.Book;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
public class CTMuonTra implements ITableRowData,Serializable	{

		@Serial
		private static final long serialVersionUID = 40367639L;
	protected int IdPhieuMuon;
    protected int IDsach =-1;
    protected int datra = 0;
    protected LocalDate ngayhentra;
    protected LocalDate ngaytra = null;
    protected int loiPhatId = -1;

	public void setNgaytra(LocalDate ngaytra) {
		this.ngaytra = ngaytra;
	}

	public int getLoiPhatId() {
		return loiPhatId;
	}

	public void setLoiPhatId(int loiPhatId) {
		this.loiPhatId = loiPhatId;
	}

	public CTMuonTra()
    {
    	super();
    }
	public int getTienPhat() {
		if(loiPhatId == -1) return 0;
		var tienPhat =  TongHopDuLieu.getDanhSachXuPhat().getById(loiPhatId).getTienPhat();
		return tienPhat ==-1 ? getBook().getGiaSach() : tienPhat;
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
	public XuPhat getXuPhat() {
		if(loiPhatId == -1)
			return null;
		return TongHopDuLieu.getDanhSachXuPhat().getById(loiPhatId);
	}




	public CTMuonTra(int IdPhieuMuon, int IDsach, int datra, LocalDate ngayhentra, LocalDate ngaytra, int xuPhat)
    {
    	this.IdPhieuMuon=IdPhieuMuon;
    	this.IDsach=IDsach;
    	this.datra=datra;
    	this.ngayhentra=ngayhentra;
    	this.ngaytra=null;
    	this.loiPhatId = xuPhat;
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
		System.out.print("Nhập id lỗi phạt: ");
		this.loiPhatId = Helper.nhapSoNguyen("id phải là số nguyên");
    }
	@Override
	public String toString() {
		return "CTMuonTra [IdPhieuMuon=" + IdPhieuMuon + ", IDsach=" + IDsach + ", datra=" + datra + ", ghichu=" + getXuPhat().getTenLoi()+ ", ngaytra=" + ngaytra + "]";
	}

	public int getIDsach() {
		return IDsach;
	}

	public void setMasach(int IDsach) {
		this.IDsach = IDsach;
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
				this.getBook().getTenSach(),
	    		this.datra+"",
	    		this.ngayhentra.format(Helper.DATE_FORMAT),
	    		this.ngaytra == null ? "Chưa trả" : this.ngaytra.format(Helper.DATE_FORMAT),
	    		this.getXuPhat() == null ?"":this.getXuPhat().getTenLoi()
	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDmt","IDsach","Tên sách","Tình trạng", "Ngày hẹn trả","Ngày trả","Ghi chú"};
	 }

	public Sach getBook(){
		return TongHopDuLieu.getKhoSach().getById(this.IDsach);
	}
}
