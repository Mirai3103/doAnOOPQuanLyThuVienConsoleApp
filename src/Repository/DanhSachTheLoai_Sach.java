package Repository;

import Model.Sach;
import Model.TheLoai;
import Model.TheLoai_Sach;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

// thực thể yếu
public class DanhSachTheLoai_Sach  implements Serializable {
    @Serial
    private static final long serialVersionUID = 134240300L;
    private ArrayList<TheLoai_Sach> theLoai_saches = new ArrayList<>();

    public ArrayList<TheLoai_Sach> getTheLoai_saches() {
        return theLoai_saches;
    }
    public void add(Sach sach, TheLoai theLoai){
        theLoai_saches.add(new TheLoai_Sach(sach.getId(),theLoai.getId()));
    }
    public void add(int sachId, int theLoaiId){
        theLoai_saches.add(new TheLoai_Sach(sachId,theLoaiId));
    }

}
