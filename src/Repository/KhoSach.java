package Repository;


import Model.Sach;
import helper.Helper;

import java.util.ArrayList;
import java.util.List;

public class KhoSach {
    private ArrayList<Sach> data= new ArrayList<>();

    public ArrayList<Sach> getAll() {
        return data;
    }
    public Sach getById(int id) {
        return data.stream().filter(s ->s.getId() == id).findFirst().orElse(null);
    }
    public List<Sach> getByName(String name){
        return data.stream().filter(s ->s.getTenSach().toLowerCase().equals(name.toLowerCase())).toList();
    }
    // doi them class DocGia
//    public List<Sach> timCacSachCoTaiThuVien(){
//        return data.stream().filter(s ->s.get).toList();
//    }
    public void themSach(Sach sach){
        this.data.add(sach);
    }
    public void themSach(){
        Sach sach = new Sach();
        sach.nhapSach();
        this.data.add(sach);
    }
    public boolean kiemTraIdTrung(int id){
        return data.stream().filter(s ->s.getId() == id).findFirst().orElse(null) !=null;
    }
    public Sach findById(int id){
        for (Sach sach : data) {
            if(sach.getId() == id){
                return sach;
            }
        }
        return null;
    }
    public List<Sach> timSachCuaTacGia(int id){
        return data.stream().filter(s ->s.getTacGia().getId() == id).toList();
    }
    public void xuatsach(){
        for (Sach sach : data) {
            sach.xuatSach();
        }
    }
    public void xoaSach(int id){
        data.removeIf(s -> s.getId() == id);
    }
    public void xoaSach(){
        System.out.println("Nhap id sach can xoa");
        int id = Helper.nhapSoNguyen("Id khong hop le");
        data.removeIf(s -> s.getId() == id);
    }
    public void suaSach(int id){
        Sach sach = findById(id);
        if(sach != null){
            sach.nhapSach();
        }
    }
    public void suaSach(){
        System.out.println("Nhap id sach can sua");
        int id = Helper.nhapSoNguyen("Id khong hop le");
        Sach sach = findById(id);
        if(sach != null){
            sach.nhapSach();
        }
    }
    public void showMenu(){
        System.out.println("1. Them sach");
        System.out.println("2. Xoa sach");
        System.out.println("3. Sua sach");
        System.out.println("4. Xuat sach");
        System.out.println("7. Thoat");
    }
    public void lamViec(){
        int chon;
        Helper.clearScreen();
        do {
            showMenu();
            chon = Helper.nhapSoNguyen("Chon khong hop le");
            switch (chon) {
                case 1 -> themSach();
                case 2 -> xoaSach();
                case 3 -> suaSach();
                case 4 -> xuatsach();
                case 5 -> System.out.println("Thoat");
                default -> System.out.println("Chon khong hop le");
            }
        }while (chon != 5);
    }

}
