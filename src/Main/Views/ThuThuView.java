package Main.Views;


import Model.CTMuonTra;
import Model.DocGia;
import Model.MuonTra;
import Model.TheThuVien;
import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.Table;

import java.time.LocalDate;

public class ThuThuView {
    private static void menu() {
        System.out.println("1. tìm kiếm sách");
        System.out.println("2. mượn sách");
        System.out.println("3. trả sách");
        System.out.println("4. đăng ký thành viên");
        System.out.println("5. xem các phiếu mượn quá hạn");
        System.out.println("6. xem các phiếu mượn chưa trả");
        System.out.println("7. xem các phiếu mượn đã trả");
        System.out.println("8. xem các phiếu mượn");
        System.out.println("9. xem các phiếu mượn của độc giả");
        System.out.println("10. gia hạn phiếu mượn");
        // toDo: thêm các chức năng khác
    }




    public static void run() {
        int luaChon;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn");
            luaChon = helper.Helper.nhapSoNguyen("Không hợp lệ: ");
            switch (luaChon) {
                case 1 -> TongHopDuLieu.getKhoSach().timSach();
                case 2 -> TongHopDuLieu.getDanhSachPhieuMuonTra().muonSach();
                case 3 -> TongHopDuLieu.getDanhSachPhieuMuonTra().traSach();
                case 4 -> TongHopDuLieu.getDanhSachDocGia().dangKyThanhVien();
            }
        } while (luaChon != 6);
    }
}
