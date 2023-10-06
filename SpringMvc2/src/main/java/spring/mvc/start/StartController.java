package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping; //�̰� �ٸ� �е��� �� ��������...���� ����...

@Controller //������ Component �ƴϰ� Controller ���ž�!!(������ mvc ���� ����)
public class StartController {

	//���� �ִ� homeController ���� �� ���� ������� ������!
	//start.jsp�� ���� ���� �޼��� �����ϱ�(=������)
	
	@GetMapping("/")
	public String start(Model model)   //string�� �������� ��ɸ� �ȴ�.
	{
		//Model: request�� �����͸� �����ϱ� ���� �������̽�
		//�������� �ϴ� request.setAttribute�� ����		
		model.addAttribute("name", "�迵ȯ");
		model.addAttribute("addr","����� ������");
		return "start";  //WEB-INF/day1005/start.jsp�� �ǹ���
	}
}


