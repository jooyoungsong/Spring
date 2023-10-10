package spring.mvc.samsung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller  //�� ����ϱ�
//@RequestMapping("/board")  //�Ʒ����� ��� board��� �߰���� ��ߵǴ� �� �����ٸ� ���� requestmapping�� ���� �ȴ�. �׷� �Ʒ����� board �����൵ �ȴ�
public class BoardController {

	@GetMapping("/board/form1") // board(�߰����)/form1�� �ص� �ȴ�
	public String form1()  //forward�� �ҰŸ� string ���� �ž�
	{
		return "board/writeForm"; 
		//servlet���Ͽ� <beans:property name="prefix" value="/WEB-INF/" /> "Web-inf �ڿ� "/" �پ��־ board�� ���� , /board�� �ϸ� �ȵ�
	}
	
	@PostMapping("/board/process")  //writeform ���Ͽ��� form�̸��� process�� ���� ��
	public ModelAndView process1(@RequestParam String name,
			@RequestParam String date,
			@RequestParam String gender,
			/*@RequestParam(defaultValue = "�ູ�� �Ϸ� �Ǽ���") String msg*/
			@RequestParam(required = false) String msg, 			
			//form ��ü�� msg ��������, ���⼭ �����ذž�!, defualtValue���� required=false�� ���൵ �ȴ�.
			//required=true�� �⺻��, �׸��� ��� ������ �ȳ��� �Ϸ��� false�� �ϴ� ��!
			@RequestParam(defaultValue = "1") int currentPage) 
			
	{
		ModelAndView model=new ModelAndView();
	
		model.addObject("name", name);		
		model.addObject("date", date);		
		model.addObject("gender", gender);
		model.addObject("msg", msg);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("board/result"); // ��ȣ�ȿ� ������/���ϸ����� ����  �״����� result ���� ���� �Է��ϱ�
		
		return model;
	}
	
	@GetMapping("/board/result2")
	public String result2(Model model)
	{
		model.addAttribute("myimg1", "../image/free-icon-boy-3667172.png");
		model.addAttribute("title","�����ϴ� ������");
		return "board/result2";  //���� result2���Ϸ� �Ѿ����!
	}
}
