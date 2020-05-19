package reflection;

public class Test {
	/*
	 * 클래스 정보를 접근하는 3가지 방법
	 * 
	 */
	
	private static void exam01() throws Exception {
		// 1번 방법 : 클래스이름.class
		Class<?> clz = Dog.class;
		
		// 2번 방법 : Class.forName("패키지명.클래스명")
		Class<?> clz2 = Class.forName("reflection.Dog");
		
		// 3번 방법 : 객체.getClass();
		Dog d = new Dog();
		Class<?> clz3 = d.getClass();
		
		System.out.println(clz == clz2);
		System.out.println(clz2 == clz3);
		
		System.out.println(clz.getSimpleName());
		System.out.println(clz.getName());
	}
	
	public static void main(String[] args) {
		// 클래스 자체의 정보를 얻는 기술
		try {
			exam01();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
