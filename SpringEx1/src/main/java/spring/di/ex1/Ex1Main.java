package spring.di.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//자바 생성방식
		System.out.println("자바?");
		Messageinter m1=new Message1();
		m1.sayHello("민수");
		
		Messageinter m2=new Message2();
		m2.sayHello("영희");
		
		//스프링 생성방식
		System.out.println("스프링?");
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext1.xml");
		
		Messageinter m3=(Message1)context.getBean("mesBean1");
		m3.sayHello("민규");
		
		Messageinter m4=context.getBean("mesBean2", Message2.class); //두번째는 클래스명 쓰는 것
		m4.sayHello("성신");
	}

}
