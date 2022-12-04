package Model;


import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class TheLoai implements Serializable, ITableRowData {
    @Serial
    private static final long serialVersionUID = 1342400999L;
    private int id;
    private String tenTheLoai;
    private String gioiThieu;

    public TheLoai() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Sach> getSachs() {
        var sachIds = TongHopDuLieu.getDanhSachTheLoai_sach().getTheLoai_saches().stream().filter(t -> t.getTheLoaiId() == this.id).toList();
        ArrayList<Sach> sachs = new ArrayList<>();
        for (TheLoai_Sach theLoai_sach : sachIds) {
            Sach s = TongHopDuLieu.getKhoSach().getById(theLoai_sach.getSachId());
            if (s != null) {
                sachs.add(s);
            }
        }
        return sachs;
    }


    public TheLoai(String tenTheLoai, String gioiThieu) {
        this.tenTheLoai = tenTheLoai;
        this.gioiThieu = gioiThieu;
    }

    public int getId() {
        return id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public void nhap() {
        System.out.println("Nhập tên thể loại: ");
        this.tenTheLoai = Helper.scanner.nextLine();
        System.out.println("Nhập giới thiệu: ");
        this.gioiThieu = Helper.scanner.nextLine();
    }

    public void xuat() {
        System.out.printf("ID: %d, Tên thể loại: %s, Giới thiệu: %s\n", this.id, this.tenTheLoai, this.gioiThieu);
    }

    public String toCSVRow() {
        return String.format("%d, %s, \"%s\"", this.id, this.tenTheLoai, this.gioiThieu);
    }

    @Override
    public String[] getRowData() {
        return new String[]{id + "", tenTheLoai, gioiThieu};
    }

    @Override
    public String[] getHeader() {
        return new String[]{"Id", "Tên thể loại", "giới thiệu"};
    }

    public void xuatDangBang() {
        System.out.println(Table.taoBang(this));
    }

    public void sua() {
        Helper.clearScreen();
        xuatDangBang();
        for (int i = 1; i < getHeader().length; i++)
            System.out.printf((i) + ". " + getHeader()[i] + "\n");
        System.out.println("3. thoát");
        System.out.println("Nhập thuộc tính cần sửa");
        int a = Helper.nhapSoNguyen("yêu cầu nhập số nguyên");
        switch (a) {
            case 1 -> {
                System.out.println("Nhập tên thể loại: ");
                this.tenTheLoai = Helper.scanner.nextLine();
            }
            case 2 -> {
                System.out.println("Nhập giới thiệu: ");
                this.gioiThieu = Helper.scanner.nextLine();
            }
            case 3 -> {
            }
            default -> {
                System.out.println("Đối số truyền vào không đúng.");
            }
        }

    }

}
