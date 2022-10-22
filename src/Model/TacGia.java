package Model;


import Main.Main;
import helper.Helper;

import java.util.ArrayList;
import java.util.List;

// Nên kế thừ từ lớp con người??
// Tại vì con người nó có cái sdt, CMND gì nữa, mấy thông tin nhạy cảm z thường tác giả ko có
public class TacGia {
    private final int id;
    private String tenTacGia;
    private String website;
    private String gioiThieu;

    public TacGia(int id) {
        this.id = id;
    }

    public TacGia(int id, String tenTacGia, String website, String gioiThieu) {
        this(id);
        this.tenTacGia = tenTacGia;
        this.website = website;
        this.gioiThieu = gioiThieu;
    }



    public int getId() {
        return id;
    }



    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public List<Sach> getSachs() {
        return Helper.khoDuLieu.getKhoSach().timSachCuaTacGia(this.id);
    }

}
