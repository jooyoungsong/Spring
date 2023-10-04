package spring.di.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {

	public static void main(String[] args) {
		// �ڹ� �� �� �ϰ� �ٷ� ������ �غ��Կ�
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext2.xml");
		
		//Myinfo���� �� Ȯ��
		Myinfo my=(Myinfo)context.getBean("my");
		
		System.out.println(my.toString());
		System.out.println(my); //���� ����� �����ϰ� ��µ�
		
		//Person�� �ִ� �޼ҵ� ����غ�����
		Person p=(Person)context.getBean("person");
		p.writeData();
	}

}
