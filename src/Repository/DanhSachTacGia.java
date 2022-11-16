package Repository;

import Model.TacGia;
import helper.Helper;

import java.io.Serial;
import java.io.Serializable;


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

    public void thuThuLamViec() {
    }
}
