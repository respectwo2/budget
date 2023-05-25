package multicapmpus.kb3.kb3project.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.GroupConsume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;
import multicapmpus.kb3.kb3project.service.ConsumeService;
import multicapmpus.kb3.kb3project.service.GroupConsumeService;

@Controller
public class CalendarController {
	
	@Autowired
	private ConsumeService consumeService;
	
	@Autowired
	private GroupConsumeService groupService;
	
	@Autowired
	private ConsumeMapper csmMapper;
	
	
	  
	
	@GetMapping("/buser/calendar")
	public String calendar(Model model) {
		LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		LocalDate pick = LocalDate.now();
		String strPick = pick.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		model.addAttribute("pick", pick);
		
		LocalDate start = LocalDate.of(pick.getYear(), pick.getMonthValue(), 1);
		String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		String strStartDay = start.format(DateTimeFormatter.ofPattern("yyyy-MM-DD"));
		model.addAttribute("start", start);
		
	
		List <Consume> consumes = consumeService.getMonthConsume(1, strStart);
		int [] arr = consumeService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		List <Consume> dayConsumes = consumeService.getDayConsume(1, strStartDay);
		model.addAttribute("dayConsumes", dayConsumes);

		return "buser/calendar";
	}
	
	@GetMapping("/buser/MyCalendar")
	public String Mycalendar(@RequestParam("year") int year, @RequestParam("month") int month,@RequestParam("day") int day, Model model) {
		LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		LocalDate start = LocalDate.of(year, month, 1);
		String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		model.addAttribute("start", start);
		
		LocalDate pick = LocalDate.of(year, month, day);
		String strPickDay = pick.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		model.addAttribute("pick", pick);
		
		// (占쎈땾占쎌젟)占쎌�占쏙옙 甕곕뜇�깈 獄쏆룇釉섓옙�궎疫뀐옙
		List <Consume> consumes = consumeService.getMonthConsume(1, strStart);
		int [] arr = consumeService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		List <Consume> dayConsumes = consumeService.getDayConsume(1, strPickDay);
		model.addAttribute("dayConsumes", dayConsumes);
		
		return "buser/MyCalendar";
	}
	
	@GetMapping("/bgroup/calendar")
	public String bgroupcalendar(Model model) {
		LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		LocalDate pick = LocalDate.now();
		String strPick = pick.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		model.addAttribute("pick", pick);
		
		LocalDate start = LocalDate.of(pick.getYear(), pick.getMonthValue(), 1);
		String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		String strStartDay = start.format(DateTimeFormatter.ofPattern("yyyy-MM-DD"));
		model.addAttribute("start", start);
		
	
		
	
		List <GroupConsume> consumes = groupService.getGroupMonthConsume(2, strStart);
		int [] arr = groupService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		List <GroupConsume> dayConsumes = groupService.getGroupDayConsume(2, strStartDay);
		model.addAttribute("dayConsumes", dayConsumes);
		

		
		
		return "bgroup/calendar";
	}
	
	@GetMapping("/bgroup/GroupCalendar")
	public String Groupcalendar(@RequestParam("year") int year, @RequestParam("month") int month,@RequestParam("day") int day, Model model) {
		LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		model.addAttribute("month", month);
	    model.addAttribute("day", day);
		
		LocalDate start = LocalDate.of(year, month, 1);
		String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		model.addAttribute("start", start);
		
		LocalDate pick = LocalDate.of(year, month, day);
		String strPickDay = pick.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		model.addAttribute("pick", pick);
		
		
		List <GroupConsume> consumes = groupService.getGroupMonthConsume(2, strStart);
		int [] arr = groupService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		List <GroupConsume> dayConsumes = groupService.getGroupDayConsume(2, strPickDay);
		model.addAttribute("dayConsumes", dayConsumes);

//	    int gNo = (int) request.getSession().getAttribute("g_no");
	    List<Integer> totalmoney = csmMapper.getTotalMoneyList(2, strPickDay);
	    List<String> usernick = csmMapper.getUserNicknames(2, strPickDay);
	    
	    
	    model.addAttribute("membercs", totalmoney);
	    model.addAttribute("member", usernick);
		
		return "bgroup/GroupCalendar";
	}

	
}
