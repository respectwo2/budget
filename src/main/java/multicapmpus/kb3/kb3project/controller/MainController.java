package multicapmpus.kb3.kb3project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "안녕하세요 index입니다.";
	}

	@GetMapping("/")
	public String root(HttpSession session) {
		Integer user_no = (Integer) session.getAttribute("user_no");
		if (user_no != null)
			return "home/home";
		else
			return "redirect:/Buser/login";
	}

	@GetMapping("/home")
	public String aaa() {
		return "home/home";
	}
	
}
