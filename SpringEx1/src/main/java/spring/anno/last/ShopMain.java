package spring.anno.last;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext anno1= new ClassPathXmlApplicationContext("annoContext4.xml");
		
		JumunController jumun=(JumunController)anno1.getBean("jumunController"); //component 이름 정의 안해서 앞 소문자 바꾼후 클래스명 가져오기
		
		jumun.insertJumun("요가매트", 35000, "red");
		jumun.deleteJumun("2");
		jumun.selectJumun("아령", 45000, "black");
	}

}
