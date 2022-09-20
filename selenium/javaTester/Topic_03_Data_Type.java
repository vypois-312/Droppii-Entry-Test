package javaTester;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Data_Type {

	public static void main(String[] args) {
		//Thông tin của một nhân viên
		
		// Tên tuổi ngày tháng năm /giới tính/ quê quán/ lương
		
		//Kiểu dữ liệu nguyên thuỷ
		// 8 loại
		// Số nguyên: byte/short/int/long
		
		byte bNumber = 50;
		short sNumber = 500;
		int iNumber = 6000;
		long lNumber = 1567890;
		// Số thực: Float/ double
		float salary = 15.5f;
		double point = 9.8d;
		
		// ký tự: char
		char a = 'a';
		
		// Logic: boolean
		
		
		//II. Kiểu dữ liệu tham chiếu
		// chuỗi: string
		// Dau nhay doi
		
		String emailInvalid = "afc345@%%%.gmail.com";
		// Class: interface (DateTime)
				
		Date date = new Date();
		WebDriver driver = new FirefoxDriver();
		// Đối tượng: object
		Object students;
		
		// Array: mảng - cố định số lượng 
		int numbers[] = {15, 20, 45};
		String addresses[] = {"Da Nang", "Ha Noi", "Ho Chi Minh"};
		// List/Set/ Queue (Collection) - động 
		List<Integer> studentNumber = new ArrayList <>();
		List<String> studentAddress = new ArrayList <>();
		Set<String> studentCity = new LinkedHashSet <>();
		
	}

}
