package multicapmpus.kb3.kb3project.mapper;

import multicapmpus.kb3.kb3project.entity.extra.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.Bgroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupMapper {

    /*
    그룹 전체 조회
     */
    @Select("select * from bgroup")
    public List<Bgroup> selectAll();

    /*
    user_no가 속한 group 가져오기
     */
    @Select("SELECT * FROM Bgroup WHERE g_no IN " +
            "(SELECT g_no FROM user_group WHERE user_no = #{userNo})")
    public List<Bgroup> selectGroupsByUserNo(@Param("userNo") int userNo);

    /*
        검색어가 그룹명 또는 해시태그에 포함된 그룹 가져오기
    */
    @Select("SELECT * FROM Bgroup WHERE g_tag LIKE '%' || #{searchValue} || '%' OR g_name LIKE '%' || #{searchValue} || '%'")
    public List<Bgroup> selectBySearchValue(@Param("searchValue") String searchValue);


    /*
        g_tag로 그룹 가져오기
     */
    @Select("SELECT * FROM Bgroup WHERE g_tag = #{gTag}")
    public List<Bgroup> selectByGtag(@Param("gTag") String gTag);


//    /*
//    g_no의 모든 user_no의 consume을 date 오름차순으로 가져오기
//    */
//    @Select("SELECT * FROM Consume WHERE user_no IN (SELECT user_no FROM user_group WHERE g_no = #{groupNo}) ORDER BY c_date ASC")
//    public List<Consume> selectConsumesByGroupNo(@Param("groupNo") int groupNo);
//
//    /*
//    c_no의 user_name 가져오기
//    @Select("
//     */

}
