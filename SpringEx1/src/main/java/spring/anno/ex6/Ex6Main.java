package spring.anno.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex6Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		MysqlController mc=(MysqlController)app.getBean("mc");
		mc.myinsert("全己版");
		mc.mydelete("3");
		mc.myselect("价林康");
	}

}
