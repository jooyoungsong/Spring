package spring.mvc.joo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String start()
	{
		//return "redirect:login/form";  // redirect의 의미 => return "form"과 마찬가지임
		return "start"; // start폴더 만들어주고 나서 바꾼 것
	}
	
	@GetMapping("/login/form")
	public String form()
	{
		return "form";
	}
	
	@GetMapping("/login/read")
	public String process(Model model,@RequestParam(value = "myid") String id,
			@RequestParam(value = "mypass") String pass)  
		//위 문장: myid로 받은 아이를 string id로 하겠다  이렇게 적어도 되고 @requestParam 안 쓰고(생략가능) string my id만 적어도 가능
		//위 문장: public String process(Model model,String myid,
		//@RequestParam(value = "mypass") String pass) 로 적어도 같은 문장임!
	
	{
		
		model.addAttribute("id", id);
		String msg="";
		
		if(pass.equals("1234"))
			msg="로그인 성공!!!";
		else
			msg="로그인 실패!!!";
		
		model.addAttribute("msg",msg);
		
		return "result";
	}
}
