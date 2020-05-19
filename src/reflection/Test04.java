package reflection;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;


public class Test04 {
	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/reflection/test04.properties"));
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("호출할 URL 입력 : ");
				String url = sc.nextLine();
				
				if(url.equals("quit")) {
					break;
				}
				String[] arr = prop.getProperty(url).split(":");
//				System.out.println(arr[0]);
//				System.out.println(arr[1]);
				
				Class<?> clz = Class.forName(arr[0]);
				Object obj = clz.newInstance();
				Method m = clz.getDeclaredMethod(arr[1]);
				m.invoke(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
