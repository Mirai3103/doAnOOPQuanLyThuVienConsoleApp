package Model;


import helper.Xuat.ITableRowData;

import java.io.Serial;
import java.io.Serializable;

public class TheLoai_Sach  implements Serializable , ITableRowData {
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

    @Override
    public String[] getRowData() {
        return new String[]{String.valueOf(sachId), String.valueOf(theLoaiId)};
    }

    @Override
    public String[] getHeader() {
        return new String[]{"SachId", "TheLoaiId"};
    }
}
