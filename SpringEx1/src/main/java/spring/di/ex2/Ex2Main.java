package spring.di.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {

	public static void main(String[] args) {
		// 자바 비교 안 하고 바로 스프링 해볼게요
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext2.xml");
		
		//Myinfo생성 후 확인
		Myinfo my=(Myinfo)context.getBean("my");
		
		System.out.println(my.toString());
		System.out.println(my); //위에 문장과 동일하게 출력됨
		
		//Person에 있는 메소드 출력해보세요
		Person p=(Person)context.getBean("person");
		p.writeData();
	}

}
