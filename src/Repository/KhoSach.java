package Repository;
import java.util.Scanner;

import Model.Sach;
import Model.TacGia;
import Report.SachThinhHanh;
import helper.Helper;
import helper.Mang;
import helper.Xuat.Table;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class KhoSach extends BaseDanhSach<Sach> {
    @Serial
    private static final long serialVersionUID = 1221313121212L;
    public static String FILE_PATH = Helper.dirPath + "KhoSach.bin";
    private int idIdentity = 0;

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
            sach.sua();
        }
    }


    public ArrayList<Sach> getByName(String name) {
        return new ArrayList<>(data.stream().filter(s -> s.getTenSach().toLowerCase().contains(name.toLowerCase())).toList());
    }


    public void themSach() {
        Sach sach = new Sach();
        sach.nhapSach();
        add(sach);
        sach.nhapTheLoaiChoSach();
        System.out.println("Bạn nhập bao nhiêu cuốn này vào kho?");
        int soLuong = Helper.nhapSoTuNhien("Số lượng không hợp lệ, vui lòng nhập lại");
        for (int i = 1; i < soLuong; i++) {
            Sach s = new Sach(sach);
            add(s);
            s.copyTheLoai(sach);
        }


    }

    public boolean kiemTraIdTrung(int id) {
        return data.stream().filter(s -> s.getId() == id).findFirst().orElse(null) != null;
    }

    public List<Sach> timSachCuaTacGia(int id) {
        return data.stream().filter(s -> s.getTacGia().getId() == id).toList();
    }

    public void xoaSach() {
        xuatConsoleDangTable();
        System.out.println("Nhap id sach can xoa");
        int id = Helper.nhapSoNguyen("Id khong hop le");

        System.out.println("Đây là sách sắp xóa");
        Mang<Sach> sachSapXoa = new Mang<>();
        sachSapXoa.add(getById(id));
        if (sachSapXoa.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(sachSapXoa));
        System.out.print("Bạn có chắc muốn xóa không (y/n): ");
      if(Helper.scanner.nextLine().equals("y")) {
        	System.out.println("Đã xóa!!");
        	delete(id);
            return;
        } 	
        System.out.println("Đã hủy xóa!!");
        
        
    }

    public void suaSach() {
        System.out.println("Nhap id sach can sua");
        int id = Helper.nhapSoNguyen("Id khong hop le");
        System.out.println("Đây là sách sắp chỉnh sửa");
        Mang<Sach> sachSapCS = new Mang<>();
        sachSapCS.add(getById(id));
        if (sachSapCS.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(sachSapCS));
        update(id);
    }

    public void showMenu() {

        System.out.println("1. Them sach");
        System.out.println("2. Xoa sach");
        System.out.println("3. Sua sach");
        System.out.println("4. Xuat sach");
        System.out.println("5. Lưu vào file");
        System.out.println("7. Thoat");
    }

    public ArrayList<Sach> laySachDangMuon() {
        return new ArrayList<>(data.stream().filter(Sach::checkDangMuon).toList());
    }

    public ArrayList<Sach> laySachDangCoSan() {
        return new ArrayList<>(data.stream().filter(s -> !s.checkDangMuon()).toList());
    }

    public void inThongKeSachMuonNhieu() {
        ArrayList<SachThinhHanh> sachThinhHanhs = new ArrayList<>();
        TongHopDuLieu.getDanhSachCTMuonTra().data.forEach(ct -> {
            SachThinhHanh sachThinhHanh = new SachThinhHanh();
            var esxist = sachThinhHanhs.stream().filter(s -> s.getTenSach().equalsIgnoreCase(ct.getBook().getTenSach()) ).findFirst().orElse(null);
            if (esxist != null) {
                esxist.setSoLanMuon(esxist.getSoLanMuon() + 1);
            } else {
                sachThinhHanh.setTenSach(ct.getBook().getTenSach());
                sachThinhHanh.setSoLanMuon(1);
                sachThinhHanhs.add(sachThinhHanh);

            }
        });
        TongHopDuLieu.getKhoSach().data.forEach(s -> {
            var esxist =sachThinhHanhs.stream().filter(th -> th.getTenSach().equalsIgnoreCase(s.getTenSach())).findFirst().orElse(null);
            if (esxist == null) {
                SachThinhHanh sachThinhHanh = new SachThinhHanh();
                sachThinhHanh.setTenSach(s.getTenSach());
                sachThinhHanh.setSoLanMuon(0);
                sachThinhHanhs.add(sachThinhHanh);
            }
        });
        sachThinhHanhs.sort((o1, o2) -> o2.getSoLanMuon() - o1.getSoLanMuon());
        // set stt
        for (int i = 0; i < sachThinhHanhs.size(); i++) {
            sachThinhHanhs.get(i).setStt(i + 1);
        }
        System.out.println("Sách mượn nhiều nhất");
        System.out.println(Table.taoBang(sachThinhHanhs));
    }

    public void showMenuThuThu() {

        System.out.println("1. Xuất toàn bộ sách");
        System.out.println("2. Tìm kiếm sách theo tên");
        System.out.println("3. Tìm kiếm sách theo tác giả");
        System.out.println("4. Xuất sách chưa được mượn");
        System.out.println("5. Xuất sách đã được mượn");
        System.out.println("6. Thống kê sách mượn nhiều nhất");
        System.out.println("7. Thoát");


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
                case 6 -> inThongKeSachMuonNhieu();
                case 7 -> {
                    xuatFileBinary();
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void lamViec() {
        int chon;
        
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
        } while (chon != 7);
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
