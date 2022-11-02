package Repository;

import Model.TacGia;
import helper.Helper;
import helper.Xuat.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author HuuHoang
 */
public class DanhSachTacGia  implements Serializable {
    @Serial
    private static final long serialVersionUID = 13424000L;
    private ArrayList<TacGia> tacGias = new ArrayList<>();

    public ArrayList<TacGia> getTacGias() {
        return tacGias;
    }
    public TacGia findById(int id){
        for (TacGia tacGia : tacGias) {
            if(tacGia.getId() == id){
                return tacGia;
            }
        }
        return null;
    }
    public void xuatDanhSachTacGia(){
        if(tacGias.size() == 0){
            System.out.println("Danh sách tác giả trống");
            return;
        }
        System.out.println(Table.taoBang(this.tacGias));
    }
    public void themTacGia(TacGia tacGia){
        tacGias.add(tacGia);
    }
    public void themTacGia(){
        TacGia tacGia = new TacGia();
        tacGia.nhap();
        tacGias.add(tacGia);
    }
    public void xoaTacGia(int id){
        tacGias.removeIf(t -> t.getId() == id);
    }
    public void xoaTacGia(){
        System.out.println("Nhap id tac gia can xoa:");
        xoaTacGia(Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: "));
    }
    public void suaTacGia(int id){
        TacGia tacGia = findById(id);
        if(tacGia != null){
            tacGia.nhap();
        }
    }
    public void suaTacGia(){
        System.out.println("Nhap id tac gia can sua:");
        suaTacGia(Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: "));
    }

    public void showMenu() {
        System.out.println("Tương tác với tác giả");
        System.out.println("1. Them tac gia");
        System.out.println("2. Sua tac gia");
        System.out.println("3. Xoa tac gia");
        System.out.println("4. Xem danh sach tac gia");
        System.out.println("5. Thoat");
    }
    public void lamViec(){
        int luaChon;
        Helper.clearScreen();
        do {
            showMenu();
            luaChon = Helper.nhapSoNguyen("Lua chon khong hop le, nhap lai: ");
            switch (luaChon){
                case 1:
                    themTacGia();
                    break;
                case 2:
                    suaTacGia();
                    break;
                case 3:
                    xoaTacGia();
                    break;
                case 4:
                    xuatDanhSachTacGia();
                    break;
                case 5:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, nhap lai");
            }
        }while (luaChon != 5);
    }
}
