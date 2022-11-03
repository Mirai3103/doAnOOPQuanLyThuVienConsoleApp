package Repository;


import Model.NhaXuatBan;
import helper.Helper;

import java.io.Serial;
import java.io.Serializable;

public class DanhSachNhaXuatBan extends BaseDanhSach<NhaXuatBan>  {
    public static String FILE_PATH = Helper.dirPath + "DanhSachNhaXuatBan.bin";


    public void themNhaXuatBan(){
        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        nhaXuatBan.nhap();
        data.add(nhaXuatBan);
    }


    public boolean kiemTraIdTrung(int id){
        return data.stream().filter(n ->n.getId() == id).findFirst().orElse(null) !=null;
    }
    public void xoaNhaXuatBan(){
        System.out.println("Nhap id nha xuat ban can xoa");
        int id = Helper.nhapSoNguyen("Lỗi!! id là số nguyên :");
        delete(id);
    }
    public void suaNhaXuatBan(){
        System.out.println("Nhap id nha xuat ban can sua");
        int id = Helper.nhapSoNguyen("Lỗi!! Bạn nên nhập số nguyên :");
        update(id);
    }
    public void showMenu(){
        System.out.println("Tương tác với nhà xuất bản");
        System.out.println("1. Them nha xuat ban");
        System.out.println("2. Sua nha xuat ban");
        System.out.println("3. Xoa nha xuat ban");
        System.out.println("4. Xem danh sach nha xuat ban");
        System.out.println("5. Thoat");
        System.out.println("6. Luu vao file");
        System.out.println("Nhap lua chon cua ban:");
    }
    public void lamViec(){
        int luaChon;
        Helper.clearScreen();
        do {
            showMenu();
            luaChon = Helper.nhapSoNguyen("Không hợp lệ, nhập lại:");
            switch (luaChon){
                case 1:
                    themNhaXuatBan();
                    break;
                case 2:
                    suaNhaXuatBan();
                    break;
                case 3:
                    xoaNhaXuatBan();
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
                    System.out.println("Lua chon khong hop le");
            }
        }while (luaChon != 5);
    }
    public void xuatFileBinary(){
        TongHopDuLieu.getDanhSachTheLoai_sach().xuatFileBinary();
        xuatFileBinary(FILE_PATH);
    }



    public NhaXuatBan getById(int id) {
        for (NhaXuatBan nhaXuatBan : data) {
            if(nhaXuatBan.getId() == id){
                return nhaXuatBan;
            }
        }
        return null;
    }

    public void add(NhaXuatBan nhaXuatBan){
        data.add(nhaXuatBan);
    }


    public void delete(int id) {
        data.removeIf(n -> n.getId() == id);
    }

    public void update(int id) {
        NhaXuatBan nhaXuatBan = getById(id);
        if(nhaXuatBan != null){
            nhaXuatBan.nhap();
        }
    }



}
