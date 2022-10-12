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
		HoTen = NgaySinh = SDT = CMND = null;
		DC = null;
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
	protected boolean checkCMND(){
		if(this.SDT.matches("^([\\d]{9}|[\\d]{12})$"))
		{
			System.out.println("Số CMND/CCCD không hop lệ! ");
			return true;
		}else {
			return  false;
		}
	}
	protected boolean checkNgaySinh(){
		Matcher matcher = Helper.DATE_PATTERN.matcher(this.NgaySinh);
		if(!matcher.find()) {
			System.out.println("Ngày sinh không hợp lệ");
			return  false;
		};
		if(Integer.parseInt(matcher.group(1)) > 31||Integer.parseInt(matcher.group(1)) ==0){
			System.out.println("Ngày sinh không hợp lệ");
			return  false;
		}
		if(Integer.parseInt(matcher.group(2)) > 12 ||Integer.parseInt(matcher.group(2)) ==0 ){
			System.out.println("Ngày sinh không hợp lệ");
			return  false;
		}
		if(Integer.parseInt(matcher.group(3)) > 2025 ||Integer.parseInt(matcher.group(3)) <1940){
			System.out.println("Ngày sinh không hợp lệ");
			return  false;
		}
		return true; //   dd/mm/yyyy || dd-mm-yyyy
	}
	public void Nhap() {
		System.out.println("Nhập họ và tên");
		HoTen = Helper.scanner.nextLine();
		do {
			System.out.println("Nhập ngày sinh:");
			NgaySinh = Helper.scanner.nextLine();
		}while (!checkNgaySinh());
		do {
			System.out.println("Nhập số điện thoại:");
			SDT = Helper.scanner.nextLine();
		}while (!checkSdt());
		do {
			System.out.println("Nhập số CMND/CCCD:");
			CMND = Helper.scanner.nextLine();
		}while (!checkCMND());
	}
	
	public void Xuat() {
		
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
