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

	@Autowired  //MyCarDao dao=new MyCardao();�ε� spring������ ���� ������ �ʿ���� @Autowired�� ����ϸ� �ȴ�.
	MyCarDao dao;
	
	@GetMapping("/kakao/list")
	public String list(Model model)
	{
		//dao�κ��� �Ѱ��� ��������
		int totalCount=dao.getTotalCount();
		
		//��� ��������
		List<MyCarDto> list=dao.getAllcars();
		
		//request�� �����ϱ�
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
	
	
	//////////////////����
	@PostMapping("/kakao/write")
	public String insert(MyCarDto dto)   //public String insert(@ModelAttribute("dto") MyCarDto dto)�� �ϴµ� modelattribute ���� ����
	{	
		dao.insertCar(dto);
		return "redirect:list";
	}
	
	@GetMapping("/kakao/delete")  //carlist���� ������ư onclick�� delete�� �ؼ� ��ȣ�� kakao/delete�� ���� ��
	//PostMapping�� �ƴ� GetMapping�� ���� ���� carlist���� ������ư onclick�� delete?num=${num}���� �Ǵϱ� �ּҰ� �����ݾ�. �׷� get����� �ž�!
	public String delete(String num)
	{
		dao.deleteCar(num);
		
		return "redirect:list";
	}
	
	/////////////////////������Ʈ
	@GetMapping("/kakao/updateform")  //������ư�� updateform�̾���
	public ModelAndView getData(String num)
	{
		ModelAndView model=new ModelAndView();
		
		MyCarDto dto=dao.getDataOfMyCar(num);
		
		model.addObject("dto", dto);
		
		model.setViewName("car/updatform");
		
		return model;
	}
	
	@PostMapping("/kakao/update") //upadateform���Ͽ� form action�� update����
	public String update(@ModelAttribute MyCarDto dto)
	{
		dao.updateCar(dto);
		
		return "redirect:list";  //������ ����� ó�� list�� ���� list�� return���� carlist�� ���� ��.
	}
}
