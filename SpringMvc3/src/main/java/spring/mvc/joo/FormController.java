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

	//myforms�� ������ �������� ��!!!
	@GetMapping("/data/myform")
	public String myform()
	{
		return "myforms";
	}
	
	//�����ϴ� ��� 3���� �˾ƺ�_get���/post(dto,map)���
	
	//read1_get����� ����
	//�𵨰� ������ ���� �� modelandview�̴�. (view�� ���� ���� ��)
	@GetMapping("/data/read1")
	public ModelAndView read1(String myname, int myage,
			@RequestParam(value = "msg",defaultValue = "HappyDay!!!") String msg) //myforms���Ͽ� name �� �� Ȯ���غ���
	{
		ModelAndView mview=new ModelAndView();
		
		//request�� ����
		mview.addObject("name", myname);  //myforms���Ͽ��� name���� myname�� �����ͼ� ����ϴ� ��, ���� name���� �����ϰ� �; ���� @requestparam���� ��������
		mview.addObject("age", myage);  //myage�� age�� �ٲٰ� ������ �̷��� ������ �ȴ�.
		mview.addObject("msg", msg);
		
		//������
		mview.setViewName("process1");
		return mview;
	}
	
	
	//dto�� �д� ���
	@PostMapping("/data/read2")
	public ModelAndView read(@ModelAttribute FormDto dto)
	{
		ModelAndView model=new ModelAndView();
	
		model.addObject("dto", dto);
		model.setViewName("process2");
		
		return model;
	}
	
	//������ �д� ����� dto�� ���� �ʰڴٴ� �ž�!!
	@PostMapping("/data/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
	
		//map���� ��� Ű ���� ���� �� �ִ�
		String sang=map.get("sang");  //string ���� ���� _�Ʒ� data�� ��Ʈ���̶�~?
		String price=map.get("price");
		
		String data=sang+"�� ������ "+price+"�Դϴ�";
		
		model.addObject("data", data);  //������ data���� string�̾ string���� �Ѱ���
		model.setViewName("process3");
		
		
		return model;
	}
}
