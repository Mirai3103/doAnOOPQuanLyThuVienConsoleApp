package Model;


import helper.Helper;
import helper.Xuat.Table;

import java.io.Serial;

public class ThuThu extends NhanVien {
    @Serial
    private static final long serialVersionUID = 321299L;
    private String NoiLamViec, NgayNhanChuc, NgayLamViec;
    private int NamKinhNghiem;
    private boolean Truong;

    public ThuThu() {
        super();
        NoiLamViec = NgayNhanChuc = NgayLamViec = "";
        NamKinhNghiem = 0;
        Truong = false;
        this.ChucVu = "Thu Thu";
    }


    public ThuThu(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC, String maNV, String chucVu, String mK, int luong, String noiLamViec, String ngayNhanChuc, String ngayLamViec, int namKinhNghiem, boolean truong) {
        super(hoTen, ngaySinh, sDT, cMND, dC, maNV, chucVu, mK, luong);
        NoiLamViec = noiLamViec;
        NgayNhanChuc = ngayNhanChuc;
        NgayLamViec = ngayLamViec;
        NamKinhNghiem = namKinhNghiem;
        Truong = truong;
        this.ChucVu = "Thu Thu";
    }

    public String getNoiLamViec() {
        return NoiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        NoiLamViec = noiLamViec;
    }

    public String getNgayNhanChuc() {
        return NgayNhanChuc;
    }

    public void setNgayNhanChuc(String ngayNhanChuc) {
        NgayNhanChuc = ngayNhanChuc;
    }

    public String getNgayLamViec() {
        return NgayLamViec;
    }

    public void setNgayLamViec(String ngayLamViec) {
        NgayLamViec = ngayLamViec;
    }

    public int getNamKinhNghiem() {
        return NamKinhNghiem;
    }

    public void setNamKinhNghiem(int namKinhNghiem) {
        NamKinhNghiem = namKinhNghiem;
    }

    public boolean isTruong() {
        return Truong;
    }

    public void setTruong(boolean truong) {
        Truong = truong;
    }


    public void Nhap() {
        super.Nhap();
        System.out.println("Nhập nơi làm việc: ");
        NoiLamViec = Helper.inputNoneEmptyString();
        do {
            System.out.println("Nhập ngày nhận chức: ");
            NgayNhanChuc = Helper.inputNoneEmptyString();
        } while (!Helper.checkNgayThang(NgayNhanChuc));
        do {
            System.out.println("Nhập ngày làm việc: ");
            NgayLamViec = Helper.inputNoneEmptyString();
        } while (!Helper.checkNgayThang(NgayLamViec));
        System.out.println("Nhập năm kinh nghiệm: ");
        NamKinhNghiem = Helper.nhapSoNguyen("Phải là số nguyên!! yêu cầu nhập lại: ");
        System.out.println("Nhấn y nếu đó là trưởng (y/n): ");
        Truong = Helper.inputNoneEmptyString().toLowerCase().charAt(0) == 'y';
    }


    public void Xuat() {

        super.Xuat();
        System.out.printf("Nơi làm việc: %s\n", NoiLamViec);
        System.out.printf("Ngày nhận chức: %s\n", NgayNhanChuc);
        System.out.printf("Ngày làm việc: %s\n", NgayLamViec);
        System.out.printf("Năm kinh nghiệm: %d\n", NamKinhNghiem);
        if(Truong) System.out.println("Trưởng phòng");
    }

    public void xuatDangBang() {
        System.out.println(Table.taoBang(this));
        ;
    }


    @Override
    public String[] getRowData() {
        String[] rowData = super.getRowData();
        // append new data
        String[] newRowData = new String[rowData.length + 5];
        System.arraycopy(rowData, 0, newRowData, 0, rowData.length);
        int i = rowData.length;
        newRowData[i++] = NoiLamViec;
        newRowData[i++] = NgayNhanChuc;
        newRowData[i++] = NgayLamViec;
        newRowData[i++] = String.valueOf(NamKinhNghiem);
        newRowData[i] = Truong ? "Trưởng phòng" : "";
        return newRowData;
    }

    @Override
    public String[] getHeader() {
        String[] header = super.getHeader();
        String[] newHeader = new String[header.length + 5];
        System.arraycopy(header, 0, newHeader, 0, header.length);
        int i = header.length;
        newHeader[i++] = "Nơi làm việc";
        newHeader[i++] = "Ngày nhận chức";
        newHeader[i++] = "Ngày làm việc";
        newHeader[i++] = "Năm kinh nghiệm";
        newHeader[i] = "Trưởng phòng";
        return newHeader;
    }

    @Override
    public void menuSua() {
        System.out.println("1. Sửa họ tên");
        System.out.println("2. Sửa ngày sinh");
        System.out.println("3. Sửa số điện thoại");
        System.out.println("4. Sửa CMND");
        System.out.println("5. Sửa địa chỉ");
        System.out.println("6. Sửa mật khẩu");
        System.out.println("7. Sửa lương");
        System.out.println("8. Sửa nơi làm việc");
        System.out.println("9. Sửa ngày nhận chức");
        System.out.println("10. Sửa ngày làm việc");
        System.out.println("11. Sửa năm kinh nghiệm");
        System.out.println("12. Sửa trưởng phòng");
        System.out.println("13. Thoát");
    }

    public void sua() {
        int choose;
        do {

            menuSua();
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
                    String MK;
                    System.out.println("Sửa Mật khẩu: ");
                    System.out.println("Nhập mật khẩu mới: ");
                    MK = Helper.inputNoneEmptyString();
                    setMK(MK);
                }
                case 7 -> {
                    int Luong;
                    System.out.println("Sửa lương: ");
                    System.out.println("Nhập lương: ");
                    Luong = Helper.nhapSoTuNhien("Phải là số nguyên >=0!! yêu cầu nhập lại: ");
                    setLuong(Luong);
                }
                case 8 -> {
                    System.out.println("Nhập nơi làm việc: ");
                    NoiLamViec = Helper.inputNoneEmptyString();
                }
                case 9 -> {
                    System.out.println("Sửa ngày nhận chức: ");
                    System.out.println("Nhập ngày nhận chức: ");
                    setNgayNhanChuc(Helper.inputDate().format(Helper.DATE_FORMAT));
                }
                case 10 -> {
                    System.out.println("Sửa ngày làm việc: ");
                    System.out.println("Nhập ngày làm việc: ");
                    setNgayLamViec(Helper.inputDate().format(Helper.DATE_FORMAT));
                }
                case 11 -> {
                    System.out.println("Sửa năm kinh nghiệm: ");
                    NamKinhNghiem = Helper.nhapSoNguyen("Phải là số nguyên >=0!! yêu cầu nhập lại: ");
                }
                case 12 -> {
                    System.out.println("Trưởng phòng: ");
                    System.out.println("Nhấn y nếu đó là trưởng (y/n): ");
                    Truong = Helper.inputNoneEmptyString().toLowerCase().charAt(0) == 'y';
                }
                case 13 -> {
                    System.out.println("Thoát sửa!");
                }
                default -> {
                    System.out.println("đối số truyền vào không đúng");
                }
            }
        } while (choose !=13 );

    }

    public static void main(String[] a) {
        ThuThu k = new ThuThu();
        k.sua();
    }
}
