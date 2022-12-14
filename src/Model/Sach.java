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
        System.out.println("Nh???p t??n s??ch: ");
        this.tenSach = Helper.inputNoneEmptyString();
        System.out.println("Nh???p t???ng s??? trang: ");
        this.tongSoTrang = Helper.nhapSoNguyen("T???ng s??? trang ph???i l?? s??? nguy??n d????ng");
        System.out.println("Nh???p ng??n ng???: ");
        this.ngonNgu = Helper.inputNoneEmptyString();
        System.out.println("Nh???p t??c gi???: ");
        // h???i ng?????i d??ng c?? mu???n nh???p t??c gi??? m???i kh??ng hay ch???n t??? danh s??ch t??c gi???
        nhapTacGia();
        String chon;
        System.out.println("Nh???p nh?? xu???t b???n: ");
        System.out.println("B???n c?? mu???n nh???p nh?? xu???t b???n m???i kh??ng? (y/n)");
        chon = Helper.inputNoneEmptyString();
        nhapNhaXuatBan(chon);
        do {
            System.out.println("Nh???p n??m xu???t b???n: ");
            this.namXuatBan = (short) Helper.nhapSoNguyen("N??m xu???t b???n ph???i l?? s??? nguy??n d????ng");
        } while (this.namXuatBan < 0);
        System.out.println("Nh???p t??nh tr???ng: ");
        this.tinhTrang = Helper.inputNoneEmptyString();
        System.out.println("Nh???p gi??: ");
        this.giaSach = Helper.nhapSoNguyen("Gi?? ph???i l?? s??? nguy??n d????ng");
        while (this.giaSach < 0) {
            System.out.println("Gi?? ph???i l?? s??? nguy??n d????ng");
            this.giaSach = Helper.nhapSoNguyen("Gi?? ph???i l?? s??? nguy??n d????ng");
        }
        System.out.println("Nh???p gi???i thi???u: ");
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
                System.out.println("Nh???p id nh?? xu???t b???n: ");
                this.nhaXuatBanId = Helper.nhapSoNguyen("Id ph???i l?? s??? nguy??n d????ng");
                //ki???m tra id c?? t???n t???i trong danh s??ch nh?? xu???t b???n kh??ng

                if (TongHopDuLieu.getDanhSachNhaXuatBan().getById(this.nhaXuatBanId) != null) {
                    validId = true;
                } else {
                    System.out.println("Id kh??ng t???n t???i trong danh s??ch nh?? xu???t b???n");
                }
            }
        }
    }

    public void nhapTheLoaiChoSach() {
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("Nh???p th??? lo???i: ");
            TongHopDuLieu.getKhoTheLoai().xuatConsoleDangTable();
            System.out.println();
            System.out.println("B???n mu???n ta??? th??? lo???i m???i kh??ng? (y/n)");
            if (Helper.inputNoneEmptyString().equals("y")) {
                TheLoai theLoai = new TheLoai();
                theLoai.nhap();
                TongHopDuLieu.getKhoTheLoai().add(theLoai);
                this.themTheLoai(theLoai);
            } else {

                System.out.println("Nh???p id th??? lo???i: ");
                int theLoaiId = Helper.nhapSoNguyen("Id ph???i l?? s??? nguy??n d????ng");
                TheLoai theLoai = TongHopDuLieu.getKhoTheLoai().getById(theLoaiId);
                if (theLoai != null) {
                    this.themTheLoai(theLoai);
                } else {
                    System.out.println("Kh??ng t??m th???y th??? lo???i v???i id: " + theLoaiId);
                }
            }

            System.out.println("B???n c?? mu???n nh???p th??m th??? lo???i kh??ng? (y/n)");
            tiepTuc = Helper.inputNoneEmptyString().equalsIgnoreCase("y");
        }
    }

    public void xuatSach() {
        System.out.println("T??n s??ch: " + this.tenSach);
        System.out.println("T???ng s??? trang: " + this.tongSoTrang);
        System.out.println("Ng??n ng???: " + this.ngonNgu);
//        System.out.println("T??c gi???: " + this.getTacGia().getTenTacGia());
//        System.out.println("Nh?? xu???t b???n: " + this.getNhaXuatBan().getTenNhaXuatBan());
        System.out.println("N??m xu???t b???n: " + this.namXuatBan);
        System.out.println("T??nh tr???ng: " + this.tinhTrang);
        System.out.println("Gi???i thi???u: " + this.gioiThieu);
        System.out.print("Th??? lo???i: ");
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
                this.checkDangMuon() ? "??ang m?????n" : "??ang c?? s???n",
                theLoai
        };
    }

    @Override
    public String[] getHeader() {
        return new String[]{"Id", "T??n s??ch", "T???ng s??? trang", "Ng??n ng???", "Gi?? s??ch", "T??c gi???", "Nh?? xu???t b???n", "N??m xu???t b???n", "T??nh tr???ng", "Gi???i thi???u", "T??nh tr???ng m?????n", "Th??? lo???i"};
    }

    public void sua() {

        System.out.println(Table.taoBang(this));
        for (int i = 1; i < getHeader().length; i++) {
            if (i != 10)
                System.out.printf(i + ". S???a" + getHeader()[i] + "\n");
        }
        System.out.println("12.Tho??t");
        System.out.println("Nh???p thu???c t??nh c???n s???a");
        int a = Helper.nhapSoNguyen("y??u c???u nh???p s??? nguy??n");
        switch (a) {
            case 1 -> {
                System.out.println("S???a t??n s??ch: ");
                this.tenSach = Helper.inputNoneEmptyString();
            }
            case 2 -> {
                System.out.println("S???a t???ng s??? trang: ");
                this.tongSoTrang = Helper.nhapSoNguyen("Y??u c???u ng?????i d??ng nh???p s??? nguy??n d????ng");
            }
            case 3 -> {
                System.out.println("S???a ng??n ng??? s??ch: ");

                this.ngonNgu = Helper.nhapTen();
            }
            case 4 -> {
                System.out.println("Nh???p gi??: ");
                this.giaSach = Helper.nhapSoNguyen("Gi?? ph???i l?? s??? nguy??n d????ng");
                while (this.giaSach < 0) {
                    System.out.println("Gi?? ph???i l?? s??? nguy??n d????ng");
                    this.giaSach = Helper.nhapSoNguyen("Gi?? ph???i l?? s??? nguy??n d????ng");
                }
            }
            case 5 -> {
                getTacGia().xuatDangBang();
                System.out.println("S???a t??c gi???: ");

                nhapTacGia();
            }
            case 6 -> {
                System.out.println(Table.taoBang(getNhaXuatBan()));
                System.out.println("Nh???p nh?? xu???t b???n: ");
                System.out.println("B???n c?? mu???n nh???p nh?? xu???t b???n m???i kh??ng? (y/n)");
                String chon = Helper.inputNoneEmptyString();
                nhapNhaXuatBan(chon);
            }
            case 7 -> {
                do {
                    System.out.println("S???a n??m xu???t b???n: ");
                    System.out.println("Nh???p n??m xu???t b???n: ");
                    this.namXuatBan = (short) Helper.nhapSoNguyen("N??m xu???t b???n ph???i l?? s??? nguy??n d????ng");
                    if (this.namXuatBan > 2022) {
                        System.out.println("N??m xu???t b???n ph???i nh??? h??n n??m hi???n t???i");
                    }
                } while (this.namXuatBan < 0 || this.namXuatBan > 2022);
            }
            case 8 -> {
                System.out.println("Nh???p t??nh tr???ng: ");
                this.tinhTrang = Helper.inputNoneEmptyString();
            }
            case 9 -> {
                System.out.println("Nh???p gi???i thi???u: ");
                this.gioiThieu = Helper.inputNoneEmptyString();
            }
            case 11 -> {
                System.out.println("S???a th??? lo???i s??ch: ");
                System.out.println(Table.taoBang(new ArrayList<>(getTheLoais())));
                System.out.println("B???n mu???n th??m hay x??a th??? lo???i s??ch? (t/x)");
                String chon = Helper.inputNoneEmptyString();
                if ((chon.charAt(0) + "").equalsIgnoreCase("t")) {
                    nhapTheLoaiChoSach();
                } else if ((chon.charAt(0) + "").equalsIgnoreCase("x")) {
                    boolean tiepTuc = true;
                    while (tiepTuc) {
                        xoaTheLoaiChoSach();
                        System.out.println("B???n c?? mu???n x??a th??? lo???i kh??c kh??ng? y/n");
                        tiepTuc = Helper.inputNoneEmptyString().charAt(0) == 'y';
                    }
                }
            }
            case 12 ->{
            }
            default -> {
                System.out.println("?????i s??? truy???n v??o kh??ng ????ng");
            }
        }

    }

    private void nhapTacGia() {
        System.out.println("B???n c?? mu???n nh???p t??c gi??? m???i kh??ng? (y/n)");
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
                System.out.println("Nh???p id t??c gi???: ");
                this.tacGiaId = Helper.nhapSoNguyen("Id ph???i l?? s??? nguy??n d????ng");
                //ki???m tra id c?? t???n t???i trong danh s??ch t??c gi??? kh??ng

                if (TongHopDuLieu.getDanhSachTacGia().getById(this.tacGiaId) != null) {
                    validId = true;
                } else {
                    System.out.println("Id kh??ng t???n t???i trong danh s??ch t??c gi???");
                }
            }
        }
    }

    private void xoaTheLoaiChoSach() {
        System.out.println("Nh???p id th??? lo???i mu???n x??a kh???i s??ch n??y: ");
        int id = Helper.nhapSoNguyen("Id ph???i l?? s??? nguy??n d????ng");
        var theLoaiCanXoa = getTheLoais().stream().filter(tl -> tl.getId() == id).findFirst().orElse(null);
        if (theLoaiCanXoa != null) {
            TongHopDuLieu.getDanhSachTheLoai_sach().getTheLoai_saches().removeIf(tl -> tl.getSachId() == this.id && tl.getTheLoaiId() == theLoaiCanXoa.getId());
            System.out.println("X??a th??nh c??ng");
        } else {
            System.out.println("Id kh??ng t???n t???i trong danh s??ch th??? lo???i");
        }

    }

    public static void main(String[] args) {
        Sach a = new Sach();
        a.sua();
    }
}
