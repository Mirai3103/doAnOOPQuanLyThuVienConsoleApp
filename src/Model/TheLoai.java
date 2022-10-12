package Model;


public class TheLoai {
    private final int id;
    private  String tenTheLoai;
    private String gioiThieu;

    public TheLoai(int id, String tenTheLoai, String gioiThieu) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.gioiThieu = gioiThieu;
    }

    public TheLoai(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }
}
