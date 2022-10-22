package Repository;


import Model.ConNguoi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DbContext implements Serializable {
    @Serial
    private static final long serialVersionUID = 134564324234L;


    private KhoSach khoSach = new KhoSach();
    private KhoTheLoai khoTheLoai = new KhoTheLoai();
    private DanhSachTheLoai_Sach danhSachTheLoai_sach = new DanhSachTheLoai_Sach();
    private DanhSachTacGia danhSachTacGia = new DanhSachTacGia();
    private String filePath = "E:\\data.bin";
    public DbContext(String saveFilePath){
        this.filePath = saveFilePath;
    }
    public  void luuDuLieuVaoFile() {

        try {
            FileOutputStream fout = new FileOutputStream(filePath);
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            objout.writeObject(this);
            System.out.println("Lưu thành công!");
            objout.close();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void copy(DbContext db){
        this.khoSach = db.khoSach;
        this.khoTheLoai = db.khoTheLoai;
    }

    public void docDuLieuTuFile() {
        File file = new File(filePath);
        if(!file.exists()){
            return;
        }
        try {
            FileInputStream finput = new FileInputStream(filePath);
            ObjectInputStream objinput = new ObjectInputStream(finput);
            DbContext duLieuDocDuoc = (DbContext) objinput.readObject();
            this.copy(duLieuDocDuoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public KhoSach getKhoSach() {
        return khoSach;
    }

    public DanhSachTheLoai_Sach getDanhSachTheLoai_sach() {
        return danhSachTheLoai_sach;
    }

    public DanhSachTacGia getDanhSachTacGia() {
        return danhSachTacGia;
    }

    public KhoTheLoai getKhoTheLoai() {
        return khoTheLoai;
    }
}
