package helper;


import Repository.TongHopDuLieu;

import javax.swing.text.DateFormatter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Helper {
	// các hằng và hàm sử lý thường dùng
	// Cái  này được xem là database chứa tất cả danh sách  , khi ghi đọc ghi file thì chỉ ghi 1 cái này thôi, khỏi toon cong ghi nhieu
	// biến toàn cucj nên ởdđau cũng lấy được, dễ dàng kiểm tra ràng buộc
	public static DateTimeFormatter DATE_FORMAT  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static TongHopDuLieu khoDuLieu  =null;
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
	public static int nhapSoTuNhien(String errorMessage){
		String number = scanner.nextLine();
		boolean continueLoop = true;
		if(number.matches(INTEGER_PATTERN)){
			int numberInt = Integer.parseInt(number);
			if(numberInt > 0){
				continueLoop = false;
			}
		}
		while ( continueLoop){
			System.out.println(errorMessage);
			number = scanner.nextLine();
			if(number.matches(INTEGER_PATTERN)){
				int numberInt = Integer.parseInt(number);
				if(numberInt > 0){
					continueLoop = false;
				}
			}
		}
		return Integer.parseInt(number);
	}
	public static String nhapEmail(){
		System.out.println("Nhập email: ");
		String email = scanner.nextLine();
		while (!email.matches(EMAIL_PATTERN)){
			System.out.println("Email không hợp lệ. Vui lòng nhập lại: ");
			email = scanner.nextLine();
		}
		return email;
	}
	public static String nhapTen(){
		String name = scanner.nextLine();
		var isOk =Arrays.stream(name.split("")).filter(t->t.charAt(0) >='0' && t.charAt(0)<='9').toList().size() !=0 ;
		while (isOk){
			System.out.println("Tên khônng hợp lệ! , nhập lại: ");
			name = scanner.nextLine();
			isOk =Arrays.stream(name.split("")).filter(t->t.charAt(0) >='0' && t.charAt(0)<='9').toList().size() !=0 ;
		}

		return name;
	}
	public static boolean checkSdt(String SDT) {
		if (SDT.matches("^[\\d]{10,11}$")) {
			return true;
		} else {
			System.out.println("Số điện thoại không hop lệ! ");
			return false;
		}
	}
	public static String nhapSdt(){
		System.out.println("Nhập số điện thoại: ");
		String number = scanner.nextLine();
		while (!checkSdt(number)){
			System.out.println("nhập lại: ");
			number = scanner.nextLine();
		}
		return number;
	}
	public static boolean checkCMND(String CMND) {
		if (CMND.matches("([\\d]{9})$")) {
			return true;
		} else {
			System.out.println("Số CMND/CCCD không hop lệ! ");
			return false;
		}
	}
	public static String nhapCMND(){
		System.out.println("Nhập CMND/CCCD: ");
		String number = scanner.nextLine();
		while (!checkCMND(number)){
			System.out.println("nhập lại: ");

			number = scanner.nextLine();
		}

		return number;
	}
	public static LocalDate inputDate(boolean isAfterNow){
		String dateStr;
		var isDateValid = false;
		do {
			System.out.print("Nhập ngày : ");
			dateStr = Helper.scanner.nextLine();
			isDateValid = Helper.checkNgayThang(dateStr);
		}while (!isDateValid);
		var date = LocalDate.parse(dateStr, DATE_FORMAT);
		if(isAfterNow){
			if (date.isBefore(LocalDate.now())){
				System.out.println("Không hợp lệ! phải sau ngày hiện hôm nay");
				return inputDate(true);
			}
		}
		return date;
	}
	public static LocalDate inputDate(){
	 return inputDate(false);
	}
	public static boolean checkEmail(String email){
		return email.matches(EMAIL_PATTERN);
	}
	public static String inputEmail(String errorMgs){
		String email = scanner.nextLine();
		while (!checkEmail(email)){
			System.out.println(errorMgs);
			email = scanner.nextLine();
		}
		return email;
	}


	public static String dirPath = System.getProperty("user.dir")+"\\data\\";

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
		//toDo:check xem thử hợp lệ ko ví dụ 30/2/2022 => ko hợp lệ
		try {
			LocalDate date = LocalDate.of(Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(1)));
		}catch (Exception e){
			System.out.println("Ngày tháng không hợp lệ");
			return  false;
		}
		return true; //   dd/mm/yyyy || dd-mm-yyyy
	}
	public static LocalDate parseDate(String date){
		return LocalDate.parse(date, DATE_FORMAT);
	}
	public static void clearScreen() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch (Exception ignored) {
		}

	}


}
