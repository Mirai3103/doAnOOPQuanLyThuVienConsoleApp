package Repository;


import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DbContext implements Serializable {
    @Serial
    private static final long serialVersionUID = 134560024234L;


    private KhoSach khoSach = new KhoSach();
    private KhoTheLoai khoTheLoai = new KhoTheLoai();
    private DanhSachTheLoai_Sach danhSachTheLoai_sach = new DanhSachTheLoai_Sach();
    private DanhSachTacGia danhSachTacGia = new DanhSachTacGia();
    private DanhSachNhaXuatBan danhSachNhaXuatBan = new DanhSachNhaXuatBan();
    private String filePath = System.getProperty("user.dir")+"\\src\\data\\data.bin";
    private int sachIdIncrement = 0, theLoaiIdIncrement = 0, tacGiaIdIncrement = 0, nhaXuatBanIdIncrement = 0;
    public  void luuDuLieuVaoFile() {
        sachIdIncrement = Sach.idIncrement;
        theLoaiIdIncrement = TheLoai.idIncrement;
        tacGiaIdIncrement = TacGia.idIncrement;
        nhaXuatBanIdIncrement = NhaXuatBan.idIncrement;

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
        this.khoSach = db.khoSach!=null?db.khoSach:new KhoSach();
        this.khoTheLoai = db.khoTheLoai!=null?db.khoTheLoai:new KhoTheLoai();
        this.danhSachTheLoai_sach = db.danhSachTheLoai_sach!=null?db.danhSachTheLoai_sach:new DanhSachTheLoai_Sach();
        this.danhSachTacGia = db.danhSachTacGia!=null?db.danhSachTacGia:new DanhSachTacGia();
        this.danhSachNhaXuatBan = db.danhSachNhaXuatBan!=null?db.danhSachNhaXuatBan:new DanhSachNhaXuatBan();
        Sach.idIncrement = db.sachIdIncrement;
        TheLoai.idIncrement = db.theLoaiIdIncrement;
        TacGia.idIncrement = db.tacGiaIdIncrement;
        NhaXuatBan.idIncrement = db.nhaXuatBanIdIncrement;

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

    public DanhSachNhaXuatBan getDanhSachNhaXuatBan() {
        return danhSachNhaXuatBan;
    }

    public KhoTheLoai getKhoTheLoai() {
        return khoTheLoai;
    }
}
