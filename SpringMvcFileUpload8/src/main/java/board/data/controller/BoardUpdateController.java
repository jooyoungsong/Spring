package board.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardUpdateController {

	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/updatepassform")
	public ModelAndView upassform(
			@RequestParam String num,
			@RequestParam  String currentPage)
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("num", num);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("reboard/updatepassform");
		return model;
	}
	
	//비번 체크
	@PostMapping("/board/updatepass")
	public ModelAndView updatepass(@RequestParam int num,
			@RequestParam int pass,
			@RequestParam int currentPage)
	{
		ModelAndView model = new ModelAndView();
		
		BoardDto dto=dao.getDataReboard(num);  //updateform의 값을 써주기 위해 dto에 num을 받아와야 해서 써준 것!
		
		//비번이 맞으면 수정폼(updateform)으로, 다르면 passfail로 이동하게 하기
		int check=dao.getCheckPass(num, pass);
	
		if(check==1)
		{
			model.addObject("dto", dto); //updateform의 값을 써주기 위해 num을 넘겨받아서 getdata를 사용해 dto의 값을 넣어줌
			model.addObject("currentPage", currentPage);
			model.setViewName("reboard/updateform");
		}else { //0이면(일치하는 게 없다면)
			model.setViewName("reboard/passfail");
		}
		
		return model;
	}
	
	//디테일페이지 수정
	@PostMapping("/board/update")
	public String updatedetail(BoardDto dto,
			@RequestParam String currentPage,
			@RequestParam ArrayList<MultipartFile> uimage,  //form에 있는 name인 uimage로 쓰는 것이다.
			HttpSession session)
	{
		
		 //실제경로
		   String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		   System.out.println(path);
		
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		   
		   String photo="";
		   
		   if(uimage.get(0).getOriginalFilename().equals(""))
			   photo="no";
		   else {
			   
			   //수정 전에 이전 사진 지우기
			   String pre_photo=dao.getDataReboard(dto.getNum()).getPhoto();
			   
			   String []pre_fName=pre_photo.split(",");
			   for(String f:pre_fName)
			   {
				   File file=new File(path+"\\"+f);
				   file.delete();
			   }
			   
			   for(MultipartFile f:uimage)
			   {
				   //String fName=f.getOriginalFilename();
				   String fName=sdf.format(new Date())+"_"+f.getOriginalFilename();
				   photo+=fName+",";
				   
				   try {
					f.transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  //try-catch문 해야함
				   
				   
			   }
			   
			 //photo에서 마지막 컴마(,) 제거
			   photo=photo.substring(0,photo.length()-1);
			   
		   }
		   
		   //dto의 photo에 넣기
		   dto.setPhoto(photo);
		   
		   //update
		   dao.updateDetail(dto);
		
		   
		//수정 후 내용보기로...
		return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;  //controller면 다 가능
	}
}
