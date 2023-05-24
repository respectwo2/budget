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
import multicapmpus.kb3.kb3project.service.ConsumeService;

@Controller
public class CalendarController {
	
	@Autowired
	private ConsumeService consumeService;
	
	
	@GetMapping("/calendar")
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
		
	
		// (수정)유저 번호 받아오기 
		List <Consume> consumes = consumeService.getMonthConsume(1, strStart);
		int [] arr = consumeService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		List <Consume> dayConsumes = consumeService.getDayConsume(1, strStartDay);
		model.addAttribute("dayConsumes", dayConsumes);

		return "calendar";
	}
	
	@GetMapping("/MyCalendar")
	public String Mycalendar(@RequestParam("year") int year, @RequestParam("month") int month, Model model) {
		LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		LocalDate start = LocalDate.of(year, month, 1);
		String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		model.addAttribute("start", start);
		
		List <Consume> consumes = consumeService.getMonthConsume(1, strStart);
		int [] arr = consumeService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		
		return "MyCalendar";
	}
	////////////////////////////////////////////////////////규택 실험실
	@GetMapping("/hcalendar")
	public String hcalendar(Model model) {
		LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		LocalDate pick = LocalDate.now();
		String strPick = pick.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		model.addAttribute("pick", pick);
		
		LocalDate start = LocalDate.of(pick.getYear(), pick.getMonthValue(), 1);
		String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		String strStartDay = start.format(DateTimeFormatter.ofPattern("yyyy-MM-DD"));
		model.addAttribute("start", start);
		
	
		// (수정)유저 번호 받아오기 
		List <Consume> consumes = consumeService.getMonthConsume(1, strStart);
		int [] arr = consumeService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		List <Consume> dayConsumes = consumeService.getDayConsume(1, strStartDay);
		model.addAttribute("dayConsumes", dayConsumes);

		return "home/calendar";
	}
	
	@GetMapping("/hMyCalendar")
	public String hMycalendar(@RequestParam("year") int year, @RequestParam("month") int month, Model model) {
		LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		LocalDate start = LocalDate.of(year, month, 1);
		String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		model.addAttribute("start", start);
		
		List <Consume> consumes = consumeService.getMonthConsume(1, strStart);
		int [] arr = consumeService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		
		return "home/MyCalendar";
	}
	
	
}
