package Repository;

import Model.Sach;
import Model.TheLoai;
import Model.TheLoai_Sach;
import helper.Helper;

import java.io.*;
import java.util.ArrayList;

// thực thể yếu
public class DanhSachTheLoai_Sach implements Serializable {
    @Serial
    private static final long serialVersionUID = 134243219644L;
    public static String FILE_PATH = Helper.dirPath+ "DanhSachTheLoai_Sach.bin";

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
    public void xuatFileBinary(){
        if(theLoai_saches.size() == 0){
            System.out.println("Danh sách trống, không thể xuất file");
            return;
        }
        try {
            FileOutputStream fout = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            objout.writeObject(this.theLoai_saches);
            objout.close();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void docFileBinary(){
        try {
            FileInputStream finput = new FileInputStream(FILE_PATH);
            ObjectInputStream objinput = new ObjectInputStream(finput);
            ArrayList<TheLoai_Sach> duLieuDocDuoc = (ArrayList<TheLoai_Sach>) objinput.readObject();
            this.theLoai_saches = duLieuDocDuoc;
            objinput.close();
            finput.close();

        } catch (Exception ignored) {
        }
    }


}
