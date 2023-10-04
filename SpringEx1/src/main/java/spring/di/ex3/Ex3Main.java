package spring.di.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex3Main {

	public static void main(String[] args) {
		// 해당 파일이름 SawonMain으로 했는데 나만 Ex3Main으로 저장함 기억하기
		ApplicationContext app=new ClassPathXmlApplicationContext("appContext3.xml");
		
		Sawon sw=app.getBean("sawon", Sawon.class);
		sw.writedata();
		
		
	}

}
