package Repository;


import Model.XuPhat;
import helper.Helper;

import java.io.Serial;

public class DanhSachXuPhat extends BaseDanhSachArray<XuPhat> {
    @Serial
    private static final long serialVersionUID = 1212121775752L;
    public static final String FILE_PATH = Helper.dirPath + "DanhSachLoiPhat.bin";
    private int idIdentity = 0;
    @Override
    public void copyFrom(IDanhSach<XuPhat> other) {
        var otherXuPhats = (DanhSachXuPhat) other;
        this.data = otherXuPhats.data;
    }

    @Override
    public void add(XuPhat item) {
        item.setIdXuPhat(idIdentity++);
        data.add(item);
    }
    public void xuatFileBinary(){
        super.xuatFileBinary(FILE_PATH);
    }
    public void add(){
        var item = new XuPhat();
        item.nhapXuPhat();
        add(item);
    }
    public XuPhat getById(int id){
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getIdXuPhat()==id){
                return data.get(i);
            }
        }
        return null;
    }
}
