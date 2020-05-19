package reflection;

import java.lang.reflect.Method;

public class Test03 {
	public static void main(String[] args) {
		try {
//			exam01();
			exam02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void exam01() throws Exception {
		// 리플렉션 기법을 이용한 객체 생성하기
		// Dog d= new Dog();
		Class<?> clz = Dog.class;
		
//		Object obj = clz.getDeclaredConstructor().newInstance(); // 1.9버전부터 권장
		Object obj = clz.newInstance(); // 1.8버전까진 괜찮음
		
		Dog d = (Dog)obj;
		d.setName("멍멍이");
		System.out.println(d.getName());
	}
	
	private static void exam02() throws Exception {
		/*
		 * Dog d = new Dog(); // newInstance();
		 * d.setName("멍멍이"); // Method
		 * System.out.prinln(d.getName()); // Method
		 */
		
		Class<?> clz = Dog.class;
		Object obj = clz.newInstance(); // 1.8버전까진 괜찮음
		
		Method m = clz.getDeclaredMethod("setName", String.class);
		m.invoke(obj, "멍멍이");
		
		m = clz.getDeclaredMethod("getName");
		Object ret = m.invoke(obj);
		System.out.println(ret);
	}
}
