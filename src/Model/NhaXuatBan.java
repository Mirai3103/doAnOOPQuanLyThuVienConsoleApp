package Model;


import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Helper;

import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class NhaXuatBan implements Serializable , ITableRowData {
    @Serial
    private static final long serialVersionUID = 13457777644L;
    private  int id;
    private String tenNXB;
    private DiaChi diaChi = new DiaChi();
    private String email;
    private String nguoiDaiDien;
    public NhaXuatBan() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public NhaXuatBan(int id, String tenNXB, DiaChi diaChi, String email, String nguoiDaiDien) {
        this.id = id;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.email = email;
        this.nguoiDaiDien = nguoiDaiDien;
    }
    public NhaXuatBan(String tenNXB, DiaChi diaChi, String email, String nguoiDaiDien) {
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.email = email;
        this.nguoiDaiDien = nguoiDaiDien;
    }

    
    public int getId() {
        return id;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNguoiDaiDien() {
        return nguoiDaiDien;
    }

    public void setNguoiDaiDien(String nguoiDaiDien) {
        this.nguoiDaiDien = nguoiDaiDien;
    }

    public List<Sach> getSachDaXuatBan() {
        var a = TongHopDuLieu.getKhoSach().getAll().stream().filter(s->s.getNhaXuatBanId()==this.id).toList();
        return a;
    }

    public void nhap(){

        System.out.println("Nhap ten nha xuat ban: ");
        this.tenNXB = Helper.scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        this.diaChi = new DiaChi();
        this.diaChi.Nhap();
        do {
        System.out.println("Nhap email: ");
        this.email = Helper.scanner.nextLine();
        }while(!Helper.checkEmail(this.email));
        System.out.println("Nhap nguoi dai dien: ");
        this.nguoiDaiDien = Helper.scanner.nextLine();
    }

    @Override
    public String[] getRowData() {
        return new String[] {this.id+"", this.tenNXB, this.diaChi.toString(), this.email, this.nguoiDaiDien};
    }

    @Override
    public String[] getHeader() {
        return new String[] {"ID", "Ten NXB", "Dia chi", "Email", "Nguoi dai dien"};
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %s", this.id, this.tenNXB, this.diaChi.toString(), this.email, this.nguoiDaiDien);
    }
    public void sua(){
        Helper.clearScreen();
        System.out.println(Table.taoBang(this));
        System.out.println("Sửa NXB: ");
        for(int i = 1; i<getHeader().length;i++){
            System.out.printf(i + ". " + getHeader()[i] + "\n");
        }
        System.out.println("5 . Thoát");
        System.out.println("Nhập thuộc tính cần sửa");
        int a = Helper.nhapSoNguyen("yêu cầu nhập số nguyên");
        switch (a) {
            case 1 -> {
                System.out.println("Sửa tên NXB: ");
                System.out.println("Nhập tên NXB mới: ");
                this.tenNXB = Helper.nhapTen();
            }
            case 2 -> {
                System.out.println("Sửa Địa chỉ: ");
                diaChi.Nhap();
            }
            case 3 -> {
                System.out.println("Sửa Email: ");
                this.email =  Helper.nhapEmail();
            }
            case 4 -> {
                System.out.println("Sửa tên người đại diện: ");
                this.nguoiDaiDien = Helper.nhapTen();
            }
            case 5 -> {
                System.out.println("Thoát");
            }
            default -> System.out.println("đối số truyền vào không đúng");
        }
    }
    public static  void main(String[] thich){
        NhaXuatBan a = new NhaXuatBan();
        a.sua();
    }
}
