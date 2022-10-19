package Model;
import java.util.Scanner;
public class DocGia extends ConNguoi {
    protected String madg;
    protected String sothe;
    Scanner sc=new Scanner(System.in);
    public DocGia()
    {
    	
    	madg=new String();
    	tendg=new String();
    	dc=new DiaChi();
    	sothe=new String();
    }

    public DocGia(String madg, String tendg, DiaChi dc, String sothe) 
    {
        this.madg=madg;
        this.tendg=tendg;
        this.dc=dc;
        this.sothe=sothe;
    }
    
    public void Nhap()
    {
        System.out.print("Nhập mã độc giả: ");
        madg=sc.nextLine();
        System.out.print("Nhập tên độc giả: ");
        tendg=sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        dc.Nhap();
        System.out.print("Nhập số thẻ: ");
        sothe=sc.nextLine();
    }
    public void Xuat()
    {
    	System.out.print(this.toString());
    }

	public String getMadg() {
		return madg;
	}

	public void setMadg(String madg) {
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

	public String getSothe() {
		return sothe;
	}

	public void setSothe(String sothe) {
		this.sothe = sothe;
	}
	
	@Override
	public String toString() {
		return "DocGia [madg=" + madg + ", tendg=" + tendg + ", dc=" + dc + ", sothe=" + sothe + "]";
	}

	


}
