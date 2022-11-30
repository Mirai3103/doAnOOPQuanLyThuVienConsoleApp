package Model;


import helper.Helper;
import Repository.KhoSach;
import helper.Xuat.Table;

import java.io.Serial;
import java.lang.reflect.Array;

public class ThuThu extends NhanVien{
    @Serial
    private static final long serialVersionUID = 321299L;
    private String NoiLamViec,NgayNhanChuc,NgayLamViec;
    private int NamKinhNghiem;
    private boolean Truong;

    public ThuThu() {
        super();
        NoiLamViec = NgayNhanChuc = NgayLamViec = "";
        NamKinhNghiem = 0;
        Truong = false;
        this.ChucVu = "Thu Thu";
    }



    public ThuThu(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC,String maNV, String chucVu, String mK, int luong,String noiLamViec, String ngayNhanChuc, String ngayLamViec, int namKinhNghiem, boolean truong) {
        super(hoTen,ngaySinh,sDT,cMND,dC,maNV,chucVu,mK,luong);
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
        NoiLamViec=Helper.scanner.nextLine();
        do {
            System.out.println("Nhập ngày nhận chức: ");
            NgayNhanChuc = Helper.scanner.nextLine();
        }while (!Helper.checkNgayThang(NgayNhanChuc));
        do {
            System.out.println("Nhập ngày làm việc: ");
            NgayLamViec = Helper.scanner.nextLine();
        }while (!Helper.checkNgayThang(NgayLamViec));
        System.out.println("Nhập năm kinh nghiệm: ");
        NamKinhNghiem= Helper.nhapSoNguyen("Phải là số nguyên!! yêu cầu nhập lại: ");
        System.out.println("Nhấn y nếu đó là trưởng (y/n): ");
        Truong=Helper.scanner.nextLine().toLowerCase().charAt(0) == 'y';
    }

    public void Xuat() {

        super.Xuat();
        System.out.printf("Nhập nga lam: " + NoiLamViec);
        System.out.printf("NgÃ y nháº­n chá»©c: " + NgayNhanChuc);
        System.out.printf("NgÃ y lÃ m viá»‡c: " + NgayLamViec);
        System.out.printf("NÄƒm kinh nghiá»‡m: " + NamKinhNghiem);
        System.out.printf("TrÆ°á»Ÿng phÃ²ng: " + Truong);
    }
    public void xuatDangBang(){
        System.out.println(Table.taoBang(this));;
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
        newRowData[i] = Truong? "Trưởng phòng" : "";
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
    public void sua() {
    	int j = 0;
    	for(var i : getHeader()) {
    		if(!(i.equalsIgnoreCase("Mã nhân viên")||i.equalsIgnoreCase("Chức vụ"))) {
    		j++;
    		System.out.printf(j + ". " + i +"\n");
    		}
    	}
    	System.out.println("3. Thoát");
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
		case 8:{
			System.out.println("Nhập nơi làm việc: ");
	        NoiLamViec=Helper.scanner.nextLine();
	        break;
		}
		case 9: {
			String NC = new String();
			System.out.println("Sửa ngày nhận chức: ");
			do {
	            System.out.println("Nhập ngày nhận chức : ");
	            NgayNhanChuc = Helper.scanner.nextLine();
	        }while (!Helper.checkNgayThang(NgayNhanChuc));
			setNgayNhanChuc(NC);
			break;
		}
		case 10:{
			 do {
		            System.out.println("Sửa ngày làm việc: ");
		            NgayLamViec = Helper.scanner.nextLine();
		        }while (!Helper.checkNgayThang(NgayLamViec));
			 break;
		}
		case 11:{
			do {
			System.out.println("Năm kinh nghiệm: ");
			NamKinhNghiem=Helper.nhapSoNguyen("Phải là số nguyên!!! Yêu cầu nhập lại: ");
			} while(NamKinhNghiem<0);
			break;
		}
		case 12 : {
			System.out.println("Trưởng phòng: ");
			System.out.println("Nhấn y nếu đó là trưởng (y/n): ");
	        Truong=Helper.scanner.nextLine().toLowerCase().charAt(0) == 'y';
	        break;
		}
		case 13: {
			break;
		}
		
		default:
			System.out.println("đối số truyền vào không đúng");;
		}}
    public static void main(String[] a) {
    	ThuThu k = new ThuThu();
    	k.sua();
    }
}
