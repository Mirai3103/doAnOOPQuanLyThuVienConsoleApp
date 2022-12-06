package Model;

import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sach implements Serializable, ITableRowData {

    @Serial
    private static final long serialVersionUID = 134243242345644L;
    private int id;
    private String tenSach;
    private int tongSoTrang;
    private String ngonNgu;
    private int tacGiaId;
    private int nhaXuatBanId;
    private short namXuatBan;
    private String tinhTrang;
    private String gioiThieu;
    private int theTVNguoiMuonId = -1;
    private int giaSach;

    public int getGiaSach() {
        return giaSach;
    }

    public int getTacGiaId() {
        return tacGiaId;
    }

    public void setGiaSach(int giaSach) {
        this.giaSach = giaSach;
    }

    public Sach() {
    }

    // copy constructor
    public Sach(Sach s) {
        this.tenSach = s.tenSach;
        this.tongSoTrang = s.tongSoTrang;
        this.ngonNgu = s.ngonNgu;
        this.tacGiaId = s.tacGiaId;
        this.nhaXuatBanId = s.nhaXuatBanId;
        this.namXuatBan = s.namXuatBan;
        this.tinhTrang = s.tinhTrang;
        this.gioiThieu = s.gioiThieu;
        this.theTVNguoiMuonId = s.theTVNguoiMuonId;
        this.giaSach = s.giaSach;

    }

    public void copyTheLoai(Sach s) {
        s.getTheLoais().forEach(t -> TongHopDuLieu.getDanhSachTheLoai_sach().add(this.getId(), t.getId()));
    }

    public boolean checkDangMuon() {
        return theTVNguoiMuonId >= 0;
    }

    public void setTheTVNguoiMuonId(TheThuVien docGia) {
        if (docGia == null) {
            theTVNguoiMuonId = -1;
        } else theTVNguoiMuonId = docGia.getIDthe();
    }

    public TheThuVien getNguoiMuon() {
        return TongHopDuLieu.getDanhSachTheThuVien().getById(theTVNguoiMuonId);
    }

    public Sach(String tenSach, int tongSoTrang, String ngonNgu, TacGia tacGia, NhaXuatBan nhaXuatBan, short namXuatBan, String tinhTrang, String gioiThieu) {
        this.tenSach = tenSach;
        this.tongSoTrang = tongSoTrang;
        this.ngonNgu = ngonNgu;
        this.tacGiaId = tacGia.getId();
        this.nhaXuatBanId = nhaXuatBan.getId();
        this.namXuatBan = namXuatBan;
        this.tinhTrang = tinhTrang;
        this.gioiThieu = gioiThieu;
    }

    public void setTacGiaId(int tacGiaId) {
        this.tacGiaId = tacGiaId;
    }

    public void setNhaXuatBanId(int nhaXuatBanId) {
        this.nhaXuatBanId = nhaXuatBanId;
    }

    public void setTheTVNguoiMuonId(int nguoiMuonId) {
        this.theTVNguoiMuonId = nguoiMuonId;
    }

    public void setId(int id) {
        this.id = id;
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
        return TongHopDuLieu.getDanhSachTacGia().getById(tacGiaId);
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGiaId = tacGia.getId();
    }

    public NhaXuatBan getNhaXuatBan() {
        return TongHopDuLieu.getDanhSachNhaXuatBan().getById(this.nhaXuatBanId);
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
        List<TheLoai_Sach> theLoaiId = TongHopDuLieu.getDanhSachTheLoai_sach().getTheLoai_saches().stream().filter(t -> t.getSachId() == this.id).toList();
        List<TheLoai> theLoais = new ArrayList<>();
        for (TheLoai_Sach theLoai_sach : theLoaiId) {
            TheLoai t = TongHopDuLieu.getKhoTheLoai().getById(theLoai_sach.getTheLoaiId());
            if (t != null) theLoais.add(t);
        }
        return theLoais;
    }

    public void themTheLoai(TheLoai theLoai) {
        TongHopDuLieu.getDanhSachTheLoai_sach().add(this.id, theLoai.getId());
    }

    public void nhapSach() {
        System.out.println("Nhập tên sách: ");
        this.tenSach = Helper.inputNoneEmptyString();
        System.out.println("Nhập tổng số trang: ");
        this.tongSoTrang = Helper.nhapSoNguyen("Tổng số trang phải là số nguyên dương");
        System.out.println("Nhập ngôn ngữ: ");
        this.ngonNgu = Helper.inputNoneEmptyString();
        System.out.println("Nhập tác giả: ");
        // hỏi người dùng có muốn nhập tác giả mới không hay chọn từ danh sách tác giả
        nhapTacGia();
        String chon;
        System.out.println("Nhập nhà xuất bản: ");
        System.out.println("Bạn có muốn nhập nhà xuất bản mới không? (y/n)");
        chon = Helper.inputNoneEmptyString();
        nhapNhaXuatBan(chon);
        do {
            System.out.println("Nhập năm xuất bản: ");
            this.namXuatBan = (short) Helper.nhapSoNguyen("Năm xuất bản phải là số nguyên dương");
        } while (this.namXuatBan < 0);
        System.out.println("Nhập tình trạng: ");
        this.tinhTrang = Helper.inputNoneEmptyString();
        System.out.println("Nhập giá: ");
        this.giaSach = Helper.nhapSoNguyen("Giá phải là số nguyên dương");
        while (this.giaSach < 0) {
            System.out.println("Giá phải là số nguyên dương");
            this.giaSach = Helper.nhapSoNguyen("Giá phải là số nguyên dương");
        }
        System.out.println("Nhập giới thiệu: ");
        this.gioiThieu = Helper.inputNoneEmptyString();

    }

    private void nhapNhaXuatBan(String chon) {
        if ((chon.charAt(0) + "").equalsIgnoreCase("y")) {
            NhaXuatBan nhaXuatBan = new NhaXuatBan();
            nhaXuatBan.nhap();
            TongHopDuLieu.getDanhSachNhaXuatBan().add(nhaXuatBan);
            this.nhaXuatBanId = nhaXuatBan.getId();
        } else {
            boolean validId = false;
            while (!validId) {
                TongHopDuLieu.getDanhSachNhaXuatBan().xuatConsoleDangTable();
                System.out.println("Nhập id nhà xuất bản: ");
                this.nhaXuatBanId = Helper.nhapSoNguyen("Id phải là số nguyên dương");
                //kiểm tra id có tồn tại trong danh sách nhà xuất bản không

                if (TongHopDuLieu.getDanhSachNhaXuatBan().getById(this.nhaXuatBanId) != null) {
                    validId = true;
                } else {
                    System.out.println("Id không tồn tại trong danh sách nhà xuất bản");
                }
            }
        }
    }

    public void nhapTheLoaiChoSach() {
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("Nhập thể loại: ");
            TongHopDuLieu.getKhoTheLoai().xuatConsoleDangTable();
            System.out.println();
            System.out.println("Bạn muốn taọ thể loại mới không? (y/n)");
            if (Helper.inputNoneEmptyString().equals("y")) {
                TheLoai theLoai = new TheLoai();
                theLoai.nhap();
                TongHopDuLieu.getKhoTheLoai().add(theLoai);
                this.themTheLoai(theLoai);
            } else {

                System.out.println("Nhập id thể loại: ");
                int theLoaiId = Helper.nhapSoNguyen("Id phải là số nguyên dương");
                TheLoai theLoai = TongHopDuLieu.getKhoTheLoai().getById(theLoaiId);
                if (theLoai != null) {
                    this.themTheLoai(theLoai);
                } else {
                    System.out.println("Không tìm thấy thể loại với id: " + theLoaiId);
                }
            }

            System.out.println("Bạn có muốn nhập thêm thể loại không? (y/n)");
            tiepTuc = Helper.inputNoneEmptyString().equalsIgnoreCase("y");
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

    @Override
    public String[] getRowData() {
        var danhSachTheLoai = getTheLoais();
        var theLoai = String.join(" - ", danhSachTheLoai.stream().map(TheLoai::getTenTheLoai).toList());
        return new String[]{
                this.id + "",
                this.tenSach,
                this.tongSoTrang + "",
                this.ngonNgu, this.giaSach + "",
                this.getTacGia().getTenTacGia(),
                this.getNhaXuatBan().getTenNXB(),
                this.namXuatBan + "",
                this.tinhTrang,
                this.gioiThieu,
                this.checkDangMuon() ? "Đang mượn" : "đang có sẵn",
                theLoai
        };
    }

    @Override
    public String[] getHeader() {
        return new String[]{"Id", "Tên sách", "Tổng số trang", "Ngôn ngữ", "Giá sách", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Tình trạng", "Giới thiệu", "Tình trạng mượn", "Thể loại"};
    }

    public void sua() {

        System.out.println(Table.taoBang(this));
        for (int i = 1; i < getHeader().length; i++) {
            if (i != 10)
                System.out.printf(i + ". Sửa" + getHeader()[i] + "\n");
        }
        System.out.println("12.Thoát");
        System.out.println("Nhập thuộc tính cần sửa");
        int a = Helper.nhapSoNguyen("yêu cầu nhập số nguyên");
        switch (a) {
            case 1 -> {
                System.out.println("Sửa tên sách: ");
                this.tenSach = Helper.inputNoneEmptyString();
            }
            case 2 -> {
                System.out.println("Sửa tổng số trang: ");
                this.tongSoTrang = Helper.nhapSoNguyen("Yêu cầu người dùng nhập số nguyên dương");
            }
            case 3 -> {
                System.out.println("Sửa ngôn ngữ sách: ");

                this.ngonNgu = Helper.nhapTen();
            }
            case 4 -> {
                System.out.println("Nhập giá: ");
                this.giaSach = Helper.nhapSoNguyen("Giá phải là số nguyên dương");
                while (this.giaSach < 0) {
                    System.out.println("Giá phải là số nguyên dương");
                    this.giaSach = Helper.nhapSoNguyen("Giá phải là số nguyên dương");
                }
            }
            case 5 -> {
                getTacGia().xuatDangBang();
                System.out.println("Sửa tác giả: ");

                nhapTacGia();
            }
            case 6 -> {
                System.out.println(Table.taoBang(getNhaXuatBan()));
                System.out.println("Nhập nhà xuất bản: ");
                System.out.println("Bạn có muốn nhập nhà xuất bản mới không? (y/n)");
                String chon = Helper.inputNoneEmptyString();
                nhapNhaXuatBan(chon);
            }
            case 7 -> {
                do {
                    System.out.println("Sửa năm xuất bản: ");
                    System.out.println("Nhập năm xuất bản: ");
                    this.namXuatBan = (short) Helper.nhapSoNguyen("Năm xuất bản phải là số nguyên dương");
                    if (this.namXuatBan > 2022) {
                        System.out.println("Năm xuất bản phải nhỏ hơn năm hiện tại");
                    }
                } while (this.namXuatBan < 0 || this.namXuatBan > 2022);
            }
            case 8 -> {
                System.out.println("Nhập tình trạng: ");
                this.tinhTrang = Helper.inputNoneEmptyString();
            }
            case 9 -> {
                System.out.println("Nhập giới thiệu: ");
                this.gioiThieu = Helper.inputNoneEmptyString();
            }
            case 11 -> {
                System.out.println("Sửa thể loại sách: ");
                System.out.println(Table.taoBang(new ArrayList<>(getTheLoais())));
                System.out.println("Bạn muốn thêm hay xóa thể loại sách? (t/x)");
                String chon = Helper.inputNoneEmptyString();
                if ((chon.charAt(0) + "").equalsIgnoreCase("t")) {
                    nhapTheLoaiChoSach();
                } else if ((chon.charAt(0) + "").equalsIgnoreCase("x")) {
                    boolean tiepTuc = true;
                    while (tiepTuc) {
                        xoaTheLoaiChoSach();
                        System.out.println("Bạn có muốn xóa thể loại khác không? y/n");
                        tiepTuc = Helper.inputNoneEmptyString().charAt(0) == 'y';
                    }
                }
            }
            case 12 ->{
            }
            default -> {
                System.out.println("đối số truyền vào không đúng");
            }
        }

    }

    private void nhapTacGia() {
        System.out.println("Bạn có muốn nhập tác giả mới không? (y/n)");
        String chon = Helper.inputNoneEmptyString();
        if ((chon.charAt(0) + "").equalsIgnoreCase("y")) {
            TacGia tacGia = new TacGia();
            tacGia.nhap();
            TongHopDuLieu.getDanhSachTacGia().getAll().add(tacGia);
            this.tacGiaId = tacGia.getId();
        } else {
            boolean validId = false;
            while (!validId) {
                TongHopDuLieu.getDanhSachTacGia().xuatConsoleDangTable();
                System.out.println("Nhập id tác giả: ");
                this.tacGiaId = Helper.nhapSoNguyen("Id phải là số nguyên dương");
                //kiểm tra id có tồn tại trong danh sách tác giả không

                if (TongHopDuLieu.getDanhSachTacGia().getById(this.tacGiaId) != null) {
                    validId = true;
                } else {
                    System.out.println("Id không tồn tại trong danh sách tác giả");
                }
            }
        }
    }

    private void xoaTheLoaiChoSach() {
        System.out.println("Nhập id thể loại muốn xóa khỏi sách này: ");
        int id = Helper.nhapSoNguyen("Id phải là số nguyên dương");
        var theLoaiCanXoa = getTheLoais().stream().filter(tl -> tl.getId() == id).findFirst().orElse(null);
        if (theLoaiCanXoa != null) {
            TongHopDuLieu.getDanhSachTheLoai_sach().getTheLoai_saches().removeIf(tl -> tl.getSachId() == this.id && tl.getTheLoaiId() == theLoaiCanXoa.getId());
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Id không tồn tại trong danh sách thể loại");
        }

    }

    public static void main(String[] args) {
        Sach a = new Sach();
        a.sua();
    }
}
