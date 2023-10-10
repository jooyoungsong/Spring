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
		//return "redirect:login/form";  // redirect�� �ǹ� => return "form"�� ����������
		return "start"; // start���� ������ְ� ���� �ٲ� ��
	}
	
	@GetMapping("/login/form")
	public String form()
	{
		return "form";
	}
	
	@GetMapping("/login/read")
	public String process(Model model,@RequestParam(value = "myid") String id,
			@RequestParam(value = "mypass") String pass)  
		//�� ����: myid�� ���� ���̸� string id�� �ϰڴ�  �̷��� ��� �ǰ� @requestParam �� ����(��������) string my id�� ��� ����
		//�� ����: public String process(Model model,String myid,
		//@RequestParam(value = "mypass") String pass) �� ��� ���� ������!
	
	{
		
		model.addAttribute("id", id);
		String msg="";
		
		if(pass.equals("1234"))
			msg="�α��� ����!!!";
		else
			msg="�α��� ����!!!";
		
		model.addAttribute("msg",msg);
		
		return "result";
	}
}
