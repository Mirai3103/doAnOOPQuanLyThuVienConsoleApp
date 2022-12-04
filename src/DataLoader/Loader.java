package DataLoader;


import Model.*;

import Repository.DanhSachCTMuonTra;
import Repository.DanhSachPhieuMuon;
import Repository.TongHopDuLieu;
import helper.Helper;

import java.io.File;
import java.time.LocalDate;


public class Loader {
    public static void removeAllData(){
        File listFile = new File(Helper.dirPath);
        if (!listFile.exists()) {
            listFile.mkdir();
        }
        String[]listFileName = listFile.list();
        for(String fname: listFileName){
            File currentFile = new File(listFile.getPath(),fname);
            currentFile.delete();
        }
    }
    //chạy để tạo dữ liệu mẫu
    public static void main(String[] args) {
        removeAllData();
        initXuPhatData();
        initTheLoaiData();
        initTacGiaData();
        initNhaXuatBanData();
        initSachData();
        initNhanVien();
        initDocGiaData();
        initPhieuMuonData();
        TongHopDuLieu.getKhoSach().xuatFileBinary();
        TongHopDuLieu.getKhoTheLoai().xuatFileBinary();
        TongHopDuLieu.getDanhSachTacGia().xuatFileBinary();
        TongHopDuLieu.getDanhSachNhaXuatBan().xuatFileBinary();
        TongHopDuLieu.getNhanViens().xuatFileBinary();
        TongHopDuLieu.getDanhSachDocGia().xuatFileBinary();
        TongHopDuLieu.getDanhSachTheThuVien().xuatFileBinary();
        TongHopDuLieu.getDanhSachPhieuMuonTra().xuatFileBinary(DanhSachPhieuMuon.FILE_PATH);
        TongHopDuLieu.getDanhSachCTMuonTra().xuatFileBinary(DanhSachCTMuonTra.FILE_PATH);



    }
    public static void initXuPhatData(){
        var dsXuPhat = TongHopDuLieu.getDanhSachXuPhat();
        var s1 = new XuPhat();
        s1.setTenLoi("Làm rách sách");
        s1.setTienPhat(60000);
        dsXuPhat.add(s1);
        var s2 = new XuPhat();
        s2.setTenLoi("Làm hỏng sách");
        s2.setTienPhat(1500000);
        dsXuPhat.add(s2);
        var s3 = new XuPhat();
        s3.setTenLoi("Làm mất sách");
        s3.setTienPhat(-1);
        dsXuPhat.add(s3);
        var s4 = new XuPhat();
        s4.setTenLoi("Trả sách quá hạn");
        s4.setTienPhat(30000);
        dsXuPhat.add(s4);
        var s5 = new XuPhat();
        s5.setTenLoi("Không trả sách");
        s5.setTienPhat(2000000);
        dsXuPhat.add(s5);
        var s6 = new XuPhat();
        s6.setTenLoi("Vẽ trên sách");
        s6.setTienPhat(50000);
        dsXuPhat.xuatFileBinary();


    }
    private static void initPhieuMuonData() {
        var DanhSachPhieuMuon = TongHopDuLieu.getDanhSachPhieuMuonTra();
        var DanhSachDocGia = TongHopDuLieu.getDanhSachDocGia();
        var DanhSachSach = TongHopDuLieu.getKhoSach();
        var DanhSachNhanVien = TongHopDuLieu.getNhanViens();
        var DanhSachTheThuVien = TongHopDuLieu.getDanhSachTheThuVien();
        var DanhSachChiTietPhieuMuon = TongHopDuLieu.getDanhSachCTMuonTra();
        var phieuMuon = new MuonTra();

        phieuMuon.setIDthe(0);
        phieuMuon.setIDnv("thuthu");
        DanhSachPhieuMuon.add(phieuMuon);
        var ctPhieuMuon = new CTMuonTra();
        phieuMuon.setNgayLapPhieu(LocalDate.now().minusDays(14));
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(0);
        ctPhieuMuon.setNgayhentra(LocalDate.now().minusDays(-1));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(4);
        ctPhieuMuon.setNgayhentra(LocalDate.now().minusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(2);
        ctPhieuMuon.setNgayhentra(LocalDate.now().minusDays(2));
        ctPhieuMuon.setDatra(1);
        ctPhieuMuon.getBook().setTheTVNguoiMuonId(-1);
        ctPhieuMuon.setNgaytra(LocalDate.now().minusDays(2));
        ctPhieuMuon.setLoiPhatId(2);
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        phieuMuon = new MuonTra();
        // 1 -> 3
        phieuMuon.setIDthe(1);
        phieuMuon.setIDnv("thuthu");
        DanhSachPhieuMuon.add(phieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(1);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(3);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);

        phieuMuon = new MuonTra();
        phieuMuon.setIDthe(4);
        phieuMuon.setIDnv("TSOOP1");
        DanhSachPhieuMuon.add(phieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(29);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(28);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(25);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);

        phieuMuon = new MuonTra();
        phieuMuon.setIDthe(5);
        phieuMuon.setIDnv("TPK022");
        DanhSachPhieuMuon.add(phieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(20);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(35);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(33);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);

        phieuMuon = new MuonTra();
        phieuMuon.setIDthe(6);
        phieuMuon.setIDnv("TPK022");
        DanhSachPhieuMuon.add(phieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(40);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(41);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(42);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);

        phieuMuon = new MuonTra();
        phieuMuon.setIDthe(16);
        phieuMuon.setIDnv("BNLATT");
        DanhSachPhieuMuon.add(phieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(50);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(2));
        ctPhieuMuon.setDatra(1);
        ctPhieuMuon.setNgaytra(LocalDate.now().minusDays(2));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(51);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(2));
        ctPhieuMuon.setDatra(1);
        ctPhieuMuon.setNgaytra(LocalDate.now().minusDays(2));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(52);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(2));
        ctPhieuMuon.setDatra(1);
        ctPhieuMuon.setNgaytra(LocalDate.now().minusDays(2));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);

        phieuMuon = new MuonTra();
        phieuMuon.setIDthe(20);
        phieuMuon.setIDnv("BNLATT");
        DanhSachPhieuMuon.add(phieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(60);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(2));
        ctPhieuMuon.setDatra(1);
        ctPhieuMuon.setNgaytra(LocalDate.now().minusDays(2));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(61);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(2));
        ctPhieuMuon.setDatra(1);
        ctPhieuMuon.setNgaytra(LocalDate.now().minusDays(2));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(62);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(2));
        ctPhieuMuon.setDatra(1);
        ctPhieuMuon.setNgaytra(LocalDate.now().minusDays(2));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);

        phieuMuon = new MuonTra();
        phieuMuon.setIDthe(20);
        phieuMuon.setIDnv("TPK022");
        DanhSachPhieuMuon.add(phieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(43);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(44);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(45);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);

        phieuMuon = new MuonTra();
        phieuMuon.setIDthe(19);
        phieuMuon.setIDnv("TPK022");
        DanhSachPhieuMuon.add(phieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(46);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(47);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
        ctPhieuMuon = new CTMuonTra();
        ctPhieuMuon.setIdPhieuMuon(phieuMuon.getIDmt());
        ctPhieuMuon.setIDsach(48);
        ctPhieuMuon.setNgayhentra(LocalDate.now().plusDays(14));
        DanhSachChiTietPhieuMuon.add(ctPhieuMuon);
    }

    public static void initDocGiaData(){

        DocGia dg1 = new DocGia();
        dg1.setHoTen("Nguyễn Văn A");
        dg1.setNgaySinh("01/01/2000");
        dg1.setSDT("0123456789");
        dg1.setCMND("123456789");
        dg1.setDC(new DiaChi("16 ","Hàng Chuối","Phạm Đình Hổ","Hai Bà Trưng"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg1);
        TheThuVien theThuVien1 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien1);

        theThuVien1.setGhichu("");
        theThuVien1.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien1.setNgayhh(Helper.parseDate("01/01/2022"));
        theThuVien1.setIDuser(dg1.getIDdg());
        DocGia dg2 = new DocGia();
        dg2.setHoTen("Lê thị B");
        dg2.setNgaySinh("04/02/2002");
        dg2.setSDT("1123456789");
        dg2.setCMND("223456789");
        dg2.setDC(new DiaChi("273","An dương vương","P4","Q5"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg2);
        TheThuVien theThuVien2 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien2);

        theThuVien2.setGhichu("");
        theThuVien2.setNgaybd(Helper.parseDate("01/01/2022"));
        theThuVien2.setNgayhh(Helper.parseDate("01/01/2023"));
        theThuVien2.setIDuser(dg2.getIDdg());
        DocGia dg3 = new DocGia();
        dg3.setHoTen("Cao Văn C");
        dg3.setNgaySinh("12/12/2000");
        dg3.setSDT("2123456789");
        dg3.setCMND("323456789");
        dg3.setDC(new DiaChi("23","An dương vương","P4","Q5"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg3);
        TheThuVien theThuVien3 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien3);

        theThuVien3.setGhichu("");
        theThuVien3.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien3.setNgayhh(Helper.parseDate("01/01/2023"));
        theThuVien3.setIDuser(dg3.getIDdg());
        DocGia dg4 = new DocGia();
        dg4.setHoTen("Trương Bảo D");
        dg4.setNgaySinh("13/12/2000");
        dg4.setSDT("3123456789");
        dg4.setCMND("423456789");
        dg4.setDC(new DiaChi("29","Trần Bình trọng","P3","Q7"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg4);
        TheThuVien theThuVien4 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien4);

        theThuVien4.setGhichu("");
        theThuVien4.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien4.setNgayhh(Helper.parseDate("01/01/2022"));
        theThuVien4.setIDuser(dg4.getIDdg());
        DocGia dg5 = new DocGia();
        dg5.setHoTen("Trần thủ đức");
        dg5.setNgaySinh("13/02/1999");
        dg5.setSDT("4123456789");
        dg5.setCMND("523456789");
        dg5.setDC(new DiaChi("25","ABC ","P3","Q12"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg5);
        TheThuVien theThuVien5 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien5);

        theThuVien5.setGhichu("");
        theThuVien5.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien5.setNgayhh(Helper.parseDate("01/01/2026"));
        theThuVien5.setIDuser(dg5.getIDdg());
        DocGia dg6 = new DocGia();
        dg6.setHoTen("Trần Minh");
        dg6.setNgaySinh("13/07/2003");
        dg6.setSDT("1234567876");
        dg6.setCMND("234123123");
        dg6.setDC(new DiaChi("25","ABC ","P3","Q12"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg6);
        TheThuVien theThuVien6 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien6);

        theThuVien6.setGhichu("");
        theThuVien6.setNgaybd(Helper.parseDate("01/01/2022"));
        theThuVien6.setNgayhh(Helper.parseDate("01/01/2027"));
        theThuVien6.setIDuser(dg6.getIDdg());
        DocGia dg7 = new DocGia();
        dg7.setHoTen("Cao Thu");
        dg7.setNgaySinh("9/02/2004");
        dg7.setSDT("0987654372");
        dg7.setCMND("123421232");
        dg7.setDC(new DiaChi("67","Lạc Long Quân","P3","Q5"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg7);
        TheThuVien theThuVien7 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien7);

        theThuVien7.setGhichu("");
        theThuVien7.setNgaybd(Helper.parseDate("01/05/2022"));
        theThuVien7.setNgayhh(Helper.parseDate("01/01/2026"));
        theThuVien7.setIDuser(dg7.getIDdg());

        DocGia dg8 = new DocGia();
        dg8.setHoTen("Diệp Lâm");
        dg8.setNgaySinh("17/02/1996");
        dg8.setSDT("9875348272");
        dg8.setCMND("547392074");
        dg8.setDC(new DiaChi("89","Đinh Bộ Lĩnh","P3","Q.Bình Thạnh"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg8);
        TheThuVien theThuVien8 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien8);

        theThuVien8.setGhichu("");
        theThuVien8.setNgaybd(Helper.parseDate("05/03/2018"));
        theThuVien8.setNgayhh(Helper.parseDate("01/01/2021"));
        theThuVien8.setIDuser(dg8.getIDdg());

        DocGia dg9 = new DocGia();
        dg9.setHoTen("Trần Đức Bo");
        dg9.setNgaySinh("10/06/2006");
        dg9.setSDT("4567890987");
        dg9.setCMND("123876948");
        dg9.setDC(new DiaChi("1/2","Mạc Đĩnh Chi","P8","Q9"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg9);
        TheThuVien theThuVien9 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien9);

        theThuVien9.setGhichu("");
        theThuVien9.setNgaybd(Helper.parseDate("01/08/2016"));
        theThuVien9.setNgayhh(Helper.parseDate("01/01/2020"));
        theThuVien9.setIDuser(dg9.getIDdg());

        DocGia dg10 = new DocGia();
        dg10.setHoTen("Nguyễn Thanh Thanh");
        dg10.setNgaySinh("19/05/1990");
        dg10.setSDT("6784857697");
        dg10.setCMND("976548765");
        dg10.setDC(new DiaChi("48","Trần Cao Vân","An Phú","Thủ Đức"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg10);
        TheThuVien theThuVien10 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien10);

        theThuVien10.setGhichu("");
        theThuVien10.setNgaybd(Helper.parseDate("09/09/2010"));
        theThuVien10.setNgayhh(Helper.parseDate("01/09/2020"));
        theThuVien10.setIDuser(dg10.getIDdg());

        DocGia dg11 = new DocGia();
        dg11.setHoTen("Cao Minh Quân");
        dg11.setNgaySinh("13/02/2004");
        dg11.setSDT("4733859632");
        dg11.setCMND("138953854");
        dg11.setDC(new DiaChi("","","La Hai","Tây Hoa","Phú Yên"));
        TongHopDuLieu.getDanhSachDocGia().add(dg11);
        TheThuVien theThuVien11 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien11);

        theThuVien11.setGhichu("");
        theThuVien11.setNgaybd(Helper.parseDate("01/07/2019"));
        theThuVien11.setNgayhh(Helper.parseDate("01/01/2023"));
        theThuVien11.setIDuser(dg11.getIDdg());

        DocGia dg12 = new DocGia();
        dg12.setHoTen("Nguyễn Hồng");
        dg12.setNgaySinh("13/02/1980");
        dg12.setSDT("374930249");
        dg12.setCMND("938274832");
        dg12.setDC(new DiaChi("","","Xã Cac Hóa","Huyện Hoa Mai","Quảng Ninh"));
        TongHopDuLieu.getDanhSachDocGia().add(dg12);
        TheThuVien theThuVien12 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien12);

        theThuVien12.setGhichu("");
        theThuVien12.setNgaybd(Helper.parseDate("01/06/2015"));
        theThuVien12.setNgayhh(Helper.parseDate("01/01/2026"));
        theThuVien12.setIDuser(dg5.getIDdg());

        DocGia dg13 = new DocGia();
        dg13.setHoTen("Hứa Kiệt");
        dg13.setNgaySinh("26/06/2001");
        dg13.setSDT("4637284953");
        dg13.setCMND("129485734");
        dg13.setDC(new DiaChi("","","Xã Minh Hà","Huyện Minh Hải","Sơn La"));
        TongHopDuLieu.getDanhSachDocGia().add(dg13);
        TheThuVien theThuVien13 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien13);

        theThuVien13.setGhichu("");
        theThuVien13.setNgaybd(Helper.parseDate("01/01/2022"));
        theThuVien13.setNgayhh(Helper.parseDate("01/01/2028"));
        theThuVien13.setIDuser(dg13.getIDdg());

        DocGia dg14 = new DocGia();
        dg14.setHoTen("Hoàng minh");
        dg14.setNgaySinh("09/05/1995");
        dg14.setSDT("7382944535");
        dg14.setCMND("8769875434");
        dg14.setDC(new DiaChi("55","Hoàng Hoa Thám","P3","Q1"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg14);
        TheThuVien theThuVien14 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien14);

        theThuVien14.setGhichu("");
        theThuVien14.setNgaybd(Helper.parseDate("01/02/2020"));
        theThuVien14.setNgayhh(Helper.parseDate("01/01/2029"));
        theThuVien14.setIDuser(dg14.getIDdg());

        DocGia dg15 = new DocGia();
        dg15.setHoTen("Minh Kiệt");
        dg15.setNgaySinh("01/10/2001");
        dg15.setSDT("8954837285");
        dg15.setCMND("985357375");
        dg15.setDC(new DiaChi("87","Quốc Lộ A1","An Bình","Dĩ An","Bình Dương"));
        TongHopDuLieu.getDanhSachDocGia().add(dg15);
        TheThuVien theThuVien15 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien15);

        theThuVien15.setGhichu("");
        theThuVien15.setNgaybd(Helper.parseDate("09/12/2020"));
        theThuVien15.setNgayhh(Helper.parseDate("01/01/2024"));
        theThuVien15.setIDuser(dg15.getIDdg());

        DocGia dg16 = new DocGia();
        dg16.setHoTen("Phạm Len");
        dg16.setNgaySinh("13/06/2000");
        dg16.setSDT("8439405849");
        dg16.setCMND("098753253");
        dg16.setDC(new DiaChi("","","Xã Spa","Spa"," Sơn La"));
        TongHopDuLieu.getDanhSachDocGia().add(dg16);
        TheThuVien theThuVien16 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien16);
        theThuVien16.setGhichu("");
        theThuVien16.setNgaybd(Helper.parseDate("01/01/2015"));
        theThuVien16.setNgayhh(Helper.parseDate("01/01/2026"));
        theThuVien16.setIDuser(dg16.getIDdg());

        DocGia dg17 = new DocGia();
        dg17.setHoTen("Huynh Tấn Tài");
        dg17.setNgaySinh("03/06/2003");
        dg17.setSDT("85930458395");
        dg17.setCMND("984358439");
        dg17.setDC(new DiaChi("6","Hoàng Diệu","P2","Thủ Đức","TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg17);

        TheThuVien theThuVien17 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien17);

        theThuVien17.setGhichu("");
        theThuVien17.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien17.setNgayhh(Helper.parseDate("01/01/2025"));
        theThuVien17.setIDuser(dg17.getIDdg());

        DocGia dg18 = new DocGia();
        dg18.setHoTen("Huỳnh Liên");
        dg18.setNgaySinh("09/05/2004");
        dg18.setSDT("8574382953");
        dg18.setCMND("453634564");
        dg18.setDC(new DiaChi("43","Trần Cao Vân","P3","Q1"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg18);
        TheThuVien theThuVien18 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien18);

        theThuVien18.setGhichu("");
        theThuVien18.setNgaybd(Helper.parseDate("01/01/2020"));
        theThuVien18.setNgayhh(Helper.parseDate("01/01/2029"));
        theThuVien18.setIDuser(dg18.getIDdg());

        DocGia dg19 = new DocGia();
        dg19.setHoTen("Đào Tiến");
        dg19.setNgaySinh("13/07/2003");
        dg19.setSDT("4839548295");
        dg19.setCMND("928439583");
        dg19.setDC(new DiaChi("8","Nguyễn Thị Minh Khai","P3","Q1"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg19);
        TheThuVien theThuVien19 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien19);

        theThuVien19.setGhichu("");
        theThuVien19.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien19.setNgayhh(Helper.parseDate("01/01/2026"));
        theThuVien19.setIDuser(dg19.getIDdg());

        DocGia dg20 = new DocGia();
        dg20.setHoTen("Trúc Linh");
        dg20.setNgaySinh("13/02/2003");
        dg20.setSDT("3948395837");
        dg20.setCMND("948392054");
        dg20.setDC(new DiaChi("7","Đinh Bộ Lĩnh","P3","Q.Bình Thạnh"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg20);
        TheThuVien theThuVien20 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien20);

        theThuVien20.setGhichu("");
        theThuVien20.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien20.setNgayhh(Helper.parseDate("01/09/2026"));
        theThuVien20.setIDuser(dg20.getIDdg());

        DocGia dg21 = new DocGia();
        dg21.setHoTen("Như Quỳnh");
        dg21.setNgaySinh("13/08/2003");
        dg21.setSDT("8673495386");
        dg21.setCMND("948375934");
        dg21.setDC(new DiaChi("","","Phú Thứ","Tây Hòa"," Phú Yên"));
        TongHopDuLieu.getDanhSachDocGia().add(dg21);
        TheThuVien theThuVien21 = new TheThuVien();
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien21);
        theThuVien21.setGhichu("");
        theThuVien21.setNgaybd(Helper.parseDate("01/12/2021"));
        theThuVien21.setNgayhh(Helper.parseDate("01/09/2027"));
        theThuVien21.setIDuser(dg21.getIDdg());


    }
    public static void initNhanVien(){
        NhanVien quanLi = new QuanLi("admin");
        quanLi.setHoTen("Admin");
        quanLi.setMK("admin");
        TongHopDuLieu.getNhanViens().add(quanLi);

        quanLi = new QuanLi("560032");
        quanLi.setHoTen("Ngô Hữu Hoàng");
        quanLi.setMK("123456");
        quanLi.setCMND("3121560032");
        quanLi.setDC(new DiaChi("30/320","Trần Bình Trọng","P4","Q5","TP HCM"));
        quanLi.setLuong(100000000);
        quanLi.setNgaySinh("13/09/2003");
        quanLi.setSDT("0934567210");

        ((QuanLi) quanLi).setNgayNhanChuc("13/09/2019");
        ((QuanLi) quanLi).setMaBaoMat("avdsfdasf");
        ((QuanLi) quanLi).setNamKinhNghiem(2);
        ((QuanLi) quanLi).setDacQuyen("Được nghĩ 30 lần mỗi tháng");


        TongHopDuLieu.getNhanViens().add(quanLi);

        quanLi = new QuanLi("560035");
        quanLi.setHoTen("Cao bảo quỳnh");
        quanLi.setMK("123456");
        quanLi.setCMND("32595602131");
        quanLi.setSDT("0934567890");
        quanLi.setDC(new DiaChi("273","An dương vương","P4","Q5","TP HCM"));
        quanLi.setLuong(1000000);
        quanLi.setNgaySinh("16/02/2003");
        ((QuanLi) quanLi).setNgayNhanChuc("13/10/2022");
        ((QuanLi) quanLi).setMaBaoMat("avdsfdasf");
        ((QuanLi) quanLi).setNamKinhNghiem(1);
        ((QuanLi) quanLi).setDacQuyen("Được không làm mà vẫn nhận lương");
        TongHopDuLieu.getNhanViens().add(quanLi);

        NhanVien thuThu = new ThuThu();
        thuThu.setMK("thuthu");
        thuThu.setHoTen("Thủ thư");
        thuThu.setMaNV("thuthu");
        TongHopDuLieu.getNhanViens().add(thuThu);

        thuThu = new ThuThu();
        thuThu.setMK("123456");
        thuThu.setHoTen("Hữu Kiên");
        thuThu.setMaNV("TTK021");
        thuThu.setCMND("30005602131");
        thuThu.setSDT("0930007890");
        thuThu.setDC(new DiaChi("273","An dương vương","P4","Q5","TP HCM"));
        thuThu.setLuong(10000);
        thuThu.setNgaySinh("16/09/2003");
        ((ThuThu) thuThu).setNgayNhanChuc("23/10/2021");
        ((ThuThu) thuThu).setNoiLamViec("Khu A");
        ((ThuThu) thuThu).setNamKinhNghiem(1);
        ((ThuThu) thuThu).setNgayLamViec("29/10/2021");
        ((ThuThu) thuThu).setTruong(false);
        TongHopDuLieu.getNhanViens().add(thuThu);

        thuThu = new ThuThu();
        thuThu.setMK("123456");
        thuThu.setHoTen("Thanh Phong");
        thuThu.setMaNV("TPK022");
        thuThu.setCMND("49005602131");
        thuThu.setSDT("0330297890");
        thuThu.setDC(new DiaChi("273","An dương vương","P4","Q5","TP HCM"));
        thuThu.setLuong(100000);
        thuThu.setNgaySinh("22/09/2003");
        ((ThuThu) thuThu).setNgayNhanChuc("25/9/2020");
        ((ThuThu) thuThu).setNoiLamViec("Khu B");
        ((ThuThu) thuThu).setNamKinhNghiem(1);
        ((ThuThu) thuThu).setNgayLamViec("29/9/2020");
        ((ThuThu) thuThu).setTruong(true);
        TongHopDuLieu.getNhanViens().add(thuThu);


        thuThu = new ThuThu();
        thuThu.setMK("123456");
        thuThu.setHoTen("Thanh Sang");
        thuThu.setMaNV("TSOOP1");
        thuThu.setCMND("3232469971");
        thuThu.setSDT("0345297890");
        thuThu.setDC(new DiaChi("273","An dương vương","P4","Q5","TP HCM"));
        thuThu.setLuong(1000);
        thuThu.setNgaySinh("22/09/1997");
        ((ThuThu) thuThu).setNgayNhanChuc("25/9/2020");
        ((ThuThu) thuThu).setNoiLamViec("Khu D");
        ((ThuThu) thuThu).setNamKinhNghiem(0);
        ((ThuThu) thuThu).setNgayLamViec("29/9/2020");
        ((ThuThu) thuThu).setTruong(false);
        TongHopDuLieu.getNhanViens().add(thuThu);

        thuThu = new ThuThu();
        thuThu.setMK("123456");
        thuThu.setHoTen("Nguyễn Thị Bích Ngọc");
        thuThu.setMaNV("BNLATT");
        thuThu.setCMND("3287469971");
        thuThu.setSDT("0345297821");
        thuThu.setDC(new DiaChi("273","An dương vương","P4","Q5","TP HCM"));
        thuThu.setLuong(100000);
        thuThu.setNgaySinh("22/09/2003");
        ((ThuThu) thuThu).setNgayNhanChuc("21/5/2020");
        ((ThuThu) thuThu).setNoiLamViec("Khu A");
        ((ThuThu) thuThu).setNamKinhNghiem(1);
        ((ThuThu) thuThu).setNgayLamViec("29/5/2020");
        ((ThuThu) thuThu).setTruong(false);
        TongHopDuLieu.getNhanViens().add(thuThu);
    }
    public static void initTheLoaiData(){
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Truyện tranh","truyen tranh"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Truyện ngắn","truyen ngan"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Truyện dài","truyen dai"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Romance","lãng mạn"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("School life","học đường"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Trẻ em","cho bé nhỏ hơn 10 tuổi"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Giáo dục","giáo dục"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Toán","toán học"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Thiếu niên","15-20 tuổi"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Văn học","văn học"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Tiểu thuyết","tiểu thuyết"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Giả tưởng","giả tưởng"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Người lớn","trên 18 tuổi"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Văn học nước ngoài","văn học nước ngoài"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Lịch sử","lịch sử"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Giáo trình","giao trình"));

        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Chính trị","chính trị"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Kinh tế","tiền bạc"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Khoa học","Khoa học"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Công nghệ","Công nghệ"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Tâm Lý","Tâm Lý"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Tôn Giáo","Tôn giáo"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Thiếu nhi","nhỏ hơn 12 tuổi"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Chưa dịch","Chưa dịch thành tiếng việt"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Truyện dân gian","TRuyện dân gian"));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Hướng dẫn","Hướng dẫn nấu ăn..."));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Helpself"," Phát triển bản thân."));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Ngược","Lấy đi nhiều nước mắt."));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Võng du","thể loại game."));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Huyền huyễn","Lấy đi nhiều nước mắt."));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Kiếm hiệp","biệt danh \"Phim chưởng \"."));
        TongHopDuLieu.getKhoTheLoai().add(new TheLoai("Tiên Hiệp","Tu tiên."));
    }




    public static void initTacGiaData(){
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Koume Fujichika","abc.com","Tac gia manga"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Lê Anh Vinh","abc.com","Tác giả Việt Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Fujiko F Fujio","abc.com","Tac gia manga"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Hajime Kamoshida","abc.com","Tac gia tieu thuyet"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("J.K.Rowling","abc.com","Tac gia noi tieng"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Vũ Tình","abc.com","Tác giả Việt Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Vũ Đức Lợi","abc.com","Tác giả Việt Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Trần Đức Thanh","abc.com","Tác giả Việt Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("PGS.TS. Nguyễn Thị Trường Giang","abc.com","Tác giả Việt Nam"));

        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Paulo Coelho","abc.com","Tác giả nước ngoài"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Dale Carnegie","abc.com","Tác giả nổi tiếng"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Napoleon Hill","abc.com","Tác giả nổi tiếng"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("David J.Lieberman","abc.com","Tác giả nổi tiếng"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Mario Puzo","abc.com","Tác giả nước ngoài"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Nick Vujicic","abc.com","Tác giả nước ngoài"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia(" Mario Puzo","abc.com","Tác giả nổi tiếng"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Andrew Matthews","abc.com","Tác giả nổi tiếng"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("George Samuel Clason","abc.com","Tác giả nước ngoài"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Nguyễn Nhật Ánh","abc.com","Tác giả Việt Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Adam Khoo","abc.com","Triệu phú trẻ nhất Singapo"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Xuân Diệu","","Nhà thơ"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia(" Xuân Quỳnh","","Nhà Thơ"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Nguyễn TRãi","","Nhà Thơ"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Trần Quốc Tuấn","","Danh tướng Việt Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Nhĩ Căn","","Đại Thần bạch kim Qidian"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Thiên Tàm Thổ Đậu","","Đại Thần bạch kim Qidian"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Đường Gia Tam Thiếu","","Đại Thần bạch kim Qidian"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Tiêu Chiến","","Tác Phẩm tiêu biểu Tru tiên"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Trạch Trư","","Tác giả mạng nổi tiếng"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Phỉ Ngã Tư Tồn","","Đa thần thể loại ngược"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Hồ Điệp Lam","","Đa thần qudian"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Cổ Long","","Chủ yếu tiêu thuyết kiếm hiệp"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Kim Dung","","Thể loại kiếm hiệp"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Trần Thùy Linh","","Giảng viên đại học"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Vong Ngữ","","Tiêu thuyết gia nổi tiếng"));
    }
    public static void initNhaXuatBanData(){

        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB Kim Đồng",new DiaChi("248","Cống Quỳnh","Phạm Ngũ Lão","Q.1","TP.HCM"),"info@nxbkimdong.com.vn","Bùi Tuấn Nghĩa"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB trẻ", new DiaChi("161B","Lý Chính Thắng","Võ Thị Sáu","Q.3","TP.HCM"),"hopthubandoc@nxbtre.com.vn","Nguyễn Thị Thanh Thủy"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB Giáo dục", new DiaChi("1","Nguyễn Thị Minh Khai","Nguyễn Thị Minh Khai","Q.3","TP.HCM"),"nxbgd@moet.edu.vn","Nguyễn Văn A"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB ĐHQG Hà Nội", new DiaChi("16 ","Hàng Chuối","Phạm Đình Hổ","Hai Bà Trưng"," Hà Nội"),"nxb@vnu.edu.vn","Nguyễn Văn B"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB Chính trị quốc gia Sự thật.", new DiaChi("6/86","","Duy tân","Cầu Giấy","Hà Nội" ),"phathanh@nxbctqg.vn","Nguyễn Văn C"));

        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("Nhà xuất bản Tổng hợp thành phố Hồ Chí Minh.", new DiaChi("62","Nguyễn Thị Minh Khai","Phường Đa Kao"," Quận 1","TP HCM" ),"nstonhop@gmail.com ","Phạm Huy"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("Nhà xuất bản Hội Nhà văn", new DiaChi("65","Nguyễn Du",""," Hai Bà Trưng","Hà Nội" )," nhaxuatbanhnv@gmail.com","Nguyễn Phong"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("Nhà xuất bản Phụ Nữ", new DiaChi("64","Trần Cao Vân","Phường Đa Kao"," Quận 1","TP HCM" ),"nxppn@gmail.com ","Phạm Thị Liên"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan(" Nhà xuất bản Lao Động", new DiaChi("175","Giảng Võ",""," Đống Đa","Hà Nội" ),"nxblaodong@yahoo.com  ","Nguyễn Tuyết"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("Nhà xuất bản Cổ Phong", new DiaChi("67","Nguyễn Thị Minh Khai","Phường Đa Kao"," Quận 1","TP HCM" ),"nstonhop@gmail.com ","Phạm Huy"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("Nhà xuất bản qidian", new DiaChi("","","","","TP HCM" ),"nstqidian@gmail.com ","Cao Quỳnh"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("Nhà xuất bản yy", new DiaChi("","","","","TP HCM" ),"nsyy@gmail.com ","Diệp Tuấn"));

    }
    public static void initSachData(){
        Sach sach = new Sach("Giáo Trình Thực Hành: Thực Vật – Dược Liệu – Dược Học Cổ Truyền ",130,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vũ Đức Lợi"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB ĐHQG Hà Nội"), (short) 2021,"Mới cứng","sách cho giáo sư");
        sach.setGiaSach(100000);
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giáo dục"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giáo trình"));

        sach = new Sach("Nhập Môn Du Lịch",130,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Trần Đức Thanh"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB ĐHQG Hà Nội"), (short) 2021,"Mới cứng","sách cho sinh viên ngành du lịch");
        sach.setGiaSach(100000);
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giáo dục"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giáo trình"));
        sach = new Sach("Nhập Môn Du Lịch",130,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("PGS.TS. Nguyễn Thị Trường Giang"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB ĐHQG Hà Nội"), (short) 2021,"Mới cứng","sách cho sinh viên ngành du lịch");
        sach.setGiaSach(120000);
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giáo dục"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Lịch sử"));

        sach = new Sach("CÔ BẠN TÔI THẦM THÍCH LẠI QUÊN MANG KÍNH RỒI - TẬP 7",130,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Koume Fujichika"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2021,"Mới cứng","Cô bạn bàn bên lại quên kính rồi tap 7");
        sach.setGiaSach(50000);
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện dài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Romance"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("School life"));

        sach = new Sach("CÔ BẠN TÔI THẦM THÍCH LẠI QUÊN MANG KÍNH RỒI - TẬP 1",146,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Koume Fujichika"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2021,"Mới cứng","Cô bạn bàn bên lại quên kính rồi Tap 1");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện dài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Romance"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("School life"));
        sach.setGiaSach(52000);
        sach = new Sach("NHỮNG ĐỨA TRẺ HẠNH PHÚC - LÀ CHÍNH MÌNH",20,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Lê Anh Vinh"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2022,"Mới cứng","Tập BẠN NHỎ DÂN TỘC KINH");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Trẻ em"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giáo dục"));
        sach.setGiaSach(20000);
        sach = new Sach("HỌC TOÁN CÙNG JENNY",32,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Lê Anh Vinh"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2021,"rách bìa trước  ","SÁCH DÀNH CHO HỌC SINH CHUẨN BỊ VÀO LỚP 1");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Trẻ em"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giáo dục"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Toán"));
        sach.setGiaSach(24000);
        sach = new Sach("DORAEMON - NOBITA VÀ NGƯỜI KHỔNG LỒ XANH",194,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Fujiko F Fujio"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2016,"bị mất bìa ","NOBITA VÀ NGƯỜI KHỔNG LỒ XANH");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện dài"));
        sach.setGiaSach(82000);
        sach = new Sach("DORAEMON TRUYỆN NGẮN - TẬP 19",192,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Fujiko F Fujio"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2021,"còn mới","Những câu chuyện về chú mèo máy thông minh Doraemon");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện ngắn"));
        sach.setGiaSach(120000);
        sach = new Sach("HỘI CHỨNG TUỔI THANH XUÂN - TẬP 8",352,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Hajime Kamoshida"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2022,"còn mới","Đây chính là nguyên tác của bộ anime đình đám thống lĩnh mọi bảng xếp hạng anime năm 2018");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Người lớn"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("School life"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Romance"));
        sach.setGiaSach(24000);
        sach = new Sach("HARRY POTTER VÀ HÒN ĐÁ PHÙ THUỶ",366,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);

        sach = new Sach("HARRY POTTER VÀ Phòng chứa bí mật",350,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và tên tù nhân ngục Azkaban",366,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Chiếc cốc lửa",364,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Hội Phượng hoàng",396,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Hoàng tử lai",450,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Bảo bối Tử thần",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);

        sach = new Sach("HỒ CHÍ MINH BÀN VỀ ĐẢNG",96,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vũ tình"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2018,"còn mới","gồm trích đoạn rất ngắn những phát biểu của Bác");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.setGiaSach(250000);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Lịch sử"));

        sach = new Sach("Triết học mac-le nin",450,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Trần Thùy Linh"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Chính trị quốc gia Sự thật."), (short) 2018,"còn mới","Triết học của Mac, Le Nin");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.setGiaSach(100000);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Chính Trị"));


        sach = new Sach("HARRY POTTER VÀ HÒN ĐÁ PHÙ THUỶ",366,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);

        sach = new Sach("HARRY POTTER VÀ Phòng chứa bí mật",350,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và tên tù nhân ngục Azkaban",366,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Chiếc cốc lửa",364,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Hội Phượng hoàng",396,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Hoàng tử lai",450,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Bảo bối Tử thần",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);

        sach = new Sach("HARRY POTTER VÀ HÒN ĐÁ PHÙ THUỶ",366,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);

        sach = new Sach("HARRY POTTER VÀ Phòng chứa bí mật",350,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và tên tù nhân ngục Azkaban",366,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Chiếc cốc lửa",364,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Hội Phượng hoàng",396,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Hoàng tử lai",450,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Bảo bối Tử thần",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);

        sach = new Sach("HARRY POTTER VÀ HÒN ĐÁ PHÙ THUỶ",366,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);

        sach = new Sach("HARRY POTTER VÀ Phòng chứa bí mật",350,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và tên tù nhân ngục Azkaban",366,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Chiếc cốc lửa",364,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"Đã cũ"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Hội Phượng hoàng",396,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"Mất Trang"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Hoàng tử lai",450,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"Mất Trang 200"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);
        sach = new Sach("Harry Potter và Bảo bối Tử thần",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"Mất bìa"," Harry Potter");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.setGiaSach(65000);

        sach = new Sach("Phàm nhân tu tiên tập 1",200,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vong Ngữ"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Phàm nhân tu tiên tập 1",200,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vong Ngữ"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Phàm nhân tu tiên tập 1",200,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vong Ngữ"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);
        sach = new Sach("Phàm nhân tu tiên tập 2",200,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vong Ngữ"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);
        sach = new Sach("Phàm nhân tu tiên tập 2",200,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vong Ngữ"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);
        sach = new Sach("Phàm nhân tu tiên tập 3",200,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vong Ngữ"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);sach = new Sach("Phàm nhân tu tiên tập 4",200,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vong Ngữ"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Đế Tôn",2000,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Trạch Trư"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2019,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Đấu Phá Thương Khung",1600,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Thiên Tàm Thổ Đậu"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2010,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Cầu Ma",2000,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Nhĩ Căn"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2015,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Tiên Nghích",1900,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Nhĩ Căn"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2018,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);
        sach = new Sach("Toàn chức cao thủ",200,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Hồ Điệp Lam"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2020,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Võng Du"));
        sach.setGiaSach(650000);
        sach = new Sach("Phàm nhân tu tiên tập 5",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vong Ngữ"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Đế Tôn",2000,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Trạch Trư"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2019,"Còn dùng được","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Đấu Phá Thương Khung",1600,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Thiên Tàm Thổ Đậu"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2010,"hư hỏng","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Cầu Ma",2000,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Nhĩ Căn"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2015,"Mất trang","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Tiên Nghích",1900,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Nhĩ Căn"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2018,"Mất bìa","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);
        sach = new Sach("Toàn chức cao thủ",200,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Hồ Điệp Lam"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản qidian"), (short) 2020,"Mất trang","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Võng Du"));
        sach.setGiaSach(650000);
        sach = new Sach("Phàm nhân tu tiên tập 5",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vong Ngữ"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"Mất trang","Tiểu thuyết mạng");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Huyền Huyễn"));
        sach.setGiaSach(650000);

        sach = new Sach("Nhà Giả Kim",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Paulo Coelho"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2018,"Mới","Tiểu thuyết");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(150000);
        sach = new Sach("Nhà Giả Kim",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Paulo Coelho"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2018,"Mới","Tiểu thuyết");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(150000);
        sach = new Sach("Nhà Giả Kim",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Paulo Coelho"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2018,"Mới","Tiểu thuyết");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(150000);
        sach = new Sach("Nhà Giả Kim",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Paulo Coelho"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2018,"mất bìa","Tiểu thuyết");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(150000);
        sach = new Sach("Nhà Giả Kim",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Paulo Coelho"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2018,"mất trang","Tiểu thuyết");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(150000);

        sach = new Sach("Đắc Nhân Tâm",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Dale Carnegie"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2020,"mất trang","Helpself");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(175000);
        sach = new Sach("Đắc Nhân Tâm",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Dale Carnegie"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2020,"mới","Helpself");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(175000);
        sach = new Sach("Đắc Nhân Tâm",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Dale Carnegie"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2020,"mới","Helpself");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(175000);
        sach = new Sach("Đắc Nhân Tâm",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Dale Carnegie"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2020,"mất bìa","Helpself");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(175000);
        sach = new Sach("Đắc Nhân Tâm",400,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Dale Carnegie"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2020,"mới","Helpself");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(175000);

        sach = new Sach("Cách nghĩ để thành công",360,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Napoleon Hill"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2020,"mới","Helpself");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(175000);
        sach = new Sach("Cách nghĩ để thành công",360,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Napoleon Hill"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2020,"mất trang","Helpself");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(175000);
        sach = new Sach("Cách nghĩ để thành công",360,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Napoleon Hill"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2020,"mất bìa","Helpself");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(175000);
        sach = new Sach("Cách nghĩ để thành công",360,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Napoleon Hill"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("Nhà xuất bản Hội Nhà văn"), (short) 2020,"mới","Helpself");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Helpself"));
        sach.setGiaSach(175000);



    }

}
