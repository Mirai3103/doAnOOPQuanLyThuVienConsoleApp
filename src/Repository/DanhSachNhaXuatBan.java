package Repository;


import Model.NhaXuatBan;
import helper.Helper;
import helper.Mang;
import helper.Xuat.Table;
import java.util.Scanner;
import java.io.Serial;
import java.util.ArrayList;

public class DanhSachNhaXuatBan extends BaseDanhSach<NhaXuatBan>  {
    @Serial
    private static final long serialVersionUID = 19068362L;
    public static String FILE_PATH = Helper.dirPath + "DanhSachNhaXuatBan.bin";
    private int idIdentity = 0;

    public void themNhaXuatBan(){
        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        nhaXuatBan.nhap();
        this.add(nhaXuatBan);
    }


    public void xoaNhaXuatBan(){
        System.out.println("Nhap id nha xuat ban can xoa");
        int id = Helper.nhapSoNguyen("Lỗi!! id là số nguyên :");

        System.out.println("Đây là nhà xuất bản bạn sắp xóa");
        Mang<NhaXuatBan> NXBSapXoa = new Mang<>();
        NXBSapXoa.add(getById(id));
        if (NXBSapXoa.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(NXBSapXoa));
        System.out.print("Bạn có chắc muốn xóa không (y/n): ");
          if(Helper.scanner.nextLine().equals("y")) {
        	System.out.println("Đã xóa!!");
        	delete(id);
           return;

        } 	
        System.out.println("Đã hủy xóa!!");
        
    }
    public void suaNhaXuatBan(){
        System.out.println("Nhap id nha xuat ban can sua");
        int id = Helper.nhapSoNguyen("Lỗi!! Bạn nên nhập số nguyên :");
        System.out.println("Đây là nhà xuất bản bạn sắp chỉnh sửa");
        Mang<NhaXuatBan> NXBSapCS = new Mang<>();
        NXBSapCS.add(getById(id));
        if (NXBSapCS.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(NXBSapCS));
        update(id);
    }
    public void showMenu(){

        System.out.println("Tương tác với nhà xuất bản");
        System.out.println("1. Thêm nhà xuất bản");
        System.out.println("2. Sửa nhà xuất bản");
        System.out.println("3. Xóa nhà xuất bản");
        System.out.println("4. Xem danh sách nhà xuất bản");
        System.out.println("5. Thoát");
        System.out.println("6. Lưu vào file");
        System.out.print("Nhập lựa chọn của bạn: ");
    }
    public void lamViec(){
        int luaChon;
        Helper.clearScreen();
        do {
            showMenu();
            luaChon = Helper.nhapSoNguyen("Không hợp lệ, nhập lại:");
            switch (luaChon) {
                case 1 -> themNhaXuatBan();
                case 2 -> suaNhaXuatBan();
                case 3 -> xoaNhaXuatBan();
                case 4 -> xuatConsoleDangTable();
                case 5 -> System.out.println("Thoát");
                case 6 -> xuatFileBinary();
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        }while (luaChon != 5);
    }
    public void xuatFileBinary(){
        xuatFileBinary(FILE_PATH);
    }

    public NhaXuatBan getByName(String name){
        return data.stream().filter(t -> t.getTenNXB().equalsIgnoreCase(name.toLowerCase())).findFirst().orElse(null);
    }

    public NhaXuatBan getById(int id) {
        for (NhaXuatBan nhaXuatBan : data) {
            if(nhaXuatBan.getId() == id){
                return nhaXuatBan;
            }
        }
        return null;
    }

    public void delete(int id) {
        NhaXuatBan nhaXuatBan = getById(id);
        if(nhaXuatBan == null){
            System.out.println("Không tìm thấy nhà xuất bản");
            return;
        }
        if(nhaXuatBan.getSachDaXuatBan().size() > 0){
            System.out.println("Không thể xóa nhà xuất bản này vì đã có sách xuất bản");
            return;
        }
        data.remove(nhaXuatBan);
    }
    public void update(int id) {
        NhaXuatBan nhaXuatBan = getById(id);
        if(nhaXuatBan != null) {
            nhaXuatBan.sua();
        }else {
            System.out.println("Không tìm thấy nhà xuất bản");
        }
    }

    @Override
    public void copyFrom(IDanhSach<NhaXuatBan> other) {
        DanhSachNhaXuatBan danhSachNhaXuatBan = (DanhSachNhaXuatBan) other;
        this.data = danhSachNhaXuatBan.data;this.idIdentity = danhSachNhaXuatBan.idIdentity;
    }

    @Override
    public void add(NhaXuatBan item) {
        item.setId(idIdentity++);
        data.add(item);
    }
    void showMenuThuThu(){

        System.out.println("Tương tác với nhà xuất bản");
        System.out.println("1. Xem danh sách nhà xuất bản");
        System.out.println("2. Tìm sách theo nhà xuất bản");
        System.out.println("3. Thoát");
    }

    public void thuThulamViec() {
        int luaChon;
        Helper.clearScreen();

        do {
            showMenuThuThu();
            luaChon = Helper.nhapSoNguyen("Không hợp lệ, nhập lại:");
            switch (luaChon) {
                case 1 -> xuatConsoleDangTable();
                case 2 -> {
                    System.out.println("Bạn muốn tìm kiếm theo tên hay id");
                    System.out.println("1. Tìm kiếm theo tên");
                    System.out.println("2. Tìm kiếm theo id");
                    int luaChon2 = Helper.nhapSoNguyen("Không hợp lệ, nhập lại:");
                    NhaXuatBan nhaXuatBan = null;
                    switch (luaChon2) {
                        case 1 -> {
                            System.out.println("Nhập tên nhà xuất bản cần tìm");
                            String tenNXB = Helper.scanner.nextLine();
                            nhaXuatBan = getByName(tenNXB);
                            if (nhaXuatBan != null) {
                                System.out.println(nhaXuatBan);
                            } else {
                                System.out.println("Không tìm thấy nhà xuất bản");
                            }
                        }
                        case 2 -> {
                            System.out.println("Nhập id nhà xuất bản cần tìm");
                            int id = Helper.nhapSoNguyen("Không hợp lệ, nhập lại:");
                            nhaXuatBan = getById(id);
                            if (nhaXuatBan != null) {
                                System.out.println(nhaXuatBan);
                            } else {
                                System.out.println("Không tìm thấy nhà xuất bản");
                            }
                        }

                    }
                    if (nhaXuatBan != null) {
                        System.out.println("Bạn có muốn xem sách của nhà xuất bản này không");
                        System.out.println("1. Có");
                        System.out.println("2. Không");
                        int luaChon3 = Helper.nhapSoNguyen("Không hợp lệ, nhập lại:");
                        switch (luaChon3) {
                            case 1 -> {
                                System.out.println("Danh sách sách của nhà xuất bản");
                                System.out.println(Table.taoBang(new ArrayList<>(nhaXuatBan.getSachDaXuatBan())));
                            }
                            case 2 -> System.out.println("Thoát");
                            default -> System.out.println("Không hợp lệ");
                        }
                    }
                }
            }
        }while (luaChon != 3);
        xuatFileBinary();
    }
}
