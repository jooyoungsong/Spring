package spring.di.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex3Main {

	public static void main(String[] args) {
		// �ش� �����̸� SawonMain���� �ߴµ� ���� Ex3Main���� ������ ����ϱ�
		ApplicationContext app=new ClassPathXmlApplicationContext("appContext3.xml");
		
		Sawon sw=app.getBean("sawon", Sawon.class);
		sw.writedata();
		
		
	}

}
