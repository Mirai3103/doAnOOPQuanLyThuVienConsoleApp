package Main.Views;


import Model.DocGia;
import Model.MuonTra;
import Model.TheThuVien;
import Repository.TongHopDuLieu;
import helper.Helper;

public class ThuThuView {
    private static void menu(){
        System.out.println("1. tìm kiếm sách");
        System.out.println("2. mượn sách");
        System.out.println("3. trả sách");
        System.out.println("4. đăng ký thành viên");
        System.out.println("5. xem các phiếu mượn quá hạn");
        System.out.println("6. Thoát");
        // toDo: thêm các chức năng khác
    }
    public  static  void dangKyThanhVien(){
        var docGia = new DocGia();
        docGia.nhapDocGia();
        var theThuVien = new TheThuVien();
        theThuVien.themTheThuVien();
        docGia.setIDthe(theThuVien.getIDthe());

    }
    public static void timSach(){
        System.out.println("Nhập tên cuốn sách muốn tìm");
        var name = Helper.scanner.nextLine();
        TongHopDuLieu.getKhoSach().getByName(name).forEach(s -> s.xuatSach());

    }
    public static void muonSach(){
        MuonTra muonTra = new MuonTra();
        muonTra.nhapPhieuMuonTra();
        System.out.println("Bạn muốn mượn bao nhiêu cuôn sách");
        int n = Helper.nhapSoNguyen("Số lượng sách không hợp lệ, nhập lại: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập id cuốn sách cần mượn thứ "+(i+1)+" ");
            var id = Helper.nhapSoNguyen("Id sách không hợp lệ!, nhập lại: ");
            Chi
        }
    }
    public static void run(){
        int luaChon;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn");
            luaChon = helper.Helper.nhapSoNguyen("Không hợp lệ: ");
            switch (luaChon) {
                //toDo: xử lý các chức năng
            }
        }while (luaChon != 6);
    }
}
