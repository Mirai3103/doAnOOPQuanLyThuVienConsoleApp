package Model;


import java.util.ArrayList;

public class NhaXuatBan {
    private final int id;
    private String tenNXB;
    private DiaChi diaChi;
    private String email;
    private ConNguoi nguoiDaiDien;
    private ArrayList<Sach> sachDaXuatBan = new ArrayList<>();
    public NhaXuatBan(int id) {
        this.id = id;
    }
    public NhaXuatBan(int id, String tenNXB, DiaChi diaChi, String email, ConNguoi nguoiDaiDien) {
        this.id = id;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.email = email;
        this.nguoiDaiDien = nguoiDaiDien;
    }
    public NhaXuatBan(int id, String tenNXB, DiaChi diaChi, String email, ConNguoi nguoiDaiDien, ArrayList<Sach> sachDaXuatBan) {
        this.id = id;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.email = email;
        this.nguoiDaiDien = nguoiDaiDien;
        this.sachDaXuatBan = sachDaXuatBan;
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

    public ConNguoi getNguoiDaiDien() {
        return nguoiDaiDien;
    }

    public void setNguoiDaiDien(ConNguoi nguoiDaiDien) {
        this.nguoiDaiDien = nguoiDaiDien;
    }

    public ArrayList<Sach> getSachDaXuatBan() {
        return sachDaXuatBan;
    }

    public void setSachDaXuatBan(ArrayList<Sach> sachDaXuatBan) {
        this.sachDaXuatBan = sachDaXuatBan;
    }
}
