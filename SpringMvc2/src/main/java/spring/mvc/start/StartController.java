package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping; //이거 다른 분들은 안 나오던데...나만 나옴...

@Controller //이제는 Component 아니고 Controller 쓸거야!!(스프링 mvc 배우는 과정)
public class StartController {

	//원래 있던 homeController 삭제 후 새로 만들어준 파일임!
	//start.jsp로 가기 위한 메서드 생성하기(=포워드)
	
	@GetMapping("/")
	public String start(Model model)   //string은 포워드의 기능만 된다.
	{
		//Model: request에 데이터를 저장하기 위한 인터페이스
		//서블릿에서 하던 request.setAttribute와 같다		
		model.addAttribute("name", "김영환");
		model.addAttribute("addr","서울시 강남구");
		return "start";  //WEB-INF/day1005/start.jsp를 의미함
	}
}


