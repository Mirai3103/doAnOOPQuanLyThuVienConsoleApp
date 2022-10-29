package Repository;


import Model.TheLoai;
import helper.ASCIITable;
import helper.Helper;

import java.io.*;
import java.util.ArrayList;

public class KhoTheLoai  implements Serializable {
    @Serial
    private static final long serialVersionUID = 13424000119L;
    private ArrayList<TheLoai> theLoais = new ArrayList<>();

    public ArrayList<TheLoai> getTheLoais() {
        return theLoais;
    }

    public TheLoai findById(int id) {
        for (TheLoai theLoai : theLoais) {
            if (theLoai.getId() == id) {
                return theLoai;
            }
        }
        return null;
    }

    public void showAll() {
        if(theLoais.size() == 0) {
            System.out.println("Danh sách tác giả trống");
            return;
        }

        System.out.println( ASCIITable.taoBang(theLoais));
    }

    //toDo: crud
    public void showMenu() {
        System.out.println("Tương tác với thể loại");
        System.out.println("1. Them the loai");
        System.out.println("2. Sua the loai");
        System.out.println("3. Xoa the loai");
        System.out.println("4. Xem danh sach the loai");
        System.out.println("5. Thoat");
    }

    public int themTheLoai() {
        TheLoai theLoai = new TheLoai();
        theLoai.nhap();
        theLoais.add(theLoai);
        return theLoai.getId();
    }
    public void suaTheLoai(int id){
        TheLoai theLoai = findById(id);
        if(theLoai != null){
            theLoai.nhap();
        }else {
            System.out.println("Khong tim thay the loai");
        }
    }
    public void xoaTheLoai(int id){
        TheLoai theLoai = findById(id);
        if(theLoai != null){
            theLoais.remove(theLoai);
        }else {
            System.out.println("Khong tim thay the loai");
        }
    }
    public void lamViecVoiDanhSachTheLoai(){
        int luaChon;
        Helper.clearScreen();
        do {
            showMenu();
            System.out.println("Nhập lựa chọn của bạn");
            luaChon = Helper.nhapSoNguyen("Không hợp lệ: ");
            switch (luaChon) {
                case 1 -> themTheLoai();
                case 2 -> {
                    System.out.println("Nhap id the loai can sua");
                    suaTheLoai(new java.util.Scanner(System.in).nextInt());
                }
                case 3 -> {
                    System.out.println("Nhap id the loai can xoa");
                    xoaTheLoai(new java.util.Scanner(System.in).nextInt());
                }
                case 4 -> showAll();
                case 5 -> System.out.println("Thoat");
                default -> System.out.println("Lua chon khong hop le");
            }
        }while (luaChon != 5);
    }
    public String getCSVHeader(){
        return "Id,tên thể loại, giới thiệu";
    }
    public void toCSVFile(String filePath){
        File fileOut = new File(filePath);
        try {
            if(!fileOut.exists())fileOut.createNewFile();
        }catch (Exception ignored){

        }
    }
}
