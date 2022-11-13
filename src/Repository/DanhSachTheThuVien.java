package Repository;


import Model.TheThuVien;
import helper.Helper;

import java.io.Serial;

public class DanhSachTheThuVien extends BaseDanhSach<TheThuVien>{
    @Serial
    private static final long serialVersionUID = 1212121775752L;
    public static final String FILE_PATH = Helper.dirPath + "DanhSachTheThuVien.bin";
    private int idIdentity = 0;

    @Override
    public void copyFrom(IDanhSach<TheThuVien> other) {
var otherTheThuViens = (DanhSachTheThuVien) other;
        this.idIdentity = otherTheThuViens.idIdentity;
        this.data = otherTheThuViens.data;
    }

    @Override
    public void add(TheThuVien item) {
        item.setIDthe(idIdentity++);
        data.add(item);
    }
    public TheThuVien getById(int id){
        return data.stream().filter(s ->s.getIDthe() == id).findFirst().orElse(null);
    }

}
