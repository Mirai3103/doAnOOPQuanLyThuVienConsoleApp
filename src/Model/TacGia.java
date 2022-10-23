package Model;


import helper.Helper;

import java.util.List;

// Nên kế thừ từ lớp con người??
// Tại vì con người nó có cái sdt, CMND gì nữa, mấy thông tin nhạy cảm z thường tác giả ko có
public class TacGia {
    private static int idIncrement = 0;
    private final int id;
    private String tenTacGia;
    private String website;
    private String gioiThieu;

    public TacGia() {
        this.id = TacGia.idIncrement++;
    }

    public TacGia(String tenTacGia, String website, String gioiThieu) {
        this();
        this.tenTacGia = tenTacGia;
        this.website = website;
        this.gioiThieu = gioiThieu;
    }


    public int getId() {
        return id;
    }


    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public List<Sach> getSachs() {
        return Helper.khoDuLieu.getKhoSach().timSachCuaTacGia(this.id);
    }

    public void nhap() {
        System.out.println("Nhập tên tác giả: ");
        this.tenTacGia = Helper.scanner.nextLine();
        System.out.println("Nhập website: ");
        this.website = Helper.scanner.nextLine();
        System.out.println("Nhập giới thiệu: ");
        this.gioiThieu = Helper.scanner.nextLine();
    }

    public void xuat() {
        // xuat id, ten
        System.out.printf("%-5d %-20s\n", this.id, this.tenTacGia);

    }

}
