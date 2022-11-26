package helper.Xuat;



import helper.Mang;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Table {
    public static<T extends ITableRowData> String taoBang(Mang<T> data){
        if(data.size() == 0){
            return "Danh sách trống";
        }
        String[] header = data.get(0).getHeader();
        int[] chieuRongCacCot = new int[header.length];
        for (int i = 0; i < header.length; i++) {
            chieuRongCacCot[i] = header[i].length();
        }
        for (int i = 0; i < data.size(); i++) {
            String[] row = data.get(i).getRowData();
            for (int j = 0; j < row.length; j++) {
                if(row[j].length() > chieuRongCacCot[j]){
                    chieuRongCacCot[j] = row[j].length();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(taoDuongPhanCach(chieuRongCacCot));
        sb.append(taoDongDuLieu(chieuRongCacCot, header));
        sb.append(taoDuongPhanCach(chieuRongCacCot));
        for (int i = 0; i < data.size(); i++) {
            String[] row = data.get(i).getRowData();
            sb.append(taoDongDuLieu(chieuRongCacCot, row));
            sb.append(taoDuongPhanCach(chieuRongCacCot));
        }
        return sb.toString();
    }
   public static String taoBang(ArrayList<? extends ITableRowData> data) {
       if(data.size()==0){
           return "Trống";
       }
       String[] header=data.get(0).getHeader();
       int[] chieuRongCacCot = new int[header.length];

       // tìm chiều rộng lớn nhất của cột
       for (int i = 0; i < header.length; i++) {
           chieuRongCacCot[i] = header[i].length();
       }

       for (ITableRowData  rowData : data) {
           for (int j = 0; j < rowData.getRowData().length; j++) {
               int lengthCell = 1;
               try {
                   lengthCell=  rowData.getRowData()[j].length();
               }catch (Exception ignored){
                   rowData.getRowData()[j] = " ";
               }
               if (lengthCell> chieuRongCacCot[j]) {
                   chieuRongCacCot[j] = (rowData.getRowData())[j].length();
               }
           }
       }
       StringBuilder sb = new StringBuilder();
       sb.append(taoDuongPhanCach(chieuRongCacCot));
       sb.append(taoDongDuLieu(chieuRongCacCot, header));
       sb.append(taoDuongPhanCach(chieuRongCacCot));
       for (ITableRowData d : data) {
           String[] dataStrs =  d.getRowData();
           sb.append(taoDongDuLieu(chieuRongCacCot,dataStrs));
           sb.append(taoDuongPhanCach(chieuRongCacCot));
       }
       return sb.toString();
   }
   // tạo các đường phân cách: +------+-------------+--------+
    private static String taoDuongPhanCach(int[] chieuRongCacCot) {
         StringBuilder sb = new StringBuilder();
        for (int k : chieuRongCacCot) {
            sb.append("+");
            sb.append("-".repeat(k + 2));
        }
         sb.append("+");
         sb.append(System.lineSeparator());
         return sb.toString();
    }
    // tạo các dòng dữ liệu: |  ID  |  Tên thể loại  |  Giới thiệu  |
    private static String taoDongDuLieu(int[] chieuRongCacCot, String[] data) {
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < chieuRongCacCot.length; i++) {
                if(data[i] == null){
                    data[i] = " ";
                }
              sb.append("| ");
              sb.append(data[i]);
             sb.append(" ".repeat(chieuRongCacCot[i] - data[i].length() + 1));
         }
         sb.append("|");
         sb.append(System.lineSeparator());
         return sb.toString();
    }
    public static String taoBang(ITableRowData data) {
        return taoBang(new ArrayList<>(){{add(data);}});
    }

    public static void xuatFileExcel(ArrayList<? extends ITableRowData> data , String fileName){
       try {
           Writer fileWriter = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
           fileWriter.write(String.join(",",data.get(0).getHeader())+"\n");
           for (ITableRowData  rowData : data) {
               fileWriter.write(String.join(",",rowData.getRowData())+"\n");
           }
           fileWriter.flush();
           fileWriter.close();
       }catch (IOException ignored){

       }

    }
    public static ArrayList<String> docFileExcel(String fileName){
        ArrayList<String> data=new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
            String line = fileReader.readLine();//ignore header

            while ((line=fileReader.readLine())!=null){
               if(line.trim().charAt(0)!='\n'){
                   data.add(line);
               }
            }
            fileReader.close();
        }catch (IOException ignored){

        }
        return data;
    }
}
