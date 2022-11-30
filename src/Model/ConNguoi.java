package Model;

import helper.Helper;

import java.io.Serial;
import java.io.Serializable;


public class ConNguoi  implements Serializable {
	@Serial
	private static final long serialVersionUID = 1345644L;
	private String HoTen, NgaySinh, SDT, CMND;
	private DiaChi DC;

	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public DiaChi getDC() {
		return DC;
	}
	public void setDC(DiaChi dC) {
		DC = dC;
	}

	public ConNguoi() {
		HoTen = NgaySinh = SDT = CMND = "";

		DC = new DiaChi();
	}

	//check lại cái ngày sinh chỗ này dùng hàm được không???
	public ConNguoi(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC) {
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		SDT = sDT;
		CMND = cMND;
		DC = dC;
	}
	public boolean checkSdt( ){
		if(this.SDT.matches("^[\\d]{10,11}$"))
		{

			return true;
		}else {
			System.out.println("Số điện thoại không hop lệ! ");
			return  false;
		}
	}

	// chặc chẽ hơn nx là check trong file thử có cái nào trùng CMND không. thầy dễ check chỗ này.
	protected boolean checkCMND(){
		if(this.CMND.matches("([\\d]{9})$"))
		{
			return true;
		}else {
			System.out.println("Số CMND/CCCD không hop lệ! ");
			return  false;
		}
	}



	public void Nhap() {
		System.out.println("Nhập họ và tên");
		HoTen = Helper.scanner.nextLine();
		do {
			System.out.println("Nhập ngày sinh:");
			NgaySinh = Helper.scanner.nextLine();
			if(NgaySinh.equalsIgnoreCase("null")){
				NgaySinh = "";
				break;
			}
		}while (!Helper.checkNgayThang(NgaySinh));
		do {
			System.out.println("Nhập số điện thoại:");
			SDT = Helper.scanner.nextLine();
			if(SDT.equalsIgnoreCase("null")){
				SDT = "";
				break;
			}
		}while (!checkSdt());
		do {
			System.out.println("Nhập số CMND/CCCD:");
			CMND = Helper.scanner.nextLine();
			if(CMND.equalsIgnoreCase("null")){
				CMND = "";
				break;
			}
		}while (!checkCMND());
		System.out.println("Bạn có muốn nhập địa chỉ không? (y/n)");
		String chon = Helper.scanner.nextLine().charAt(0)+"";
		if(chon.equalsIgnoreCase("y")){
			System.out.println("Nhập địa chỉ: ");
			DC.Nhap();
		}
	}

	public void Xuat() {
		System.out.printf("Họ và tên: " + HoTen);
		System.out.printf("\nNgày sinh: " + NgaySinh);
		System.out.printf("Số điện thoại: " + SDT);
		System.out.printf("Số CMND/CCCD: " + CMND);
		DC.Xuat();

	}

	@Override
	public String toString() {
		return "ConNguoi{" +
				"HoTen='" + HoTen + '\'' +
				", NgaySinh='" + NgaySinh + '\'' +
				", SDT='" + SDT + '\'' +
				", CMND='" + CMND + '\'' +
				", DC=" + DC +
				'}';
	}

	public static void main(String[] args) {
		ConNguoi a = new ConNguoi();
		a.Nhap();
		a.Xuat();
	}
	protected boolean checkCMND(String CMND){
		if(CMND.matches("([\\d]{9})$"))
		{
			return true;
		}else {
			System.out.println("Số CMND/CCCD không hop lệ! ");
			return  false;
		}
	}
	protected boolean checkSdt(String SDT ){
		if(SDT.matches("^[\\d]{10,11}$"))
		{

			return true;
		}else {
			System.out.println("Số điện thoại không hop lệ! ");
			return  false;
		}
	}

}
