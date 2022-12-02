package Model;
import java.awt.print.Book;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import Exceptions.SachDaMuonException;
import Repository.DanhSachCTMuonTra;
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
			throw new SachDaMuonException();
		this.IDsach = IDsach;
		sach.setTheTVNguoiMuonId(IdPhieuMuon);
	}
	public void showMenuSua() {
		System.out.println("1. Sửa ngày hẹn trả");
		System.out.println("2. trả sách");
		System.out.println("3. Sửa lỗi phạt");
		System.out.println("4. Xoá khỏi phiếu mượn");
		System.out.println("5. Thoát");
	}
	public void suaCTMuonTra() {
		int luaChon;
		do {
			showMenuSua();
			luaChon = Helper.nhapSoNguyen("Lua chon khong hop le, nhap lai: ");
			switch (luaChon) {
				case 1 -> {
					System.out.println("Nhập ngày hẹn trả mới");
					ngayhentra = Helper.inputDate();
				}
				case 2 -> {
					ngaytra = LocalDate.now();
					datra = 1;
					getBook().setTheTVNguoiMuonId(-1);
					TongHopDuLieu.getKhoSach().xuatFileBinary();
				}
				case 3 -> {
					TongHopDuLieu.getDanhSachXuPhat().xuatConsoleDangTable();
					System.out.println("Nhập id lỗi phạt ");
					loiPhatId = Helper.nhapSoNguyen("Id lỗi phạt không hợp lệ, nhập lại: ");

				}
				case 4 ->{
					TongHopDuLieu.getDanhSachCTMuonTra().getAll().remove(this);
					TongHopDuLieu.getDanhSachCTMuonTra().xuatFileBinary(DanhSachCTMuonTra.FILE_PATH);
				}
				case 5 -> System.out.println("Thoat");
				default -> System.out.println("Lua chon khong hop le, nhap lai: ");
			}
		} while (luaChon != 5);
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
		this.ngayhentra = Helper.inputDate();
//		System.out.print("Nhập id lỗi phạt: ");
//		this.loiPhatId = Helper.nhapSoNguyen("id phải là số nguyên");
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
		var phat = getXuPhat();
	    return new String[]{
	    		this.IdPhieuMuon +"",
	    		this.IDsach+"",
				this.getBook().getTenSach(),
	    		this.datra+"",
	    		this.ngayhentra.format(Helper.DATE_FORMAT),
	    		this.ngaytra == null ? "Chưa trả" : this.ngaytra.format(Helper.DATE_FORMAT),
				phat == null ?"":phat.getTenLoi(),
				phat == null ?"":phat.getTienPhat() ==-1?getBook().getGiaSach()+"":phat.getTienPhat()+""

	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDmt","IDsach","Tên sách","Tình trạng", "Ngày hẹn trả","Ngày trả","Ghi chú", "Tiền phạt"};
	 }

	public Sach getBook(){
		return TongHopDuLieu.getKhoSach().getById(this.IDsach);
	}

}
