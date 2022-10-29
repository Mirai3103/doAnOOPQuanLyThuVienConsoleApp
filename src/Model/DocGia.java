package Model;
import java.util.Scanner;
import helper.Helper;
public class DocGia {

    protected String madg;
    protected String tendg;
    protected DiaChi dc;
    protected String sothe;
    public DocGia()
    {
    	madg=new String();
    	sothe=new String();
    }

    public DocGia(String madg, String tendg, DiaChi dc, String sothe) 
    {
        this.madg=madg;
        this.sothe=sothe;
    }
    
    public void Nhap()
    {
        System.out.print("Nhập mã độc giả: ");
        madg=Helper.scanner.nextLine();
        System.out.print("Nhập tên độc giả: ");
        tendg=Helper.scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        dc.Nhap();
        System.out.print("Nhập số thẻ: ");
        sothe=Helper.scanner.nextLine();
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





	public String getSothe() {
		return sothe;
	}

	public void setSothe(String sothe) {
		this.sothe = sothe;
	}
	


	


}
