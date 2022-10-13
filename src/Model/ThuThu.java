package Model;


import helper.Helper;

public class ThuThu extends NhanVien{
    private String NoiLamViec,NgayNhanChuc,NgayLamViec;
    private int NamKinhNghiem;
    private boolean Truong;


    private ThuThu() {
        super();
        NoiLamViec = NgayNhanChuc = NgayLamViec = null;
        NamKinhNghiem = 0;
        Truong = false;
//        s = null;
    }



    public ThuThu(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC,String maNV, String chucVu, String mK, int luong,String noiLamViec, String ngayNhanChuc, String ngayLamViec, int namKinhNghiem, boolean truong) {
        super(hoTen,ngaySinh,sDT,cMND,dC,maNV,chucVu,mK,luong);
        NoiLamViec = noiLamViec;
        NgayNhanChuc = ngayNhanChuc;
        NgayLamViec = ngayLamViec;
        NamKinhNghiem = namKinhNghiem;
        Truong = truong;
//        this.s = s;
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
        }while (!checkNgayThang(NgayNhanChuc));
        do {
            System.out.println("Nhập ngày làm việc: ");
            NgayLamViec = Helper.scanner.nextLine();
        }while (!checkNgayThang(NgayLamViec));
        System.out.println("Nhập năm kinh nghiệm: ");
        NamKinhNghiem= Helper.nhapSoNguyen("Không hợp lệ. Nhập lại năm Kinh nghiem: ");
        System.out.println("Đây có phải là trưởng phòng (y/n): ");
        Truong=Helper.scanner.nextLine().toLowerCase().charAt(0) == 'y'; // bị lỗi ?? cần hàm check không?
    }
    public void Xuat() {

        super.Xuat();
        System.out.printf("Nơi làm việc: " + NoiLamViec);
        System.out.printf("Ngày nhận chức: " + NgayNhanChuc);
        System.out.printf("Ngày làm việc: " + NgayLamViec);
        System.out.printf("Năm kinh nghiệm: " + NamKinhNghiem);
        System.out.printf("Trưởng phòng: " + Truong);
    }


}
