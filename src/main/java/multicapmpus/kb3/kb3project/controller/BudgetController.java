package multicapmpus.kb3.kb3project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.service.BgroupService;


@Controller
public class BudgetController {

	@Autowired
	private BgroupService bgroupservice;
	
//	@GetMapping("/bgroup/list{g_no}")
//	public String list(@PathVariable("g_no") int gNo, Model model) {
//		Bgroup bgroupByNo = bgroupservice.getBgroupByNo(gNo);
//		String g_name = bgroupByNo.getG_name();
//		model.addAttribute("name",g_name);
//		return "bgroup/list";
//	}
//	
	@GetMapping("/budget/budget_register")
	public String register(Model model) {
		return "budget/budget_register";
	}
//	
//	@GetMapping("/bgroup/info{g_no}")
//	public String info(@PathVariable("g_no") int gNo, Model model) {
//		
//		Bgroup bgroupByNo = bgroupservice.getBgroupByNo(gNo);
//		String g_content = bgroupByNo.getG_content();
//		String g_name = bgroupByNo.getG_name();
//		String g_tag = bgroupByNo.getG_tag();
//		int g_maxpeople = bgroupByNo.getG_maxpeople();
//		int g_leader = bgroupByNo.getG_leader();
//		
//		model.addAttribute("content",g_content);
//		model.addAttribute("name",g_name);
//		model.addAttribute("tag",g_tag);
//		model.addAttribute("maxpeople",g_maxpeople);
//		model.addAttribute("leader",g_leader);
//		
//	    return "bgroup/info";
//	}
}