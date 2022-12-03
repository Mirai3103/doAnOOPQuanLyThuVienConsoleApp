package Repository;
import java.util.Scanner;

import Model.Sach;
import Model.TacGia;
import helper.Helper;
import helper.Xuat.Table;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class KhoSach extends BaseDanhSach<Sach> {
    @Serial
    private static final long serialVersionUID = 1221313121212L;
    public static String FILE_PATH = Helper.dirPath + "KhoSach.bin";
    private int idIdentity = 0;
    Scanner sc = new Scanner(System.in);
    public KhoSach() {
    }

    public Sach getById(int id) {
        return data.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }


    public void delete(int id) {
        data.removeIf(s -> s.getId() == id);
    }


    public void update(int id) {

        Sach sach = getById(id);
        if (sach != null) {
            sach.nhapSach();
        }
    }


    public ArrayList<Sach> getByName(String name) {
        return new ArrayList<>(data.stream().filter(s -> s.getTenSach().toLowerCase().contains(name.toLowerCase())).toList());
    }

    // doi them class DocGia
//    public List<Sach> timCacSachCoTaiThuVien(){
//        return data.stream().filter(s ->s.get).toList();
//    }
    public void themSach() {
        Sach sach = new Sach();
        sach.nhapSach();
        data.add(sach);
        sach.nhapTheLoaiChoSach();

    }

    public boolean kiemTraIdTrung(int id) {
        return data.stream().filter(s -> s.getId() == id).findFirst().orElse(null) != null;
    }

    public List<Sach> timSachCuaTacGia(int id) {
        return data.stream().filter(s -> s.getTacGia().getId() == id).toList();
    }

    public void xoaSach() {
        System.out.println("Nhap id sach can xoa");
        int id = Helper.nhapSoNguyen("Id khong hop le");
        System.out.print("Bạn có chắc muốn xóa không (y/n): ");
        if(sc.nextLine().equals("y")) {
        	System.out.println("Đã xóa!!");
        	delete(id);
        } 	
        System.out.println("Đã hủy xóa!!");
        
        
    }

    public void suaSach() {
        System.out.println("Nhap id sach can sua");
        int id = Helper.nhapSoNguyen("Id khong hop le");
        update(id);
    }

    public void showMenu() {
        System.out.println("1. Them sach");
        System.out.println("2. Xoa sach");
        System.out.println("3. Sua sach");
        System.out.println("4. Xuat sach");
        System.out.println("6. Lưu vào file");
        System.out.println("7. Thoat");
    }
    public ArrayList<Sach> laySachDangMuon(){
        return new ArrayList<>(data.stream().filter(Sach::checkDangMuon).toList());
    }
    public ArrayList<Sach> laySachDangCoSan(){
        return new ArrayList<>(data.stream().filter(s -> !s.checkDangMuon()).toList());
    }
    public void showMenuThuThu() {
        System.out.println("1. Xuất toàn bộ sách");
        System.out.println("2. Tìm kiếm sách theo tên");
        System.out.println("3. Tìm kiếm sách theo tác giả");
        System.out.println("4. Xuất sách chưa được mượn");
        System.out.println("5. Xuất sách đã được mượn");
        System.out.println("6. Thoát");


    }

    public ArrayList<Sach> timTheoTen() {
        System.out.println("Nhập tên sách cần tìm");
        String name = Helper.scanner.nextLine();
        return getByName(name);
    }

    public ArrayList<Sach> timTheoTacGia() {
        System.out.println("Nhap id tác giả cần tìm");
        int id = Helper.nhapSoNguyen("Id không hợp lệ");
        TacGia tg = TongHopDuLieu.getDanhSachTacGia().getById(id);
        if (tg == null) {
            System.out.println("Không tìm thấy tác giả");
            return null;
        }
        return new ArrayList<>(timSachCuaTacGia(id));
    }

    public void thuThuLamViec() {
        while (true) {
            showMenuThuThu();
            int choice = Helper.nhapSoNguyen("Lựa chọn không hợp lệ");
            switch (choice) {
                case 1 -> xuatConsoleDangTable();
                case 2 -> System.out.println(Table.taoBang(timTheoTen()));
                case 3 -> {
                    var a = timTheoTacGia();
                    if (a != null) {
                        System.out.println(Table.taoBang(a));
                    }
                }
                case 4 -> System.out.println(Table.taoBang(laySachDangCoSan()));
                case 5 -> System.out.println(Table.taoBang(laySachDangMuon()));
                case 6 -> {
                    xuatFileBinary();
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void lamViec() {
        int chon;
        Helper.clearScreen();
        do {
            showMenu();
            chon = Helper.nhapSoNguyen("Chọn không hợp lệ");
            switch (chon) {
                case 1 -> themSach();
                case 2 -> xoaSach();
                case 3 -> suaSach();
                case 4 -> xuatConsoleDangTable();
                case 5 -> xuatFileBinary();
                case 7 -> System.out.println("Thoát");
                default -> System.out.println("Chọn không hợp lệ");
            }
        } while (chon != 5);
    }

    public void xuatFileBinary() {
        TongHopDuLieu.getDanhSachTheLoai_sach().xuatFileBinary();
        super.xuatFileBinary(FILE_PATH);
    }

    @Override
    public void copyFrom(IDanhSach<Sach> other) {
        var otherKhoSach = (KhoSach) other;
        this.data = otherKhoSach.data;
        this.idIdentity = otherKhoSach.idIdentity;
    }

    @Override
    public void add(Sach item) {
        item.setId(idIdentity++);
        this.data.add(item);
    }

    public void timSach() {
        System.out.println("Nhập tên cuốn sách muốn tìm");
        var name = Helper.scanner.nextLine();
        var sachs = getByName(name);
        if (sachs.size() == 0) {
            System.out.println("Không tìm thấy sách");
        } else {
            System.out.println(Table.taoBang(sachs));
        }
    }
}
