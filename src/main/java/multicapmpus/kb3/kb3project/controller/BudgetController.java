package multicapmpus.kb3.kb3project.controller;

import java.time.LocalDate;
import java.util.HashMap;
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
import multicapmpus.kb3.kb3project.entity.ConsumePlusCategory;
import multicapmpus.kb3.kb3project.service.BudgetService;

@Controller
public class BudgetController {
	
	@Autowired private BudgetService budgetService;
	//���� ���� ������ �����ֱ�
	@GetMapping("/budget/budget_start")
	public String budgetStart(Model model) {
		return "budget/budget_start";
	}
	
	//���� ���
	@GetMapping("/budget/budget_register")
	public String budgetRegisterForm(Model model) {
		return "budget/budget_register";
	}
	@GetMapping("/budget/create") 
	private String createBudget(Model model) {
		return "budget/create"; 
	}
	//post�� ���� ������ insert
	@PostMapping("/budget/create")
	public String createBudgetPost(@RequestParam("title") String bd_name,
			@RequestParam("start_date") LocalDate bd_start,
			@RequestParam("end_date") LocalDate bd_end,
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
	//���� ����Ʈ �����ֱ� 
	@GetMapping("/budget/budget_list") 
	public String budgetList(HttpSession session, Model model) { 
		int user_No=(int)session.getAttribute("user_no");
		List<BudgetList> budgetList = budgetService.findbudgetAll(user_No);
		model.addAttribute("budgetList", budgetList);
		return "budget/budget_list"; 
	}
	
	//���ο��� ���� �޾ƿ���
	@GetMapping("/budget/main")
	public String main(HttpSession session, Model model) {
		int user_No=1;
		session.setAttribute("user_no", user_No);
	
		model.addAttribute("user_no",user_No);
		
		return "redirect:/budget/budget_list";
		
	}
	//��� �Һ� ����Ʈ �� ������ �����ֱ�
	@GetMapping("/budget/budget_detail{bd_no}")
	public String budgetDetailList(@PathVariable("bd_no") int bd_No, HttpSession session, Model model) {
		int user_No=(int) session.getAttribute("user_no");
		
		BudgetList bgl=budgetService.getBudgetByNo(bd_No);
		Budget bg=budgetService.getBdByNo(bd_No);
		LocalDate bd_start=bg.getBd_start();
		LocalDate bd_end=bg.getBd_end();
		int bd_no=bgl.getBd_no();
		String bd_name=bgl.getBd_name();
		int bd_goal=bgl.getBd_goal();
		int bd_goalleft=bgl.getBd_goalleft();
		String bd_dateleft=bgl.getBd_dateleft();
		List<ConsumePlusCategory> consumeList=budgetService.findbudgetC(user_No,bd_No);
		
		HashMap<Integer, String> categoryMap=getCategoryMap();
		for(ConsumePlusCategory consume : consumeList) {
			int categoryid=consume.getC_categoryid();
			String category=categoryMap.get(categoryid);
			consume.setC_category(category);
		}
		
		model.addAttribute("bd_start",bd_start);
		model.addAttribute("bd_end",bd_end);
		model.addAttribute("bd_no",bd_no);
		model.addAttribute("bd_name",bd_name);
		model.addAttribute("bd_goal",bd_goal);
		model.addAttribute("bd_goalleft",bd_goalleft);
		model.addAttribute("bd_dateleft",bd_dateleft);
		model.addAttribute("consumeList",consumeList);
		return "budget/budget_detail";
	} 
	
	//�Һ�ī�װ� id->�̸����� ��ȯ
	 private HashMap<Integer, String> getCategoryMap() {
	     HashMap<Integer,String> categoryMap= new HashMap<>();
	     categoryMap.put(1,"�ĺ�");
	     categoryMap.put(2,"ī��/����");
	     categoryMap.put(3,"��/����");
	     categoryMap.put(4,"��Ȱ");
	     categoryMap.put(5,"�мǼ���");
	     categoryMap.put(6,"��Ƽ/�̿�");
	     categoryMap.put(7,"�����");
	     categoryMap.put(8,"�ְź�");
	     categoryMap.put(9,"�Ƿ�/�ǰ�");
	     categoryMap.put(10,"��ȭ");
	     categoryMap.put(11,"����");
	     categoryMap.put(12,"����/����");
	     categoryMap.put(13,"����/�н�");
	     categoryMap.put(14,"����");
	     categoryMap.put(15,"�ݷ�����");
	     categoryMap.put(16,"������/����");
	     categoryMap.put(17,"��û���");
	     categoryMap.put(18,"��Ÿ");
         return categoryMap;
	    }
	
	
	
	
		

}	
