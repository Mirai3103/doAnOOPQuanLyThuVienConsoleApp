package Model;

import helper.Helper;

import java.io.Serial;
import java.util.ArrayList;

import helper.Helper;

import java.util.ArrayList;

public class NhanVien extends ConNguoi {
	@Serial
	private static final long serialVersionUID = 221223213L;
	private String MaNV, ChucVu, MK;
	private int Luong;



	public NhanVien(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC,String maNV, String chucVu, String mK, int luong) {
		super(hoTen,ngaySinh,sDT,cMND,dC);
		MaNV = maNV;
		ChucVu = chucVu;
		MK = mK;
		Luong = luong;
	}

	public NhanVien() {
		super();
		MaNV = "";
		ChucVu = "";
		MK = "";
		Luong = 0;
	}

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
		System.out.println("Nhập mật khẩu: ");
		MK = Helper.scanner.nextLine();
		System.out.println("Nhập lương");
		Luong = Helper.nhapSoNguyen("Không hợp lệ!. Nhập lại số lương: ");
	}

	public void Xuat() {
		super.Xuat();
		System.out.printf("Mã nhân viên: " + MaNV);
		System.out.printf("Chức vụ: " + ChucVu);
		System.out.printf("Mật khẩu: " + MK);
		System.out.printf("Lương" + Luong);
	}
}
