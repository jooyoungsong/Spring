package spring.mvc.friday;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InfoController {
	
	@Autowired //객체 생성하는 거
	InfoDao dao; //인터페이스로 해도 되고, dao로 해도 된다.
	
	////count
	@GetMapping("/info/list")
	public String getTotalCount(Model model)
	{
		List<InfoDto> list=dao.getAllInfos();
		
		model.addAttribute("count",dao.getTotalCount());
		model.addAttribute("list",list);
		
		return "Info/infolist";
	}
	
	////insert
	@GetMapping("/info/addform")
	public String form()
	{
		return "Info/addform";
	}

	@PostMapping("/info/insert")
	public String insert(@ModelAttribute InfoDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session)  //마지막 준 건 real path 때문에 준다
	{
		String path=session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		//사진 선택 안 했을 경우 no...
		if(upload.getOriginalFilename().equals(""))
			photo="no";
		else {
		
			String fName=upload.getOriginalFilename();
			fName=sdf.format(new Date())+"_"+fName;
			photo=fName;
			

			//업로드
			try {
				upload.transferTo(new File(path+"/"+photo));  //transferTo 실제 파일경로를 올리는 것! 
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		//dto의 photo에 넣기
		dto.setPhoto(photo);
		
		//insert
		dao.insertMyinfo(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/info/uform")
	public String uform(@RequestParam String num, Model model)
	{
		InfoDto dto=dao.getData(num);
		
		model.addAttribute("dto", dto);
		
		return "Info/updateform";
	}
	
	@PostMapping("/info/update")  //insert랑 완전 비슷해서 복사해서 바꾸면 좋아요
	public String update(@ModelAttribute InfoDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session)
	{
		String path=session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photoname;//dto에 담을 변수
		
		/*사진 선택 안 할 경우 null
		이라고 하기로 했음*/
		if(upload.getOriginalFilename().equals(""))
			photoname=null;
		else {
			photoname=upload.getOriginalFilename();
			photoname=sdf.format(new Date())+"_"+photoname;
			
			//업로드
			try {
				upload.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//dto에서 photo에 업로드한 photoname 넣어주기
		dto.setPhoto(photoname);
		
		//update
		dao.updateMyInfo(dto);
		
		return "redirect:list";
	}
	
	
	//delete
	@GetMapping("/info/delete") //가상경로는 버튼에 내가 임의로 만든 이름 그대로 가져다 쓰는 것!
	public String delete(
			@RequestParam String num, HttpSession session)
	{
		String photo=dao.getData(num).getPhoto();   //해당 넘버의 포토 가져오고 싶으면 dao에서 data 불러와서 photo를 부른다
		
		if(!photo.equals("no"))  //photo에 no라고 적은 걸 제외하고 다 삭제하려고 함
		{
			//그러려면 제일 먼저 real path 먼저 해야한다.
			String path=session.getServletContext().getRealPath("/resources/image/");
			
			File file=new File(path+"\\"+photo);
			file.delete();
		}
		
		//db삭제
		//이건 파일 삭제가 아니라 db 삭제임
		dao.deleteInfo(num);
		
		return "redirect:list";
	}
}
