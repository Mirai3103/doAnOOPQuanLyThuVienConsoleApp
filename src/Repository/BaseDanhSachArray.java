package Repository;


import helper.Mang;
import helper.Xuat.ITableRowData;

import java.io.*;
import java.util.ArrayList;


public abstract class BaseDanhSachArray<T extends ITableRowData> implements IDanhSach<T>, Serializable {
    protected Mang<T> data = new Mang<>();
    public void copyFrom(BaseDanhSachArray<T> other){
        this.data = other.data;
    }
    public T[] getAll() {
        return data.getAll();
    }

    @Override
    public void xuatConsoleDangTable() {
        if (data.size() == 0) {
            System.out.println("Danh sách trống");
            return;
        }
        System.out.println(data);
    }

    @Override
    public void xuatFileBinary(String filePath ){
        if(data.size() == 0){
            System.out.println("Danh sách trống, không thể xuất file");
            return;
        }
        try {
            FileOutputStream fout = new FileOutputStream(filePath);
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            objout.writeObject(this);
            System.out.println("Lưu thành công!");
            objout.close();
            fout.close();
        } catch (Exception ignored) {
        }
    }
    @Override
    public   void docFileBinary(String filePath){
        try {
            FileInputStream finput = new FileInputStream(filePath);
            ObjectInputStream objinput = new ObjectInputStream(finput);
            BaseDanhSachArray<T> duLieuDocDuoc = (BaseDanhSachArray<T>) objinput.readObject();
            this.copyFrom(duLieuDocDuoc);
            objinput.close();
            finput.close();
        } catch (Exception ignored) {
        }
    }

}
