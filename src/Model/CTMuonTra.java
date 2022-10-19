package Model;
import java.util.Scanner;
public class CTMuonTra {
    protected String mamt;
    protected String masach;
    protected String ghichu;
    protected Boolean datra;
    protected String ngaytra;
    Scanner sc=new Scanner(System.in);
    public CTMuonTra()
    {
    	mamt=new String();
    	masach=new String();
    	ghichu=new String();
    	datra=false;
    	ngaytra=new String();
    }

    public CTMuonTra(String mamt, String masach, String ghichu,Boolean datra, String ngaytra)
    {
    	this.mamt=mamt;
    	this.masach=masach;
    	this.ghichu=ghichu;
    	this.datra=datra;
    	this.ngaytra=ngaytra;      
    }
    
    public void Nhap()
    {
        System.out.print("Nhập mã mượn trả: ");
        mamt=sc.nextLine();
        System.out.print("Nhập mã sách: ");
        masach=sc.nextLine();
        System.out.print("Sách đã trả hay chưa: ");
        datra=Boolean.parseBoolean(sc.nextLine());
        if(datra)
        {
        	System.out.print("Nhập ngày trả: ");
            ngaytra=sc.nextLine();
        }
        
    }
    public void Xuat()
    {
    	System.out.print(this.toString());
    }

	
	
	@Override
	public String toString() {
		return "CTMuonTra [mamt=" + mamt + ", masach=" + masach + ", ghichu=" + ghichu + ", datra=" + datra
				+ ", ngaytra=" + ngaytra + "]";
	}

	public String getMamt() {
		return mamt;
	}

	public void setMamt(String mamt) {
		this.mamt = mamt;
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

	public Boolean getDatra() {
		return datra;
	}

	public void setDatra(Boolean datra) {
		this.datra = datra;
	}

	public String getNgaytra() {
		return ngaytra;
	}

	public void setNgaytra(String ngaytra) {
		this.ngaytra = ngaytra;
	}
}
