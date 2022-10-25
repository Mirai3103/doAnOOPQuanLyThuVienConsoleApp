package Model;

import helper.Helper;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sach implements Serializable {
    public  static int idIncrement = 0;
    @Serial
    private static final long serialVersionUID = 134243242345644L;
    private final int id;
    private String tenSach;
    private int tongSoTrang;
    private String ngonNgu;
    private int tacGiaId;
    private int nhaXuatBanId;
    private short namXuatBan;
    private String tinhTrang;
    private String gioiThieu;


    public Sach() {
        this.id = Sach.idIncrement++;
    }

    public Sach(int id, String tenSach, int tongSoTrang, String ngonNgu, TacGia tacGia, NhaXuatBan nhaXuatBan, short namXuatBan, String tinhTrang, String gioiThieu) {
        this.id = Sach.idIncrement++;
        this.tenSach = tenSach;
        this.tongSoTrang = tongSoTrang;
        this.ngonNgu = ngonNgu;
        this.tacGiaId = tacGia.getId();
        this.nhaXuatBanId = nhaXuatBan.getId();
        this.namXuatBan = namXuatBan;
        this.tinhTrang = tinhTrang;
        this.gioiThieu = gioiThieu;
    }

    public int getId() {
        return id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getTongSoTrang() {
        return tongSoTrang;
    }

    public void setTongSoTrang(int tongSoTrang) {
        this.tongSoTrang = tongSoTrang;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public TacGia getTacGia() {
        return Helper.khoDuLieu.getDanhSachTacGia().findById(tacGiaId);
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGiaId = tacGia.getId();
    }

    public NhaXuatBan getNhaXuatBan() {
        return Helper.khoDuLieu.getDanhSachNhaXuatBan().findById(this.nhaXuatBanId);
    }

    public int getNhaXuatBanId() {
        return this.nhaXuatBanId;
    }

    public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
        this.nhaXuatBanId = nhaXuatBan.getId();
    }

    public short getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(short namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public List<TheLoai> getTheLoais() {
        List<TheLoai_Sach> theLoaiId = Helper.khoDuLieu.getDanhSachTheLoai_sach().getTheLoai_saches().stream().filter(t -> t.getSachId() == this.id).toList();
        List<TheLoai> theLoais = new ArrayList<>();
        for (TheLoai_Sach theLoai_sach : theLoaiId) {
            TheLoai t = Helper.khoDuLieu.getKhoTheLoai().findById(theLoai_sach.getTheLoaiId());
            if (t != null) theLoais.add(t);
        }
        return theLoais;
    }

    public void themTheLoai(TheLoai theLoai) {
        Helper.khoDuLieu.getDanhSachTheLoai_sach().add(this.id, theLoai.getId());
    }

    public void nhapSach() {
        System.out.println("Nhập tên sách: ");
        this.tenSach = Helper.scanner.nextLine();
        System.out.println("Nhập tổng số trang: ");
        this.tongSoTrang = Helper.nhapSoNguyen("Tổng số trang phải là số nguyên dương");
        System.out.println("Nhập ngôn ngữ: ");
        this.ngonNgu = Helper.scanner.nextLine();
        System.out.println("Nhập tác giả: ");
        // hỏi người dùng có muốn nhập tác giả mới không hay chọn từ danh sách tác giả
        System.out.println("Bạn có muốn nhập tác giả mới không? (y/n)");
        String chon = Helper.scanner.nextLine();
        if ((chon.charAt(0) + "").equalsIgnoreCase("y")) {
            TacGia tacGia = new TacGia();
            tacGia.nhap();
            Helper.khoDuLieu.getDanhSachTacGia().getTacGias().add(tacGia);
            this.tacGiaId = tacGia.getId();
        } else {
            boolean validId = false;
            while (!validId) {
                Helper.khoDuLieu.getDanhSachTacGia().xuatDanhSachTacGia();
                System.out.println("Nhập id tác giả: ");
                this.tacGiaId = Helper.nhapSoNguyen("Id phải là số nguyên dương");
                //kiểm tra id có tồn tại trong danh sách tác giả không

                if (Helper.khoDuLieu.getDanhSachTacGia().findById(this.tacGiaId) != null) {
                    validId = true;
                } else {
                    System.out.println("Id không tồn tại trong danh sách tác giả");
                }
            }
        }
        System.out.println("Nhập nhà xuất bản: ");
        System.out.println("Bạn có muốn nhập nhà xuất bản mới không? (y/n)");
        chon = Helper.scanner.nextLine();
        if ((chon.charAt(0) + "").equalsIgnoreCase("y")) {
            NhaXuatBan nhaXuatBan = new NhaXuatBan();
            nhaXuatBan.nhap();
            Helper.khoDuLieu.getDanhSachNhaXuatBan().getData().add(nhaXuatBan);
            this.nhaXuatBanId = nhaXuatBan.getId();
        } else {
            boolean validId = false;
            while (!validId) {
                Helper.khoDuLieu.getDanhSachNhaXuatBan().showAll();
                System.out.println("Nhập id nhà xuất bản: ");
                this.nhaXuatBanId = Helper.nhapSoNguyen("Id phải là số nguyên dương");
                //kiểm tra id có tồn tại trong danh sách nhà xuất bản không

                if (Helper.khoDuLieu.getDanhSachNhaXuatBan().findById(this.nhaXuatBanId) != null) {
                    validId = true;
                } else {
                    System.out.println("Id không tồn tại trong danh sách nhà xuất bản");
                }
            }
        }
        System.out.println("Nhập năm xuất bản: ");
        this.namXuatBan = (short) Helper.nhapSoNguyen("Năm xuất bản phải là số nguyên dương");
        System.out.println("Nhập tình trạng: ");
        this.tinhTrang = Helper.scanner.nextLine();
        System.out.println("Nhập giới thiệu: ");
        this.gioiThieu = Helper.scanner.nextLine();
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("Nhập thể loại: ");
            Helper.khoDuLieu.getKhoTheLoai().showAll();
            System.out.println();
            System.out.println("Bạn muốn taọ thể loại mới không? (y/n)");
            if (Helper.scanner.nextLine().equals("y")) {
                TheLoai theLoai = new TheLoai();
                theLoai.nhap();
                Helper.khoDuLieu.getKhoTheLoai().getTheLoais().add(theLoai);
                this.themTheLoai(theLoai);
            } else {

                System.out.println("Nhập id thể loại: ");
                int theLoaiId = Helper.nhapSoNguyen("Id phải là số nguyên dương");
                TheLoai theLoai = Helper.khoDuLieu.getKhoTheLoai().findById(theLoaiId);
                if (theLoai != null) {
                    this.themTheLoai(theLoai);
                } else {
                    System.out.println("Không tìm thấy thể loại với id: " + theLoaiId);
                }
            }

            System.out.println("Bạn có muốn nhập thêm thể loại không? (y/n)");
            tiepTuc = Helper.scanner.nextLine().equalsIgnoreCase("y");
        }
    }

    public void xuatSach() {
        System.out.println("Tên sách: " + this.tenSach);
        System.out.println("Tổng số trang: " + this.tongSoTrang);
        System.out.println("Ngôn ngữ: " + this.ngonNgu);
//        System.out.println("Tác giả: " + this.getTacGia().getTenTacGia());
//        System.out.println("Nhà xuất bản: " + this.getNhaXuatBan().getTenNhaXuatBan());
        System.out.println("Năm xuất bản: " + this.namXuatBan);
        System.out.println("Tình trạng: " + this.tinhTrang);
        System.out.println("Giới thiệu: " + this.gioiThieu);
        System.out.print("Thể loại: ");
        for (TheLoai theLoai : this.getTheLoais()) {
            System.out.print(theLoai.getTenTheLoai() + "; ");
        }
    }
}
