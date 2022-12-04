package Repository;


import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

import java.io.*;
import java.util.ArrayList;

public abstract class BaseDanhSach<T extends ITableRowData> implements IDanhSach<T>, Serializable {


protected ArrayList<T> data = new ArrayList<>();


    public final ArrayList<T> getAll() {
        return  this.data;
    }
    @Override
    public final void xuatConsoleDangTable(){
        if(data.size() == 0){
            System.out.println("Danh sách trống");
            return;
        }
        System.out.println(Table.taoBang(data));
    }

    @Override
    public final void xuatFileBinary(String filePath ){
        if(data.size() == 0){
            System.out.println("Danh sách trống, không  xuất file");
            return;
        }
        try {
            FileOutputStream fout = new FileOutputStream(filePath);
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            objout.writeObject(this);
//            System.out.println("Lưu thành công!");
            objout.close();
            fout.close();
        } catch (Exception ignored) {
//            System.out.println(ignored.getMessage());
//            ignored.printStackTrace();
        }
    }
    @Override
    public final void docFileBinary(String filePath){
        try {
            FileInputStream finput = new FileInputStream(filePath);
            ObjectInputStream objinput = new ObjectInputStream(finput);
            BaseDanhSach<T> duLieuDocDuoc = (BaseDanhSach<T>) objinput.readObject();
            this.copyFrom(duLieuDocDuoc);
            objinput.close();
            finput.close();
        } catch (Exception ignored) {
        }
    }


}
