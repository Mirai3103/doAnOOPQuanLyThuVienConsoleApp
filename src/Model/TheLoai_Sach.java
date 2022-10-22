package Model;


public class TheLoai_Sach {
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
