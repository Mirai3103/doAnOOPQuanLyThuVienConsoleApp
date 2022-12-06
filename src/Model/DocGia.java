package Model;

import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class DocGia extends ConNguoi implements Serializable, ITableRowData {
    @Serial
    private static final long serialVersionUID = -266706354210367639L;
    protected int IDdg;
    protected int IDthe;

    public DocGia() {
    }

    public DocGia(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC, int IDdg, int IDthe) {
        super(hoTen, ngaySinh, sDT, cMND, dC);
        this.IDdg = IDdg;
        this.IDthe = IDthe;
    }

    public void nhapDocGia() {
        super.Nhap();
    }

    public int getIDdg() {
        return IDdg;
    }

    public void setIDdg(int IDdg) {
        this.IDdg = IDdg;
    }

    public int phiTaoThe() {
        return LocalDate.now().getYear() - Helper.parseDate(this.getNgaySinh()).getYear() > 18 ? 50000 : 20000;
    }


    public int getIDthe() {
        return IDthe;
    }

    public void setIDthe(int IDthe) {
        this.IDthe = IDthe;
    }

    @Override
    public String[] getRowData() {
        return new String[]{
                this.IDdg + "",
                this.IDthe + "",
                this.getHoTen(),
                this.getNgaySinh(),
                this.getSDT(),
                this.getCMND(),
                this.getDC().toString(),
        };
    }

    @Override
    public String[] getHeader() {
        return new String[]{"ID Độc Giả", "ID Thẻ", "Họ Tên", "Ngày Sinh", "Số Điện Thoại", "CMND", "Địa Chỉ"};
    }

    void menuSua() {
        System.out.println("1. Sửa họ tên");
        System.out.println("2. Sửa ngày sinh");
        System.out.println("3. Sửa số điện thoại");
        System.out.println("4. Sửa CMND");
        System.out.println("5. Sửa địa chỉ");
        System.out.println("6. Tạo thẻ mới");
        System.out.println("7. Thoát");
        System.out.println("Chọn chức năng: ");
    }

    public void sua() {

        int chon;

        do {
            
//            System.out.println(Table.taoBang(this));
            System.out.println("Sửa thông tin độc giả");
            menuSua();
            chon = Helper.nhapSoNguyen("Không hợp lệ. Nhập lại: ");
            switch (chon) {
                case 1 -> {
                    String HoTen;
                    System.out.println("Sửa Họ Tên: ");
                    HoTen = Helper.scanner.nextLine();
                    setHoTen(HoTen);
                }
                case 2 -> {
                    System.out.println("Sửa Ngày Sinh: ");
                    System.out.println("Nhập ngày sinh: ");
                    setNgaySinh(Helper.inputDate().format(Helper.DATE_FORMAT));
                }
                case 3 -> {
                    System.out.println("Sửa Số Điện Thoại: ");
                    setSDT(Helper.nhapSdt());
                }
                case 4 -> {
                    System.out.println("Sửa CMND: ");

                    setCMND(Helper.nhapCMND());
                }
                case 5 -> {
                    DiaChi k = new DiaChi();
                    System.out.println("Sửa địa chỉ: ");
                    k.Nhap();
                    setDC(k);
                }
                case 6 -> {
                    TheThuVien theThuVien = new TheThuVien();
                    TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien);
                    theThuVien.setNgaybd(LocalDate.now());
                    theThuVien.setNgayhh(LocalDate.now().plusYears(1));
                    theThuVien.setIDuser(this.IDdg);
                    theThuVien.inThe();
                    System.out.println("Tạo thẻ thành công, phí tạo thẻ là: " + phiTaoThe());

                }
                case 7 -> {
                    System.out.println("Thoát");
                }
                default -> System.out.println("đối số truyền vào không đúng");
            }

        } while (chon != 7);

    }

    public static void main(String[] a) {
        DocGia k = new DocGia();
        k.sua();
    }
}
