package Model;


import java.util.ArrayList;

// Nên kế thừ từ lớp con người??
// Tại vì con người nó có cái sdt, CMND gì nữa, mấy thông tin nhạy cảm z thường tác giả ko có
public class TacGia{
    private final int id;
    private String tenTacGia;
    private String website;
    private String gioiThieu;
    private ArrayList<Sach> sachs;

    public TacGia(int id) {
        this.id = id;
        sachs = new ArrayList<>();
    }

    public TacGia(int id, String tenTacGia, String website, String gioiThieu) {
        this(id);
        this.tenTacGia = tenTacGia;
        this.website = website;
        this.gioiThieu = gioiThieu;
    }

    public TacGia(int id, String tenTacGia, String website, String gioiThieu, ArrayList<Sach> sachs) {
        this.id = id;
        this.tenTacGia = tenTacGia;
        this.website = website;
        this.gioiThieu = gioiThieu;
        this.sachs = sachs;
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

    public ArrayList<Sach> getSachs() {
        return sachs;
    }


}
