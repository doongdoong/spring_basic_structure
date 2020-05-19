package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class Test02 {
	
	public static void main(String[] args) {
		try {
//			exam01();
			exam02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void exam01() throws Exception {
		Class<?> clz = Dog.class;
		
		System.out.println("Dog의 모든 메서드 정보 출력");
		Method[] mArr = clz.getDeclaredMethods();
		
		for(Method m : mArr) {
//			System.out.println(m);
			System.out.println("메서드 이름 : " + m.getName());
			Class<?> rClz = m.getReturnType();
			System.out.println("반환 타입 : " + rClz.getName());
			// 파라미터 정보 가져오기
			Parameter[] pArr = m.getParameters();
			for(Parameter p : pArr) {
				System.out.println(p.getName());
				Type t = p.getParameterizedType();
				System.out.println(t.getTypeName());
			}
		}
	}
	
	private static void exam02() throws Exception {
		Class<?> clz = Dog.class;
//		Method m = clz.getDeclaredMethod("setName", String.class);
		Method m = clz.getDeclaredMethod("setAge", int.class);		
		System.out.println(m.getName());
		System.out.println(m.getReturnType());
		
		// getName
		Method m2 = clz.getDeclaredMethod("getName");		
		System.out.println(m2.getName());
		System.out.println(m2.getReturnType().getTypeName());
	}
}
