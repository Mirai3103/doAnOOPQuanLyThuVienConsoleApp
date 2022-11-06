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


//    @Override
//    public String[] getRowData() {
//        String[] rowData = super.getRowData();
//        // append new data
//        String[] newRowData = new String[rowData.length + 5];
//        System.arraycopy(rowData, 0, newRowData, 0, rowData.length);
//        int i = rowData.length;
//        newRowData[i++] = NoiLamViec;
//        newRowData[i++] = NgayNhanChuc;
//        newRowData[i++] = NgayLamViec;
//        newRowData[i++] = String.valueOf(NamKinhNghiem);
//        newRowData[i] = Truong? "Trưởng phòng" : "";
//        return newRowData;
//    }

//    @Override
//    public String[] getHeader() {
//        String[] header = super.getHeader();
//        String[] newHeader = new String[header.length + 5];
//        System.arraycopy(header, 0, newHeader, 0, header.length);
//        int i = header.length;
//        newHeader[i++] = "Nơi làm việc";
//        newHeader[i++] = "Ngày nhận chức";
//        newHeader[i++] = "Ngày làm việc";
//        newHeader[i++] = "Năm kinh nghiệm";
//        newHeader[i] = "Trưởng phòng";
//        return newHeader;
//}
}
