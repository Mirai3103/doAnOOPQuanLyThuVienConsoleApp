package Model;
import java.time.LocalDate;
import java.util.Scanner;
import helper.Helper;

public class CTMuonTra extends MuonTra {
    protected String masach;
    protected String ghichu;
    protected int datra;
    protected LocalDate ngayhentra;
    protected LocalDate ngaytra;
    protected LocalDate ngaymuon;
    
    public CTMuonTra()
    {
    	super();
    	masach=new String();
    	ghichu=new String();
    	datra=1;
    	ngayhentra=null;
    	ngaytra=null;
    }

    public CTMuonTra(int mamt, String sothe, String manv, String ngaymuon, String masach, String ghichu,int datra)
    {
    	super(mamt,sothe,manv,ngaymuon);
    	this.masach=masach;
    	this.ghichu=ghichu;
    	this.datra=datra;
    	this.ngaytra=ngaytra;      
    }
    
    public void Nhap()
    {
        System.out.print("Nhập mã sách: ");
        masach=Helper.scanner.nextLine();
        System.out.print("Sách đã trả hay chưa: ");   
    }
    public void Xuat()
    {
    	System.out.print(this.toString());
    }

	@Override
	public String toString() {
		return "CTMuonTra [mamt=" + mamt + ", manv=" + manv + ", ngaymuon=" + ngaymuon + ", sothe=" + sothe
				+ ", masach=" + masach + ", datra=" + datra + ", ghichu=" + ghichu + ", ngaytra=" + ngaytra + "]";
	}

	public String getMasach() {
		return masach;
	}

	public void setMasach(String masach) {
		this.masach = masach;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public int getDatra() {
		return datra;
	}

	public void setDatra(int datra) {
		this.datra = datra;
	}

	
}
