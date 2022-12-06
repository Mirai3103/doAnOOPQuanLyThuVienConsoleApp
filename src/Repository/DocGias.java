package Repository;

import Model.DocGia;
import Model.TacGia;
import Model.TheThuVien;
import Report.ThongKeDocGia;
import helper.Helper;
import helper.Mang;
import helper.Xuat.Table;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Scanner;
public class DocGias  extends BaseDanhSach<DocGia> {
    @Serial
    private static final long serialVersionUID = 121246565461212L;
    public static final String FILE_PATH = Helper.dirPath + "DanhSachDocGia.bin";
    private int idIdentity = 0;

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
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien);

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
        System.out.println("6. Thống kê độc giả");
        System.out.println("7. Lưu vào file");
        System.out.println("8. Quay lại");
    }
    public void  inThongKe(){
        ArrayList<ThongKeDocGia> list = new ArrayList<>();
        var ctMuonTras = TongHopDuLieu.getDanhSachCTMuonTra().getAll();
        for(var ctMuonTra : ctMuonTras){
            var tk = new ThongKeDocGia();
            tk.setMaThe(ctMuonTra.getMuonTra().getIDthe());
            tk.setMaDocGia(ctMuonTra.getMuonTra().getTheThuVien().getIDuser());
            tk.setHoTen(ctMuonTra.getMuonTra().getTheThuVien().getUser().getHoTen());
            var exist = list.stream().filter(x -> x.getMaDocGia() == tk.getMaDocGia()).findFirst().orElse(null);
            if(exist == null){
                tk.setSoSachMuon(1);
                tk.setSoLanViPham(0);
                if(ctMuonTra.getLoiPhatId() != -1){
                    tk.setSoLanViPham(1);
                }
                list.add(tk);
            }else {
                exist.setSoSachMuon(exist.getSoSachMuon() + 1);
                if(ctMuonTra.getLoiPhatId() != -1){
                    exist.setSoLanViPham(exist.getSoLanViPham() + 1);
                }
            }
        }
        //Sắp xếp theo số sách mượn
        list.sort((x, y) -> y.getSoSachMuon() - x.getSoSachMuon());
        //set STT
        for(int i = 0; i < list.size(); i++){
            list.get(i).setStt(i + 1);
        }
        System.out.println("Thống kê độc giả");
        System.out.println(Table.taoBang(list));
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
        System.out.println("Đây là độc giả sắp chỉnh sửa");
        Mang<DocGia> DocGiaSapCS = new Mang<>();
        DocGiaSapCS.add(getById(id));
        if (DocGiaSapCS.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(DocGiaSapCS));
        docGia.sua();

    }
    public void xoaDocGia(){
        System.out.println("Nhập ID độc giả cần xóa");
        var id = Helper.nhapSoNguyen("ID độc giả không hợp lệ");
        var docGia = this.getById(id);
        if(docGia == null){
            System.out.println("Không tìm thấy độc giả");
            return;
        }

        System.out.println("Đây là độc giả sắp Xóa");
        Mang<DocGia> DocGiaSapXoa = new Mang<>();
        DocGiaSapXoa.add(getById(id));
        if (DocGiaSapXoa.size() == 0) {
            return;
        }
        System.out.println(Table.taoBang(DocGiaSapXoa));
        System.out.print("Bạn có chắc muốn xóa không (y/n): ");
        if(Helper.scanner.nextLine().equals("y")) {
            System.out.println("Đã xóa!!");
            data.remove(docGia);
            return;
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
                        System.out.println("Nhập ID độc giả cần tìm");
                        int id = Helper.nhapSoNguyen("Id không hop  lệ,nhập lại: ");
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
                case 6 -> this.inThongKe();
                case 7 -> xuatFileBinary();
                default -> System.out.println("Chọn chức năng không hợp lệ, nhập lại: ");
            }
        }while (chon != 8);
    }
    public void xuatFileBinary(){
        super.xuatFileBinary(FILE_PATH);
    }

    public void thuThuLamViec() {
    }
}


