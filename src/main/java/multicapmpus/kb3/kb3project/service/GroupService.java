package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.extra.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithLeaderName;

import java.util.List;

public interface GroupService {

    public List<Bgroup> getGroupsByUserNo(int userNo);  //회원의 모든 그룹 조회

    public List<Bgroup> getGroupsByGtag(String gRequiredTag);  //태그로 그룹 조회하기

    public List<Bgroup> getGroupList();  //모든 그룹 조회

    public List<Bgroup> getBySearchValue(String searchValue);  //검색어로 그룹 조회

    public GroupWithLeaderName getGroupByGroupNo(int groupNo);  //groupNo으로 그룹정보 조회

    public int joinGroup(int userNo, int groupNo);  //userNo를 groupNo에 가입
}
