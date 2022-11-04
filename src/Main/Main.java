package Main;

import Model.NhanVien;
import Model.QuanLi;
import Model.ThuThu;
import Repository.TongHopDuLieu;
import helper.Helper;
public class Main {
    public static NhanVien nguoiDung = null;
    private static boolean Login(){
        System.out.println("\t ĐĂNG NHẬP");
        System.out.println("Nhập mã nhân viên:");
        String maNhanVien = Helper.scanner.nextLine().trim();
        System.out.println("Nhập mật khẩu:");
        String matKhau = Helper.scanner.nextLine().trim();
        NhanVien user = TongHopDuLieu.getNhanViens().getByMaNV(maNhanVien);
        if(user == null){
            System.out.println("Mã nhân viên không tồn tại");
            return false;
        }
        if(!user.getMK().equals(matKhau)){
            System.out.println("Mật khẩu không đúng");
            return  false;
        }
        nguoiDung = user;
        System.out.println("Đăng nhập thành công");
        System.out.println("Xin chào " + nguoiDung.getHoTen());
        return true;
    }
    public static void main(String[] args) {
        while (!Login()){

        }
        if(nguoiDung instanceof QuanLi){
            // Menu Các việc làm của quản lí
        }
        else{
            // Menu Các việc làm của thủ thư
        }
    }
}