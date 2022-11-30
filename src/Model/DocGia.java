package Model;
import java.io.Serializable;
import helper.Helper;
import helper.Xuat.ITableRowData;

import java.io.Serial;
import java.time.LocalDate;

public class DocGia extends ConNguoi implements Serializable, ITableRowData {
	@Serial
	private static final long serialVersionUID = -266706354210367639L;
    protected int IDdg;
    protected int IDthe;
    public DocGia()
    {
    }

	public DocGia(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC, int IDdg, int IDthe) {
		super(hoTen, ngaySinh, sDT, cMND, dC);
		this.IDdg = IDdg;
		this.IDthe = IDthe;
	}

	public void nhapDocGia()
    {
        super.Nhap();
    }
	public int getIDdg() {
		return IDdg;
	}

	public void setIDdg(int IDdg) {
		this.IDdg = IDdg;
	}

	public int phiTaoThe()
	{
		return LocalDate.now().getYear()- Helper.parseDate(this.getNgaySinh()).getYear() > 18 ? 50000 : 20000;
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
	    		this.IDthe+"",
					    		this.getHoTen(),
					    		this.getNgaySinh(),
					    		this.getSDT(),
					    		this.getCMND(),
					    		this.getDC().toString(),
	        };
	    }
	 @Override
	 public String[] getHeader() {
		 return new String[]{"ID Độc Giả", "ID Thẻ", "Họ Tên", "Ngày Sinh", "Số Điện Thoại", "CMND", "Địa Chỉ"};
	 }
	 public void sua(){
		for (int i = 0 ;i<getHeader().length;i++)
			if(!(getHeader()[i].equalsIgnoreCase("ID Độc Giả")||getHeader()[i].equalsIgnoreCase("ID Thẻ")))
				System.out.printf(i + ". " + getHeader()[i] + "\n");
		 System.out.printf("7. Thoát\n");
		 System.out.println("Nhập thuộc tính cần sửa");
		 int a = Helper.nhapSoNguyen("yêu cầu nhập số nguyên");
		 switch (a) {
			 case 2: {
				 String HoTen;
				 System.out.println("Sửa Họ Tên: ");
				 HoTen = Helper.scanner.nextLine();
				 setHoTen(HoTen);
				 break;
			 }
			 case 3: {
				 String NgaySinh;
				 System.out.println("Sửa ngay sinh: ");
				 do {
					 System.out.println("Nhập ngày sinh:");
					 NgaySinh = Helper.scanner.nextLine();
					 if (NgaySinh.equalsIgnoreCase("null")) {
						 NgaySinh = "";
						 break;
					 }
				 } while (!Helper.checkNgayThang(NgaySinh));

				 setNgaySinh(NgaySinh);
				 break;
			 }
			 case 4: {
				 String SDT;
				 System.out.println("Sửa SDT: ");
				 do {
					 System.out.println("Nhập số điện thoại:");
					 SDT = Helper.scanner.nextLine();
					 if (SDT.equalsIgnoreCase("null")) {
						 SDT = "";
						 break;
					 }
				 } while (!checkSdt(SDT));
				 setSDT(SDT);
				 break;
			 }
			 case 5: {
				 String CMND;
				 System.out.println("Sửa CMND: ");
				 do {
					 System.out.println("Nhập số CMND/CCCD:");
					 CMND = Helper.scanner.nextLine();
					 if (CMND.equalsIgnoreCase("null")) {
						 CMND = "";
						 break;
					 }
				 } while (!checkCMND(CMND));

				 setCMND(CMND);
				 break;
			 }
			 case 6: {
				 DiaChi k = new DiaChi();
				 System.out.println("Sửa địa chỉ: ");
				 k.Nhap();
				 setDC(k);
				 break;
			 }
			 case 7 :{
				 break;
			 }
			 default:
				 System.out.println("đối số truyền vào không đúng");
		 }
		 }
		 public static void main (String[] a){
			DocGia k = new DocGia();
			k.sua();
		 }
	 }
