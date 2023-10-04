package framework.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///////////�ڹ�

		System.out.println("�ڹٹ������ hello�޼��� ȣ���ϱ�");
		
		Hello hello1=new Hello();
		System.out.println(hello1.getMessage());
		
		Hello hello2=new Hello();
		System.out.println(hello2.getMessage());
		
		System.out.println(hello1==hello2); //�ڹٿ����� new��ü �����ϸ�, �ּҰ��� �ٸ��⿡ false�� ���´ٴ� �� �˱� ���� �غ�
		
		
		///////////������
		
		System.out.println("������������� hello�޼��� ȣ���ϱ�");
		//xml���� ��������...������ ���� ��, web.xml�� ������ �Ǿ������Ƿ� �ʿ����
		
		ApplicationContext app1=new ClassPathXmlApplicationContext("helloContext.xml");
		
		//hello ��ü ����
		Hello h1=(Hello)app1.getBean("hello"); // ���1_helloContext.xml���� bean������ name�� ���ش�.
		System.out.println(h1.getMessage());
		
		Hello h2=app1.getBean("hello", Hello.class); //���2
		System.out.println(h2.getMessage());
		
		//spring������ �⺻�� singleton(�̱���) : �޸� �ּҰ��� ������ ���� ����Ѵ�.  cf_�ڹٴ� �ٸ� �� ���
		System.out.println(h1==h2);  //������������ new��ü �����ص�, �⺻�� �̱����̱⿡ true�� ������ �� (�ּҰ� ���� �� ����ϱ� ����)
	}

}
