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
	
	
	@GetMapping("/MyCalendar")
	public String Mycalendar(@RequestParam("year") int year, @RequestParam("month") int month, @RequestParam("day") int day, Model model) {
		// 푸터나, 로그인 이후 오늘 날짜로 연결 할 것
		LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		LocalDate start = LocalDate.of(year, month, 1);
		String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		model.addAttribute("start", start);
		
		LocalDate pick = LocalDate.of(year, month, day);
		String strPickDay = pick.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		model.addAttribute("pick", pick);
		
		// (수정)유저 번호 받아오기
		List <Consume> consumes = consumeService.getMonthConsume(1, strStart);
		int [] arr = consumeService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		List <Consume> dayConsumes = consumeService.getDayConsume(1, strPickDay);
		model.addAttribute("dayConsumes", dayConsumes);
		
		return "MyCalendar";
	}
	
}
