package Repository;

import java.util.Scanner;
import Model.TheLoai;
import Report.SachThinhHanh;
import Report.TheLoaiThinhHanh;
import helper.Helper;
import helper.Mang;
import helper.Xuat.Table;

import java.io.Serial;
import java.util.ArrayList;

public class KhoTheLoai extends BaseDanhSach<TheLoai> {
    @Serial
    private static final long serialVersionUID = 121211232112L;
    public static String FILE_PATH = Helper.dirPath + "KhoTheLoai.bin";
    private int idIdentity = 0;

    //toDo: crud

    public void showMenu() {

        System.out.println("Tương tác với thể loại");
        System.out.println("1. Them the loai");
        System.out.println("2. Sua the loai");
        System.out.println("3. Xoa the loai");
        System.out.println("4. Xem danh sach the loai");
        System.out.println("5. Thoat");

    }

    public void showMenuThuThu() {

        System.out.println("Tương tác với thể loại");
        System.out.println("1. tìm kiếm thể loại");
        System.out.println("2. Xem danh sach the loai");
        System.out.println("3. Thống kê thể loại yêu thích");

        System.out.println("4. Thoat");
    }
    public void inThongKeTheLoaiYeuThich(){
        ArrayList<TheLoaiThinhHanh> theLoaiYeuThich = new ArrayList<>();
        TongHopDuLieu.getDanhSachCTMuonTra().data.forEach(ct -> {
           ct.getBook().getTheLoais().forEach(theLoai -> {
               var theLoaiYT = new TheLoaiThinhHanh();
               var theLoaiExist = theLoaiYeuThich.stream().filter(tl -> tl.getTenTheLoai().equals(theLoai.getTenTheLoai())).findFirst().orElse(null);
                if (theLoaiExist == null) {
                    theLoaiYT.setTenTheLoai(theLoai.getTenTheLoai());
                    theLoaiYT.setSoLanMuon(1);
                    theLoaiYeuThich.add(theLoaiYT);
                } else {
                    theLoaiExist.setSoLanMuon(theLoaiExist.getSoLanMuon() + 1);
                }
           });
        });
        // sap xep theo so lan muon
        theLoaiYeuThich.sort((o1, o2) -> o2.getSoLanMuon() - o1.getSoLanMuon());
        // set stt
        for (int i = 0; i < theLoaiYeuThich.size(); i++) {
            theLoaiYeuThich.get(i).setStt(i + 1);
        }
        System.out.println(Table.taoBang(theLoaiYeuThich));

    }
    public void thuThuLamViec() {
        int luaChon;
        
        do {
            showMenuThuThu();
            luaChon = Helper.nhapSoNguyen("Lua chon khong hop le, nhap lai: ");
            switch (luaChon) {
                case 1 -> timKiemTheLoai();
                case 2 -> xuatConsoleDangTable();
                case 3 -> inThongKeTheLoaiYeuThich();
                case 4 -> System.out.println("Thoat");
                default -> System.out.println("Lua chon khong hop le, nhap lai: ");
            }
        } while (luaChon != 3);
    }

    private void timKiemTheLoai() {
        System.out.println("Bạn muốn tìm theo tên hay id?");
        System.out.println("1. Tìm theo tên");
        System.out.println("2. Tìm theo id");
        int luaChon = Helper.nhapSoNguyen("Lua chon khong hop le, nhap lai: ");
        switch (luaChon) {
            case 1 -> {
                System.out.println("Nhập tên: ");
                String ten = Helper.scanner.nextLine();
                ArrayList<TheLoai> theLoaiArrayList = this.getAllByName(ten);
                if (theLoaiArrayList.size() == 0) {
                    System.out.println("Không tìm thấy");
                }
            }
            case 2 -> {
                System.out.println("Nhập id: ");
                int id = Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: ");
                TheLoai theLoai = this.getById(id);
                if (theLoai == null) {
                    System.out.println("Không tìm thấy");
                } else {
                    theLoai.xuat();
                    System.out.println("Bạn có muốn xuất tất cả sách thuộc thể loại này không? (y/n)");
                    char luaChon2 = Helper.scanner.nextLine().trim().toLowerCase().charAt(0);
                    if (luaChon2 == 'y') {
                        var khoSach = theLoai.getSachs();
                        System.out.println(Table.taoBang(khoSach));
                    } else {
                        System.out.println("bye");
                    }
                }
            }

            default -> System.out.println("Lua chon khong hop le: ");
        }
    }


    public int themVaNhapTheLoai() {
        TheLoai theLoai = new TheLoai();
        theLoai.nhap();
        this.add(theLoai);
        return theLoai.getId();
    }


    public TheLoai getByName(String name) {
        return this.data.stream().filter(s -> s.getTenTheLoai().toLowerCase().contains(name.toLowerCase())).findFirst().orElse(null);
    }

    public ArrayList<TheLoai> getAllByName(String name) {
        return new ArrayList<TheLoai>(this.data.stream().filter(s -> s.getTenTheLoai().toLowerCase().contains(name.toLowerCase())).toList());
    }

    public void add(TheLoai theLoai) {
        var exist = getByName(theLoai.getTenTheLoai());
        if (exist != null) {
            theLoai.setId(exist.getId());
            return;
        }
        theLoai.setId(idIdentity++);
        data.add(theLoai);
    }

    public void lamViecVoiDanhSachTheLoai() {
        int luaChon;
        
        do {
            showMenu();
            System.out.println("Nhập lựa chọn của bạn");
            luaChon = Helper.nhapSoNguyen("Không hợp lệ: ");
            switch (luaChon) {
                case 1 -> themVaNhapTheLoai();
                case 2 -> {
                    xuatConsoleDangTable();
                    System.out.println("Nhap id thể loại muốn sửa: ");
                    int id = Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: ");
                    TheLoai theLoai = this.getById(id);
                    if (theLoai == null) {
                        System.out.println("Không tìm thấy");
                    } else {
                        theLoai.sua();
                    }

                }
                case 3 -> {
                    System.out.println("Nhap id thể loại muốn xóa: ");
                    int id = Helper.nhapSoNguyen("Id không hợp lệ, nhập lại: ");
                    TheLoai theLoai = this.getById(id);
                    if (theLoai == null) {
                        System.out.println("Không tìm thấy");
                    } else {
                        TongHopDuLieu.getDanhSachTheLoai_sach().getTheLoai_saches().removeIf(s -> s.getTheLoaiId()== id);

                        this.data.remove(theLoai);
                    }
                }
                case 4 -> xuatConsoleDangTable();
                case 5 -> {
                    this.xuatFileBinary();
                    System.out.println("Lưu dữ liệu thành công");
                }


                default -> System.out.println("Lua chon khong hop le");
            }
        } while (luaChon != 5);
    }

    public TheLoai getById(int id) {
        for (TheLoai theLoai : this.data) {
            if (theLoai.getId() == id) {
                return theLoai;
            }
        }
        return null;
    }


    public void delete(int id) {
    	if(getById(id)==null){
    		System.out.println("Không có trong kho thể loại!!");
    		return;
    	}
        TheLoai theLoai = getById(id);
        if (theLoai != null) {

            System.out.println("Đây là thể loại sắp xóa");
            Mang<TheLoai> TheLoaiSapXoa = new Mang<>();
            TheLoaiSapXoa.add(getById(id));
            if (TheLoaiSapXoa.size() == 0) {
                return;
            }
            System.out.println(Table.taoBang(TheLoaiSapXoa));
        	System.out.print("Bạn có chắc muốn xóa không (y/n): ");
        	if(Helper.scanner.nextLine().equals("y")) {
            	System.out.println("Đã xóa!!");
            	data.remove(theLoai);
              return;
            } 	
            System.out.println("Đã hủy xóa!!");
            
        }
    }

    public void update(int id) {
        TheLoai theLoai = getById(id);
        if (theLoai != null) {
            System.out.println("Đây là thể loại sắp chỉnh sửa");
            Mang<TheLoai> TheLoaiSapCS = new Mang<>();
            TheLoaiSapCS.add(getById(id));
            if (TheLoaiSapCS.size() == 0) {
                return;
            }
            System.out.println(Table.taoBang(TheLoaiSapCS));
            theLoai.nhap();
        } else {
            System.out.println("Khong tim thay the loai");
        }
    }


    public void xuatFileBinary() {
        TongHopDuLieu.getDanhSachTheLoai_sach().xuatFileBinary();
        super.xuatFileBinary(FILE_PATH);
    }

    @Override
    public void copyFrom(IDanhSach<TheLoai> other) {
        var otherKhoTheLoai = (KhoTheLoai) other;
        this.data = otherKhoTheLoai.data;
        this.idIdentity = otherKhoTheLoai.idIdentity;
    }

}
