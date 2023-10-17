package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//����� ���� ajax�� �ϴϱ� �̷��� JsonTest2Controller���� �ϴ� ������ �ϸ� �ȴ�.
@RestController  //������ ajax���� ���� repository��� �����ϸ� �ȴ�. //@Controller+@ResponseBody =@REstController


public class JsonTest2Controller {

	@GetMapping("/list2")
	public Map<String, String> list2()
	{
		Map<String, String> map =new HashMap<String, String>();
		
		map.put("sang", "�䰡��Ʈ");
		map.put("price", "23000");
		map.put("color", "ȭ��Ʈ");
		
		return map;		
	}
	
	/////ex4 �غ��Կ�!
	//(dto�� ������ ��ü �߿� 1���� ��Ƽ� ����� �Ŷ�. list���� dto(�迭�̶�) ��� ���� �ϳ� ����̴ϱ� map�� ���, �׸��� map ����ϸ� ��ü ��������� ��_�ű⿡ list�� �������� �ʴ� �� ����)
	@GetMapping("/list4")
	public Map<String, Object> list4(@RequestParam String name)//Ű���� �Ѱܾ� �� //���ڿ� ���ڰ� ���� ���� �� string ��� object ����Ѵ�
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>(); //arraylist�� �迭 +�߰� -������ �����ӱ⿡ �̰� ���!
		
		list.add(new PhotoDto("������", "boy1.png"));  //list�� ���� ���ĸ� �߰��� �� �ִ�. ex. string�̸� string��
		list.add(new PhotoDto("�̿��", "boy2.png"));  
		list.add(new PhotoDto("���л�", "boy3.png"));  
		list.add(new PhotoDto("���", "boy4.png"));  
		list.add(new PhotoDto("�ǻ�", "boy5.png"));  
	
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "�������� �ʴ� ����");
		map.put("photo", "boy6.png");
		
		for(PhotoDto dto:list)
		{
			if(name.equals(dto.getName()))
			{
				map.put("name", dto.getName());
				map.put("photo", dto.getPhoto());
			}
		}
		
		return map;
	
		//�ش� ó�� �� �ٽ� ex4������ ����.
	}
	
}
