package Repository;


import Model.TheLoai;
import helper.Helper;

public class KhoTheLoai extends BaseDanhSach<TheLoai> {
    public static String FILE_PATH = Helper.dirPath + "KhoTheLoai.bin";

    public KhoTheLoai() {
    }



    //toDo: crud
    public void showMenu() {
        System.out.println("Tương tác với thể loại");
        System.out.println("1. Them the loai");
        System.out.println("2. Sua the loai");
        System.out.println("3. Xoa the loai");
        System.out.println("4. Xem danh sach the loai");
        System.out.println("5. Thoat");
        System.out.println("7. Lưu dữ liệu");

    }

    public int themVaNhapTheLoai() {
        TheLoai theLoai = new TheLoai();
        theLoai.nhap();
        data.add(theLoai);
        return theLoai.getId();
    }
    public TheLoai getByName(String name){
        return this.data.stream().filter(s ->s.getTenTheLoai().toLowerCase().equalsIgnoreCase(name.toLowerCase())).findFirst().orElse(null);
    }
    public void add(TheLoai theLoai){
        data.add(theLoai);
    }

    public void lamViecVoiDanhSachTheLoai(){
        int luaChon;
        Helper.clearScreen();
        do {
            showMenu();
            System.out.println("Nhập lựa chọn của bạn");
            luaChon = Helper.nhapSoNguyen("Không hợp lệ: ");
            switch (luaChon) {
                case 1 -> themVaNhapTheLoai();
                case 2 -> {
                    System.out.println("Nhap id the loai can sua");
                    update(new java.util.Scanner(System.in).nextInt());
                }
                case 3 -> {
                    System.out.println("Nhap id the loai can xoa");
                    delete(new java.util.Scanner(System.in).nextInt());
                }
                case 4 -> xuatConsoleDangTable();
                case 5 -> System.out.println("Thoat");
                case 7 -> {
                    this.xuatFileBinary();
                    System.out.println("Lưu dữ liệu thành công");
                }

                default -> System.out.println("Lua chon khong hop le");
            }
        }while (luaChon != 5);
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
        TheLoai theLoai = getById(id);
        if(theLoai != null){
            data.remove(theLoai);
        }
    }

    public void update(int id) {
        TheLoai theLoai = getById(id);
        if(theLoai != null){
            theLoai.nhap();
        }else {
            System.out.println("Khong tim thay the loai");
        }
    }


    public void xuatFileBinary(){
        TongHopDuLieu.getDanhSachTheLoai_sach().xuatFileBinary();
        super.xuatFileBinary(FILE_PATH);
    }

//    @Override
//    public void readCsv(String fileName) {
//        this.data = new ArrayList<>();
//       var rows =  Table.docFileExcel(FILE_PATH);
//         for (String row : rows) {
//           data.add(TheLoai.fromCSVRow(row));
//         }
//    }


}
