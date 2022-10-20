package Model;

import helper.Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ConNguoi {
	private String HoTen, NgaySinh, SDT, CMND;
	private DiaChi DC = new DiaChi();

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
		DC=new DiaChi();
	}

	//check lại cái ngày sinh chỗ này dùng hàm được không???
	public ConNguoi(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC) {
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		SDT = sDT;
		CMND = cMND;
		DC = dC;
	}
	private boolean checkSdt( ){
		if(this.SDT.matches("^[\\d]{10,11}$"))
		{
			System.out.println("Số điện thoại không hop lệ! ");
			return true;
		}else {
			return  false;
		}
	}

	// chặc chẽ hơn nx là check trong file thử có cái nào trùng CMND không. thầy dễ check chỗ này.
	protected boolean checkCMND(){
		if(this.SDT.matches("^([\\d]{9}|[\\d]{12})$"))
		{
			System.out.println("Số CMND/CCCD không hop lệ! ");
			return true;
		}else {
			return  false;
		}
	}

	// chuyên cái này qua helper vì  mã phiếu còn dùng mấy cái này nữa.
	// hàm ngày tháng còn thiếu check tháng 31 30 ngày với check tháng 2.
	// tui sửa lại cho nó đa dụng check ngày tháng luôn class con dùng lại check thử đúng hay sai nha.
//	protected boolean checkNgayThang(String NgayThang){
//		Matcher matcher = Helper.DATE_PATTERN.matcher(NgayThang);
//		if(!matcher.find()) {
//			System.out.println("Ngày tháng không hợp lệ");
//			return  false;
//		};
//		if(Integer.parseInt(matcher.group(1)) > 31||Integer.parseInt(matcher.group(1)) ==0){
//			System.out.println("Ngày tháng không hợp lệ");
//			return  false;
//		}
//		if(Integer.parseInt(matcher.group(2)) > 12 ||Integer.parseInt(matcher.group(2)) ==0 ){
//			System.out.println("Ngày tháng không hợp lệ");
//			return  false;
//		}
//		if(Integer.parseInt(matcher.group(3)) > 2025 ||Integer.parseInt(matcher.group(3)) <1940){
//			System.out.println("Ngày tháng không hợp lệ");
//			return  false;
//		}
//		return true; //   dd/mm/yyyy || dd-mm-yyyy
//	}


	public void Nhap() {
		System.out.println("Nhập họ và tên");
		HoTen = Helper.scanner.nextLine();
		do {
			System.out.println("Nhập ngày sinh:");
			NgaySinh = Helper.scanner.nextLine();
		}while (Helper.checkNgayThang(NgaySinh));
		do {
			System.out.println("Nhập số điện thoại:");
			SDT = Helper.scanner.nextLine();
		}while (!checkSdt());
		do {
			System.out.println("Nhập số CMND/CCCD:");
			CMND = Helper.scanner.nextLine();
		}while (!checkCMND());
		System.out.println("Nhập địa chỉ: ");
		DC.Nhap();
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

}
