package multicapmpus.kb3.kb3project.service;

import lombok.extern.slf4j.Slf4j;
import multicapmpus.kb3.kb3project.entity.extra.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;

    @Autowired
    public GroupServiceImpl(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @Override
    public List<Bgroup> getGroupsByUserNo(int userNo) {
        List<Bgroup> userBgroups = groupMapper.selectGroupsByUserNo(userNo);
        return userBgroups;
    }

    @Override
    public List<Bgroup> getGroupList() {
        List<Bgroup> Bgroups = groupMapper.selectAll();
        return Bgroups;
    }

    @Override
    public List<Bgroup> getBySearchValue(String searchValue) {
        List<Bgroup> Bgroups = groupMapper.selectBySearchValue(searchValue);
        return Bgroups;
    }

    @Override
    public List<Bgroup> getGroupsByGtag(int gRequiredTag) {
        List<Bgroup> groupsByRequiredtag = groupMapper.selectByGtag(gRequiredTag);
        return groupsByRequiredtag;
    }
}
