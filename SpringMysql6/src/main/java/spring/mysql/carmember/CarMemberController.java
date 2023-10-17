package spring.mysql.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarMemberController {

	@Autowired
	CarMemberInter inter;    //dao 받아도 되고 interface를 받아도 된다
	
	@GetMapping("/member/list")
	public String memberStart(Model model)
	{
		//개수 가져오기 _O개의 멤버가 있습니다.
		int count=inter.getTotalCount();
		
		//select
		List<CarMemberDto> list=inter.selectCarMember();
		
		//request에 저장
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		return "carmember/memberlist";
	}
	
	/////////////////
	@GetMapping("/member/add")  //memberlist의 onclick에서 add를 가져옴
	public String carMemberForm()
	{
		return "carmember/addform";
	}
	
	@PostMapping("/member/write")  //addform의 form action에서 write를 가져옴
	public String memberInsert(CarMemberDto dto)  //(@ModelAttribute CarMemberDto dto)로 써도 되고 모델어트리뷰트 생략도 가능
	{
		
		inter.insert(dto);  //interface를 가져오는 것. (위에서 인터페이스 정의했고, 인터페이스에서 이미 dto를 담고 있음)
		
		return "redirect:list";
	}
	
	///////////////////
	@GetMapping("/member/modify")
	public String memberGetData(int num,Model model)
	{
		CarMemberDto dto = inter.getData(num);     
		//dao에서 return값이 있었기 때문에(리턴값 있어서 리턴값 받아준다는 의미)
		//inter.getData(num);로 작성 안하고 CarMemberDto dto = inter.getData(num);로 작성해줌
		
		model.addAttribute("dto", dto);
		
		return "carmember/updateform";
	}
	
	@PostMapping("/member/update")
	public String memberUpdate(CarMemberDto dto)
	{
		inter.updateCarMember(dto);
		
		return "redirect:list";		
	}
	
	///////////////
	@GetMapping("/member/delete")
	public String memberDelete(int num)
	{
		inter.deleteCarMember(num);
		
		return "redirect:list";
	}
	
	
	
}
