package Model;

import helper.Helper;
import helper.Xuat.ITableRowData;

import java.io.Serial;

public abstract class NhanVien extends ConNguoi implements ITableRowData {

    @Serial
    private static final long serialVersionUID = 221223213L;
    protected String MaNV, ChucVu, MK;
    private int Luong;

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public NhanVien(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC, String maNV, String chucVu, String mK, int luong) {
        super(hoTen, ngaySinh, sDT, cMND, dC);
        MaNV = maNV;
        ChucVu = chucVu;
        MK = mK;
        Luong = luong;
    }

    public NhanVien() {
        super();
        MaNV = ChucVu = MK = "";
        Luong = 0;
    }

    public NhanVien(String maNV) {
        super();
        MaNV = maNV;
        ChucVu = "";
        MK = "";
        Luong = 0;
    }


    public String getMaNV() {
        return MaNV;
    }


    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String mK) {
        MK = mK;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int luong) {
        Luong = luong;
    }

    protected boolean checkCMND(String CMND) {
        if (CMND.matches("([\\d]{9})$")) {
            return true;
        } else {
            System.out.println("Số CMND/CCCD không hop lệ! ");
            return false;
        }
    }

    protected boolean checkSdt(String SDT) {
        if (SDT.matches("^[\\d]{10,11}$")) {
            return true;
        } else {
            System.out.println("Số điện thoại không hop lệ! ");
            return false;
        }
    }

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.println("Nhập mật khẩu: ");
        MK = Helper.inputNoneEmptyString();
        System.out.println("Nhập mức lương");
        Luong = Helper.nhapSoNguyen("phải là số nguyên!! yêu cầu nhập lại : ");
        while (Luong < 0) {
            System.out.println("Lương không hợp lệ!, nhập lại");
            Luong = Helper.nhapSoNguyen("phải là số nguyên!! yêu cầu nhập lại : ");
        }
    }

    public void Nhap(String maNV) {
        MaNV = maNV;
        this.Nhap();

    }

    public abstract void menuSua();

    public abstract void sua();

    public void Xuat() {
        super.Xuat();
        System.out.println("Mã nhân viên: " + MaNV);
        System.out.println("Chức vụ: " + ChucVu);
        System.out.println("Mật khẩu: " + MK);
        System.out.println("Lương: " + Luong);
    }

    @Override
    public String[] getRowData() {
        return new String[]{MaNV, getHoTen(), getNgaySinh(), getSDT(), getCMND(), getDC().toString(), ChucVu, MK, String.valueOf(Luong)};
    }

    public void suaThongTinCaNhan() {
        int choose;
        do {
            System.out.println("1. Sửa họ tên");
            System.out.println("2. Sửa ngày sinh");
            System.out.println("3. Sửa số điện thoại");
            System.out.println("4. Sửa CMND");
            System.out.println("5. Sửa địa chỉ");
            System.out.println("6. Sửa mật khẩu");
            System.out.println("Nhập lựa chọn: ");
            choose = Helper.nhapSoNguyen("Lựa chọn không hop lệ !! yêu cầu nhập lại: ");
            switch (choose) {
                case 1 -> {
                    String HoTen;
                    System.out.println("Sửa Họ Tên: ");
                    HoTen = Helper.inputNoneEmptyString();
                    setHoTen(HoTen);
                }
                case 2 -> {
                    System.out.println("Sửa ngay sinh: ");
                    setNgaySinh(Helper.inputDate().format(Helper.DATE_FORMAT));
                }
                case 3 -> {
                    System.out.println("Sửa số điện thoại: ");
                    setSDT(Helper.nhapSdt());
                }

                case 4 -> {
                    DiaChi k = new DiaChi();
                    System.out.println("Sửa địa chỉ: ");
                    k.Nhap();
                    setDC(k);
                }
                case 5 -> {
                    String MK;
                    System.out.println("Sửa Mật khẩu: ");
                    System.out.println("Nhập mật khẩu mới: ");
                    MK = Helper.inputNoneEmptyString();
                    setMK(MK);
                }

                case 6->{}
                default -> {
                    System.out.println("đối số truyền vào không đúng");
                }
            }
        } while (choose != 6);

    }
    public void thongTinCaNhan(){

        System.out.println("Thông tin cá nhân");
        Xuat();
        System.out.println("Bạn có muốn sửa thông tin cá nhân không? (y/n)");
        if(Helper.inputNoneEmptyString().charAt(0)=='y'){
            suaThongTinCaNhan();
        }else {
            System.out.println("bye");
        }
    }
    @Override
    public String[] getHeader() {
        return new String[]{"Mã nhân viên", "Họ tên", "Ngày sinh", "Số điện thoại", "CMND", "Địa chỉ", "Chức vụ", "Mật khẩu", "Lương"};
    }
}
