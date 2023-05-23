package multicapmpus.kb3.kb3project.controller;

import lombok.extern.slf4j.Slf4j;
import multicapmpus.kb3.kb3project.entity.extra.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithLeaderName;
import multicapmpus.kb3.kb3project.service.ConsumeService;
import multicapmpus.kb3.kb3project.service.GroupMissionService;
import multicapmpus.kb3.kb3project.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

    @Controller
    @Slf4j
    public class GroupHomeController {

        private final GroupService groupService;
        private final GroupMissionService groupMissionService;
        private final ConsumeService consumeService;

        @Autowired
        public GroupHomeController(GroupService groupService, GroupMissionService groupMissionService, ConsumeService consumeService) {
            this.groupService = groupService;
            this.groupMissionService = groupMissionService;
            this.consumeService = consumeService;
        }

        /*
        그룹 메인 화면
         */
        @GetMapping("/group")
        public String main(Model model, HttpServletRequest request) {
            // 세션에 담긴 회원no가져오기
//        HttpSession session = request.getSession();
//        int userNo = (int) session.getAttribute("user_no");
            int userNo = 1;

            List<Bgroup> userBgroups = groupService.getGroupsByUserNo(userNo);
            System.out.println("userGroups=" + userBgroups);
            model.addAttribute("userGroups", userBgroups);
            return "group/main";  //group/main으로 리다이렉트
        }

        /*
        검색된 그룹
         */
        @GetMapping("/group/search")
        public String main(@RequestParam("q") String searchValue, Model model, HttpServletRequest request) {
            // 세션에 담긴 회원no가져오기
//        HttpSession session = request.getSession();
//        int userNo = (int) session.getAttribute("user_no");

            List<Bgroup> groupsBySearches = groupService.getBySearchValue(searchValue);
            System.out.println("groupsBySearch=" + groupsBySearches);
            model.addAttribute("groupsBySearch", groupsBySearches);

            return "group/search";
        }

        /*
        그룹 정보 페이지
         */
        @GetMapping("/group/info")
        public String info(@RequestParam("groupNo") int groupNo, Model model) {

            GroupWithLeaderName groupInfo = groupService.getGroupByGroupNo(groupNo);
            System.out.println("groupInfo=" + groupInfo);
            model.addAttribute("groupInfo", groupInfo);

            return "group/info";
        }




        /*
        test
         */
        @GetMapping("/groupList")
        public String home(Model model) {
            List<Bgroup> BgroupList = groupService.getGroupList();
            System.out.println("groupList=" + BgroupList);
            model.addAttribute("groupList", BgroupList);
            return "test/groupList";
        }

}
