package Repository;


import helper.Mang;

import java.util.ArrayList;
import java.util.List;

public interface IDanhSach<T> {

     void copyFrom(IDanhSach<T> other);

    void add(T item);
    void xuatConsoleDangTable();
    void xuatFileBinary(String fileName);
    void  docFileBinary(String fileName);


}
