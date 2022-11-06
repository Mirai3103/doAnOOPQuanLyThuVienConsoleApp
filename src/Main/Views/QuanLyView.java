package Main.Views;

import Repository.TongHopDuLieu;

public class QuanLyView {
    private static void menu(){
        System.out.println("1. Quản lí sách");
        System.out.println("2. Quản lí thể loại");
        System.out.println("3. Quản lí tác giả");
        System.out.println("4. Quản lí nhà xuất bản");
        System.out.println("5. Quản lí nhân viên");
        System.out.println("6. Thoát");
        //toDo: thêm các chức năng khác
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
                case 6 -> System.out.println("Thoát");
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        }while (luaChon != 6);
    }
}
