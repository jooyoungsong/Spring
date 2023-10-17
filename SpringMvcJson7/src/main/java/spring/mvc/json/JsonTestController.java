package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //�Ϲ����� ��Ʈ�� �� �� map�� ������ �� ���� ���� �� ���!
public class JsonTestController {

	@GetMapping("/list1")
	@ResponseBody//json���� ó���� �� browser�� ���(�Ϲ� ��Ʈ�ѷ��� ���)
	
	//list�� map�� ����ؼ� ������ �׳� map���� �׽�Ʈ �غ��� �ž�
	//�Ʒ�ó�� ���� �Ǹ� ���������� Ȯ���غ�! ��Ű������ ũ�� ���� ������ �ּҿ� /list1�� ������! �׷� �Ʒ� ���� ������ �� Ȯ�� ����
	
	public Map<String, String> list1()
	{
		Map<String, String> map=new HashMap<String, String>();
		//map�� �������̽��� ������ �� �Ǳ⿡, �����ǰ� ���ַ��� map�� ������ hashmap�� ������� ������ �ȴ�.
		 
		map.put("name", "�����");
		map.put("hp", "010-222-3333");
		map.put("addr", "������ ��ȱ�");
		
		return map;
	}
	
	
	//dto�������� ����(��? ������ ����Ϸ���_���� ���ϸ� ������ 1���� �����͸� ���� ��, ������ ������ ������ ���� ��)
	@GetMapping("/list3")  //@GetMapping("/list3") ������ @ResponseBody �ᵵ �ǰ�, �ƴϸ� ���� �̰�ó�� ��� ���൵ �ȴ�
	public @ResponseBody List<PhotoDto> list3()
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>(); //arraylist�� �迭 +�߰� -������ �����ӱ⿡ �̰� ���!
		
		list.add(new PhotoDto("������", "boy1.png"));  //list�� ���� ���ĸ� �߰��� �� �ִ�. ex. string�̸� string��
		list.add(new PhotoDto("�̿��", "boy2.png"));  
		list.add(new PhotoDto("���л�", "boy3.png"));  
		list.add(new PhotoDto("���", "boy4.png"));  
		list.add(new PhotoDto("�ǻ�", "boy5.png"));  
		
		return list;
	}
}
