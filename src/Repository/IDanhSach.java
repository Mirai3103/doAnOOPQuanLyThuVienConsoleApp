package Repository;


import helper.Mang;

import java.util.ArrayList;
import java.util.List;

public interface IDanhSach<T> {
    ArrayList<T> getAll();
    T getById(int id);
    void add(T obj);
    void delete(int id);
    void update(int id);
    void xuatConsoleDangTable();
//    void xuatFileCsv(String fileName);
    void xuatFileBinary(String fileName);
//    void copyFrom(IDanhSach<T> danhSach);
    void  docFileBinary(String fileName);
//     void readCsv(String fileName);
}
