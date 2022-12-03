package Repository;

import Model.DocGia;
import Model.TacGia;
import Model.TheThuVien;
import helper.Helper;
import helper.Xuat.Table;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Scanner;
public class DocGias  extends BaseDanhSach<DocGia> {
    @Serial
    private static final long serialVersionUID = 121246565461212L;
    public static final String FILE_PATH = Helper.dirPath + "DanhSachDocGia.bin";
    private int idIdentity = 0;
    Scanner sc= new Scanner(System.in);
    @Override
    public void copyFrom(IDanhSach<DocGia> other) {
        var otherDocGias = (DocGias) other;
        this.idIdentity = otherDocGias.idIdentity;
        this.data = otherDocGias.data;
    }

    @Override
    public void add(DocGia item) {
       item.setIDdg(idIdentity++);
        data.add(item);
    }
    public  void dangKyThanhVien() {
        var docGia = new DocGia();
        docGia.nhapDocGia();
        this.add(docGia);
        System.out.println("Bắt đầu đăng ký thẻ thư viện");
        var theThuVien = new TheThuVien();
        theThuVien.themTheThuVien(docGia.getIDdg());
        docGia.setIDthe(theThuVien.getIDthe());
        System.out.println("Đăng ký thành công");
        System.out.println("Phí đăng ký thẻ là: " + docGia.phiTaoThe());
        theThuVien.xuatTheThuVien();
    }
    public void showMenu(){
        System.out.println("1. Đăng ký thành viên");
        System.out.println("2. Hiển thị danh sách độc giả");
        System.out.println("3. Tìm kiếm độc giả");
        System.out.println("4. Sửa thông tin độc giả");
        System.out.println("5. Xóa độc giả");
        System.out.println("6. Quay lại");
    }
    public DocGia getById(int id){
        return data.stream().filter(s ->s.getIDdg() == id).findFirst().orElse(null);
    }
    public ArrayList<DocGia> getByName(String name){
       return  new ArrayList<>( data.stream().filter(s ->s.getHoTen().toLowerCase().contains(name.toLowerCase())).toList());
    }
    public void suaDocGia(){
        System.out.println("Nhập ID độc giả cần sửa");
        var id = Helper.nhapSoNguyen("ID độc giả không hợp lệ");
        var docGia = this.getById(id);
        if(docGia == null){
            System.out.println("Không tìm thấy độc giả");
            return;
        }
        docGia.nhapDocGia();

    }
    public void xoaDocGia(){
        System.out.println("Nhập ID độc giả cần xóa");
        var id = Helper.nhapSoNguyen("ID độc giả không hợp lệ");
        var docGia = this.getById(id);
        if(docGia == null){
            System.out.println("Không tìm thấy độc giả");
            return;
        }
        System.out.print("Bạn có chắc muốn xóa không (y/n): ");
        if(sc.nextLine().equals("y")) {
        	System.out.println("Đã xóa!!");
        	data.remove(docGia);
        } 	
        System.out.println("Đã hủy xóa!!");
        
    }

    public void lamViec(){
        int chon;
        do {
            showMenu();
            chon = Helper.nhapSoNguyen("Chọn chức năng không hợp lệ, nhập lại: ");
            switch (chon) {
                case 1 -> dangKyThanhVien();
                case 2 -> this.xuatConsoleDangTable();
                case 3 -> {
                    System.out.println("Bạn muốn tìm theo tên hay ID");
                    System.out.println("1. Tìm theo tên");
                    System.out.println("2. Tìm theo ID");
                    int chon2 = Helper.nhapSoNguyen("Chọn chức năng không hợp lệ, nhập lại: ");
                    if (chon2 == 1) {
                        String name = Helper.scanner.nextLine();
                        var docGias = getByName(name);

                        if (docGias.size() == 0) {
                            System.out.println("Không tìm thấy độc giả nào");
                        } else {
                            System.out.println("Có " + docGias.size() + " độc giả tên " + name);
                            System.out.println(Table.taoBang(docGias));
                        }
                    } else if (chon2 == 2) {
                        int id = Helper.nhapSoNguyen("Nhập ID độc giả: ");
                        var docGia = getById(id);
                        if (docGia == null) {
                            System.out.println("Không tìm thấy độc giả nào");
                        } else {
                            System.out.println(Table.taoBang(docGia));
                        }
                    } else {
                        System.out.println("Chọn chức năng không hợp lệ");
                    }
                }
                case 4 -> this.suaDocGia();
                case 5 -> this.xoaDocGia();
                case 6 -> xuatFileBinary();
                default -> System.out.println("Chọn chức năng không hợp lệ, nhập lại: ");
            }
        }while (chon != 6);
    }
    public void xuatFileBinary(){
        super.xuatFileBinary(FILE_PATH);
    }

    public void thuThuLamViec() {
    }
}


