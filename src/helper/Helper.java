package helper;


import java.util.Scanner;
import java.util.regex.Pattern;

public final class Helper {
    // các hằng và hàm sử lý thường dùng
    public final static Scanner scanner = new Scanner(System.in);
    public final static String EMAIL_PATTERN = "^([\\w.][^_])+@([\\w]+\\.)+[\\w-]{2,4}$";
    public final static Pattern DATE_PATTERN = Pattern.compile("^([\\d]{1,2})[/\\-]([\\d]{1,2})[/\\-]([\\d]{4})$");
    public final static String INTEGER_PATTERN ="^\\-?\\d+$";
    public static int nhapSoNguyen(String errorMessage){
        String number = scanner.nextLine();
        while (!number.matches(INTEGER_PATTERN)){
            System.out.println(errorMessage);
            number = scanner.nextLine();
        }
        return Integer.parseInt(number);
    }
}
