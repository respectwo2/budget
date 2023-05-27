package multicapmpus.kb3.kb3project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import multicapmpus.kb3.kb3project.service.BgroupService;


@Controller
public class BgroupController {

	@Autowired
	private BgroupService bgroupservice;
	
	
	
	@GetMapping("/bgroup/main")
	public String main(HttpSession session, Model model) {
		int userNo = (int) session.getAttribute("user_no");
	    int gNo = (int) session.getAttribute("g_no");
	    model.addAttribute("user_no", userNo);
	    model.addAttribute("g_no",gNo);
	    return "redirect:/bgroup/list";
	}
	
	@GetMapping("/bgroup/list")
	public String list(HttpSession session, Model model) {
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
	
	@GetMapping("/bgroup/create")
	private String createbgroup(Model model) {
		return "bgroup/create";
	}
	
	@PostMapping("/bgroup/create")
	public String createBgroup(@RequestParam("g_name") String gName,
	                                  @RequestParam("g_maxpeople") int gPeople,
	                                  @RequestParam("g_content") String gContent,
	                                  @RequestParam("g_tag") String gTag,
	                                  @RequestParam("g_rtag") String gRTag
	                                  ) {

	    Bgroup bgroup = new Bgroup();
	    bgroup.setG_name(gName);
	    bgroup.setG_content(gContent);
	    bgroup.setG_tag(gTag);
	    bgroup.setG_requiredTag(gRTag);
	    bgroup.setG_maxpeople(gPeople);
	    bgroupservice.saveBgroup(bgroup);
	    
	    return "redirect:/bgroup/main";
	}
	
	
	@GetMapping("/bgroup/info")
	public String info(@RequestParam("g_no") int gNo, Model model) {
	    // ���ǿ��� g_no ��������
	    // int gNo = (int) session.getAttribute("g_no");

	    Bgroup bgroupByNo = bgroupservice.getBgroupByNo(gNo);
	    String g_rtag = bgroupByNo.getG_requiredTag();
	    String g_content = bgroupByNo.getG_content();
	    String g_name = bgroupByNo.getG_name();
	    String g_tag = bgroupByNo.getG_tag();
	    int g_maxpeople = bgroupByNo.getG_maxpeople();
	    int g_leader = bgroupByNo.getG_leader();
	    
	    
	    model.addAttribute("rtag",g_rtag);
	    model.addAttribute("content", g_content);
	    model.addAttribute("name", g_name);
	    model.addAttribute("tag", g_tag);
	    model.addAttribute("maxpeople", g_maxpeople);
	    model.addAttribute("leader", g_leader);

	    return "bgroup/info";
	}
	
	
}