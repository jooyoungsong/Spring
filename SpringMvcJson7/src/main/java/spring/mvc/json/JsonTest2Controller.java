package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//댓글은 거의 ajax로 하니깐 이렇게 JsonTest2Controller에서 하는 식으로 하면 된다.
@RestController  //오로지 ajax만을 위한 repository라고 생각하면 된다. //@Controller+@ResponseBody =@REstController


public class JsonTest2Controller {

	@GetMapping("/list2")
	public Map<String, String> list2()
	{
		Map<String, String> map =new HashMap<String, String>();
		
		map.put("sang", "요가매트");
		map.put("price", "23000");
		map.put("color", "화이트");
		
		return map;		
	}
	
	/////ex4 해볼게요!
	//(dto로 여러개 객체 중에 1개를 담아서 출력할 거라. list에는 dto(배열이라) 담고 그중 하나 출력이니깐 map을 사용, 그리고 map 사용하면 객체 생성해줘야 함_거기에 list에 존재하지 않는 걸 써줌)
	@GetMapping("/list4")
	public Map<String, Object> list4(@RequestParam String name)//키값을 넘겨야 됨 //숫자와 문자가 섞여 있을 때 string 대신 object 사용한다
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>(); //arraylist는 배열 +추가 -삭제가 자유롭기에 이걸 사용!
		
		list.add(new PhotoDto("개발자", "boy1.png"));  //list는 같은 형식만 추가할 수 있다. ex. string이면 string만
		list.add(new PhotoDto("미용사", "boy2.png"));  
		list.add(new PhotoDto("대학생", "boy3.png"));  
		list.add(new PhotoDto("어린이", "boy4.png"));  
		list.add(new PhotoDto("의사", "boy5.png"));  
	
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "존재하지 않는 직업");
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
	
		//해당 처리 후 다시 ex4폴더로 간다.
	}
	
}
