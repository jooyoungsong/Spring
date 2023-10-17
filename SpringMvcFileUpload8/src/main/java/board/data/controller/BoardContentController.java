package board.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDaoInter;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardContentController {

	
	@Autowired
	BoardDaoInter inter;
	
	@GetMapping("/board/content")
	public ModelAndView getdataReboard(int num,int currentPage)
	{
		ModelAndView model = new ModelAndView();

		//조회수 증가
		inter.updateReadcount(num);
		//dto
		BoardDto dto = inter.getDataReboard(num);
		
		model.addObject("dto", dto);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("reboard/content");   //boardlist에 써놓은 주소대로 매핑주소 쓰면 된다.
		
		return model;
		
	}
}
