package multicapmpus.kb3.kb3project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	  
	
	@GetMapping("/consume/list")
	public String list(Model model) {
		List<Consume> csmList=this.csmMapper.getAll();
        model.addAttribute("csmList", csmList);

		return "consume/list";
	}
}
