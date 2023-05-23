package multicapmpus.kb3.kb3project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.service.BgroupService;


@Controller
public class BgroupController {

	@Autowired
	private BgroupService bgroupservice;
	
	@GetMapping("/bgroup/main")
	public String main(HttpSession session, Model model) {
	    int userNo = 1; 
	    int gNo = 2;
	    session.setAttribute("user_no", userNo);
	    session.setAttribute("g_no", gNo);
	    model.addAttribute("user_no", userNo);
	    
	    return "redirect:/bgroup/list";
	}
	
	@GetMapping("/bgroup/list")
	public String list(HttpSession session, Model model) {
	    // 세션에서 user_no 가져오기
	    int userNo = (int) session.getAttribute("user_no");


	    List<String> gNames = bgroupservice.getGNamesByUserNo(userNo);
	    List<Integer> gNos = bgroupservice.getGNosByUserNo(userNo);


	    model.addAttribute("names", gNames);
	    model.addAttribute("nos", gNos);

	    return "bgroup/list";
	}

	

	@GetMapping("/bgroup/register")
	public String register(Model model) {
		return "bgroup/register";
	}
	
	@GetMapping("/bgroup/info")
	public String info(@RequestParam("g_no") int gNo, Model model) {
	    // 세션에서 g_no 가져오기
	    // int gNo = (int) session.getAttribute("g_no");

	    Bgroup bgroupByNo = bgroupservice.getBgroupByNo(gNo);
	    String g_content = bgroupByNo.getG_content();
	    String g_name = bgroupByNo.getG_name();
	    String g_tag = bgroupByNo.getG_tag();
	    int g_maxpeople = bgroupByNo.getG_maxpeople();
	    int g_leader = bgroupByNo.getG_leader();

	    model.addAttribute("content", g_content);
	    model.addAttribute("name", g_name);
	    model.addAttribute("tag", g_tag);
	    model.addAttribute("maxpeople", g_maxpeople);
	    model.addAttribute("leader", g_leader);

	    return "bgroup/info";
	}
	
	
}