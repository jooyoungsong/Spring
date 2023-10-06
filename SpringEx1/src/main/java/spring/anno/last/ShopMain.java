package spring.anno.last;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext anno1= new ClassPathXmlApplicationContext("annoContext4.xml");
		
		JumunController jumun=(JumunController)anno1.getBean("jumunController"); //component �̸� ���� ���ؼ� �� �ҹ��� �ٲ��� Ŭ������ ��������
		
		jumun.insertJumun("�䰡��Ʈ", 35000, "red");
		jumun.deleteJumun("2");
		jumun.selectJumun("�Ʒ�", 45000, "black");
	}

}