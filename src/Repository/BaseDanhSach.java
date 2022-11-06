package Repository;


import helper.Xuat.ITableRowData;
import helper.Xuat.Table;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class BaseDanhSach<T extends ITableRowData> implements IDanhSach<T> {


protected ArrayList<T> data = new ArrayList<>();



    @Override
    public ArrayList<T> getAll() {
        return data;
    }
    public void add(T value) {
        data.add( value);
    }
    @Override
    public void xuatConsoleDangTable(){
        if(data.size() == 0){
            System.out.println("Danh sách trống");
            return;
        }
        System.out.println(Table.taoBang(data));
    }
//    @Override
//    public void xuatFileCsv(String fileName ){
//        if(data.size() == 0){
//            System.out.println("Danh sách trống, không thể xuất file");
//            return;
//        }
//        Table.xuatFileExcel(data, TongHopDuLieu.createFilePath(fileName));
//    }
    @Override
    public void xuatFileBinary(String filePath ){
        if(data.size() == 0){
            System.out.println("Danh sách trống, không thể xuất file");
            return;
        }
        try {
            FileOutputStream fout = new FileOutputStream(filePath);
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            objout.writeObject(this.data);
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
            ArrayList<T> duLieuDocDuoc = (ArrayList<T>) objinput.readObject();
            this.data = duLieuDocDuoc;
            objinput.close();
            finput.close();
        } catch (Exception ignored) {
        }
    }
//    @Override


}
