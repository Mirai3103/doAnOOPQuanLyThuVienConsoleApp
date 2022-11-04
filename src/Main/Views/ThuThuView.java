package Main.Views;


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
