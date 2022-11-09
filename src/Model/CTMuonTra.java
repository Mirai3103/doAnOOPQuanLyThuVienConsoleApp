package Model;
import java.io.Serializable;
import helper.Helper;
import helper.Xuat.ITableRowData;
public class CTMuonTra implements ITableRowData {
	protected int IDmt;
    protected int IDsach;
    protected int datra;
    protected String ngayhentra;
    protected String ngaytra;
    protected String ghichu;
    public CTMuonTra()
    {
    	super();
    }
    public CTMuonTra( int IDmt,int IDsach, int datra, String ngayhentra, String ngaytra,String ghichu)
    {
    	this.IDmt=IDmt;
    	this.IDsach=IDsach;
    	this.datra=datra;
    	this.ngayhentra=ngayhentra;
    	this.ngaytra=ngaytra;  
    	this.ghichu=ghichu;
    }
    public void nhapCTMuonTra()
    {
    	System.out.print("Nhập IDsach: ");
    	this.IDsach=Integer.parseInt(Helper.scanner.nextLine());
    	System.out.print("Sách đã trả hay chưa(1/0): ");
    	this.datra=IDsach=Integer.parseInt(Helper.scanner.nextLine());
    	System.out.print("Nhập ngày hẹn trả(dd/MM/yyyy): ");
    	this.ngayhentra=Helper.scanner.nextLine();
    	System.out.print("Nhập ngày hẹn trả(dd/MM/yyyy): ");
    	this.ngaytra=Helper.scanner.nextLine();
    	System.out.print("Nhập ghi chú: ");
    	this.ghichu=Helper.scanner.nextLine();
    }
	@Override
	public String toString() {
		return "CTMuonTra [IDmt=" + IDmt + ", IDsach=" + IDsach + ", datra=" + datra + ", ghichu=" + ghichu + ", ngaytra=" + ngaytra + "]";
	}

	public int getIDsach() {
		return IDsach;
	}

	public void setMasach(int IDsach) {
		this.IDsach = IDsach;
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
	@Override
	public String[] getRowData() {
	    return new String[]{
	    		this.IDmt +"", 
	    		this.IDsach+"", 
	    		this.datra+"",
	    		this.ngayhentra,
	    		this.ngaytra,
	    		this.ghichu  
	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDmt","IDsach","Tình trạng", "Ngày hẹn trả","Ngày trả","Ghi chú"};
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
