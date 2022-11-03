package Repository;


import helper.Mang;

import java.util.ArrayList;
import java.util.List;

public interface IDanhSach<T> {
    ArrayList<T> getAll();
    void xuatConsoleDangTable();
    void xuatFileBinary(String fileName);
    void  docFileBinary(String fileName);
}
