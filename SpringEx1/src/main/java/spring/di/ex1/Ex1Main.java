package spring.di.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//�ڹ� �������
		System.out.println("�ڹ�?");
		Messageinter m1=new Message1();
		m1.sayHello("�μ�");
		
		Messageinter m2=new Message2();
		m2.sayHello("����");
		
		//������ �������
		System.out.println("������?");
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext1.xml");
		
		Messageinter m3=(Message1)context.getBean("mesBean1");
		m3.sayHello("�α�");
		
		Messageinter m4=context.getBean("mesBean2", Message2.class); //�ι�°�� Ŭ������ ���� ��
		m4.sayHello("����");
	}

}