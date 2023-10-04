package spring.anno.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic") //id가 logic이 된다
public class LogicController {
  
	//DaoInter,MyDao를 구현하기 위한 클래스 하나 더 생성하기 위해 LogicController.java 생성
	 @Autowired
	 //정확한 빈의 아이디를 주입하고 할 때는 _ 모호성이 있는 경우에는 @Resource(name="정확한이름적기_ex.myDao")로 해준다.
	DaoInter daoInter; //자동 주입 받는 걸 보여주기 위해 이렇게 해놓은 것
	
	public LogicController(MyDao dao) {
		// TODO Auto-generated constructor stub
		 
		 this.daoInter=dao;
	 }
	 
	 //insert
	 public void insert(String str)
	 {
		 daoInter.insertData(str);
	 }
	 
	 //delete
	 public void delete(String num)
	 {
		 daoInter.deleteData(num);
	 }
	 
}
	
