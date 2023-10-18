package answer.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnswerController {
	
	@Autowired
	AnswerDao adao;
	
	@PostMapping("/board/ainsert")
	public String answerinsert(
			@ModelAttribute AnswerDto dto,
			@RequestParam String currentPage)
	{
		//db추가
		adao.insertAnswer(dto);
		
		return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;  //currentPage 넘길 때 항상 num과 currentPage을 같이 넘겼으니깐 이렇게 작성(어떤 글인지 알려주기 위해 같이 넘겨준다)
	}
	
}
