package multicapmpus.kb3.kb3project.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.Context;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;
import multicapmpus.kb3.kb3project.service.ConsumeService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/consume")
//@RequiredArgsConstructor
@Controller
public class ConsumeController {

	private final ConsumeService csmService;
	private Map<Integer, String> categoryMap = new HashMap<>();

	public ConsumeController(ConsumeService csmService) {
		this.csmService = csmService;
		categoryMap.put(1, "식비");
		categoryMap.put(2, "카페/간식");
		categoryMap.put(3, "술/유흥");
		categoryMap.put(4, "생활");
		categoryMap.put(5, "패션쇼핑");
		categoryMap.put(6, "뷰티/미용");
		categoryMap.put(7, "교통비");
		categoryMap.put(8, "주거비");
		categoryMap.put(9, "의료/건강");
		categoryMap.put(10, "문화");
		categoryMap.put(11, "금융");
		categoryMap.put(12, "여행/숙박");
		categoryMap.put(13, "교육/학습");
		categoryMap.put(14, "가족");
		categoryMap.put(15, "반려동물");
		categoryMap.put(16, "경조사/선물");
		categoryMap.put(17, "멍청비용");
		categoryMap.put(18, "기타");

	}

	@GetMapping("/list")
	public String list(Model model) {
		List<Consume> csmList = this.csmService.getConsumeList();
		model.addAttribute("csmList", csmList);
		return "consume/consume_list";
	}

	@GetMapping(value = "/detail/{c_no}")
	public String detail(Model model, @PathVariable("c_no") Integer c_no) {
		Consume csm = this.csmService.getConsumeDetail(c_no);
		model.addAttribute("csm", csm);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = csm.getC_date().format(formatter);

		// String csm_date_modify = date.substring(0, 10); //시간 정보 제거
		// String csm_date_modify = csm.getC_date().substring(0, 10); //시간 정보 제거
//		model.addAttribute("csm_date_modify", csm_date_modify); //날짜만 넘겨주기
		model.addAttribute("csm_date_modify", date); // 날짜만 넘겨주기
		model.addAttribute("categoryMap", categoryMap); // 카테고리 맵 넘겨주기
		return "consume/consume_detail";
	}

	@GetMapping(value = "/list/{c_date}")
	// @ResponseBody
	public String dateList(Model model, @PathVariable("c_date") String c_date, HttpSession session) throws Exception {

		if(session.getAttribute("user_no") == null) {
			return "redirect:/Buser/login";
		}
		List<Consume> csmList = csmService.getConsumeListByDate(c_date, session, model);
		model.addAttribute("csmList", csmList);
		model.addAttribute("c_date", c_date);
		model.addAttribute("categoryMap", categoryMap);
//		for (Consume csm : csmList) {
//			String csm_date_modify = csm.getC_date().substring(0, 10);
//			csm.setC_date(csm_date_modify);
//		
//			System.out.println(csm_date_modify);
//		}
		return "consume/consume_date";

	}

	@GetMapping("/create")
	public String create() {
		return "consume/consume_form";
	}

	@PostMapping("/create")
	public String create(@RequestParam String date, @RequestParam int amount, @RequestParam int category,
			@RequestParam String memo, @RequestParam String photo,HttpSession session) {
		// @RequestParam MultipartFile file
		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); Date date2
		 * = null; try { date2 = dateFormat.parse(date); } catch (ParseException e) { //
		 * 날짜 변환 실패 처리 e.printStackTrace(); }
		 */
//		String fileName = date + file.getOriginalFilename();
//		String filePath = "src/main/webapp/resources/" + fileName;
//		try {
//			file.transferTo(new File(filePath));
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		this.csmService.create(date, amount, category, memo, photo,session);
		LocalDate now= (LocalDate)session.getAttribute("loginDate");
		//System.out.println(now.toString());
		if (now!=null)
			return "redirect:/hMyCalendar?year=" + now.getYear() + "&month=" + now.getMonthValue() + "&day=" + now.getDayOfMonth();
		return "redirect:/Buser/login";
	}
}
