package spring.mvc.samsung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller  //빈 등록하기
//@RequestMapping("/board")  //아래에서 계속 board라는 중간경로 써야되는 게 귀찮다면 위에 requestmapping을 쓰면 된다. 그럼 아래에서 board 지워줘도 된다
public class BoardController {

	@GetMapping("/board/form1") // board(중간경로)/form1만 해도 된다
	public String form1()  //forward만 할거면 string 쓰는 거야
	{
		return "board/writeForm"; 
		//servlet파일에 <beans:property name="prefix" value="/WEB-INF/" /> "Web-inf 뒤에 "/" 붙어있어서 board로 시작 , /board로 하면 안됨
	}
	
	@PostMapping("/board/process")  //writeform 파일에서 form이름인 process를 써준 것
	public ModelAndView process1(@RequestParam String name,
			@RequestParam String date,
			@RequestParam String gender,
			/*@RequestParam(defaultValue = "행복한 하루 되세요") String msg*/
			@RequestParam(required = false) String msg, 			
			//form 자체에 msg 없었지만, 여기서 정해준거야!, defualtValue말고 required=false로 써줘도 된다.
			//required=true가 기본값, 항목이 없어도 에러가 안나게 하려면 false로 하는 것!
			@RequestParam(defaultValue = "1") int currentPage) 
			
	{
		ModelAndView model=new ModelAndView();
	
		model.addObject("name", name);		
		model.addObject("date", date);		
		model.addObject("gender", gender);
		model.addObject("msg", msg);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("board/result"); // 괄호안에 폴더명/파일명으로 쓰기  그다으에 result 들어가서 내용 입력하기
		
		return model;
	}
	
	@GetMapping("/board/result2")
	public String result2(Model model)
	{
		model.addAttribute("myimg1", "../image/free-icon-boy-3667172.png");
		model.addAttribute("title","좋아하는 아이콘");
		return "board/result2";  //이제 result2파일로 넘어가세요!
	}
}
