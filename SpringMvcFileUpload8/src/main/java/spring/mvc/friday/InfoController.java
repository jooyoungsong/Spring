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
	
	@Autowired //��ü �����ϴ� ��
	InfoDao dao; //�������̽��� �ص� �ǰ�, dao�� �ص� �ȴ�.
	
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
			HttpSession session)  //������ �� �� real path ������ �ش�
	{
		String path=session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		//���� ���� �� ���� ��� no...
		if(upload.getOriginalFilename().equals(""))
			photo="no";
		else {
		
			String fName=upload.getOriginalFilename();
			fName=sdf.format(new Date())+"_"+fName;
			photo=fName;
			

			//���ε�
			try {
				upload.transferTo(new File(path+"/"+photo));  //transferTo ���� ���ϰ�θ� �ø��� ��! 
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		//dto�� photo�� �ֱ�
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
	
	@PostMapping("/info/update")  //insert�� ���� ����ؼ� �����ؼ� �ٲٸ� ���ƿ�
	public String update(@ModelAttribute InfoDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session)
	{
		String path=session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photoname;//dto�� ���� ����
		
		/*���� ���� �� �� ��� null
		�̶�� �ϱ�� ����*/
		if(upload.getOriginalFilename().equals(""))
			photoname=null;
		else {
			photoname=upload.getOriginalFilename();
			photoname=sdf.format(new Date())+"_"+photoname;
			
			//���ε�
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
		
		//dto���� photo�� ���ε��� photoname �־��ֱ�
		dto.setPhoto(photoname);
		
		//update
		dao.updateMyInfo(dto);
		
		return "redirect:list";
	}
	
	
	//delete
	@GetMapping("/info/delete") //�����δ� ��ư�� ���� ���Ƿ� ���� �̸� �״�� ������ ���� ��!
	public String delete(
			@RequestParam String num, HttpSession session)
	{
		String photo=dao.getData(num).getPhoto();   //�ش� �ѹ��� ���� �������� ������ dao���� data �ҷ��ͼ� photo�� �θ���
		
		if(!photo.equals("no"))  //photo�� no��� ���� �� �����ϰ� �� �����Ϸ��� ��
		{
			//�׷����� ���� ���� real path ���� �ؾ��Ѵ�.
			String path=session.getServletContext().getRealPath("/resources/image/");
			
			File file=new File(path+"\\"+photo);
			file.delete();
		}
		
		//db����
		//�̰� ���� ������ �ƴ϶� db ������
		dao.deleteInfo(num);
		
		return "redirect:list";
	}
}
