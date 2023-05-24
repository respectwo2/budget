package multicapmpus.kb3.kb3project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.service.BudgetService;

@Controller
public class BudgetController {
	
	@Autowired private BudgetService budgetService;
	//踰꾩컡 �벑濡� �럹�씠吏�
	@GetMapping("/budget/budget_register")
	public String budgetRegisterForm(Model model) {
		return "budget/budget_register";
	}
	@GetMapping("/budget/create") 
	private String createBudget(Model model) {
		return "budget/create"; 
	}
	//踰꾩컡 �벑濡� 諛쏆� 媛� post 濡� �쟾�넚 �썑 insert
	@PostMapping("/budget/create")//POST 諛⑹떇�쑝濡� �쟾�넚 
	public String createBudgetPost(@RequestParam("title") String bd_name,
			@RequestParam("start_date") String bd_start,
			@RequestParam("end_date") String bd_end,
			@RequestParam("goal") int bd_goal,
			@RequestParam("comment") String bd_comment,
			@RequestParam("user_no") int user_no,
			@RequestParam("goal_now") int bd_goalnow) { 
		Budget bd=new Budget();
		bd.setBd_name(bd_name);
		bd.setBd_start(bd_start);
		bd.setBd_end(bd_end);
		bd.setBd_goal(bd_goal);
		bd.setBd_content(bd_comment);
		bd.setUser_no(user_no);
		bd.setBd_goalnow(bd_goalnow);
		
		budgetService.saveBudget(bd);
		
		return"redirect:/budget/budget_list"; 
	}
	//�쑀�� 蹂� �벑濡앺븳 踰꾩컡 由ъ뒪�듃 蹂댁뿬二쇨린 
	@GetMapping("/budget/budget_list") 
	public String budgetList(HttpSession session, Model model) { 
		int user_No=(int)session.getAttribute("user_no");
		List<BudgetList> budgetList = budgetService.findbudgetAll(user_No);
		model.addAttribute("budgetList", budgetList);
		return "budget/budget_list"; 
	}
	
	//�꽭�뀡 �엫�쓽 �꽕�젙�빐�몦寃�
	@GetMapping("/budget/main")
	public String main(HttpSession session, Model model) {
		int user_No=1;
		session.setAttribute("user_no", user_No);
	
		model.addAttribute("user_no",user_No);
		
		return "redirect:/budget/budget_list";
		
	}
	//踰꾩컡 湲곌컙 蹂� �냼鍮� �궡�뿭  由ъ뒪�듃 蹂댁뿬二쇨린
	@GetMapping("/budget/budget_detail{bd_no}")
	public String budgetDetailList(@PathVariable("bd_no") int bd_No, HttpSession session, Model model) {
		int user_No=(int) session.getAttribute("user_no");
		List<Consume> consumeList=budgetService.findbudgetC(user_No,bd_No);
		model.addAttribute("consumeList",consumeList);
		return "budget/budget_detail";
	} 
	
		

}	
