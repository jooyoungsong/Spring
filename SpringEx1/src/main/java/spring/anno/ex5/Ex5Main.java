package spring.anno.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex5Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		//KoreaFruit.java에서 Component(이름) 가져오기 : 이름 그대로 가져옴
		Fruit fruit=(KoreaFruit)app.getBean("kfruit");
		fruit.writeFruitName();
		
		//MyFruit.java에서 Component 가져오기 : 파일명에서 앞에만 소문자로 바꾸고 가져옴
		MyFruit myfruit=(MyFruit)app.getBean("myFruit");
		myfruit.writeFruit();
	}

}
