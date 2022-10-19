package temp;
import java.util.Scanner;
public class TheThuVien {
    protected String sothe;
    protected String ngaybd;
    protected String ngayhh;
    protected String ghichu;
    Scanner sc=new Scanner(System.in);
    public TheThuVien()
    {
    	sothe=new String();
    	ngaybd=new String();
    	ngayhh=new String();
    	ghichu=new String();
    }

    public TheThuVien(String sothe, String ngaybd,String ngayhh, String ghichu) 
    {
    	this.sothe=sothe;
    	this.ngaybd=ngaybd;
    	this.ngayhh=ngayhh;
    	this.ghichu=ghichu;	
    }  
    public void Nhap()
    {
        System.out.print("Nhập số thẻ: ");
        sothe=sc.nextLine();
        System.out.print("Nhập tên ngày bắt đầu: ");
        ngaybd=sc.nextLine();
        System.out.print("Nhập tên ngày hết hạn: ");
        ngayhh=sc.nextLine();
        System.out.print("Nhập tên ghi chú: ");
        ghichu=sc.nextLine();
    }
    public void Xuat()
    {
    	System.out.print(this.toString());
    }
	public String getSothe() {
		return sothe;
	}

	public void setSothe(String sothe) {
		this.sothe = sothe;
	}

	public String getNgaybd() {
		return ngaybd;
	}

	public void setNgaybd(String ngaybd) {
		this.ngaybd = ngaybd;
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
		return "TheThuVien [sothe=" + sothe + ", ngaybd=" + ngaybd + ", ngayhh=" + ngayhh + ", ghichu=" + ghichu + "]";
	}


}
