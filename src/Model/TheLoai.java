package Model;


import java.util.ArrayList;

public class TheLoai {
    private final int id;
    private  String tenTheLoai;
    private String gioiThieu;
    private ArrayList<Sach> sachs = new ArrayList<>();

    public TheLoai(int id, String tenTheLoai, String gioiThieu) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.gioiThieu = gioiThieu;
    }

    public ArrayList<Sach> getSachs() {
        return sachs;
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
    public void themSach(Sach sach){
        for (Sach s:sachs) {
            if(s.getId() == sach.getId())return;
        }
        sachs.add(sach);
    }
}
