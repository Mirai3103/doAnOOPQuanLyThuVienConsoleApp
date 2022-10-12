package Model;

import java.util.Scanner;

public class DiaChi {
	private String SoNha, Duong, Phuong, Quan, Tinh;
	Scanner inp = new Scanner(System.in);

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
		SoNha = Duong = Quan = Phuong = Tinh = null;
	}
	
	public void Nhap() {
		System.out.println("Nhập số nhà: ");
		SoNha = inp.nextLine();
		System.out.println("Nhập đường: ");
		Duong = inp.nextLine();
		System.out.println("Nhập phường: ");
		Phuong = inp.nextLine();
		System.out.println("Nhập quận: ");
		Quan = inp.nextLine();
		System.out.println("Nhập tỉnh: ");
		Tinh = inp.nextLine();
	}

	public String toString() {
		return "DiaChi [SoNha=" + SoNha + ", Duong=" + Duong + ", Phuong=" + Phuong + ", Quan=" + Quan + ", Tinh="
				+ Tinh + ", inp=" + inp + "]";
	}
	
	public void Xuat() {
		System.out.printf("số nhà: " + SoNha);
		System.out.printf("\n Đường: " + Duong);
		System.out.printf("\nPhường: " + Phuong);
		System.out.printf("Quận: " + Quan);
		System.out.printf("\nTỉnh: " + Tinh);
	}
	
	
	
	
}
