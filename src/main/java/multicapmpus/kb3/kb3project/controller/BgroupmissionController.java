package multicapmpus.kb3.kb3project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import multicapmpus.kb3.kb3project.entity.BgroupmissionInfo;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.service.BgroupService;
import multicapmpus.kb3.kb3project.service.BgroupmissionService;


@Controller
public class BgroupmissionController {

	@Autowired
	private BgroupmissionService bgroupmissionservice;
	
	
	@GetMapping("/bgm/register")
	public String register(Model model) {
		return "bgroupmission/register";
	}
	
	@GetMapping("/bgm/create")
	private String createbgm(Model model) {
		return "bgm/create";
	}
	
	@PostMapping("/bgm/create")
	public String createBgroupMission(@RequestParam("bgm_name") String bgmName,
	                                  @RequestParam("bgm_goal") int bgmGoal,
	                                  @RequestParam("bgm_content") String bgmContent,
	                                  @RequestParam("bgm_start") String bgmStart,
	                                  @RequestParam("bgm_end") String bgmEnd) {

	    Bgroupmission bgm = new Bgroupmission();
	    bgm.setBgm_name(bgmName);
	    bgm.setBgm_goal(bgmGoal);
	    bgm.setBgm_content(bgmContent);
	    bgm.setBgm_start(bgmStart);
	    bgm.setBgm_end(bgmEnd);
	    
	    bgroupmissionservice.saveBgroupmission(bgm);
	    
	    return "redirect:/bgroup/main";
	}
	@GetMapping("/bgm/info{bgm_no}")
	public String info(@PathVariable("bgm_no") int bgmNo, Model model) {
		
		Bgroupmission bgm = bgroupmissionservice.getBgmByNo(bgmNo);
		String bgm_content = bgm.getBgm_content();
		String bgm_name = bgm.getBgm_name();
		String bgm_start = bgm.getBgm_start();
		String bgm_end = bgm.getBgm_end();
		int bgm_goal = bgm.getBgm_goal();
		
		
		model.addAttribute("content",bgm_content);
		model.addAttribute("name",bgm_name);
		model.addAttribute("start",bgm_start);
		model.addAttribute("end",bgm_end);
		model.addAttribute("goal",bgm_goal);
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	    
	    try {
	        Date startDate = dateFormat.parse(bgm_start); 
	        Date endDate = dateFormat.parse(bgm_end); 
	        long remain = (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24); 
	        
	        model.addAttribute("remain", remain); 
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		
		return "bgroupmission/info";
	}
	@GetMapping("/bgm/now{bgm_no}")
	public String now(@PathVariable("bgm_no") int bgmNo, Model model) {
		
		
	    Bgroupmission bgm = bgroupmissionservice.getBgmByNo(bgmNo);
	    String bgm_content = bgm.getBgm_content();
	    String bgm_name = bgm.getBgm_name();
	    String bgm_start = bgm.getBgm_start().substring(0, 10);
	    String bgm_end = bgm.getBgm_end().substring(0, 10);
	    int bgm_goal = bgm.getBgm_goal();
	    List<Integer> userCList = bgroupmissionservice.getUserCListDate(bgmNo);
	    List<String> userNicknameList = bgroupmissionservice.getUserCListDateUserNo(bgmNo);
	    
	    
	    model.addAttribute("content", bgm_content);
	    model.addAttribute("name", bgm_name);
	    model.addAttribute("start", bgm_start);
	    model.addAttribute("end", bgm_end);
	    model.addAttribute("goal", bgm_goal);
	    model.addAttribute("membercs", userCList);
	    model.addAttribute("member", userNicknameList);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	    
	    try {
	        Date startDate = dateFormat.parse(bgm_start); 
	        Date endDate = dateFormat.parse(bgm_end); 
	        long remain = (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24); 
	        
	        model.addAttribute("remain", remain); 
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    return "bgroupmission/bgmnow";
	}
	
	
}