package Main;

import Model.ConNguoi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void testGhi() {
        ArrayList<ConNguoi> arr = new ArrayList<>(5); // vi du cho kho du lieu
        for (int i = 0; i < 1; i++) {
            ConNguoi cn = new ConNguoi();
            cn.Nhap();
            cn.Xuat();
            arr.add(cn);
        }
        try {
            FileOutputStream fout = new FileOutputStream("E:\\data.obj");
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            objout.writeObject(arr);
            System.out.println("ghi thanh coong");
            objout.close();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ConNguoi> testDocTuFile() {
        try {

            // doc file
            FileInputStream finput = new FileInputStream("E:\\data.obj");
            ObjectInputStream objinput = new ObjectInputStream(finput);
            ArrayList<ConNguoi> duLieuDocDuoc = (ArrayList<ConNguoi>) objinput.readObject();
          return duLieuDocDuoc;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        //vi du ghi file
        testGhi();
      List<ConNguoi> list =   testDocTuFile();
    list.forEach(System.out::println);
    }
}