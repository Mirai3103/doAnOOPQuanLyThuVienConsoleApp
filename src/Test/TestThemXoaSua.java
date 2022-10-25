package Test;


import Repository.DbContext;
import helper.Helper;

public class TestThemXoaSua {
    public static void showMenu(){
        Helper.clearScreen();
        System.out.println("1. Làm việc voi sách");
        System.out.println("2. Làm việc voi thể loại");
        System.out.println("3. Làm việc voi tác giả");
        System.out.println("4. Làm việc voi nhà xuất bản");
        System.out.println("5. Thoat");
    }
    public static void main(String[] args) {

        Helper.khoDuLieu = new DbContext();
        Helper.khoDuLieu.docDuLieuTuFile();
        int luaChon;
        do {
            showMenu();
            System.out.println("Nhap lua chon cua ban");
            luaChon = Helper.nhapSoNguyen("Khong hop le, nhap lai");
            switch (luaChon) {
                case 1 -> Helper.khoDuLieu.getKhoSach().lamViec();
                case 2 -> Helper.khoDuLieu.getKhoTheLoai().lamViecVoiDanhSachTheLoai();
                case 3 -> Helper.khoDuLieu.getDanhSachTacGia().lamViec();
                case 4 -> Helper.khoDuLieu.getDanhSachNhaXuatBan().lamViec();
                case 5 -> System.out.println("Thoat");
                default -> System.out.println("Lua chon khong hop le");
            }
        }while (luaChon != 5);
        Helper.khoDuLieu.luuDuLieuVaoFile();
    }
}
