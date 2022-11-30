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
    	int j = 0;
    	for(var i : getHeader()) {
    		if(!(i.equalsIgnoreCase("Mã nhân viên")||i.equalsIgnoreCase("Chức vụ"))) {
    		j++;
    		System.out.printf(j + ". " + i +"\n");
    		}
    	}
    	System.out.println("12. Thoát");
    	System.out.println("Nhập thuộc tính cần sửa");
    	int a = Helper.nhapSoNguyen("yêu cầu nhập số nguyên");
    	switch (a) {
		case 1: {
			String HoTen;
			System.out.println("Sửa Họ Tên: ");
			HoTen = Helper.scanner.nextLine();
			setHoTen(HoTen);	
			break;
		}
		case 2: {
			String NgaySinh;
			System.out.println("Sửa ngay sinh: ");
			do {
				System.out.println("Nhập ngày sinh:");
				NgaySinh = Helper.scanner.nextLine();
				if(NgaySinh.equalsIgnoreCase("null")){
					NgaySinh = "";
					break;
				}
			}while (!Helper.checkNgayThang(NgaySinh));

			setNgaySinh(NgaySinh);	
			break;
		}
		case 3: {
			String SDT;
			System.out.println("Sửa SDT: ");
			do {
				System.out.println("Nhập số điện thoại:");
				SDT = Helper.scanner.nextLine();
				if(SDT.equalsIgnoreCase("null")){
					SDT = "";
					break;
				}
			}while (!checkSdt(SDT));
			setSDT(SDT);
			break;
		}
		case 4: {
			String CMND;
			System.out.println("Sửa CMND: ");
			do {
				System.out.println("Nhập số CMND/CCCD:");
				CMND = Helper.scanner.nextLine();
				if(CMND.equalsIgnoreCase("null")){
					CMND = "";
					break;
				}
			}while (!checkCMND(CMND));

			setCMND(CMND);	
			break;
		}
		case 5: {
			DiaChi k = new DiaChi();
			System.out.println("Sửa địa chỉ: ");
			k.Nhap();
			setDC(k);
			break;
		}
		case 6: {
			String MK;
			System.out.println("Sửa Mật khẩu: ");
			MK = Helper.scanner.nextLine();
			setMK(MK);
			break;
		}
		case 7: {
			int Luong;
			System.out.println("Sửa lương: ");
			Luong = Helper.nhapSoNguyen("phải là số nguyên!! yêu cầu nhập lại : ");
			while (Luong <0){
				System.out.println("Lương không hợp lệ!, nhập lại");
				Luong = Helper.nhapSoNguyen("phải là số nguyên dương!! yêu cầu nhập lại : ");
			}
			setLuong(Luong);
			break;
		}
		case 8: {
			String NC = new String();
			System.out.println("Sửa ngày nhận chức: ");
			do {
	            System.out.println("Nhập ngày nhận chức : ");
	            NgayNhanChuc = Helper.scanner.nextLine();
	        }while (!Helper.checkNgayThang(NgayNhanChuc));
			setNgayNhanChuc(NC);
			break;
		}
		case 9:{
			do {
			System.out.println("Năn kinh nghiệm: ");
			NamKinhNghiem=Helper.nhapSoNguyen("Phải là số nguyên!!! Yêu cầu nhập lại: ");
			} while(NamKinhNghiem<0);
			break;
		}
		case 10:{
			System.out.println("Đặt quyền");
			DacQuyen = Helper.scanner.nextLine();
			break;
		}
		case 11:{
			System.out.println("Nhập mã bảo mật: ");
	        MaBaoMat = Helper.scanner.nextLine();
	        break;
		}
		case 12 : {
			break;
		}
		
		default:
			System.out.println("đối số truyền vào không đúng");;
		}
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
