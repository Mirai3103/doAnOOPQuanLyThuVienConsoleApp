package Model;


import helper.Helper;

import java.util.Scanner;

import Repository.NhanViens;
import helper.Mang;
import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

public class QuanLi extends NhanVien  {
    private int NamKinhNghiem;
    private String NgayNhanChuc,MaBaoMat,DacQuyen;

    public QuanLi(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC,String maNV, String chucVu, String mK, int luong, int namKinhNghiem, String ngayNhanChuc, String maBaoMat, String dacQuyen) {
        super(hoTen,ngaySinh,sDT,cMND, dC, maNV, chucVu, mK, luong);
        NamKinhNghiem = namKinhNghiem;
        NgayNhanChuc = ngayNhanChuc;
        MaBaoMat = maBaoMat;
        DacQuyen = dacQuyen;
    }
    public QuanLi() {
        super();
        NamKinhNghiem = 0;
        NgayNhanChuc = MaBaoMat = DacQuyen = "";
        this.ChucVu = "Quan Li";
    }
    public QuanLi(String maNV) {
        super(maNV);
        NamKinhNghiem = 0;
        NgayNhanChuc = MaBaoMat = DacQuyen = "";
        this.ChucVu = "Quan Li";
    }

    public int getNamKinhNghiem() {
        return NamKinhNghiem;
    }

    public void setNamKinhNghiem(int namKinhNghiem) {
        NamKinhNghiem = namKinhNghiem;
    }

    public String getNgayNhanChuc() {
        return NgayNhanChuc;
    }

    public void setNgayNhanChuc(String ngayNhanChuc) {
        NgayNhanChuc = ngayNhanChuc;
    }

    public String getMaBaoMat() {
        return MaBaoMat;
    }

    public void setMaBaoMat(String maBaoMat) {
        MaBaoMat = maBaoMat;
    }

    public String getDacQuyen() {
        return DacQuyen;
    }

    public void setDacQuyen(String dacQuyen) {
        DacQuyen = dacQuyen;
    }

    public void Nhap() {
        super.Nhap();
        do {
            System.out.println("Nhập ngày nhận chức : ");
            NgayNhanChuc = Helper.scanner.nextLine();
        }while (!Helper.checkNgayThang(NgayNhanChuc));
        do {
        System.out.println("Nhập năm kinh nghiệm: ");
        NamKinhNghiem=Helper.nhapSoNguyen("Phải là số nguyên!!! Yêu cầu nhập lại: ");
        }while(NamKinhNghiem<0);
        System.out.println("Nhập mã bảo mật: ");
        MaBaoMat = Helper.scanner.nextLine();
        System.out.println("Nhập đặc quyền: ");
        DacQuyen = Helper.scanner.nextLine();
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
        System.out.println("8. Sửa năm kinh nghiệm");
        System.out.println("9. Sửa ngày nhận chức");
        System.out.println("10. Sửa đặc quyền ");
        System.out.println("11. Thoát");
	}

	public void Xuat() {
        super.Xuat();
        System.out.printf("\nNgày nhận chức: " + NgayNhanChuc);
        System.out.printf("\nNăm kinh nghiệm: " + NamKinhNghiem);
        System.out.printf("\nĐặc quyền: " + DacQuyen);
        System.out.printf("\nMã bảo mật: " + MaBaoMat);

    }

    @Override
    public String[] getRowData() {
        String[] oldRow = super.getRowData();
        String[] newRow = new  String[oldRow.length+4];
        System.arraycopy(oldRow, 0, newRow, 0, oldRow.length);
        int i = oldRow.length;
        newRow[i++] = NgayNhanChuc;
        newRow[i++] = String.valueOf(NamKinhNghiem);
        newRow[i++] = DacQuyen;
        newRow[i++] = MaBaoMat;
        return newRow;

    }
    public void xuatDangBang(){
        System.out.println(Table.taoBang(this));
    }

	public void sua() {
		int choose;
		do {
            
            this.xuatDangBang();
			menuSua();
			System.out.println("Nhập lựa chọn: ");
			choose = Helper.nhapSoNguyen("Lựa chọn không hop lệ !! yêu cầu nhập lại: ");
			switch (choose) {
				case 1 -> {
					String HoTen;
					System.out.println("Sửa Họ Tên: ");
					HoTen = Helper.scanner.nextLine();
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
                    MK = Helper.scanner.nextLine();
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
                    System.out.println("Nhập năm kinh nghiệm: ");
                    NamKinhNghiem = Helper.nhapSoTuNhien("Phải là số nguyên >=0!! yêu cầu nhập lại: ");
                }
                case 9 -> {
                    System.out.println("Sửa ngày nhận chức: ");
                    System.out.println("Nhập ngày nhận chức: ");
                    setNgayNhanChuc(Helper.inputDate().format(Helper.DATE_FORMAT));
                }
                case 10 -> {
                    System.out.println("Sửa đặc quyền: ");
                    System.out.println("Nhập đặc quyền: ");
                    DacQuyen = Helper.scanner.nextLine();
                }
                case 11->{}
                default -> {
                    System.out.println("đối số truyền vào không đúng");
                }
            }
        } while (choose != 11);

    }

    @Override
    public String[] getHeader() {
        String[] oldHeader = super.getHeader();
        String[] newHeader = new  String[oldHeader.length+4];
        System.arraycopy(oldHeader, 0, newHeader, 0, oldHeader.length);
        int i = oldHeader.length;
        newHeader[i++] = "Ngày nhận chức";
        newHeader[i++] = "Năm kinh nghiệm";
        newHeader[i++] = "Đặc quyền";
        newHeader[i++] = "Mã bảo mật";
        return newHeader;
    }
    public static void main(String[] args) {
    	QuanLi a = new QuanLi();
    	a.sua();
    }
}
