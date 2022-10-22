package Test;


import Repository.DbContext;
import helper.Helper;

public class ThemVaShowSach {
    public static void main(String[] args) {
        // có lẽ cần thêm 1 số data mẫu để test

        Helper.khoDuLieu = new DbContext("E:\\data.bin");
        Helper.khoDuLieu.docDuLieuTuFile();
        // mới chỉ xu lý quan hệ n-n của sách  và thể loại, còn quang hệ 1-n của sách và tác giả thì chưa làm
        for (int i = 0; i < 1; i++) {
            Helper.khoDuLieu.getKhoSach().themSach();
        }
        // các classs nào mà muốn ghi xuống khi thì phải implement interface serializable
        Helper.khoDuLieu.getKhoSach().xuatsach();
    }
}
