package Repository;
import java.util.Scanner;

import Model.XuPhat;
import helper.Helper;
import helper.Mang;
import helper.Xuat.Table;

import java.io.Serial;

public class DanhSachXuPhat extends BaseDanhSachArray<XuPhat> {
    @Serial
    private static final long serialVersionUID = 1212121775752L;
    public static final String FILE_PATH = Helper.dirPath + "DanhSachLoiPhat.bin";
    private int idIdentity = 0;
    @Override
    public void copyFrom(IDanhSach<XuPhat> other) {
        var otherXuPhats = (DanhSachXuPhat) other;
        this.idIdentity = otherXuPhats.idIdentity;
        this.data = otherXuPhats.data;
    }

    @Override
    public void add(XuPhat item) {
        item.setIdXuPhat(idIdentity++);
        data.add(item);
    }
    public void xuatFileBinary(){
        super.xuatFileBinary(FILE_PATH);
    }
    public void add(){
        var item = new XuPhat();
        item.nhapXuPhat();
        add(item);
    }
    public XuPhat getById(int id){
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getIdXuPhat()==id){
                return data.get(i);
            }
        }
        return null;
    }
    public void showMenu() {


        System.out.println("1. Thêm lỗi phạt");
        System.out.println("2. Xem danh sách lỗi phạt");
        System.out.println("3. Sửa lỗi phạt");
        System.out.println("4. Xóa lỗi phạt");
        System.out.println("5. Thoát");
    }
    public void show(){
        this.xuatConsoleDangTable();
    }
    public void sua(){
        xuatConsoleDangTable();
        System.out.println("Nhập id lỗi phạt cần sửa");
        int id = Helper.nhapSoNguyen("id lỗi phạt không hợp lệ!, nhập lại: ");
        var item = getById(id);
        if(item==null){
            System.out.println("Không tìm thấy lỗi phạt");
            return;
        }
        System.out.println("Đây là lỗi phạt sắp chỉnh sửa");
        Mang<XuPhat> XuaPhatSapCS = new Mang<>();
        XuaPhatSapCS.add(getById(id));
        if (XuaPhatSapCS.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(XuaPhatSapCS));
        item.nhapXuPhat();
    }
    public XuPhat getByName(String name){
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getTenLoi().toLowerCase().trim().contains(name.toLowerCase().trim())){
                return data.get(i);
            }
        }
        return null;
    }
    public void xoa() {
        System.out.println("Nhập id lỗi phạt cần xóa");
        int id = Helper.nhapSoNguyen("id lỗi phạt không hợp lệ!, nhập lại: ");
        var item = getById(id);
        if (item == null) {
            System.out.println("Không tìm thấy lỗi phạt");
            return;
        }

        System.out.println("Đây là lỗi phạt sắp xóa");
        Mang<XuPhat> XuaPhatSapXoa = new Mang<>();
        XuaPhatSapXoa.add(getById(id));
        if (XuaPhatSapXoa.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(XuaPhatSapXoa));
        System.out.print("Bạn có chắc muốn xóa không (y/n): ");
        if(Helper.inputNoneEmptyString().equals("y")) {
            System.out.println("Đã xóa!!");
            data.remove(item);
            return;
        }
        System.out.println("Đã hủy xóa!!");
        return;
    }
    public  void lamViec(){
        char c = ' ';
        do {
            showMenu();
            String a = Helper.inputNoneEmptyString();
            c = a.charAt(0);
            switch (c) {
                case '1' -> add();
                case '2' -> show();
                case '3' -> sua();
                case '4' -> xoa();
                case '5' -> {
                    xuatFileBinary();
                    System.out.println("Thoát");
                }
                default -> System.out.println("Lựa chọn không hợp lệ, nhập lại");
            }
        } while (c != '5');
    }
}
