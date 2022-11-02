package helper;


import java.util.ArrayList;

public class Table {
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
               if ((rowData.getRowData())[j].length()> chieuRongCacCot[j]) {
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
}