package spring.mvc.joo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.FormDto;

@Controller
public class FormController {

	//myforms가 나오게 포워드할 것!!!
	@GetMapping("/data/myform")
	public String myform()
	{
		return "myforms";
	}
	
	//매핑하는 방법 3가지 알아봄_get방식/post(dto,map)방식
	
	//read1_get방식폼 전송
	//모델과 전송을 위한 게 modelandview이다. (view는 전송 위한 것)
	@GetMapping("/data/read1")
	public ModelAndView read1(String myname, int myage,
			@RequestParam(value = "msg",defaultValue = "HappyDay!!!") String msg) //myforms파일에 name 준 거 확인해보기
	{
		ModelAndView mview=new ModelAndView();
		
		//request에 저장
		mview.addObject("name", myname);  //myforms파일에서 name값을 myname을 가져와서 써야하는 데, 내가 name으로 정의하고 싶어서 위에 @requestparam으로 수정해줌
		mview.addObject("age", myage);  //myage를 age로 바꾸고 싶으면 이렇게 적으면 된다.
		mview.addObject("msg", msg);
		
		//포워드
		mview.setViewName("process1");
		return mview;
	}
	
	
	//dto로 읽는 방법
	@PostMapping("/data/read2")
	public ModelAndView read(@ModelAttribute FormDto dto)
	{
		ModelAndView model=new ModelAndView();
	
		model.addObject("dto", dto);
		model.setViewName("process2");
		
		return model;
	}
	
	//맵으로 읽는 방법은 dto로 읽지 않겠다는 거야!!
	@PostMapping("/data/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
	
		//map으로 모든 키 값을 얻을 수 있다
		String sang=map.get("sang");  //string 쓰는 이유 _아래 data가 스트링이라서~?
		String price=map.get("price");
		
		String data=sang+"의 가격은 "+price+"입니다";
		
		model.addObject("data", data);  //오른쪽 data값이 string이어서 string으로 넘겨줌
		model.setViewName("process3");
		
		
		return model;
	}
}
