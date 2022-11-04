package Model;


import helper.Helper;
import Repository.NhanViens;
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
    }
    public QuanLi(String maNV) {
        super(maNV);
        NamKinhNghiem = 0;
        NgayNhanChuc = MaBaoMat = DacQuyen = "";
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
        System.out.println("Nhập năm kinh nghiệm: ");
        NamKinhNghiem=Helper.nhapSoNguyen("Phải là số nguyên!!! Yêu cầu nhập lại: ");
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
}
