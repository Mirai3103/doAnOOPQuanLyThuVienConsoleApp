package Main;

import Main.Views.QuanLyView;
import Main.Views.ThuThuView;
import Model.NhanVien;
import Model.QuanLi;
import Repository.TongHopDuLieu;
import helper.Helper;


public class MainApp {
    public static NhanVien nguoiDung = null;
    private static boolean Login(){
        System.out.println("\t ĐĂNG NHẬP");
        System.out.println("Nhập mã nhân viên:");
        String maNhanVien = Helper.inputNoneEmptyString().trim();
        System.out.println("Nhập mật khẩu:");
        String matKhau = Helper.inputNoneEmptyString().trim();
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
        // Bắt sự kiện người dùng tắt chương trình đột ngột
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Đang lưu dữ liệu");
            TongHopDuLieu.fastXuatFile();
        }));

        while (true){
            while (!Login()){

            }
            if(nguoiDung instanceof QuanLi){
                QuanLyView.run();
            }
            else{
                ThuThuView.run();
            }
        }
    }


}

