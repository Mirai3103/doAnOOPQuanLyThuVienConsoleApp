package Model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import helper.Helper;
import helper.Xuat.ITableRowData;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class MuonTra implements Serializable, ITableRowData{
	public  static int IDmtIncrement = 0;
    protected final int IDmt;
    protected int IDthe;
    protected int IDnv;
    protected String ngaymuon;
    public MuonTra()
    {
        this.IDmt = MuonTra.IDmtIncrement++;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ngaymuon = formatter.format(date);
    }
    public MuonTra(int IDmt, int IDthe, int IDnv, String ngaymuon) 
    {
        this.IDmt = MuonTra.IDmtIncrement++;
        this.IDthe=IDthe;
        this.IDnv=IDnv;
        this.ngaymuon=ngaymuon;

    }
	@Override
	public String toString() {
		return "MuonTra [ID=" + IDmt + ", IDthe=" + IDthe + ", IDnv=" + IDnv + ", ngaymuon=" + ngaymuon + "]";
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
	public int getIDnv() {
		return IDnv;
	}
	public void setIDnv(int IDnv) {
		this.IDnv = IDnv;
	}
	public String getNgaymuon() {
		return ngaymuon;
	}
	 public  void nhapPhieuMuonTra()
	{
		System.out.print("Nhập số thẻ: ");
        IDthe=Integer.parseInt(Helper.scanner.nextLine());
        System.out.print("Nhập mã nhân viên: ");
        IDnv=Integer.parseInt(Helper.scanner.nextLine());
	}
	public void xuatPhieuMuonTra()
	{
		System.out.println("IDthe: " + this.IDthe);
		System.out.println("IDuser: " + this.IDthe);
		System.out.println("IDnv: " + this.IDnv);
        System.out.println("Ngày mượn: " + this.ngaymuon);	
	}
	@Override
	public String[] getRowData() {
	    return new String[]{
	           this.IDmt + "",
	           this.IDthe + "",
	           this.IDnv + "",
	           this.ngaymuon,     
	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDmt", "IDthe", "IDnv", "Ngày mượn"};
	 }
	 public static void showString(String[] str)
	 {
		 for(int i=0;i<str.length;i++)
		 {
			 System.out.printf("%-20s",str[i]);
		 }
		 System.out.printf("\n");
	 }
}
