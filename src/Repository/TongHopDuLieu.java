package Repository;


import Model.*;
import helper.Helper;
import helper.Xuat.Table;

import java.io.*;
import java.util.ArrayList;

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
        if (nhanViens.getAll().size()==0){
            NhanVien quanLi = new QuanLi("admin");
            quanLi.setHoTen("Admin");
            quanLi.setMK("admin");
            nhanViens.add(quanLi);
        }
        return nhanViens;
    }
    public static void fastXuatFile(){
        if(khoSach != null){
            khoSach.xuatFileBinary();
        }
        if(khoTheLoai != null){
            khoTheLoai.xuatFileBinary();
        }
        if(danhSachTheLoai_sach != null){
            danhSachTheLoai_sach.xuatFileBinary();
        }
        if(danhSachTacGia != null){
            danhSachTacGia.xuatFileBinary();
        }
        if(danhSachNhaXuatBan != null){
            danhSachNhaXuatBan.xuatFileBinary();
        }
        if(nhanViens != null){
            nhanViens.xuatFileBinary();
        }
        if(danhSachPhieuMuonTra != null){
            danhSachPhieuMuonTra.xuatFileBinary(DanhSachPhieuMuon.FILE_PATH);
        }
        if(danhSachCTMuonTra != null){
            danhSachCTMuonTra.xuatFileBinary(DanhSachCTMuonTra.FILE_PATH);
        }
        if(danhSachDocGia != null){
            danhSachDocGia.xuatFileBinary();
        }
        if(danhSachTheThuVien != null){
            danhSachTheThuVien.xuatFileBinary();
        }
        if(danhSachXuPhat != null){
            danhSachXuPhat.xuatFileBinary();
        }
    }
    public static void fastXuatCsv(){
        Table.xuatFileExcel(getKhoSach().getAll(), KhoSach.FILE_PATH);
        Table.xuatFileExcel(getKhoTheLoai().getAll(), KhoTheLoai.FILE_PATH);
        Table.xuatFileExcel(new ArrayList<TheLoai_Sach>(getDanhSachTheLoai_sach().getTheLoai_saches()), DanhSachTheLoai_Sach.FILE_PATH);
        Table.xuatFileExcel(getDanhSachTacGia().getAll(), DanhSachTacGia.FILE_PATH);
        Table.xuatFileExcel(getDanhSachNhaXuatBan().getAll(), DanhSachNhaXuatBan.FILE_PATH);
        Table.xuatFileExcel(getNhanViens().getAll(), NhanViens.FILE_PATH);
        Table.xuatFileExcel(getDanhSachPhieuMuonTra().getAll(), DanhSachPhieuMuon.FILE_PATH);
        Table.xuatFileExcel(getDanhSachCTMuonTra().getAll(), DanhSachCTMuonTra.FILE_PATH);
        Table.xuatFileExcel(getDanhSachDocGia().getAll(), DocGias.FILE_PATH);
        Table.xuatFileExcel(getDanhSachTheThuVien().data, DanhSachTheThuVien.FILE_PATH);
        Table.xuatFileExcel(getDanhSachXuPhat().data, DanhSachXuPhat.FILE_PATH);


    }


}
