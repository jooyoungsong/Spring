package board.data.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardDeleteController {

	@Autowired
	BoardDao dao;
	
	//비밀번호 삭제
	@GetMapping("/board/deletepassform")
	public ModelAndView dpassform(
			@RequestParam String num,
			@RequestParam String currentPage)
	{
		ModelAndView model=new ModelAndView();
		model.addObject("num", num);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("reboard/delpassform");
		return model;
	}
	
	//게시판 글 삭제
	@PostMapping("/board/deletepass")
	public String delteReboard(int num,int pass,
			@RequestParam String currentPage,
			HttpSession session)
	{
		 //실제경로
		   String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		   System.out.println(path);
		
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		   
		   String photo="";
		
		//비밀번호 체크
		int passcheck=dao.getCheckPass(num, pass);
		
		if(passcheck==1)
		{	
			 //수정 전에 이전 사진 지우기
			  String pre_photo=dao.getDataReboard(num).getPhoto();
			   
			   String []pre_fName=pre_photo.split(",");
			   for(String f:pre_fName)
			   {
				   File file=new File(path+"\\"+f);
				   file.delete();
			   }
			  
			dao.deleteReboard(num);
			return "redirect:list";
				
		} else {
			
			return "reboard/passfail";
		}
		
		
	}
}
