package spring.mysql.mycar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

	@Autowired  //MyCarDao dao=new MyCardao();인데 spring에서는 굳이 생성할 필요없이 @Autowired를 사용하면 된다.
	MyCarDao dao;
	
	@GetMapping("/kakao/list")
	public String list(Model model)
	{
		//dao로부터 총개수 가져오기
		int totalCount=dao.getTotalCount();
		
		//목록 가져오기
		List<MyCarDto> list=dao.getAllcars();
		
		//request에 저장하기
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		
		return "car/carlist";
	}
	
	/////////////////
	@GetMapping("/kakao/writeform")
	public String carform()
	{
		return "car/writeform";
	}
	
	
	//////////////////삭제
	@PostMapping("/kakao/write")
	public String insert(MyCarDto dto)   //public String insert(@ModelAttribute("dto") MyCarDto dto)로 하는데 modelattribute 생략 가능
	{	
		dao.insertCar(dto);
		return "redirect:list";
	}
	
	@GetMapping("/kakao/delete")  //carlist에서 삭제버튼 onclick에 delete로 해서 괄호에 kakao/delete로 써준 것
	//PostMapping이 아닌 GetMapping을 써준 것은 carlist에서 삭제버튼 onclick에 delete?num=${num}으로 되니깐 주소가 보이잖아. 그럼 get방식인 거야!
	public String delete(String num)
	{
		dao.deleteCar(num);
		
		return "redirect:list";
	}
	
	/////////////////////업데이트
	@GetMapping("/kakao/updateform")  //수정버튼이 updateform이었음
	public ModelAndView getData(String num)
	{
		ModelAndView model=new ModelAndView();
		
		MyCarDto dto=dao.getDataOfMyCar(num);
		
		model.addObject("dto", dto);
		
		model.setViewName("car/updatform");
		
		return model;
	}
	
	@PostMapping("/kakao/update") //upadateform파일에 form action이 update엿음
	public String update(@ModelAttribute MyCarDto dto)
	{
		dao.updateCar(dto);
		
		return "redirect:list";  //가상의 경로인 처음 list로 가서 list에 return값인 carlist로 가게 됨.
	}
}
