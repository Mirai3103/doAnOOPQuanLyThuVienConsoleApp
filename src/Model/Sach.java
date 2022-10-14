package Model;

import java.util.ArrayList;

public class Sach {

    private final int id;
    private String tenSach;
    private int tongSoTrang;
    private String ngonNgu;
    private TacGia tacGia;
    private NhaXuatBan nhaXuatBan;
    private short namXuatBan;
    private String tinhTrang;
    private String gioiThieu;
    private ArrayList<TheLoai> theLoais = new ArrayList<>();


    public Sach(int id) {
        this.id = id;
    }

    public Sach(int id, String tenSach, int tongSoTrang, String ngonNgu, TacGia tacGia, NhaXuatBan nhaXuatBan, short namXuatBan, String tinhTrang, String gioiThieu) {
        this.id = id;
        this.tenSach = tenSach;
        this.tongSoTrang = tongSoTrang;
        this.ngonNgu = ngonNgu;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.tinhTrang = tinhTrang;
        this.gioiThieu = gioiThieu;
    }

    public int getId() {
        return id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getTongSoTrang() {
        return tongSoTrang;
    }

    public void setTongSoTrang(int tongSoTrang) {
        this.tongSoTrang = tongSoTrang;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public NhaXuatBan getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public short getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(short namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public ArrayList<TheLoai> getTheLoais() {
        return theLoais;
    }
    public void themTheLoai(TheLoai theLoai){
        for (TheLoai t:theLoais) {
            if(t.getId() == theLoai.getId())return;
        }
        this.theLoais.add(theLoai);
        theLoai.themSach(this);
    }

}
