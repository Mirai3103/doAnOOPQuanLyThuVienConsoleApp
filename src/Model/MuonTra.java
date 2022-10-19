package temp;
import java.util.Scanner;
public class MuonTra {
    protected String mamt;
    protected String sothe;
    protected String manv;
    protected String ngaymuon;
    Scanner sc=new Scanner(System.in);
    public MuonTra()
    {
    	mamt=new String();
    	sothe=new String();
    	manv=new String();
    	ngaymuon=new String();
    }

    public MuonTra(String mamt, String sothe, String manv, String ngaymuon) 
    {
        this.mamt=mamt;
        this.sothe=sothe;
        this.manv=manv;
        this.ngaymuon=ngaymuon;
    }
    
    public void Nhap()
    {
        System.out.print("Nhập mã mượn trả: ");
        mamt=sc.nextLine();
        System.out.print("Nhập số thẻ: ");
        sothe=sc.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        manv=sc.nextLine();
        System.out.print("Nhập ngày mượn: ");
        ngaymuon=sc.nextLine();
    }
    public void Xuat()
    {
    	System.out.print(this.toString());
    }

	
	@Override
	public String toString() {
		return "MuonTra [mamt=" + mamt + ", sothe=" + sothe + ", manv=" + manv + ", ngaymuon=" + ngaymuon + "]";
	}

	public String getMamt() {
		return mamt;
	}

	public void setMamt(String mamt) {
		this.mamt = mamt;
	}

	public String getSothe() {
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
