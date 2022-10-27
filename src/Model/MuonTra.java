package Model;
import java.io.Serializable;
import java.util.Scanner;
import helper.Helper;
public class MuonTra implements Serializable {
	public  static int mamtIncrement = 0;
    protected final int mamt;
    protected String sothe;
    protected String manv;
    protected String ngaymuon;
    public MuonTra()
    {
        this.mamt = MuonTra.mamtIncrement++;
    	sothe=new String();
    	manv=new String();
    	ngaymuon=new String();
    }

    public MuonTra(int mamt, String sothe, String manv, String ngaymuon) 
    {
        this.mamt = MuonTra.mamtIncrement++;
        this.sothe=sothe;
        this.manv=manv;
        this.ngaymuon=ngaymuon;
    }
    
    public void Nhap()
    {
        System.out.print("Nhập số thẻ: ");
        sothe=Helper.scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        manv=Helper.scanner.nextLine();
        do {
        	System.out.print("Nhập ngày mượn: ");
        	ngaymuon=Helper.scanner.nextLine();
        }while(!Helper.checkNgayThang(ngaymuon));
    }
    public void Xuat()
    {
    	System.out.print(this.toString());
    }
	@Override
	public String toString() {
		return "MuonTra [ID=" + mamt + ", sothe=" + sothe + ", manv=" + manv + ", ngaymuon=" + ngaymuon + "]";
	}
	public int getID() {
		return mamt;
	}
	String getSothe() {
		return sothe;
	}
	public void setSothe(String sothe) {
		this.sothe = sothe;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getNgaymuon() {
		return ngaymuon;
	}
	public void setNgaymuon(String ngaymuon) {
		this.ngaymuon = ngaymuon;
	}


}
