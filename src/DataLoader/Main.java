package DataLoader;


import Model.*;

import Repository.TongHopDuLieu;
import helper.Helper;

import java.io.File;

public class Main {
    public static void removeAllData(){
        File index = new File(Helper.dirPath);
        String[]entries = index.list();
        for(String s: entries){
            File currentFile = new File(index.getPath(),s);
            currentFile.delete();
        }
    }
//chạy để tạo dữ liệu mẫu
    public static void main(String[] args) {
        removeAllData();
        initTheLoaiData();
        initTacGiaData();
        initNhaXuatBanData();
        initSachData();
        TongHopDuLieu.getKhoSach().xuatFileBinary();
        TongHopDuLieu.getKhoTheLoai().xuatFileBinary();
        TongHopDuLieu.getDanhSachTacGia().xuatFileBinary();
        TongHopDuLieu.getDanhSachNhaXuatBan().xuatFileBinary();

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


    }
    public static void initTacGiaData(){
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Koume Fujichika","abc.com","Tac gia manga"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Lê Anh Vinh","abc.com","Tac gia Viet Nam"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Fujiko F Fujio","abc.com","Tac gia manga"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Hajime Kamoshida","abc.com","Tac gia tieu thuyet"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("J.K.Rowling","abc.com","Tac gia noi tieng"));
        TongHopDuLieu.getDanhSachTacGia().add(new TacGia("Vũ Tình","abc.com","Tac gia Viet Nam"));
    }
    public static void initNhaXuatBanData(){

        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB Kim Đồng",new DiaChi("248","Cống Quỳnh","Phạm Ngũ Lão","Q.1","TP.HCM"),"info@nxbkimdong.com.vn","Bùi Tuấn Nghĩa"));
            TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB trẻ", new DiaChi("161B","Lý Chính Thắng","Võ Thị Sáu","Q.3","TP.HCM"),"hopthubandoc@nxbtre.com.vn","Nguyễn Thị Thanh Thủy"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB Giáo dục", new DiaChi("1","Nguyễn Thị Minh Khai","Nguyễn Thị Minh Khai","Q.3","TP.HCM"),"nxbgd@moet.edu.vn","Nguyễn Văn A"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB ĐHQG Hà Nội", new DiaChi("16 ","Hàng Chuối","Phạm Đình Hổ","Hai Bà Trưng"," Hà Nội"),"nxb@vnu.edu.vn","Nguyễn Văn B"));
        TongHopDuLieu.getDanhSachNhaXuatBan().add(new NhaXuatBan("NXB Chính trị quốc gia Sự thật.", new DiaChi("6/86","","Duy tân","Cầu Giấy","Hà Nội" ),"phathanh@nxbctqg.vn","Nguyễn Văn C"));

    }
    public static void initSachData(){
        Sach sach = new Sach("CÔ BẠN TÔI THẦM THÍCH LẠI QUÊN MANG KÍNH RỒI - TẬP 7",130,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Koume Fujichika"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2021,"Mới cứng","Cô bạn bàn bên lại quên kính rồi tap 7");
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện dài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Romance"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("School life"));
        TongHopDuLieu.getKhoSach().add(sach);
         sach = new Sach("CÔ BẠN TÔI THẦM THÍCH LẠI QUÊN MANG KÍNH RỒI - TẬP 1",146,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Koume Fujichika"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2021,"Mới cứng","Cô bạn bàn bên lại quên kính rồi Tap 1");
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện dài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Romance"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("School life"));
        TongHopDuLieu.getKhoSach().add(sach);
         sach = new Sach("NHỮNG ĐỨA TRẺ HẠNH PHÚC - LÀ CHÍNH MÌNH",20,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Lê Anh Vinh"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2022,"Mới cứng","Tập BẠN NHỎ DÂN TỘC KINH");
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Trẻ em"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giáo dục"));
        TongHopDuLieu.getKhoSach().add(sach);
            sach = new Sach("HỌC TOÁN CÙNG JENNY",32,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Lê Anh Vinh"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2021,"rách bìa trước  ","SÁCH DÀNH CHO HỌC SINH CHUẨN BỊ VÀO LỚP 1");
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Trẻ em"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giáo dục"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Toán"));
        TongHopDuLieu.getKhoSach().add(sach);
        sach = new Sach("DORAEMON - NOBITA VÀ NGƯỜI KHỔNG LỒ XANH",194,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Fujiko F Fujio"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2016,"bị mất bìa ","NOBITA VÀ NGƯỜI KHỔNG LỒ XANH");
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện dài"));
        TongHopDuLieu.getKhoSach().add(sach);
        sach = new Sach("DORAEMON TRUYỆN NGẮN - TẬP 19",192,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Fujiko F Fujio"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2021,"còn mới","Những câu chuyện về chú mèo máy thông minh Doraemon");
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện tranh"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Truyện ngắn"));
        TongHopDuLieu.getKhoSach().add(sach);
        sach = new Sach("HỘI CHỨNG TUỔI THANH XUÂN - TẬP 8",352,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Hajime Kamoshida"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB Kim Đồng"), (short) 2022,"còn mới","Đây chính là nguyên tác của bộ anime đình đám thống lĩnh mọi bảng xếp hạng anime năm 2018");
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Người lớn"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("School life"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Romance"));
        TongHopDuLieu.getKhoSach().add(sach);
        sach = new Sach("HARRY POTTER VÀ HÒN ĐÁ PHÙ THUỶ",366,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("J.K.Rowling"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2015,"còn mới"," Harry Potter");
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Tiểu thuyết"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Thiếu niên"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Văn học nước ngoài"));
        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Giả tưởng"));
        TongHopDuLieu.getKhoSach().add(sach);
        sach = new Sach("HỒ CHÍ MINH BÀN VỀ ĐẢNG",96,"Vi",TongHopDuLieu.getDanhSachTacGia().getByName("Vũ tình"),TongHopDuLieu.getDanhSachNhaXuatBan().getByName("NXB trẻ"), (short) 2018,"còn mới","gồm trích đoạn rất ngắn những phát biểu của Bác");

        sach.themTheLoai(TongHopDuLieu.getKhoTheLoai().getByName("Lịch sử"));
        TongHopDuLieu.getKhoSach().add(sach);
    }

}
