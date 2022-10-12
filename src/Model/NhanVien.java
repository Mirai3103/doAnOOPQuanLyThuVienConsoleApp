package Model;

import helper.Helper;

import java.util.ArrayList;

public class NhanVien extends ConNguoi {

	private String MaNV, ChucVu, MK;
	private int Luong;
	public String getMaNV() {
		return MaNV;
	}

	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	public String getMK() {
		return MK;
	}
	public void setMK(String mK) {
		MK = mK;
	}
	public int getLuong() {
		return Luong;
	}
	public void setLuong(int luong) {
		Luong = luong;
	}

	@Override
	public void Nhap() {
		super.Nhap();
		System.out.println("Nhập mã nhân viên: ");
		MaNV = Helper.scanner.nextLine();
		System.out.println("Nhập chức vụ: ");
		ChucVu = Helper.scanner.nextLine();
		MK = Helper.scanner.nextLine();
		System.out.println("Nhập mật khẩu: ");
		MK = Helper.scanner.nextLine();
		System.out.println("Nhập lương");
		Luong = Helper.nhapSoNguyen("Không hợp lệ!. Nhập lại số lương: ");
	}
}
