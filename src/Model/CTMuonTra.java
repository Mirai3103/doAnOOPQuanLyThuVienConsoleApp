package Model;
import java.io.Serializable;
import helper.Helper;
import helper.Xuat.ITableRowData;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class CTMuonTra extends MuonTra {
    protected int IDsach;
    protected int datra;
    protected String ngayhentra;
    protected String ngaytra;
    protected String ghichu;
    public CTMuonTra()
    {
    	super();
    }

    public CTMuonTra(int IDmt, int IDthe, int IDnv, String ngaymuon ,int IDsach, int datra, String ngayhentra, String ngaytra,String ghichu)
    {
    	super(IDmt,IDthe,IDnv,ngaymuon);
    	this.IDsach=IDsach;
    	this.datra=datra;
    	this.ngayhentra=ngayhentra;
    	this.ngaytra=ngaytra;  
    	this.ghichu=ghichu;
    }
    public void nhapCTMuonTra()
    {
    	super.nhapPhieuMuonTra();
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
		return "CTMuonTra [IDmt=" + IDmt + ", IDnv=" + IDnv + ", ngaymuon=" + ngaymuon + ", IDthe=" + IDthe
				+ ", IDsach=" + IDsach + ", datra=" + datra + ", ghichu=" + ghichu + ", ngaytra=" + ngaytra + "]";
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
	    		this.IDthe +"", 
	    		this.IDnv +"", 
	    		this.ngaymuon ,
	    		this.IDsach+"", 
	    		this.datra+"",
	    		this.ngayhentra,
	    		this.ngaytra,
	    		this.ghichu  
	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDmt","IDthe","IDnv","Ngày mượn" ,"IDsach","Tình trạng", "Ngày hẹn trả","Ngày trả","Ghi chú"};
	 }
	 public static void showString(String[] str)
	 {
		 for(int i=0;i<str.length;i++)
		 {
			 System.out.printf("%-20s",str[i]);
		 }
		 System.out.printf("\n");
	 }
//	 ghi file
	 public void ghifile(CTMuonTra[] CTMTG)
	 {
		 try {   
             FileOutputStream f = new FileOutputStream("phieumuontra.dat");   
             ObjectOutputStream oStream = new ObjectOutputStream(f); 
             oStream.writeObject(CTMTG);   
             oStream.close();
         } catch (IOException e) {
             System.out.println("Error Write file");
         }
	 }
	 public CTMuonTra[] docfile()
	 {
		 CTMuonTra[]  CTMTD = null;
         try {  
             FileInputStream f = new FileInputStream("phieumuontra.dat");
             ObjectInputStream inStream = new ObjectInputStream(f); 
             CTMTD = (CTMuonTra[]) inStream.readObject();
             inStream.close();
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found");
         } catch (IOException e) {
             System.out.println("Error Read file");
         }
         return CTMTD;
	 }
	 public void show(CTMuonTra[] CTMT)
	 {
         try {
        	 showString(CTMT[0].getHeader());
             for (int i = 0; i < CTMT.length; i++) {
            	showString(CTMT[i].getRowData());
             }	
         } catch (NullPointerException e) {
             System.out.println("File Empty");
         }
         
	 }
	 public static void main(String[] args)
	    {
//	    	
	    }
}
