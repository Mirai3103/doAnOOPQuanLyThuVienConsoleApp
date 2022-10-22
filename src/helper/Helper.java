package helper;


import Repository.DbContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Helper {
    // các hằng và hàm sử lý thường dùng
	public static DbContext khoDuLieu  =null;
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
    
    // dùng để đọc flie theo từng dòng thành String 
    // vào hàm của ai thì cắt cái String đó ra bằng lệnh str.split(" ")
//    public static ArrayList<String> DocFile(String Path){
//    	ArrayList<String> listLine = new ArrayList<>();
//    	try {
//			FileReader f = new FileReader(Path);
//			BufferedReader B = new BufferedReader(f); 
//			String Line;
//			while ((Line = B.readLine())!=null) {
//				listLine.add(Line);
//			}
//		} catch (FileNotFoundException E) {
//			E.printStackTrace();
//		} catch ( IOException E) {
//			E.printStackTrace();
//		}
    	
//    	return listLine;
//
//    }
    
    public static boolean checkNgayThang(String NgayThang){
		Matcher matcher = Helper.DATE_PATTERN.matcher(NgayThang);
		if(!matcher.find()) {
			System.out.println("Ngày tháng không hợp lệ");
			return  false;
		};
		if(Integer.parseInt(matcher.group(1)) > 31||Integer.parseInt(matcher.group(1)) ==0){
			System.out.println("Ngày tháng không hợp lệ");
			return  false;
		}
		if(Integer.parseInt(matcher.group(2)) > 12 ||Integer.parseInt(matcher.group(2)) ==0 ){
			System.out.println("Ngày tháng không hợp lệ");
			return  false;
		}
		if(Integer.parseInt(matcher.group(3)) > 2025 ||Integer.parseInt(matcher.group(3)) <1940){
			System.out.println("Ngày tháng không hợp lệ");
			return  false;
		}
		return true; //   dd/mm/yyyy || dd-mm-yyyy
	}
    
}
