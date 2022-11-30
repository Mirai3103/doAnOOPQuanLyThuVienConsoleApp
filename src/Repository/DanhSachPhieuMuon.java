package Repository;

import Model.CTMuonTra;
import Model.DocGia;
import Model.MuonTra;
import helper.Helper;
import helper.Xuat.Table;

import java.io.Serial;
import java.time.LocalDate;
import java.util.ArrayList;


public class DanhSachPhieuMuon extends BaseDanhSach<MuonTra> {
    @Serial
    private static final long serialVersionUID = 1980612L;
    public static final String FILE_PATH = Helper.dirPath + "DanhSachPhieuMuon.bin";
    private int idIdentity = 0;


    @Override
    public void copyFrom(IDanhSach<MuonTra> other) {
        var otherMuonTras = (DanhSachPhieuMuon) other;
        this.idIdentity = otherMuonTras.idIdentity;
        this.data = otherMuonTras.data;
    }

    @Override
    public void add(MuonTra item) {
        item.setIDmt(idIdentity++);
        data.add(item);
    }

    public MuonTra getById(int id) {
        return data.stream().filter(s -> s.getIDmt() == id).findFirst().orElse(null);
    }

    public void muonSach() {
        MuonTra muonTra = new MuonTra();
        muonTra.nhapPhieuMuonTra();
        muonTra.setIDnv(Main.Main.nguoiDung.getMaNV());
        System.out.println("Bạn muốn mượn bao nhiêu cuôn sách");
        this.add(muonTra);
        int n = Helper.nhapSoNguyen("Số lượng sách không hợp lệ, nhập lại: ");
        for (int i = 0; i < n; i++) {
            var isOk = false;
            while (isOk) {
                System.out.println(Table.taoBang(TongHopDuLieu.getKhoSach().laySachDangCoSan()));
                System.out.println("Nhập id cuốn sách cần mượn thứ " + (i + 1) + " ");
                var id = Helper.nhapSoNguyen("Id sách không hợp lệ!, nhập lại: ");
                var sachCanMuon = TongHopDuLieu.getKhoSach().getById(id);
                if (sachCanMuon == null) {
                    System.out.println("Không tìm thấy sách có id " + id);
                    i--;
                    continue;
                }
                var Ctmuon = new CTMuonTra();

                try {
                    Ctmuon.setIdPhieuMuon(muonTra.getIDmt());
                    Ctmuon.setIDsach(sachCanMuon.getId());
                    sachCanMuon.setTheTVNguoiMuonId(muonTra.getIDthe());
                    Ctmuon.nhapCTMuonTra();
                    TongHopDuLieu.getDanhSachCTMuonTra().add(Ctmuon);
                    isOk = true;
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    System.out.println("Nhập lại: ");
                    isOk = false;
                }

            }


        }
        muonTra.xuatPhieu();
    }

    public void traSach() {
        System.out.println("Nhập mã phiếu mượn");
        var id = Helper.nhapSoNguyen("Id không hợp lệ");
        var muonTra = getById(id);
        if (muonTra == null) {
            System.out.println("Không tìm thấy phiếu mượn");
            return;
        }
        var danhSachSachMuon = TongHopDuLieu.getDanhSachCTMuonTra().getChiTietPhieuMuong(muonTra.getIDmt());
        for (var ctmt : danhSachSachMuon) {
            if (ctmt.getNgaytra() == null) {
                System.out.println(Table.taoBang(ctmt.getBook()));
                System.out.println("Bạn có muốn trả sách này không? (y/n)");
                var answer = Helper.scanner.nextLine().charAt(0);
                if (answer == 'y') {
                    ctmt.setNgayhentra(LocalDate.now());
                    System.out.println("Trả sách thành công");
                    ctmt.getBook().setTheTVNguoiMuonId(null);
                }
                System.out.println("Có phạt không? (y/n)");
                answer = Helper.scanner.nextLine().charAt(0);
                if (answer == 'y') {
                    TongHopDuLieu.getDanhSachXuPhat().xuatConsoleDangTable();
                    System.out.println("Nhập id xử phạt");
                    int idXuPhat = -1;
                    do {
                        idXuPhat = Helper.nhapSoNguyen("Id không hợp lệ, Nhập lại: ");
                        var xuPhat = TongHopDuLieu.getDanhSachXuPhat().getById(idXuPhat);
                        if (xuPhat == null) {
                            System.out.println("Không tìm thấy loại xử phạt");
                            idXuPhat = -1;
                        } else {
                            ctmt.setLoiPhatId(xuPhat.getIdXuPhat());
                        }
                    } while (idXuPhat == -1);
                }
            }
        }
    }

    public void giaHanSachDangMuon() {
        System.out.println("Nhập mã phiếu mượn");
        var id = Helper.nhapSoNguyen("Id không hợp lệ");
        var muonTra = getById(id);
        if (muonTra == null) {
            System.out.println("Không tìm thấy phiếu mượn");
            return;
        }
        var danhSachSachMuon = TongHopDuLieu.getDanhSachCTMuonTra().getChiTietPhieuMuong(muonTra.getIDmt());
        for (var ctmt : danhSachSachMuon) {
            if (ctmt.getNgaytra() != null) {
                System.out.println(Table.taoBang(ctmt.getBook()));
                System.out.println("Bạn có muốn gia hạn sách này không? (y/n)");
                var answer = Helper.scanner.nextLine().charAt(0);
                if (answer == 'y') {
                    System.out.println("Nhập số ngày muốn gia hạn");
                    var soNgay = Helper.nhapSoNguyen("Số ngày không hợp lệ, nhập lại: ");
                    ctmt.setNgayhentra(ctmt.getNgayhentra().plusDays(soNgay));
                    System.out.println("Gia hạn thành công");
                }
            }
        }
    }

    public void hienThiQuaHan() {
        var danhSachSachMuon = TongHopDuLieu.getDanhSachCTMuonTra().getAll();
        var dsQuaHan = new ArrayList<CTMuonTra>();
        for (var ctmt : danhSachSachMuon) {
            if (ctmt.getNgaytra() != null) {
                if (ctmt.getNgayhentra().isBefore(LocalDate.now()) && ctmt.getNgaytra() != null) {
                    dsQuaHan.add(ctmt);
                }
            }
        }
        if (dsQuaHan.size() == 0) {
            System.out.println("Không có sách nào quá hạn");
            return;
        }
        System.out.println(Table.taoBang(dsQuaHan));
        System.out.println("Bạn có muốn hiển thị độc giả vi pham (y/n");
        var awnser = Helper.scanner.nextLine().toLowerCase().charAt(0) == 'y';

        if (awnser) {
            ArrayList<DocGia> dsDGQuaHan = new ArrayList<>();
            for (var ctmt : dsQuaHan) {
                dsDGQuaHan.add(getById(ctmt.getIdPhieuMuon()).getTheThuVien().getUser());
            }
            System.out.println("Danh sách độc giả trả muộn: ");
            System.out.println(Table.taoBang(dsDGQuaHan));
        }
    }

    public void xoaPhieu(MuonTra phieu) {
        data.remove(phieu);
    }

    public void showMenu() {
        System.out.println("1. Thêm phiếu mượn");
        System.out.println("2. Xóa phiếu mượn");
        System.out.println("3. Sửa phiếu mượn");
        System.out.println("4. Hiển thị danh sách phiếu mượn");
        System.out.println("5. Tìm kiếm phiếu mượn");
        System.out.println("6. Trả sách");
        System.out.println("7. Gia hạn sách");
        System.out.println("8. Hiển thị mượn sách quá hạn");
        System.out.println("9. Thoát");
        System.out.println("Nhập lựa chọn của bạn: ");
    }

    public void suaPhieuMuon() {
        System.out.println("Nhập mã phiếu mượn");
        var id = Helper.nhapSoNguyen("Id không hợp lệ");
        var muonTra = getById(id);
        if (muonTra == null) {
            System.out.println("Không tìm thấy phiếu mượn");
            return;
        }

    }

    public void thuThuLamViec() {
        int choose = -1;
        do {
            showMenu();
            choose = Helper.nhapSoNguyen("Lựa chọn không hợp lệ!");
            switch (choose) {
                case 1 -> {
                    muonSach();
                }
                case 2 -> {
                    System.out.println("Nhập id phiếu mươn: ");
                    var id = Helper.nhapSoNguyen("id không hợp lệ,Nhập lại! ");
                    var phieuMuon = getById(id);
                    phieuMuon.xuatPhieu();
                    System.out.println("Bạn có muốn xoá phiếu mượn: ");
                    boolean y = Helper.scanner.nextLine().charAt(0) == 'y';
                    if (y) {
                        phieuMuon.xoaTatCaCtMuonTra();
                        TongHopDuLieu.getDanhSachPhieuMuonTra().xoaPhieu(phieuMuon);
                    } else {
                        System.out.println("Bye");
                    }
                }
                case 4 -> {
                    TongHopDuLieu.getDanhSachPhieuMuonTra().getAll().forEach(e -> {
                        System.out.println("-----------------------------");
                        e.xuatPhieu();
                    });
                }
                case 5 -> {
                    System.out.println("Nhập id phiếu mượn: ");
                    var muontra = getById(Helper.nhapSoNguyen("Không hợp lệ, nhập lại"));
                    muontra.xuatPhieu();
                }
                case 6 -> {
                    traSach();
                }
                case 7 -> {
                    giaHanSachDangMuon();
                }
                case 8 -> {
                    hienThiQuaHan();
                }
                case 9 -> {
                    System.out.println("Bye");
                }

            }
        } while (choose != 9);
        xuatFileBinary(FILE_PATH);
    }
}
