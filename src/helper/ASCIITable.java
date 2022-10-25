package helper;


public class ASCIITable {
   public static String taoBang(String[] header, String[][] data) {
       int[] chieuRongCacCot = new int[header.length];
       // tìm chiều rộng lớn nhất của cột
       for (int i = 0; i < header.length; i++) {
           chieuRongCacCot[i] = header[i].length();
       }
       for (String[] datum : data) {
           for (int j = 0; j < datum.length; j++) {
               if (datum[j].length() > chieuRongCacCot[j]) {
                   chieuRongCacCot[j] = datum[j].length();
               }
           }
       }
       StringBuilder sb = new StringBuilder();
       sb.append(taoDuongPhanCach(chieuRongCacCot));
       sb.append(taoDongDuLieu(chieuRongCacCot, header));
       sb.append(taoDuongPhanCach(chieuRongCacCot));
       for (String[] d : data) {
           sb.append(taoDongDuLieu(chieuRongCacCot, d));
       }
       sb.append(taoDuongPhanCach(chieuRongCacCot));
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
}
