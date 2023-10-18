package board.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import answer.data.AnswerDao;
import answer.data.AnswerDto;
import spring.mvc.reboard.BoardDaoInter;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardContentController {

	
	@Autowired
	BoardDaoInter inter;
	
	@Autowired
	AnswerDao adao;
	
	@GetMapping("/board/content")
	public ModelAndView getdataReboard(int num,int currentPage)
	{
		ModelAndView model = new ModelAndView();

		//조회수 증가
		inter.updateReadcount(num);
		//dto
		BoardDto dto = inter.getDataReboard(num);
		
		//day1018
		//num에 해당하는 댓글을 db에서 가져와서 보낸다 
		List<AnswerDto> alist=adao.getAnswerList(num);
		
		//day1018
		//값이 있을때만 넘겨야 하므로
		model.addObject("acount", alist.size());  //alist.size() 는 댓글 갯수를 의미함
		model.addObject("alist", alist);
		
		//
		model.addObject("dto", dto);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("reboard/content");   //boardlist에 써놓은 주소대로 매핑주소 쓰면 된다.
		
		return model;
		
	}
}
