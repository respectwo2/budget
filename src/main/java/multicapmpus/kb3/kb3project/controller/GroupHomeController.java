package multicapmpus.kb3.kb3project.controller;

import lombok.extern.slf4j.Slf4j;
import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.necessary.GroupWithMemberCount;
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

        @GetMapping("/group")
        public String main(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int userNo = (int) session.getAttribute("user_no");
            List<GroupWithMemberCount> groupsWithMemberCount = groupService.getGroupsWithMemeberCount(userNo);
            System.out.println("groupsWithMemberCount=" + groupsWithMemberCount);
            model.addAttribute("groupsWithMemberCount", groupsWithMemberCount);
            
            
//            model.addAttribute("g_no",gNo);
//            model.addAttribute("gNo",groupNo);

            // 현재 등록된 그룹들
            List<Bgroup> groupList = groupService.getGroupList();
            System.out.println("groups=" + groupList);
            model.addAttribute("groupList", groupList);

            return "group/main";  // group/main�쑝濡� 由щ떎�씠�젆�듃
        }

        @GetMapping("/group/search")
        public String main(@RequestParam("q") String searchValue, Model model, HttpServletRequest request) {

            List<Bgroup> groupsBySearch = groupService.getBySearchValue(searchValue);
            System.out.println("groupsBySearch=" + groupsBySearch);
            model.addAttribute("groupsBySearch", groupsBySearch);

            return "group/search";
        }

        @GetMapping("/group/create")
        private String createbgroup(Model model) {
            return "group/createGroup";
        }

        @PostMapping("/group/create")
        public String createBgroup(@RequestParam("g_name") String gName,
                                   @RequestParam("g_maxpeople") int gPeople,
                                   @RequestParam("g_content") String gContent,
                                   @RequestParam("g_tag") String gTag,
                                   @RequestParam("g_rtag") String gRTag) {
//        HttpSession session = request.getSession();
//        int userNo = (int) session.getAttribute("user_no");
            int userNo = 1;

            Bgroup group = new Bgroup();
            group.setG_name(gName);
            group.setG_leader(userNo);
            group.setG_maxpeople(gPeople);
            group.setG_requiredTag(gRTag);
            group.setG_tag(gTag);
            group.setG_content(gContent);
            groupService.createGroup(group);

            int groupNo = groupService.getGroupNoByGname(gName);
            groupService.joinGroup(userNo, groupNo);

            return "redirect:/group";
        }

        @GetMapping("/group/list")
        public String showGroupsByGTag(@RequestParam("tag") String selectedTag, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        	int userNo = (int) session.getAttribute("user_no");
           

            List<GroupWithMemberCount> groupsWithMemberCount = groupService.getGroupsWithMemeberCount(userNo);
            System.out.println("groupsWithMemberCount=" + groupsWithMemberCount);
            model.addAttribute("groupsWithMemberCount", groupsWithMemberCount);

            List<Bgroup> groupsByGtag = groupService.getGroupsByGtag(selectedTag);
            System.out.println("groupsByGtag=" + groupsByGtag);
            model.addAttribute("groupsByGtag", groupsByGtag);

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
