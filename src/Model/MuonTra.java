package Model;
import java.awt.print.Book;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

public class MuonTra implements Serializable, ITableRowData{
		@Serial
		private static final long serialVersionUID = -23136354210367639L;
    protected  int IDmt;
    protected int IDthe;
    protected String IDnv;
    protected LocalDate ngayLapPhieu;
    public MuonTra()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		ngayLapPhieu = LocalDate.now();
    }
    public MuonTra(int IDmt, int IDthe, String IDnv, String ngaymuon) {
        this.IDthe=IDthe;
        this.IDnv=IDnv;
		var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.ngayLapPhieu= LocalDate.parse(ngaymuon, formatter);

    }
	@Override
	public String toString() {
		return "MuonTra [ID=" + IDmt + ", IDthe=" + IDthe + ", IDnv=" + IDnv + ", ngaymuon=" + ngayLapPhieu + "]";
	}

	public void setIDmt(int IDmt) {
		this.IDmt = IDmt;
	}

	public int getIDmt() {
		return IDmt;
	}
	public int getIDthe() {
		return IDthe;
	}
	public void setIDthe(int IDthe) {
		this.IDthe = IDthe;
	}
	public String getIDnv() {
		return IDnv;
	}
	public void setIDnv(String IDnv) {
		this.IDnv = IDnv;
	}
	public LocalDate getNgayLapPhieu() {
		return ngayLapPhieu;
	}
	 public  void nhapPhieuMuonTra()
	{
		while (true)
		{
			System.out.print("Nhập số thẻ: ");
			IDthe=Integer.parseInt(Helper.scanner.nextLine());
			var theTv =TongHopDuLieu.getDanhSachTheThuVien().getById(IDthe);
			if(theTv==null)
			{
				System.out.println("Không tìm thấy thẻ thư viện");
			}
			else
			{
				break;
			}
		}

	}

	@Override
	public String[] getRowData() {
	    return new String[]{
	           this.IDmt + "",
	           this.IDthe + "",
	           this.IDnv + "",
	           this.ngayLapPhieu.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDmt", "IDthe", "IDnv", "Ngày mượn"};
	 }
	 public ArrayList<CTMuonTra> getCTMuontras (){
		return  TongHopDuLieu.getDanhSachCTMuonTra().getChiTietPhieuMuong(this.IDmt);
	 }
	 public void xoaMuonTra(int IdCtMuonTra, int idSach)
	 {
		 TongHopDuLieu.getDanhSachCTMuonTra().xoaCTMuonTra(IdCtMuonTra,idSach);
		 TongHopDuLieu.getKhoSach().getById(idSach).setTheTVNguoiMuonId(-1);
	 }
	 public void xoaTatCaCtMuonTra()
	 {
		 var ctMuonTras = getCTMuontras();
		 for (CTMuonTra ctMuonTra : ctMuonTras) {
			 TongHopDuLieu.getDanhSachCTMuonTra().xoaCTMuonTra(ctMuonTra.getIdPhieuMuon(),ctMuonTra.getIDsach());
			 TongHopDuLieu.getKhoSach().getById(ctMuonTra.getIDsach()).setTheTVNguoiMuonId(-1);
		}
	 }
	public  void xuatPhieu(){
		System.out.println("ID phiếu mượn: "+this.IDmt);
		System.out.println("ID thẻ: "+this.IDthe);
		System.out.println("ID nhân viên: "+this.IDnv);
		System.out.println("Ngày mượn: "+this.ngayLapPhieu);
		System.out.println("Người mượn:" +TongHopDuLieu.getDanhSachTheThuVien().getById(this.IDthe).getUser().getHoTen());
		ArrayList<CTMuonTra> ctMuonTras= getCTMuontras();
		System.out.println("Danh sách sách mượn: ");
		System.out.println(Table.taoBang(ctMuonTras));
	}
	public int tinhTienPhat()
	{
		int tienPhat=0;
		ArrayList<CTMuonTra> ctMuonTras= getCTMuontras();
		for (CTMuonTra ctMuonTra : ctMuonTras) {
			tienPhat+=ctMuonTra.getTienPhat();
		}
		return tienPhat;
	}
	public TheThuVien getTheThuVien()
	{
		return TongHopDuLieu.getDanhSachTheThuVien().getById(this.IDthe);
	}

}
