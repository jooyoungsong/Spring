package framework.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///////////자바

		System.out.println("자바방식으로 hello메서드 호출하기");
		
		Hello hello1=new Hello();
		System.out.println(hello1.getMessage());
		
		Hello hello2=new Hello();
		System.out.println(hello2.getMessage());
		
		System.out.println(hello1==hello2); //자바에서는 new객체 생성하면, 주소값이 다르기에 false가 나온다는 걸 알기 위해 해봄
		
		
		///////////스프링
		
		System.out.println("스프링방식으로 hello메서드 호출하기");
		//xml파일 가져오기...웹으로 실행 시, web.xml에 설정이 되어있으므로 필요없다
		
		ApplicationContext app1=new ClassPathXmlApplicationContext("helloContext.xml");
		
		//hello 객체 생성
		Hello h1=(Hello)app1.getBean("hello"); // 방법1_helloContext.xml에서 bean설정한 name을 써준다.
		System.out.println(h1.getMessage());
		
		Hello h2=app1.getBean("hello", Hello.class); //방법2
		System.out.println(h2.getMessage());
		
		//spring에서는 기본이 singleton(싱글톤) : 메모리 주소값을 동일한 것을 사용한다.  cf_자바는 다른 걸 사용
		System.out.println(h1==h2);  //스프링에서는 new객체 생성해도, 기본이 싱글톤이기에 true가 나오는 것 (주소값 같은 걸 사용하기 때문)
	}

}
