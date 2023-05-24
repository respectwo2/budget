package multicapmpus.kb3.kb3project.controller;

import multicapmpus.kb3.kb3project.entity.necessary.GroupInfo;
import multicapmpus.kb3.kb3project.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupInfoController {

    private final GroupService groupService;

    public GroupInfoController(GroupService groupService) {
        this.groupService = groupService;
    }

    /*
        그룹 정보 페이지
    */
    @GetMapping("/group/info")
    public String info(@RequestParam("groupNo") int groupNo, Model model) {

        GroupInfo groupInfo = groupService.getGroupInfo(groupNo);
        System.out.println("groupInfo=" + groupInfo);
        model.addAttribute("groupInfo", groupInfo);

        return "group/info";
    }

    /*
    그룹가입
     */
    @PostMapping("/group/join")
    public String join(@RequestParam("groupNo") int groupNo) {
//      HttpSession session = request.getSession();
//      int userNo = (int) session.getAttribute("user_no");
        int userNo = 1;

        // 그룹 가입 처리
        groupService.joinGroup(userNo, groupNo);

        // 그룹홈으로 페이지 이동
        return "redirect:/group";
    }

}
