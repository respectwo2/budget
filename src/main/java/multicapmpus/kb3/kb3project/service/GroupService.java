package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.extra.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.Bgroup;

import java.util.List;

public interface GroupService {

    public List<Bgroup> getGroupsByUserNo(int userNo);  //회원의 모든 그룹 조회

    public List<Bgroup> getGroupsByGtag(String gTag);  //태그로 그룹 조회하기

    public List<Bgroup> getGroupList();  //모든 그룹 조회

    public List<Bgroup> getBySearchValue(String searchValue);  //검색어로 그룹 조회
}
