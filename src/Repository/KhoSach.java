package Repository;


import Model.Sach;
import helper.Helper;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class KhoSach extends BaseDanhSach<Sach>  {
    public static String FILE_PATH = Helper.dirPath + "KhoSach.bin";
    private int idIncrement;

    public KhoSach() {
    }

    public Sach getById(int id) {
        return data.stream().filter(s ->s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(int id) {
        data.removeIf(s -> s.getId() == id);
    }

    @Override
    public void update(int id) {

        Sach sach = getById(id);
        if(sach != null){
            sach.nhapSach();
        }
    }




    public List<Sach> getByName(String name){
        return data.stream().filter(s ->s.getTenSach().toLowerCase().equals(name.toLowerCase())).toList();
    }
    // doi them class DocGia
//    public List<Sach> timCacSachCoTaiThuVien(){
//        return data.stream().filter(s ->s.get).toList();
//    }
    public void themSach(){
        Sach sach = new Sach();
        sach.nhapSach();
      add(sach);
    }
    public boolean kiemTraIdTrung(int id){
        return data.stream().filter(s ->s.getId() == id).findFirst().orElse(null) !=null;
    }

    public List<Sach> timSachCuaTacGia(int id){
        return data.stream().filter(s ->s.getTacGia().getId() == id).toList();
    }

    public void xoaSach(){
        System.out.println("Nhap id sach can xoa");
        int id = Helper.nhapSoNguyen("Id khong hop le");
        delete(id);
    }
    public void suaSach(){
        System.out.println("Nhap id sach can sua");
        int id = Helper.nhapSoNguyen("Id khong hop le");
        update(id);
    }
    public void showMenu(){
        System.out.println("1. Them sach");
        System.out.println("2. Xoa sach");
        System.out.println("3. Sua sach");
        System.out.println("4. Xuat sach");
        System.out.println("6. Lưu vào file");
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
                case 4 -> xuatConsoleDangTable();
                case 5 -> xuatFileBinary();
                case 7 -> System.out.println("Thoat");
                default -> System.out.println("Chon khong hop le");
            }
        }while (chon != 5);
    }
    public void xuatFileBinary(){
        TongHopDuLieu.getDanhSachTheLoai_sach().xuatFileBinary();
        super.xuatFileBinary(FILE_PATH);
    }

}
