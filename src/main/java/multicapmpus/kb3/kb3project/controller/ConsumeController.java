package multicapmpus.kb3.kb3project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.RequiredArgsConstructor;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.GroupConsume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;
import multicapmpus.kb3.kb3project.service.GroupConsumeService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ConsumeController {

	private final ConsumeMapper csmMapper;
	
	@Autowired
	private GroupConsumeService groupservice;
	
	
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

	      LocalDate parsedDate = LocalDate.parse(date);
	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy³â MM¿ù ddÀÏ");
	      String formattedDate = parsedDate.format(formatter);
	      
	      model.addAttribute("parsedDate", formattedDate);
	      
	      List<GroupConsume> groupConsumeByDate = groupservice.getGroupConsumeByDate(gNo, date);
	      
	      model.addAttribute("list",groupConsumeByDate);
	      
	      List<String> consumeList = new ArrayList<>();
	      Map<String, List<GroupConsume>> consumeMap = new HashMap<>();

	      for (GroupConsume consume : groupConsumeByDate) {
	          String nickname = consume.getUser_nickname();
	          if (!consumeList.contains(nickname)) {
	              consumeList.add(nickname);
	          }
	          if (!consumeMap.containsKey(nickname)) {
	              consumeMap.put(nickname, new ArrayList<>());
	          }
	          consumeMap.get(nickname).add(consume);
	      }

	      model.addAttribute("consumeList", consumeList);
	      model.addAttribute("consumeMap", consumeMap);
	      
	      
	      return "consume/grouplist";
	  }


}
