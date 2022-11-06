package Model;


import java.io.Serial;
import java.io.Serializable;

public class TheLoai_Sach  implements Serializable {
    @Serial
    private static final long serialVersionUID = 13424321644L;
    private int sachId;
    private int theLoaiId;

    public TheLoai_Sach(int sachId, int theLoaiId) {
        this.sachId = sachId;
        this.theLoaiId = theLoaiId;
    }

    public int getSachId() {
        return sachId;
    }

    public int getTheLoaiId() {
        return theLoaiId;
    }
}
