package multicapmpus.kb3.kb3project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.RequiredArgsConstructor;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;

@Controller
public class ConsumeController {

	private final ConsumeMapper csmMapper;
	
	
	
	  public ConsumeController(ConsumeMapper csmMapper) 
	  { 
		  this.csmMapper =csmMapper; 
		  }
	  
	
	  @GetMapping("/consume/grouplist/{date}")
	  public String grouplist(@PathVariable("date") String date, HttpServletRequest request, Model model) {
	      
		  int gNo = (int) request.getSession().getAttribute("g_no");
		  
	      List<Integer> totalmoney = csmMapper.getTotalMoneyList(gNo, date);
	      List<String> usernick = csmMapper.getUserNicknames(gNo, date);
	      model.addAttribute("membercs", totalmoney);
	      model.addAttribute("member",usernick);
	      
	      return "consume/grouplist";
	  }
}
