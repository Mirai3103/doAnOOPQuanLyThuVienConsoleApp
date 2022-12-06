package Repository;

import java.util.Scanner;
import Model.TheThuVien;
import helper.Helper;
import helper.Mang;
import helper.Xuat.Table;

import java.io.Serial;
import java.time.LocalDate;

public class DanhSachTheThuVien extends BaseDanhSachArray<TheThuVien>{
    @Serial
    private static final long serialVersionUID = 1212121775752L;
    public static final String FILE_PATH = Helper.dirPath + "DanhSachTheThuVien.bin";
    private int idIdentity = 0;

    @Override
    public void copyFrom(IDanhSach<TheThuVien> other) {
        var otherTheThuViens = (DanhSachTheThuVien) other;
        this.idIdentity = otherTheThuViens.idIdentity;
        this.data = otherTheThuViens.data;
    }

    @Override
    public void add(TheThuVien item) {
        item.setIDthe(idIdentity++);
        data.add(item);
    }
    public TheThuVien getById(int id){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIDthe() == id) return data.get(i);
        }
        return null;
    }
    public void xuatFileBinary(){
        super.xuatFileBinary(FILE_PATH);
    }
    public void giaHanThe(){
        System.out.println("Nhập id thẻ cần gia hạn");
        var id = Helper.nhapSoNguyen("Id thẻ không hợp lệ!, nhập lại: ");
        var theThuVien = getById(id);
        if (theThuVien == null) {
            System.out.println("Không tìm thấy thẻ có id " + id);
            return;
        }
        theThuVien.giaHanThe();
        System.out.println("Gia hạn thành công");
    }
    public void xuatDanhSachTheHetHan(){
        Mang<TheThuVien> theThuViensHetHan = new Mang<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).checkHetHan()) theThuViensHetHan.add(data.get(i));
        }
        if (theThuViensHetHan.size() == 0) {
            System.out.println("Không có thẻ nào hết hạn");
            return;
        }
        System.out.println(Table.taoBang(theThuViensHetHan));
    }
    void showMenu() {

        System.out.println("1. Tìm kiếm thẻ thư viện");
        System.out.println("2. Sửa thông tin thẻ thư viện");
        System.out.println("3. Xóa thẻ thư viện");
        System.out.println("4. Gia hạn thẻ thư viện");
        System.out.println("5. Xuất danh sách thẻ thư viện hết hạn");
        System.out.println("6. Xuất danh sách thẻ thư viện");
        System.out.println("7. Thoát");
    }
    public void lamViec(){
        int luaChon;


        do {
            showMenu();
            System.out.println("Nhập lựa chọn của bạn");
            luaChon = Helper.nhapSoNguyen("Không hợp lệ: ");
            switch (luaChon) {
                case 1 -> {
                    System.out.println("Nhập id thẻ cần tìm");
                    var id = Helper.nhapSoNguyen("Id thẻ không hợp lệ!, nhập lại: ");
                    var theThuVien = getById(id);
                    if (theThuVien == null) {
                        System.out.println("Không tìm thấy thẻ có id " + id);
                        return;
                    }
                    System.out.println(Table.taoBang(theThuVien));
                }
                case 2 -> {
                    System.out.println("Nhập id thẻ cần sửa");
                    var id = Helper.nhapSoNguyen("Id thẻ không hợp lệ!, nhập lại: ");
                    var theThuVien = getById(id);
                    if (theThuVien == null) {
                        System.out.println("Không tìm thấy thẻ có id " + id);
                        return;
                    }
                    System.out.println("Đây là thẻ thư viện sắp chỉnh sửa");
                    Mang<TheThuVien> theThuVienSapCS = new Mang<>();
                    theThuVienSapCS.add(getById(id));
                    if (theThuVienSapCS.size() == 0) {
                        return;
                    }
                    System.out.println(Table.taoBang(theThuVienSapCS));
                    theThuVien.suaTheThuVien();
                }
                case 3 -> {
                    System.out.println("Nhập id thẻ cần xóa");
                    var id = Helper.nhapSoNguyen("Id thẻ không hợp lệ!, nhập lại: ");
                    var theThuVien = getById(id);
                    if (theThuVien == null) {
                        System.out.println("Không tìm thấy thẻ có id " + id);
                        return;
                    }
                    System.out.println("Đây là thẻ thư viện sắp xóa");
                    Mang<TheThuVien> theThuVienSapXoa = new Mang<>();
                    theThuVienSapXoa.add(getById(id));
                    if (theThuVienSapXoa.size() == 0) {
                        return;
                    }
                    System.out.println(Table.taoBang(theThuVienSapXoa));
                    System.out.print("Bạn có chắc muốn xóa không (y/n): ");
                    if(Helper.inputNoneEmptyString().equals("y")) {
                        System.out.println("Đã xóa!!");
                        data.remove(theThuVien);
                    }
                    System.out.println("Đã hủy xóa!!");
                }
                case 4 -> giaHanThe();
                case 5 -> xuatDanhSachTheHetHan();
                case 6 -> xuatConsoleDangTable();
                case 7 -> {
                    this.xuatFileBinary();
                    System.out.println("Thoát");
                }
            }
        } while (luaChon != 7);
    }
}
