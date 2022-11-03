package Repository;


import Model.*;

import java.io.*;

public final  class TongHopDuLieu  {

    private static KhoSach khoSach = null;
    private static KhoTheLoai khoTheLoai = null;
    private static DanhSachTheLoai_Sach danhSachTheLoai_sach = null;
    private static DanhSachTacGia danhSachTacGia = null;
    private static DanhSachNhaXuatBan danhSachNhaXuatBan = null;

    public static KhoSach getKhoSach() {
        if(khoSach == null){
            khoSach = new KhoSach();
            khoSach.docFileBinary(KhoSach.FILE_PATH);
        }
        return khoSach;
    }
    public static KhoTheLoai getKhoTheLoai() {
        if(khoTheLoai == null){
            khoTheLoai = new KhoTheLoai();
            khoTheLoai.docFileBinary(KhoTheLoai.FILE_PATH);
        }
        return khoTheLoai;
    }
    public static DanhSachTheLoai_Sach getDanhSachTheLoai_sach() {
        if(danhSachTheLoai_sach == null){
            danhSachTheLoai_sach = new DanhSachTheLoai_Sach();
            danhSachTheLoai_sach.docFileBinary(DanhSachTheLoai_Sach.FILE_PATH);
        }
        return danhSachTheLoai_sach;
    }
    public static DanhSachTacGia getDanhSachTacGia() {
        if(danhSachTacGia == null){
            danhSachTacGia = new DanhSachTacGia();
            danhSachTacGia.docFileBinary(DanhSachTacGia.FILE_PATH);
        }
        return danhSachTacGia;
    }
    public static DanhSachNhaXuatBan getDanhSachNhaXuatBan() {
        if(danhSachNhaXuatBan == null){
            danhSachNhaXuatBan = new DanhSachNhaXuatBan();
            danhSachNhaXuatBan.docFileBinary(DanhSachNhaXuatBan.FILE_PATH);
        }
        return danhSachNhaXuatBan;
    }


}
