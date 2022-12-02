package DataLoader;


import Model.*;

import Repository.DanhSachCTMuonTra;
import Repository.DanhSachPhieuMuon;
import Repository.TongHopDuLieu;
import helper.Helper;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
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
        s1.setTienPhat(15000);
        dsXuPhat.add(s1);
        var s2 = new XuPhat();
        s2.setTenLoi("Làm hỏng sách");
        s2.setTienPhat(25000);
        dsXuPhat.add(s2);
        var s3 = new XuPhat();
        s3.setTenLoi("Làm mất sách");
        s3.setTienPhat(-1);
        dsXuPhat.add(s3);
        var s4 = new XuPhat();
        s4.setTenLoi("Trả sách quá hạn");
        s4.setTienPhat(10000);
        dsXuPhat.add(s4);
        var s5 = new XuPhat();
        s5.setTenLoi("Không trả sách");
        s5.setTienPhat(20000);
        dsXuPhat.add(s5);
        var s6 = new XuPhat();
        s6.setTenLoi("Vẽ trên sách");
        s6.setTienPhat(5000);
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
        theThuVien1.setGhichu("");
        theThuVien1.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien1.setNgayhh(Helper.parseDate("01/01/2022"));
        theThuVien1.setIDuser(dg1.getIDdg());
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien1);
        DocGia dg2 = new DocGia();
        dg2.setHoTen("Lê thị B");
        dg2.setNgaySinh("04/02/2002");
        dg2.setSDT("1123456789");
        dg2.setCMND("223456789");
        dg2.setDC(new DiaChi("273","An dương vương","P4","Q5"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg2);
        TheThuVien theThuVien2 = new TheThuVien();
        theThuVien2.setGhichu("");
        theThuVien2.setNgaybd(Helper.parseDate("01/01/2022"));
        theThuVien2.setNgayhh(Helper.parseDate("01/01/2023"));
        theThuVien2.setIDuser(dg2.getIDdg());
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien2);
        DocGia dg3 = new DocGia();
        dg3.setHoTen("Cao Văn C");
        dg3.setNgaySinh("12/12/2000");
        dg3.setSDT("2123456789");
        dg3.setCMND("323456789");
        dg3.setDC(new DiaChi("23","An dương vương","P4","Q5"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg3);
        TheThuVien theThuVien3 = new TheThuVien();
        theThuVien3.setGhichu("");
        theThuVien3.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien3.setNgayhh(Helper.parseDate("01/01/2023"));
        theThuVien3.setIDuser(dg3.getIDdg());
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien3);
        DocGia dg4 = new DocGia();
        dg4.setHoTen("Trương Bảo D");
        dg4.setNgaySinh("13/12/2000");
        dg4.setSDT("3123456789");
        dg4.setCMND("423456789");
        dg4.setDC(new DiaChi("29","Trần Bình trọng","P3","Q7"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg4);
        TheThuVien theThuVien4 = new TheThuVien();
        theThuVien4.setGhichu("");
        theThuVien4.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien4.setNgayhh(Helper.parseDate("01/01/2022"));
        theThuVien4.setIDuser(dg4.getIDdg());
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien4);
        DocGia dg5 = new DocGia();
        dg5.setHoTen("Trần thủ đức");
        dg5.setNgaySinh("13/02/1999");
        dg5.setSDT("4123456789");
        dg5.setCMND("523456789");
        dg5.setDC(new DiaChi("25","ABC ","P3","Q12"," TP HCM"));
        TongHopDuLieu.getDanhSachDocGia().add(dg5);
        TheThuVien theThuVien5 = new TheThuVien();
        theThuVien5.setGhichu("");
        theThuVien5.setNgaybd(Helper.parseDate("01/01/2021"));
        theThuVien5.setNgayhh(Helper.parseDate("01/01/2026"));
        theThuVien5.setIDuser(dg5.getIDdg());
        TongHopDuLieu.getDanhSachTheThuVien().add(theThuVien5);


    }
    public static void initNhanVien(){
        NhanVien quanLi = new QuanLi("admin");
        quanLi.setHoTen("Admin");
        quanLi.setMK("admin");
        TongHopDuLieu.getNhanViens().add(quanLi);
        NhanVien thuThu = new ThuThu();
        thuThu.setMK("thuthu");
        thuThu.setHoTen("Thủ thư");
        thuThu.setMaNV("thuthu");
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


    }




    public static void initTacGiaData(){
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Koume Fujichika","abc.com","Tac gia manga"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Lê Anh Vinh","abc.com","Tac gia Viet Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Fujiko F Fujio","abc.com","Tac gia manga"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Hajime Kamoshida","abc.com","Tac gia tieu thuyet"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("J.K.Rowling","abc.com","Tac gia noi tieng"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Vũ Tình","abc.com","Tac gia Viet Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Vũ Đức Lợi","abc.com","Tac gia Viet Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Trần Đức Thanh","abc.com","Tac gia Viet Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("PGS.TS. Nguyễn Thị Trường Giang","abc.com","Tac gia Viet Nam"));

    }
    public static void initNhaXuatBanData(){

        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB Kim Đồng",new DiaChi("248","Cống Quỳnh","Phạm Ngũ Lão","Q.1","TP.HCM"),"info@nxbkimdong.com.vn","Bùi Tuấn Nghĩa"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB trẻ", new DiaChi("161B","Lý Chính Thắng","Võ Thị Sáu","Q.3","TP.HCM"),"hopthubandoc@nxbtre.com.vn","Nguyễn Thị Thanh Thủy"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB Giáo dục", new DiaChi("1","Nguyễn Thị Minh Khai","Nguyễn Thị Minh Khai","Q.3","TP.HCM"),"nxbgd@moet.edu.vn","Nguyễn Văn A"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB ĐHQG Hà Nội", new DiaChi("16 ","Hàng Chuối","Phạm Đình Hổ","Hai Bà Trưng"," Hà Nội"),"nxb@vnu.edu.vn","Nguyễn Văn B"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB Chính trị quốc gia Sự thật.", new DiaChi("6/86","","Duy tân","Cầu Giấy","Hà Nội" ),"phathanh@nxbctqg.vn","Nguyễn Văn C"));

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
        sach = new Sach("HỒ CHÍ MINH BÀN VỀ ĐẢNG",96,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vũ tình"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2018,"còn mới","gồm trích đoạn rất ngắn những phát biểu của Bác");
        TongHopDuLieu.getKhoSach().add(sach);
        sach.setGiaSach(250000);
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Lịch sử"));
    }

}
