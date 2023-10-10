package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

	@GetMapping("/happy")
	public String quiz1Img()
	{
		return "quiz1";
	}
}
