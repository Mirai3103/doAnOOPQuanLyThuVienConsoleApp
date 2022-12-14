package Repository;

import Model.TacGia;
import helper.Helper;
import helper.Mang;
import helper.Xuat.Table;
import java.util.Scanner;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;


public class DanhSachTacGia extends BaseDanhSach<TacGia>  {
    @Serial
    private static final long serialVersionUID = 132434645712L;
    public static String FILE_PATH = Helper.dirPath + "DanhSachTacGia.bin";
    private int idIdentity = 0;


    public void xoaTacGia(){
        System.out.println("Nhap id tac gia can xoa:");
        int id=Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: ");

        System.out.println("Đây là tác giả bạn sắp xóa");
        Mang<TacGia> TacGiaSapXoa = new Mang<>();
        TacGiaSapXoa.add(getById(id));
        if (TacGiaSapXoa.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(TacGiaSapXoa));
        System.out.print("Bạn có chắc muốn xóa không (y/n): ");
        if(Helper.inputNoneEmptyString().equals("y")) {
            System.out.println("Đã xóa!!");
            this.delete(id);
            return;

        }
        System.out.println("Đã hủy xóa!!");

    }

    public void suaTacGia(){
        System.out.println("Nhập id tác giả cần sửa:");
        int id=Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: ");
        System.out.println("Đây là tác giả bạn sắp sửa");
        Mang<TacGia> TacGiaSapXoa = new Mang<>();
        TacGiaSapXoa.add(getById(id));
        if (TacGiaSapXoa.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(TacGiaSapXoa));
        update(id);
    }

    public void showMenu() {

        System.out.println("Tương tác với tác giả");
        System.out.println("1. Thêm tác giả");
        System.out.println("2. Sửa tác giả");
        System.out.println("3. Xóa tác giả");
        System.out.println("4. Xem danh sách tác giả");
        System.out.println("5. Thoát");
        System.out.println("6. Lưu vào file");

    }
    public void lamViec(){
        int luaChon;


        do {
            showMenu();
            luaChon = Helper.nhapSoNguyen("Lua chon khong hop le, nhap lai: ");
            switch (luaChon) {
                case 1 -> nhapVaThemTacGia();
                case 2 -> suaTacGia();
                case 3 -> xoaTacGia();
                case 4 -> xuatConsoleDangTable();
                case 5 -> System.out.println("Thoat");
                case 6 -> xuatFileBinary();
                default -> System.out.println("Lua chon khong hop le, nhap lai");
            }
        }while (luaChon != 5);
    }

    public void xuatFileBinary(){
        this.xuatFileBinary(FILE_PATH);
    }

    public TacGia getById(int id) {
        for (TacGia tacGia : data) {
            if(tacGia.getId() == id){
                return tacGia;
            }
        }
        return null;
    }

    public TacGia getByName(String name){
        return this.data.stream().filter(s ->s.getTenTacGia().toLowerCase().equalsIgnoreCase(name.toLowerCase())).findFirst().orElse(null);
    }

    public void delete(int id) {
        TacGia tacGia = getById(id);
        if (tacGia ==null) {
            System.out.println("Không tìm thấy tác giả");
            return;
        }
        if(tacGia.getSachs().size() > 0){
            System.out.println("Không thể xóa tác giả này vì tác giả này đã có sách");
            return;
        }
        data.remove(tacGia);
    }

    public void update(int id) {
        TacGia tacGia = getById(id);
        if(tacGia != null){
            tacGia.sua();
        }else {
            System.out.println("Khong tim thay tac gia");
        }
    }



//    @Override
//    public void readCsv(String fileName) {
//
//    }

    public void nhapVaThemTacGia(){
        TacGia tacGia = new TacGia();
        tacGia.nhap();
        data.add(tacGia);

    }

    @Override
    public void copyFrom(IDanhSach<TacGia> other) {
        var otherList = (DanhSachTacGia) other;
        this.data = otherList.data;
        this.idIdentity = otherList.idIdentity;
    }

    @Override
    public void add(TacGia item) {
        item.setId(idIdentity++);
        data.add(item);
    }
    public void showMenuThuThu(){

        System.out.println("1. Xuất danh sách tác giả ");
        System.out.println("2. Tìm kiếm tác giả");        System.out.println("3. Thoats");
        System.out.println("Nhap lua chon: ");

    }
    public void thuThuLamViec() {
        int luaChon;


        do {
            showMenuThuThu();
            luaChon = Helper.nhapSoNguyen("Lua chon khong hop le, nhap lai: ");
            switch (luaChon) {
                case 1 -> xuatConsoleDangTable();
                case 2 -> {
                    System.out.println("Tìm theo tên hay id");
                    System.out.println("1. Tìm theo tên");
                    System.out.println("2. Tìm theo id");
                    int luaChon2 = Helper.nhapSoNguyen("Lua chon khong hop le, nhap lai: ");
                    TacGia tacGia = null;
                    switch (luaChon2) {
                        case 1 -> {
                            System.out.println("Nhập tên tác giả cần tìm");
                            String tenTacGia = Helper.inputNoneEmptyString();
                            tacGia = getByName(tenTacGia);
                            if (tacGia != null) {
                                tacGia.xuat();
                            } else {
                                System.out.println("Không tìm thấy tác giả");
                            }
                        }
                        case 2 -> {
                            System.out.println("Nhập id tác giả cần tìm");
                            int id = Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: ");
                            tacGia = getById(id);
                            if (tacGia != null) {
                                tacGia.xuat();
                            } else {
                                System.out.println("Không tìm thấy tác giả");
                            }
                        }
                        default -> System.out.println("Lua chon khong hop le");
                    }
                    if (tacGia != null) {
                        System.out.println("bạn có muốn xuất sách của tác giả này không y/n");
                        char luaChon3 = Helper.inputNoneEmptyString().charAt(0) ;
                        if (luaChon3 == 'y') {
                            System.out.println(Table.taoBang(new ArrayList<>(tacGia.getSachs())));
                        }
                    }

                }
                default -> System.out.println("Lua chon khong hop le");
            }
        } while (luaChon != 3);
    }
}
