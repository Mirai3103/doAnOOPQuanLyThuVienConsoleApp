package Model;

import helper.Helper;

import java.io.Serial;
import java.io.Serializable;

public class DiaChi implements Serializable {
    @Serial
    private static final long serialVersionUID = 67434000L;
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

    public String getQuan() {
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

    public DiaChi() {
        SoNha = Duong = Quan = Phuong = Tinh = "";
    }

    public DiaChi(String soNha, String duong, String phuong, String quan, String tinh) {
        SoNha = soNha;
        Duong = duong;
        Phuong = phuong;
        Quan = quan;
        Tinh = tinh;
    }

    public void Nhap() {
        System.out.println("Nhập số nhà: ");
        SoNha = Helper.inputNoneEmptyString();
        System.out.println("Nhập đường: ");
        Duong = Helper.inputNoneEmptyString();
        System.out.println("Nhập phường: ");
        Phuong = Helper.inputNoneEmptyString();
        System.out.println("Nhập quận: ");
        Quan = Helper.inputNoneEmptyString();
        System.out.println("Nhập tỉnh: ");

        this.Tinh = Helper.inputNoneEmptyString();
    }

    public String toString() {
        return SoNha+", "+Duong+", "+Phuong+", "+Quan+", "+Tinh;
    }

    public void Xuat() {
        System.out.printf("số nhà: " + SoNha);
        System.out.printf(" Đường: " + Duong);
        System.out.printf(" Phường: " + Phuong);
        System.out.printf(" Quận: " + Quan);
        System.out.printf(" Tỉnh: " + Tinh);
    }


}
