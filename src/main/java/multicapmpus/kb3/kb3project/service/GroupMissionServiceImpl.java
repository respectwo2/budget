package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import multicapmpus.kb3.kb3project.mapper.GroupMissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GroupMissionServiceImpl implements GroupMissionService {

    private final GroupMissionMapper groupMissionMapper;

    @Autowired
    public GroupMissionServiceImpl(GroupMissionMapper groupMissionMapper) {
        this.groupMissionMapper = groupMissionMapper;
    }

    /*
    그룹미션 배너 가져오기
     */
    @Override
    public String getGroupMissionBanner(int gNo) {  //param: g_no in GroupMission table
        Bgroupmission BGroupMission = groupMissionMapper.selectOne(gNo);

        LocalDate gmStartDate = BGroupMission.getBgm_start();
        LocalDate gmEndDate = BGroupMission.getBgm_end();
        int gmGoal = BGroupMission.getBgm_goal();

        String groupMissionName = gmStartDate + "~" + gmEndDate + "  " + gmGoal + "원만 소비 목표";
        return groupMissionName;
    }
}
