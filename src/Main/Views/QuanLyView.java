package Main.Views;

import Main.MainApp;
import Repository.TongHopDuLieu;

public class QuanLyView {
    private static void menu(){
        System.out.println("1. Quản lí sách");
        System.out.println("2. Quản lí thể loại");
        System.out.println("3. Quản lí tác giả");
        System.out.println("4. Quản lí nhà xuất bản");
        System.out.println("5. Quản lí nhân viên");
        System.out.println("6. Quản lí độc giả");
        System.out.println("7. Quản lí phiếu mượn");
        System.out.println("8. Quản lí lỗi phạt");
        System.out.println("9. Làm việc với tư cách thủ thư");
        System.out.println("10. Thoát");

        System.out.println("11. Đăng xuất");
    }
    public static void run(){
        int luaChon;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn");
            luaChon = helper.Helper.nhapSoNguyen("Không hợp lệ: ");
            switch (luaChon) {
                case 1 -> TongHopDuLieu.getKhoSach().lamViec();
                case 2 -> TongHopDuLieu.getKhoTheLoai().lamViecVoiDanhSachTheLoai();
                case 3 -> TongHopDuLieu.getDanhSachTacGia().lamViec();
                case 4 -> TongHopDuLieu.getDanhSachNhaXuatBan().lamViec();
                case 5 -> TongHopDuLieu.getNhanViens().LamViec();
                case 6 -> TongHopDuLieu.getDanhSachDocGia().lamViec();
                case 7 -> TongHopDuLieu.getDanhSachPhieuMuonTra().thuThuLamViec();
                case 8 -> TongHopDuLieu.getDanhSachXuPhat().lamViec();
                case 10 -> System.exit(0);
                case 9 -> ThuThuView.run();
                case 11 -> {
                    System.out.println("Đăng xuất thành công");
                    MainApp.nguoiDung = null;
                }
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        }while (luaChon != 11);


    }
}
