package helper;


import java.util.Scanner;
import java.util.regex.Pattern;

public final class Helper {
    // các hằng và hàm sử lý thường dùng
    public final static Scanner scanner = new Scanner(System.in);
    public final static String EMAIL_PATTERN = "^([\\w.][^_])+@([\\w]+\\.)+[\\w-]{2,4}$";
    public final static Pattern DATE_PATTERN = Pattern.compile("^([\\d]{1,2})[/\\-]([\\d]{1,2})[/\\-]([\\d]{4})$");

}
