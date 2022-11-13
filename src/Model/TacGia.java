package Model;


import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

// Nên kế thừ từ lớp con người??
// Tại vì con người nó có cái sdt, CMND gì nữa, mấy thông tin nhạy cảm z thường tác giả ko có
public class TacGia implements Serializable, ITableRowData {
    @Serial
    private static final long serialVersionUID = 12200345644L;
    private int id;
    private String tenTacGia;
    private String website;
    private String gioiThieu;

    public TacGia() {
    }

    public TacGia(String tenTacGia, String website, String gioiThieu) {
        this();
        this.tenTacGia = tenTacGia;
        this.website = website;
        this.gioiThieu = gioiThieu;
    }

    public void setId(int id) {
        this.id = id;
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
        return TongHopDuLieu.getKhoSach().timSachCuaTacGia(this.id);
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

    @Override
    public String[] getRowData() {
        return new String[]{"" + id, tenTacGia, website, gioiThieu};
    }

    @Override
    public String[] getHeader() {
        return new String[]{"Id", "Tên tác giả", "website", "giới thiệu"};
    }

    public static TacGia fromCSVRong(String[] data) {
        TacGia tg = new TacGia(data[1], data[2], data[3]);
        tg.id = Integer.parseInt(data[0]);
        return tg;

    }

    public void xuatDangBang() {
        System.out.println(Table.taoBang(this));
    }
}
