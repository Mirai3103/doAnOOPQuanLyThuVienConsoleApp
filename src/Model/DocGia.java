package Model;
import java.io.Serializable;
import helper.Helper;
import helper.Xuat.ITableRowData;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
public class DocGia implements Serializable, ITableRowData{
	private static int IDdgIncrement=0;
	@Serial
	private static final long serialVersionUID = -266706354210367639L;
    protected int IDdg;
    protected String tendg;
    protected DiaChi dc;
    protected int IDthe;
    public DocGia()
    {
    	this.IDdg=DocGia.IDdgIncrement++;
    }
    public DocGia(int IDdg, int IDthe, DiaChi dc, String tendg) 
    {
        this.IDdg=IDdg;
        this.IDthe=IDthe;
        this.dc=dc;
        this.tendg=tendg;
    }    
    public void nhapDocGia()
    {
        System.out.print("Nhập tên độc giả: ");
        tendg=Helper.scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        dc.Nhap();
        System.out.print("Nhập số thẻ: ");
        IDthe=Integer.parseInt(Helper.scanner.nextLine());
    }
	public int getIDdg() {
		return IDdg;
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
		return "DocGia [IDdg=" + IDdg + ", tendg=" + tendg + ", dc=" + dc + ", IDthe=" + IDthe + "]";
	}
	public int getIDthe() {
		return IDthe;
	}
	public void setIDthe(int IDthe) {
		this.IDthe = IDthe;
	}
	@Override
	public String[] getRowData() {
	    return new String[]{
	    		this.IDdg+"",
	    		this.tendg,
	    		this.dc+"",
	    		this.IDthe+""
	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDdg","Tên độc giả","Địa chỉ","Idthe"};
	 }
	 public static void showString(String[] str)
	 {
		 for(int i=0;i<str.length;i++)
		 {
			 System.out.printf("%-20s",str[i]);
		 }
		 System.out.printf("\n");
	 }
	public void ghifile(DocGia[] DGG)
	 {
		 try {   
            FileOutputStream f = new FileOutputStream("docgia.dat");   
            ObjectOutputStream oStream = new ObjectOutputStream(f); 
            oStream.writeObject(DGG);   
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
        }
	 }
	 public DocGia[] docfile()
	 {
		 DocGia[]  DGD = null;
        try {  
            FileInputStream f = new FileInputStream("docgia.dat");
            ObjectInputStream inStream = new ObjectInputStream(f); 
            DGD = (DocGia[]) inStream.readObject();
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        }
        return DGD;
	 }
	 public void show(DocGia[] DG)
	 {
        try {
       	 showString(DG[0].getHeader());
            for (int i = 0; i < DG.length; i++) {
           	showString(DG[i].getRowData());
            }	
        } catch (NullPointerException e) {
            System.out.println("File Empty");
        }
        
	 }
	
	
	

}
