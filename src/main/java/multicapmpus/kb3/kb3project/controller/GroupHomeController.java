package multicapmpus.kb3.kb3project.controller;

import lombok.extern.slf4j.Slf4j;
import multicapmpus.kb3.kb3project.entity.extra.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithLeaderName;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithMemberCount;
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

            // 회원이 가입한 그룹들 (+현재 인원)
            List<GroupWithMemberCount> groupsWithMemberCount = groupService.getGroupsWithMemeberCount(userNo);
            System.out.println("groupsWithMemberCount=" + groupsWithMemberCount);
            model.addAttribute("groupsWithMemberCount", groupsWithMemberCount);


            // 현재 등록된 그룹들
            List<Bgroup> groupList = groupService.getGroupList();
            System.out.println("groups=" + groupList);
            model.addAttribute("groupList", groupList);

            return "group/main";  // group/main으로 리다이렉트
        }

        /*
        검색된 그룹
         */
        @GetMapping("/group/search")
        public String main(@RequestParam("q") String searchValue, Model model, HttpServletRequest request) {

            List<Bgroup> groupsBySearch = groupService.getBySearchValue(searchValue);
            System.out.println("groupsBySearch=" + groupsBySearch);
            model.addAttribute("groupsBySearch", groupsBySearch);

            return "group/search";
        }

        /*
        그룹 만들기 페이지로 이동
         */
        @GetMapping("/group/create")
        private String createbgroup(Model model) {
            return "group/createGroup";
        }

        /*
        그룹 만들기 처리 후 그룹홈 페이지로 이동
         */
        @PostMapping("/group/create")
        public String createBgroup(@RequestParam("g_name") String gName,
                                   @RequestParam("g_maxpeople") int gPeople,
                                   @RequestParam("g_content") String gContent,
                                   @RequestParam("g_tag") String gTag,
                                   @RequestParam("g_rtag") String gRTag) {
            // 세션에 담긴 회원no가져오기
//        HttpSession session = request.getSession();
//        int userNo = (int) session.getAttribute("user_no");
            int userNo = 1;

            // 그룹 생성
            Bgroup group = new Bgroup();
            group.setG_name(gName);
            group.setG_leader(userNo);
            group.setG_maxpeople(gPeople);
            group.setG_requiredTag(gRTag);
            group.setG_tag(gTag);
            group.setG_content(gContent);
            groupService.createGroup(group);

            // 생성된 그룹의 groupNo를 받아와서, user_group테이블에 userNo와 groupNo를 삽입해주기
            int groupNo = groupService.getGroupNoByGname(gName);
            groupService.joinGroup(userNo, groupNo);

            return "redirect:/group";
        }

        /*
        g_requiredTag로 그룹 조회하기
         */
        @GetMapping("/group/list")
        public String showGroupsByGTag(@RequestParam("tag") String selectedTag, Model model, HttpServletRequest request) {
            // 세션에 담긴 회원no가져오기
//        HttpSession session = request.getSession();
//        int userNo = (int) session.getAttribute("user_no");
            int userNo = 1;

            // 회원이 가입한 그룹들 (+현재 인원)
            List<GroupWithMemberCount> groupsWithMemberCount = groupService.getGroupsWithMemeberCount(userNo);
            System.out.println("groupsWithMemberCount=" + groupsWithMemberCount);
            model.addAttribute("groupsWithMemberCount", groupsWithMemberCount);

            // 선택된 태그의 그룹들
            List<Bgroup> groupsByGtag = groupService.getGroupsByGtag(selectedTag);
            System.out.println("groupsByGtag=" + groupsByGtag);
            model.addAttribute("groupsByGtag", groupsByGtag);

            // 선택된 태그 model에 담아주기
            model.addAttribute("selectedTag", selectedTag);

            return "group/mainByGtag";
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
