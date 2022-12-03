package Main.Views;


import Main.Main;
import Model.ThuThu;
import Repository.TongHopDuLieu;

public class ThuThuView {
    private static void menu() {
        System.out.println("1. Tương tác với sách");
        System.out.println("2. Tương tác với thể loại");
        System.out.println("3. Tương tác với nhà xuất bản");
        System.out.println("4. Tương tác với tác giả");
        System.out.println("5. Tương tác với độc giả");
        System.out.println("6. Tương tác với phiếu mượn");
        System.out.println("7. Tương tác với thẻ thư viện");
        System.out.println("8. Tương tác với lỗi phạt");
        System.out.println("9. Thông tin cá nhân");

        System.out.println("10. Thoát");
        System.out.println("11. Đăng xuất");
    }


    public static void run() {
        int luaChon;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn");
            luaChon = helper.Helper.nhapSoNguyen("Không hợp lệ: ");
            switch (luaChon) {
                case 1 -> TongHopDuLieu.getKhoSach().thuThuLamViec();
                case 2 -> TongHopDuLieu.getKhoTheLoai().thuThuLamViec();
                case 3 -> TongHopDuLieu.getDanhSachNhaXuatBan().thuThulamViec();
                case 4 -> TongHopDuLieu.getDanhSachTacGia().thuThuLamViec();
                case 5 -> TongHopDuLieu.getDanhSachDocGia().lamViec();
                case 6 -> TongHopDuLieu.getDanhSachPhieuMuonTra().thuThuLamViec();
                case 7 -> TongHopDuLieu.getDanhSachTheThuVien().lamViec();
<<<<<<< Updated upstream
=======
                case 8 -> System.out.println("Chức năng chưa được cập nhật");
                case 9 -> System.out.println("Chức năng chưa được cập nhật");
                case 10 -> System.out.println("Thoát");
>>>>>>> Stashed changes

                case 8 -> TongHopDuLieu.getDanhSachXuPhat().lamViec();
                case 9 -> {
                    ThuThu nguoiDung = (ThuThu) Main.nguoiDung;
                    System.out.println("Thông tin cá nhân");
                    nguoiDung.thongTinCaNhan();
                }
                case 10 ->{
                    System.out.println("Thoát");
                    System.exit(0);
                }
                case 11 -> {
                    System.out.println("Đăng xuất");
                    Main.nguoiDung = null;
                }
            }
        } while (luaChon != 11);
    }
}
