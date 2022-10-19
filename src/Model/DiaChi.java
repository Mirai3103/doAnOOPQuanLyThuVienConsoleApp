package Model;

import helper.Helper;

import java.util.Scanner;

public class DiaChi {
	private String SoNha, Duong, Phuong, Quan, Tinh;


	public String getSoNha() {
		return SoNha;
	}

	public void setSoNha(String sonha) {
		SoNha = sonha;
	}

	public String getDuong() {
		return Duong;
	}

	public void setDuong(String duong) {
		Duong = duong;
	}

	public String get() {
		return Quan;
	}

	public void setQuan(String quan) {
		this.Quan = quan;
	}

	public String getPhuong() {
		return Phuong;
	}

	public void setPhuong(String Phuong) {
		this.Phuong = Phuong;
	}

	public String getTinh() {
		return Tinh;
	}

	public void setTinh(String tinh) {
		this.Tinh = tinh;
	}
	
	public DiaChi () {
		SoNha = Duong = Quan = Phuong = Tinh = "";
	}
	
	public void Nhap() {
		System.out.println("Nhập số nhà: ");
		SoNha = Helper.scanner.nextLine();
		System.out.println("Nhập đường: ");
		Duong = Helper.scanner.nextLine();
		System.out.println("Nhập phường: ");
		Phuong = Helper.scanner.nextLine();
		System.out.println("Nhập quận: ");
		Quan = Helper.scanner.nextLine();
		System.out.println("Nhập tỉnh: ");
		Tinh = Helper.scanner.nextLine();
	}

	public String toString() {
		return "DiaChi [SoNha=" + SoNha + ", Duong=" + Duong + ", Phuong=" + Phuong + ", Quan=" + Quan + ", Tinh="
				+ Tinh +"]";
	}
	
	public void Xuat() {
		System.out.printf("số nhà: " + SoNha);
		System.out.printf("\n Đường: " + Duong);
		System.out.printf("\nPhường: " + Phuong);
		System.out.printf("Quận: " + Quan);
		System.out.printf("\nTỉnh: " + Tinh);
	}
	
	
	
	
}
