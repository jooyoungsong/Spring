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
	CarMemberInter inter;    //dao �޾Ƶ� �ǰ� interface�� �޾Ƶ� �ȴ�
	
	@GetMapping("/member/list")
	public String memberStart(Model model)
	{
		//���� �������� _O���� ����� �ֽ��ϴ�.
		int count=inter.getTotalCount();
		
		//select
		List<CarMemberDto> list=inter.selectCarMember();
		
		//request�� ����
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		return "carmember/memberlist";
	}
	
	/////////////////
	@GetMapping("/member/add")  //memberlist�� onclick���� add�� ������
	public String carMemberForm()
	{
		return "carmember/addform";
	}
	
	@PostMapping("/member/write")  //addform�� form action���� write�� ������
	public String memberInsert(CarMemberDto dto)  //(@ModelAttribute CarMemberDto dto)�� �ᵵ �ǰ� �𵨾�Ʈ����Ʈ ������ ����
	{
		
		inter.insert(dto);  //interface�� �������� ��. (������ �������̽� �����߰�, �������̽����� �̹� dto�� ��� ����)
		
		return "redirect:list";
	}
	
	///////////////////
	@GetMapping("/member/modify")
	public String memberGetData(int num,Model model)
	{
		CarMemberDto dto = inter.getData(num);     
		//dao���� return���� �־��� ������(���ϰ� �־ ���ϰ� �޾��شٴ� �ǹ�)
		//inter.getData(num);�� �ۼ� ���ϰ� CarMemberDto dto = inter.getData(num);�� �ۼ�����
		
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
