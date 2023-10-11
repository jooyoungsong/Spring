package spring.mvc.tea;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.data.dto.ShopDto;

@Controller
@RequestMapping("/naver")
public class NaverController {
	
	@GetMapping("/form1")
	public String form1()
	{
		return "day1010/form1";
	}
	
	@PostMapping("/read1")
	public ModelAndView read1(
			@RequestParam String name,
			@RequestParam String gender,
			@RequestParam String addr)
	{
		ModelAndView model=new ModelAndView();
	
		model.addObject("name", name);  //forward할 때 "name"왼쪽의 값으로 불러오면된다.
		model.addObject("gender", gender);
		model.addObject("addr", addr);
		
		model.setViewName("day1010/result1");
		
		return model;
	}
	

	////////////////////////
	@GetMapping("/form2")
	public String form2()
	{
		return "day1010/form2";
	}

	//@ModelAttribute: 폼의 데이터를 읽어서 dto에 넣고 model에 저장
		//단 model에는 ShopDto타입일 경우 shopDto라는 이름으로 저장
		//만약 다른 이름 원하면 @ModelAttribute("이름")
		
	@PostMapping("/read2")
	public String read2(@ModelAttribute ShopDto dto)
	{
		return "day1010/result2";
	}
	
	////////////////////////
	@GetMapping("/form3")
	public String form3()
	{
		return "day1010/form3";
	}
	
	@PostMapping("/read3")
	/* 폼태그의 name이 key값으로, 입력값은 value값으로...*/
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("sang", map.get("sang"));
		model.addObject("color", map.get("color"));
		model.addObject("price", map.get("price"));
		model.addObject("image", map.get("image"));
		
		model.setViewName("day1010/result3");
		
		return model;
	}

	//day1011
	//////////////////////
	@GetMapping("/form4")
	public String uploadform1()
	{
		return "upload/uploadForm1";
	}
	
	@PostMapping("/upload1") //uploadForm의 form action에 있는 upload1 써준 것
	public ModelAndView read1(
			@RequestParam String title,
			@RequestParam MultipartFile photo, //multipartfile photo는 form에서 준 이름으로 주기
			HttpSession session) //Httpsession도 realPath 구하기 위한 것 (cf_HttpServletRequest request :realpath를 찾으려함 (업로드 할 실제 경로 찾기 위함))
	{
		ModelAndView model=new ModelAndView();
		
		//업로드할 실제 경로 구하기
		//String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image"); //해당 괄호 안에 쓰는 다르긴 함 ///cf_HttpServletRequest request쓸 때
		String path=session.getServletContext().getRealPath("/WEB-INF/image");//세션으로 쓸 때 업로드 경로
		String fileName=photo.getOriginalFilename(); //업로드된 파일명
		
		//현재 날짜와 시간 이용해서 파일명에 저장
		//중복된 이미지는 하나만 저장되기에 중복된 이미지 여러개 저장하고 싶으면 file이름 앞에 시분초까지 붙이면 여러개 저장 가능
		SimpleDateFormat sdf=new SimpleDateFormat("yyymmddHHss");
		
		
		//이미지 없다면 noimage 나오게 하기
				if(!fileName.equals(""))
				{
					fileName=sdf.format(new Date())+"_"+fileName;   //이미지명 앞에 시간 붙이기

					//path에 업로드
					try {
						photo.transferTo(new File(path+"\\"+fileName));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					fileName="no"; //업로드안 할 경우 _선택 안 했을 때를 no라고 임의 지정해놓음
				}
					

		//path에 업로드 _ 이걸 안 하면 경로에 들어가도 저장되어 있는 걸 볼 수 없음_그래서 저장하기 위해 이걸 함(실제 경로에 저장 위함)
		//try-catch 해줘야 함 (파일이 없을 수도 있어서 꼭 해줘야 함)
		try {
			photo.transferTo(new File(path+"\\"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject("fileName", fileName);
		model.addObject("title", title);
		model.addObject("path", path);
		
		model.setViewName("upload/uploadResult1");
		
		return model;  //이거 다하고 uploadResult1으로 넘어가기
	}
	
	//여러개 업로드 하는 폼으로 이동_uploadForm2 파일
	@GetMapping("uploadform5")
	public String uploadForm2()
	{
		return "upload/uploadForm2";
	}
	
	//여러개 업로드해서 2번 결과창으로 이동
	@PostMapping("/upload2") //uploadForm2의 form action에 있는 upload2 써준 것
	public ModelAndView read1(
			@RequestParam String title,
			@RequestParam ArrayList<MultipartFile> photo, //여러개 할 떄는 multipartFile(1개)가 아닌 arrayList<멀티파트파일>
			HttpSession session)
	{
		ModelAndView model=new ModelAndView();
		
		//업로드할 실제 경로 구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/image");//세션으로 쓸 때 업로드 경로
		//현재날자와 시간 이용해서 파일명에 저장
		SimpleDateFormat sdf=new SimpleDateFormat("yyymmddHHss");
		
		ArrayList<String> files=new ArrayList<String>();  //arraylist에 파일명을 아래 for문을 통해 파일명 붙여서 담아놓는다.
		
		//파일명 담기
		for(MultipartFile f:photo)
		{
			String fileName=sdf.format(new Date())+"_"+f.getOriginalFilename(); //사진명 앞에 시분초 붙이기
			files.add(fileName); //파일명 담기_여기까지 하면 실제 업로드 된 거 아님
			
			//실제 업로드 되려면 아래처럼 하기: f.transferTo();
			 try {
				f.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addObject("files", files);
		model.addObject("title", title);
		model.addObject("path", path);
		
		model.setViewName("upload/uploadResult2");
		
		return model;  //이거 다하고 uploadResult1으로 넘어가기
	}
}


