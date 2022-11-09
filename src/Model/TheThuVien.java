package Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;
import helper.Helper;
import helper.Xuat.ITableRowData;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
public class TheThuVien implements Serializable, ITableRowData{
	private static int IDtheIncrement=0;
	@Serial
	private static final long serialVersionUID = -266706354210367639L;
	private final int IDthe;
    private int IDuser;
    private String ngaybd;
    private String ngayhh;
    private String ghichu;
    public TheThuVien()
    {
        this.IDthe = TheThuVien.IDtheIncrement++;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ngaybd = formatter.format(date);
    }
    public TheThuVien(String IDthe,String ngaybd,int IDuser,String ngayhh,String ghichu) 
    {
        this.IDthe = TheThuVien.IDtheIncrement++;
        this.IDuser=IDuser;
    	this.ngaybd=ngaybd;
    	this.ngayhh=ngayhh;
    	this.ghichu=ghichu;	
    }  
  
	public int getIDthe() {
		return IDthe;
	}
	public int getIDuser()
	{
		return IDuser;
	}
	public void setIDuser(int IDuser)
	{
		this.IDuser=IDuser;
	}
	public String getNgaybd() {
		return ngaybd;
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
		return "TheThuVien [IDthe=" + IDthe + ",IDuser=" + IDuser + ", ngaybd=" + ngaybd + ", ngayhh=" + ngayhh + ", ghichu=" + ghichu + "]";
	}
	void themTheThuVien()
	{
		System.out.print("Nhập IDuser: ");
	    this.IDuser = Integer.parseInt(Helper.scanner.nextLine());
        System.out.print("Nhập ngày hết hạn(dd/MM/yyyy): ");
        this.ngayhh = Helper.scanner.nextLine();
        System.out.print("Nhập ghi chú: ");
        this.ghichu = Helper.scanner.nextLine();
	}
	public void xuatTheThuVien()
	{
		System.out.println("IDthe: " + this.IDthe);
		System.out.println("IDuser: " + this.IDuser);
        System.out.println("Ngày bắt đầu: " + this.ngaybd);
        System.out.println("Ngày hết hạn: " + this.ngayhh);
        System.out.println("Ghi chú: " + this.ghichu);	
	}
	@Override
	public String[] getRowData() {
	    return new String[]{
	           this.IDthe + "",
	           this.IDuser + "",
	           this.ngaybd,
	           this.ngayhh,
	           this.ghichu,     
	        };
	    }
	 @Override
	 public String[] getHeader() {
	     return new String[]{"IDthe", "IDuser", "Ngày bắt đầu", "Ngày hết hạn", "Ghi chú"};
	 }
	 public static void showString(String[] str)
	 {
		 for(int i=0;i<str.length;i++)
		 {
			 System.out.printf("%-20s",str[i]);
		 }
		 System.out.printf("\n");
	 }
    public static void main(String[] args)
    {
//    	tao magn the thu vien
    	 int n;
         System.out.print("Nhập số lượng thẻ: ");
         n = Integer.parseInt(Helper.scanner.nextLine());  
         TheThuVien[] ttv = new TheThuVien[n];
         for (int i = 0; i < n; i++) {
         	ttv[i] = new TheThuVien(); 
             ttv[i].themTheThuVien();  
         }
//         ghi the thu vien
         try {   
             FileOutputStream f = new FileOutputStream("thethuvien.dat");   
             ObjectOutputStream oStream = new ObjectOutputStream(f); 
             oStream.writeObject(ttv);   
             oStream.close();
         } catch (IOException e) {
             System.out.println("Error Write file");
         }
         
//         doc the thu vien
         TheThuVien[] ttvd = null;
         try {  
             FileInputStream f = new FileInputStream("thethuvien.dat");
             ObjectInputStream inStream = new ObjectInputStream(f); 
             ttvd = (TheThuVien[]) inStream.readObject();
             inStream.close();
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found");
         } catch (IOException e) {
             System.out.println("Error Read file");
         }
         /// show the thi vein
         try {
        	 showString(ttvd[0].getHeader());
             for (int i = 0; i < ttvd.length; i++) {
            	showString(ttvd[i].getRowData());
             }	
         } catch (NullPointerException e) {
             System.out.println("File Empty");
         }   
    }
}