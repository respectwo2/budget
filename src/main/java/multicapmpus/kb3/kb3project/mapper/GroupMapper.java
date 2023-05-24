package multicapmpus.kb3.kb3project.mapper;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithLeaderName;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithMemberCount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupMapper {

    /*
    그룹 만들기
     */
    @Insert("insert into bgroup (g_no, g_maxpeople, g_content, g_tag, g_date, g_leader, g_requiredTag, g_name) " +
            "VALUES (g_no_seq.nextval, #{group.g_maxpeople}, #{group.g_content}, #{group.g_tag}, sysdate, #{group.g_leader}, #{group.g_requiredTag}, #{group.g_name})")
    int saveGroup(@Param("group") Bgroup group);

    /*
        gName으로 g_no 가져오기
     */
    @Select("SELECT g_no FROM Bgroup WHERE g_name = #{gName}")
    int selectGroupNoByGname(@Param("gName") String gName);

    /*
    그룹 전체 조회
     */
    @Select("select * from bgroup")
    public List<Bgroup> selectAll();

    /*
    user_no가 속한 그룹들과 해당 그룹의 현재 인원 가져오기
     */
    @Select("SELECT u.user_no, u.g_no, COUNT(u2.user_no) AS memberCount " +
            "FROM user_group u JOIN user_group u2 ON u.g_no = u2.g_no " +
            "WHERE u.user_no = ${userNo} GROUP BY u.user_no, u.g_no")
    public List<GroupWithMemberCount> selectGroupsWithMemberCountByUserNo(@Param("userNo") int userNo);


    /*
        검색어가 그룹명 또는 해시태그 또는 필수태그에 포함된 그룹 가져오기
    */
    @Select("SELECT * FROM Bgroup WHERE g_tag LIKE '%' || #{searchValue} || '%' OR g_name LIKE '%' || #{searchValue} || '%' OR g_requiredTag LIKE '%' || #{searchValue} || '%'")
    public List<Bgroup> selectBySearchValue(@Param("searchValue") String searchValue);


    /*
        g_tag로 그룹 가져오기
     */
    @Select("SELECT * FROM Bgroup WHERE g_requiredTag = #{gRequiredTag}")
    public List<Bgroup> selectByGtag(@Param("gRequiredTag") String gRequiredTag);

    /*
    groupNo으로 그룹정보 가져오기
     */
    @Select("SELECT g.*, u.user_name as g_leaderName FROM Bgroup g " +
            "JOIN Buser u ON g.g_leader = u.user_no WHERE g.g_no = #{groupNo}")
    public GroupWithLeaderName selectByGroupNo(@Param("groupNo") int groupNo);

    /*
    user_no와 groupNo를 등록
     */
    @Insert("insert into user_group (usergroup, user_no, g_no) " +
            "values (usergroup_no_seq.nextval, #{userNo}, #{groupNo})")
    public int insertUserGroup(@Param("userNo") int userNo, @Param("groupNo") int groupNo);


    /*
    user_no가 속한 group 가져오기 - 사용X
     */
    @Select("SELECT * FROM Bgroup WHERE g_no IN " +
            "(SELECT g_no FROM user_group WHERE user_no = #{userNo})")
    public List<Bgroup> selectGroupsByUserNo(@Param("userNo") int userNo);



//    /*
//    g_no의 모든 user_no의 consume을 date 오름차순으로 가져오기
//    */
//    @Select("SELECT * FROM Consume WHERE user_no IN (SELECT user_no FROM user_group WHERE g_no = #{groupNo}) ORDER BY c_date ASC")
//    public List<Consume> selectConsumesByGroupNo(@Param("groupNo") int groupNo);

}
