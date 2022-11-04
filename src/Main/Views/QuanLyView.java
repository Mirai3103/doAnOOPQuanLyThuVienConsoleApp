package Main.Views;


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
                //toDo: xử lý các chức năng
            }
        }while (luaChon != 6);
    }
}
