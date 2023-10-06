package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	
	//@GetMapping("/apple/list.do") //list 뒤에 '.do'나 '다른 확장자'를 붙이면 그것만 호출된다.
	@GetMapping("/apple/list")  //list 뒤에 아무것도 붙지 않으면 모두 호출된다.
	public String result1(Model model)
	{
		model.addAttribute("myname", "이수연");
		model.addAttribute("myaddr", "강남구 역삼동");
		return "result1";
	}

	@GetMapping("/banana/insert")
	public ModelAndView banana()
	{
		//ModelAndView는 request에 저장하기 위한 Model과 포워드하기 위한 View를 합쳐놓은 클래스이다.
		//위에서 ModelAndView를 만들어주기 때문에 아래 해당문장에서 객체를 생성해주는 것이다
		ModelAndView mview=new ModelAndView();
		
		//request에 저장
		mview.addObject("java", 88);
		mview.addObject("spring", 99);
		
		//포워드할 jsp 파일 지정
		mview.setViewName("result2");
		
		return mview;
	}
	
	@GetMapping("/orange/delete")
	public ModelAndView orange()
	{
		
		ModelAndView oview=new ModelAndView();
		
		oview.addObject("sname", "가디건");
		oview.addObject("sprice", 59000);
		oview.addObject("scolor", "pink");
		
		oview.setViewName("result3");
		
		return oview;
	}
	
	@GetMapping("/shop/detail")
	public String resImage()
	{
		return "result4";
	}
	
	@GetMapping("/board/insert/data")
	public String webImage()
	{
		return "result5";
	}
}
