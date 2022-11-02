package Model;
import java.util.Scanner;
import helper.Helper;
public class DocGia {
    protected int madg;
    protected String tendg;
    protected DiaChi dc;
    protected int sothe;
    public DocGia()
    {
    	madg=0;
    	tendg =new String();
    	dc= new DiaChi();
    	sothe=0;
    	
    }
    public DocGia(int madg, String tendg, DiaChi dc, int sothe) 
    {
        this.madg=madg;
        this.sothe=sothe;
        this.tendg=tendg;
        this.dc=dc;
    }    
    public void Nhap()
    {
        System.out.print("Nhập mã độc giả: ");
        madg=Helper.scanner.nextInt();
        System.out.print("Nhập tên độc giả: ");
        tendg=Helper.scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        dc.Nhap();
        System.out.print("Nhập số thẻ: ");
        sothe=Helper.scanner.nextInt();
    }
    public void Xuat()
    {
    	System.out.print(this.toString());
    }
	public int getMadg() {
		return madg;
	}
	public void setMadg(int madg) {
		this.madg = madg;
	}
	
	public String getTendg() {
		return tendg;
	}
	public void setTendg(String tendg) {
		this.tendg = tendg;
	}
	public DiaChi getDc() {
		return dc;
	}
	public void setDc(DiaChi dc) {
		this.dc = dc;
	}
	@Override
	public String toString() {
		return "DocGia [madg=" + madg + ", tendg=" + tendg + ", dc=" + dc + ", sothe=" + sothe + "]";
	}
	public int getSothe() {
		return sothe;
	}

	public void setSothe(int sothe) {
		this.sothe = sothe;
	}
	
	
	

}
