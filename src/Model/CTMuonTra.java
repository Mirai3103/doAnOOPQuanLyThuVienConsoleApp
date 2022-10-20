package Model;
import java.util.Scanner;
import helper.Helper;

public class CTMuonTra {
    protected String mamt;
    protected String masach;
    protected String ghichu;
    protected Boolean datra;
    protected String ngaytra;
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
        mamt=Helper.scanner.nextLine();
        System.out.print("Nhập mã sách: ");
        masach=Helper.scanner.nextLine();
        System.out.print("Sách đã trả hay chưa: ");
        // cái này sao bữa trước tui ép nó báo lỗi ta?? (Quỳnh)
        datra=Boolean.parseBoolean(Helper.scanner.nextLine());
        if(datra)
        {
        	do {
        		System.out.print("Nhập ngày trả: ");
        		ngaytra=Helper.scanner.nextLine();;
        	}while(!Helper.checkNgayThang(ngaytra));
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
