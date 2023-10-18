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

		//��ȸ�� ����
		inter.updateReadcount(num);
		//dto
		BoardDto dto = inter.getDataReboard(num);
		
		//day1018
		//num�� �ش��ϴ� ����� db���� �����ͼ� ������ 
		List<AnswerDto> alist=adao.getAnswerList(num);
		
		//day1018
		//���� �������� �Ѱܾ� �ϹǷ�
		model.addObject("acount", alist.size());  //alist.size() �� ��� ������ �ǹ���
		model.addObject("alist", alist);
		
		//
		model.addObject("dto", dto);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("reboard/content");   //boardlist�� ����� �ּҴ�� �����ּ� ���� �ȴ�.
		
		return model;
		
	}
}
