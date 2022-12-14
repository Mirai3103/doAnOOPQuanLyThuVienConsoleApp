package Model;

import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class MuonTra implements Serializable, ITableRowData {
    @Serial
    private static final long serialVersionUID = -23136354210367639L;
    protected int IDmt;
    protected int IDthe;
    protected String IDnv;
    protected LocalDate ngayLapPhieu;

    public MuonTra() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ngayLapPhieu = LocalDate.now();
    }

    public MuonTra(int IDmt, int IDthe, String IDnv, LocalDate ngayLapPhieu) {
        this.IDmt = IDmt;
        this.IDthe = IDthe;
        this.IDnv = IDnv;
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public MuonTra(int IDmt, int IDthe, String IDnv, String ngaymuon) {
        this.IDthe = IDthe;
        this.IDnv = IDnv;
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.ngayLapPhieu = LocalDate.parse(ngaymuon, formatter);

    }

    public void suaPhieuMuon() {

        xuatPhieu();

        int choose;
        do {
            System.out.println("1. Sửa ngày mượn");
            System.out.println("2. Sửa chi tiết mượn trả");
            System.out.println("3. Thoát");
            System.out.println("Nhập lựa chọn: ");
            choose = Helper.nhapSoNguyen("Lựa chọn không hợp lệ. Vui lòng nhập lại: ");
            switch (choose) {
                case 1 -> {
                    System.out.println("Nhập ngày mượn mới: ");
                    var isValidate = false;
                    do {
                        var ngaymuon = Helper.inputNoneEmptyString();
                        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        try {
                            this.ngayLapPhieu = LocalDate.parse(ngaymuon, formatter);
                            isValidate = true;
                        } catch (Exception e) {
                            System.out.println("Ngày mượn không hợp lệ. Vui lòng nhập lại: ");
                        }
                    } while (!isValidate);
                }
                case 2 -> {
                    var dsctmt = getCTMuontras();
                    System.out.println(Table.taoBang(dsctmt));
                    System.out.println("Nhap id sach trong chi tiet muon tra can sua: ");
                    int id = Helper.nhapSoNguyen("Id khong hop le. Vui long nhap lai: ");
                    var ctmt = dsctmt.stream().filter(x -> x.getIDsach() == id).findFirst().orElse(null);
                    if (ctmt == null) {
                        System.out.println("Khong tim thay sach trong chi tiet muon tra");
                    } else {
                        ctmt.suaCTMuonTra();
                    }
                }
                case 3 -> System.out.println("Thoat");
                default -> System.out.println("Lua chon khong hop le. Vui long nhap lai: ");
            }
        } while (choose != 3);
    }

    @Override
    public String toString() {
        return "MuonTra [ID=" + IDmt + ", IDthe=" + IDthe + ", IDnv=" + IDnv + ", ngaymuon=" + ngayLapPhieu + "]";
    }

    public void setIDmt(int IDmt) {
        this.IDmt = IDmt;
    }

    public void setNgayLapPhieu(LocalDate ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public int getIDmt() {
        return IDmt;
    }

    public int getIDthe() {
        return IDthe;
    }

    public void setIDthe(int IDthe) {
        this.IDthe = IDthe;
    }

    public String getIDnv() {
        return IDnv;
    }

    public void setIDnv(String IDnv) {
        this.IDnv = IDnv;
    }

    public LocalDate getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void nhapPhieuMuonTra() {
        while (true) {
            System.out.print("Nhập số thẻ: ");
            IDthe = Integer.parseInt(Helper.inputNoneEmptyString());
            var theTv = TongHopDuLieu.getDanhSachTheThuVien().getById(IDthe);

            if (theTv == null) {
                System.out.println("Không tìm thấy thẻ thư viện");
            } else {
                var dsPhieu = TongHopDuLieu.getDanhSachPhieuMuonTra().getByTheThuVienId(IDthe);
                if (dsPhieu.size() == 0) {
                    return;
                }
                dsPhieu.forEach(x -> {
                    x.getCTMuontras().forEach(y -> {
                        if (y.getNgaytra() == null) {
                            x.xuatPhieu();
                            throw new RuntimeException("Bạn đang mượn sách. Vui lòng trả sách trước khi mượn sách mới");
                        }
                    });
                });

                break;
            }
        }

    }

    public void menuSua() {
        System.out.println("1. Sửa id thẻ mượn");
        System.out.println("2. Sửa id sửa id nhân viên cho mượn");
        System.out.println("3. Sửa id sửa id nhân viên cho mượn");
    }

    public void sua() {

    }

    @Override
    public String[] getRowData() {
        return new String[]{
                this.IDmt + "",
                this.IDthe + "",
                this.IDnv + "",
                this.ngayLapPhieu.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
        };
    }

    @Override
    public String[] getHeader() {
        return new String[]{"IDmt", "IDthe", "IDnv", "Ngày mượn"};
    }

    public ArrayList<CTMuonTra> getCTMuontras() {
        return TongHopDuLieu.getDanhSachCTMuonTra().getChiTietPhieuMuong(this.IDmt);
    }

    public void xoaMuonTra(int IdCtMuonTra, int idSach) {
        TongHopDuLieu.getDanhSachCTMuonTra().xoaCTMuonTra(IdCtMuonTra, idSach);
        TongHopDuLieu.getKhoSach().getById(idSach).setTheTVNguoiMuonId(-1);
    }

    public void xoaTatCaCtMuonTra() {
        var ctMuonTras = getCTMuontras();
        for (CTMuonTra ctMuonTra : ctMuonTras) {
            TongHopDuLieu.getDanhSachCTMuonTra().xoaCTMuonTra(ctMuonTra.getIdPhieuMuon(), ctMuonTra.getIDsach());
            TongHopDuLieu.getKhoSach().getById(ctMuonTra.getIDsach()).setTheTVNguoiMuonId(-1);
        }
    }
    public NhanVien getNhanVien() {
        return TongHopDuLieu.getNhanViens().getByMaNV(this.IDnv);
    }

    public void xuatPhieu() {
        System.out.println("ID phiếu mượn: " + this.IDmt);
        System.out.println("ID thẻ thư viện: " + this.IDthe);
        System.out.println("ID nhân viên lập phiếu: " + this.IDnv+" - Tên nhân viên lập phiếu: "+getNhanVien().getHoTen());
        System.out.println("Ngày mượn: " + this.ngayLapPhieu);
        System.out.print("Id độc giả mượn: " + TongHopDuLieu.getDanhSachTheThuVien().getById(this.IDthe).getIDuser());
        System.out.println(" - Người mượn: " + TongHopDuLieu.getDanhSachTheThuVien().getById(this.IDthe).getUser().getHoTen());
        ArrayList<CTMuonTra> ctMuonTras = getCTMuontras();
        System.out.println("Danh sách sách mượn: ");
        System.out.println(Table.taoBang(ctMuonTras));
    }

    public int tinhTienPhat() {
        int tienPhat = 0;
        ArrayList<CTMuonTra> ctMuonTras = getCTMuontras();
        for (CTMuonTra ctMuonTra : ctMuonTras) {
            tienPhat += ctMuonTra.getTienPhat();
        }
        return tienPhat;
    }

    public TheThuVien getTheThuVien() {
        return TongHopDuLieu.getDanhSachTheThuVien().getById(this.IDthe);
    }

}
