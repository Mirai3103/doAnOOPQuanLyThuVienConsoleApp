package Repository;


import Model.NhaXuatBan;
import helper.Helper;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhSachNhaXuatBan  implements Serializable {
    @Serial
    private static final long serialVersionUID = 13424644L;
    private ArrayList<NhaXuatBan> data = new ArrayList<>();

    public ArrayList<NhaXuatBan> getData() {
        return data;
    }

    public void setData(ArrayList<NhaXuatBan> data) {
        this.data = data;
    }

    public void themNhaXuatBan(NhaXuatBan nhaXuatBan){
        this.data.add(nhaXuatBan);
    }
    public void themNhaXuatBan(){
        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        nhaXuatBan.nhap();
        this.data.add(nhaXuatBan);
    }
    public NhaXuatBan findById(int id){
        for (NhaXuatBan nhaXuatBan : data) {
            if(nhaXuatBan.getId() == id){
                return nhaXuatBan;
            }
        }
        return null;
    }
    public void showAll(){
        if(data.size() == 0){
            System.out.println("Danh sách tác giả trống");
            return;
        }
        for (NhaXuatBan nhaXuatBan : data) {
            // print id and tenNhaXuatBan
            System.out.println(nhaXuatBan.getId() + " - " + nhaXuatBan.getTenNXB()+"\n");
        }
    }
    public boolean kiemTraIdTrung(int id){
        return data.stream().filter(n ->n.getId() == id).findFirst().orElse(null) !=null;
    }
    public void xoaNhaXuatBan(int id){
        data.removeIf(n -> n.getId() == id);
    }
    public void xoaNhaXuatBan(){
        System.out.println("Nhap id nha xuat ban can xoa");
        int id = Helper.scanner.nextInt();
        data.removeIf(n -> n.getId() == id);
    }
    public void suaNhaXuatBan(int id){
        NhaXuatBan nhaXuatBan = findById(id);
        if(nhaXuatBan != null){
            nhaXuatBan.nhap();
        }
    }
    public void suaNhaXuatBan(){
        System.out.println("Nhap id nha xuat ban can sua");
        int id = Helper.scanner.nextInt();
        NhaXuatBan nhaXuatBan = findById(id);
        if(nhaXuatBan != null){
            nhaXuatBan.nhap();
        }
    }
    public void showMenu(){
        System.out.println("Tương tác với nhà xuất bản");
        System.out.println("1. Them nha xuat ban");
        System.out.println("2. Sua nha xuat ban");
        System.out.println("3. Xoa nha xuat ban");
        System.out.println("4. Xem danh sach nha xuat ban");
        System.out.println("5. Thoat");
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
                    showAll();
                    break;
                case 5:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }while (luaChon != 5);
    }



}
