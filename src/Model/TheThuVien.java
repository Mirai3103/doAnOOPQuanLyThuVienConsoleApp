package Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

import Repository.DocGias;
import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
import java.io.Serial;
public class TheThuVien implements Serializable, ITableRowData{
	@Serial
	private static final long serialVersionUID = -266706354210367639L;
	private  int IDthe;
    private int IDuser;
    private String ngaybd;
    private String ngayhh;
    private String ghichu;
    public TheThuVien()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ngaybd = formatter.format(date);
    }
    public TheThuVien(String IDthe,String ngaybd,int IDuser,String ngayhh,String ghichu) 
    {
        this.IDuser=IDuser;
    	this.ngaybd=ngaybd;
    	this.ngayhh=ngayhh;
    	this.ghichu=ghichu;	
    }

	public void setIDthe(int IDthe) {
		this.IDthe = IDthe;
	}

	public void setNgaybd(String ngaybd) {
		this.ngaybd = ngaybd;
	}

	public int getIDthe() {
		return IDthe;
	}
	public int getIDuser()
	{
		return IDuser;
	}
	public void setIDuser(int IDuser)
	{
		this.IDuser=IDuser;
	}
	public String getNgaybd() {
		return ngaybd;
	}
	public String getNgayhh() {
		return ngayhh;
	}
	public void setNgayhh(String ngayhh) {
		this.ngayhh = ngayhh;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	@Override
	public String toString() {
		return "TheThuVien [IDthe=" + IDthe + ",IDuser=" + IDuser + ", ngaybd=" + ngaybd + ", ngayhh=" + ngayhh + ", ghichu=" + ghichu + "]";
	}
	public void themTheThuVien()
	{
		System.out.print("Nhập IDuser: ");
	    this.IDuser = Integer.parseInt(Helper.scanner.nextLine());
        System.out.print("Nhập ngày hết hạn(dd/MM/yyyy): ");
        this.ngayhh = Helper.scanner.nextLine();
        System.out.print("Nhập ghi chú: ");
        this.ghichu = Helper.scanner.nextLine();
	}
	public DocGia getUser(){
		return TongHopDuLieu.getDanhSachDocGia().getById(IDuser);
	}
	public void themTheThuVien(int IDuser)
	{
		this.IDuser = IDuser;
		System.out.print("Nhập ngày hết hạn(dd/MM/yyyy): ");
		this.ngayhh = Helper.scanner.nextLine();
		System.out.print("Nhập ghi chú: ");
		this.ghichu = Helper.scanner.nextLine();
	}
	public void inThe()
	{
		var chuThe = getUser();
		System.out.println("ID thẻ: "+IDthe);
		System.out.println("ID user: "+IDuser);
		System.out.println("Họ tên chủ thẻ: "+chuThe.getHoTen());
        System.out.println("Ngày bắt đầu: " + this.ngaybd);
        System.out.println("Ngày hết hạn: " + this.ngayhh);
        System.out.println("Ghi chú: " + this.ghichu);	
	}

	@Override
	public String[] getRowData() {
	    return new String[]{
	           this.IDthe + "",
	           this.IDuser + "",
	           this.ngaybd,
	           this.ngayhh,
	           this.ghichu,     
	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDthe", "IDuser", "Ngày bắt đầu", "Ngày hết hạn", "Ghi chú"};
	 }
}