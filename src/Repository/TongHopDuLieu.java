package Repository;


import Model.*;

import java.io.*;

public final  class TongHopDuLieu  {

    private static KhoSach khoSach = null;
    private static KhoTheLoai khoTheLoai = null;
    private static DanhSachTheLoai_Sach danhSachTheLoai_sach = null;
    private static DanhSachTacGia danhSachTacGia = null;
    private static DanhSachNhaXuatBan danhSachNhaXuatBan = null;

    private static NhanViens nhanViens = null;
    private static DanhSachPhieuMuon danhSachPhieuMuonTra =null;
    private static DanhSachCTMuonTra danhSachCTMuonTra = null;
    private static DocGias danhSachDocGia = null;
    private static DanhSachTheThuVien danhSachTheThuVien = null;
    private static DanhSachXuPhat danhSachXuPhat = null;

    public static DanhSachXuPhat getDanhSachXuPhat() {
        if(danhSachXuPhat == null){
            danhSachXuPhat = new DanhSachXuPhat();
            danhSachXuPhat.docFileBinary(DanhSachXuPhat.FILE_PATH);
        }
        return danhSachXuPhat;
    }



    public static DanhSachTheThuVien getDanhSachTheThuVien() {
        if (danhSachTheThuVien == null) {
            danhSachTheThuVien = new DanhSachTheThuVien();
            danhSachTheThuVien.docFileBinary(DanhSachTheThuVien.FILE_PATH);
        }
        return danhSachTheThuVien;
    }

    public static DocGias getDanhSachDocGia() {
        if(danhSachDocGia == null){
            danhSachDocGia = new DocGias();
            danhSachDocGia.docFileBinary(DocGias.FILE_PATH);
        }
        return danhSachDocGia;
    }
    public static DanhSachCTMuonTra getDanhSachCTMuonTra() {
        if(danhSachCTMuonTra == null){
            danhSachCTMuonTra = new DanhSachCTMuonTra();
            danhSachCTMuonTra.docFileBinary(DanhSachCTMuonTra.FILE_PATH);
        }
        return danhSachCTMuonTra;
    }
    public static DanhSachPhieuMuon getDanhSachPhieuMuonTra(){
        if(danhSachPhieuMuonTra == null){
            danhSachPhieuMuonTra = new DanhSachPhieuMuon();
            danhSachPhieuMuonTra.docFileBinary(DanhSachPhieuMuon.FILE_PATH);
        }

        return danhSachPhieuMuonTra;
    }

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
            danhSachTheLoai_sach.docFileBinary();
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

    public static NhanViens getNhanViens() {
        if(nhanViens == null){
            nhanViens = new NhanViens();
            nhanViens.docFileBinary(NhanViens.FILE_PATH);

        }
        return nhanViens;
    }


}
