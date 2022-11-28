package Repository;

import Model.TacGia;
import helper.Helper;
import helper.Xuat.Table;

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
        this.delete(Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: "));
    }

    public void suaTacGia(){
        System.out.println("Nhap id tac gia can sua:");
        update(Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: "));
    }

    public void showMenu() {
        System.out.println("Tương tác với tác giả");
        System.out.println("1. Them tac gia");
        System.out.println("2. Sua tac gia");
        System.out.println("3. Xoa tac gia");
        System.out.println("4. Xem danh sach tac gia");
        System.out.println("5. Thoat");
        System.out.println("5. Luu vao file");

    }
    public void lamViec(){
        int luaChon;
        Helper.clearScreen();
        do {
            showMenu();
            luaChon = Helper.nhapSoNguyen("Lua chon khong hop le, nhap lai: ");
            switch (luaChon){
                case 1:
                    nhapVaThemTacGia();
                    break;
                case 2:
                    suaTacGia();
                    break;
                case 3:
                    xoaTacGia();
                    break;
                case 4:
                    xuatConsoleDangTable();
                    break;
                case 5:
                    System.out.println("Thoat");
                    break;
                case 6:
                    xuatFileBinary();
                    break;
                default:
                    System.out.println("Lua chon khong hop le, nhap lai");
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
        data.removeIf(t -> t.getId() == id);
    }

    public void update(int id) {
        TacGia tacGia = getById(id);
        if(tacGia != null){
            tacGia.nhap();
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
                            String tenTacGia = Helper.scanner.nextLine();
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
                        char luaChon3 = Helper.scanner.nextLine().charAt(0) ;
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
