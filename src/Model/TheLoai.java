package Model;


import helper.Xuat.Table;
import helper.Helper;
import helper.Xuat.ITableRowData;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class TheLoai  implements Serializable, ITableRowData {
    @Serial
    private static final long serialVersionUID = 1342400999L;
    public  static int idIncrement = 0;
    private final int id;
    private  String tenTheLoai;
    private String gioiThieu;

    public TheLoai( String tenTheLoai, String gioiThieu) {
        this.id = TheLoai.idIncrement++;
        this.tenTheLoai = tenTheLoai;
        this.gioiThieu = gioiThieu;
    }

    public TheLoai(){
        this.id = TheLoai.idIncrement++;
    }
    public ArrayList<Sach> getSachs() {
     var sachIds =  Helper.khoDuLieu.getDanhSachTheLoai_sach().getTheLoai_saches().stream().filter(t -> t.getTheLoaiId() == this.id).toList();
        ArrayList<Sach> sachs = new ArrayList<>();
        for (TheLoai_Sach theLoai_sach : sachIds) {
            Sach s = Helper.khoDuLieu.getKhoSach().findById(theLoai_sach.getSachId());
            if (s != null) {
                sachs.add(s);
            }
        }
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
    public void nhap(){
        System.out.println("Nhập tên thể loại: ");
        this.tenTheLoai = Helper.scanner.nextLine();
        System.out.println("Nhập giới thiệu: ");
        this.gioiThieu = Helper.scanner.nextLine();
    }
    public void xuat(){
        System.out.printf("ID: %d, Tên thể loại: %s, Giới thiệu: %s\n", this.id, this.tenTheLoai, this.gioiThieu);
    }
    public String toCSVRow(){
        return String.format("%d, %s, \"%s\"", this.id,this.tenTheLoai,this.gioiThieu);
    }

    @Override
    public String[] getRowData() {
        return new String[]{id+"",tenTheLoai,gioiThieu};
    }

    @Override
    public String[] getHeader() {
        return  new String[]{"Id","Tên thể loại","giới thiệu"};
    }
    public void xuatDangBang(){
        System.out.println(Table.taoBang(this));
    }
}
