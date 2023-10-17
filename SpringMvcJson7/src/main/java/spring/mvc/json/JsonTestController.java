package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //일반적인 컨트럴 일 때 map에 저장한 걸 보고 싶을 때 사용!
public class JsonTestController {

	@GetMapping("/list1")
	@ResponseBody//json으로 처리한 후 browser에 출력(일반 컨트롤러일 경우)
	
	//list와 map이 비슷해서 지금은 그냥 map으로 테스트 해보는 거야
	//아래처럼 쓰게 되면 브라우저에서 확인해봐! 패키지에서 크롬 열고 마지막 주소에 /list1만 적어줘! 그럼 아래 정보 나오는 걸 확인 가능
	
	public Map<String, String> list1()
	{
		Map<String, String> map=new HashMap<String, String>();
		//map은 인터페이스라서 구현이 안 되기에, 구현되게 해주려면 map의 종류인 hashmap을 써줘야지 구현이 된다.
		 
		map.put("name", "장순영");
		map.put("hp", "010-222-3333");
		map.put("addr", "수원시 장안구");
		
		return map;
	}
	
	
	//dto형식으로 담음(왜? 여러개 출력하려고_위와 비교하면 위에는 1개의 데이터만 담을 때, 지금은 여러개 데이터 담을 때)
	@GetMapping("/list3")  //@GetMapping("/list3") 다음에 @ResponseBody 써도 되고, 아니면 지금 이것처럼 가운데 써줘도 된다
	public @ResponseBody List<PhotoDto> list3()
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>(); //arraylist는 배열 +추가 -삭제가 자유롭기에 이걸 사용!
		
		list.add(new PhotoDto("개발자", "boy1.png"));  //list는 같은 형식만 추가할 수 있다. ex. string이면 string만
		list.add(new PhotoDto("미용사", "boy2.png"));  
		list.add(new PhotoDto("대학생", "boy3.png"));  
		list.add(new PhotoDto("어린이", "boy4.png"));  
		list.add(new PhotoDto("의사", "boy5.png"));  
		
		return list;
	}
}
