package spring.anno.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mc")
public class MysqlController {

	@Autowired
	TestDao tdao;
	
		public void myinsert(String irum)
		{
			tdao.insert(irum);	
		}
		
		public void mydelete(String no)
		{
			tdao.delete(no);
		}
		
		public void myselect(String irum)
		{
			tdao.select(irum);
		}
}
