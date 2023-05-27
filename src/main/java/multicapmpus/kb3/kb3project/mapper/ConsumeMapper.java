package multicapmpus.kb3.kb3project.mapper;

import multicapmpus.kb3.kb3project.entity.necessary.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeForFeed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ConsumeMapper {

    /*
        g_no의 모든 user_no의 user_name과 consume과 해당 consume글의 댓글 개수를 date 오름차순으로 가져오기
    */
    @Select("SELECT c.c_no, c.user_no, TO_CHAR(c.c_date, 'YYYY\"년\" MM\"월\" DD\"일\"') as c_date, c.c_money, c.c_categoryid, c.c_image, c.c_content, bu.user_name, COUNT(bc.cmn_no) AS commentNum, c.c_like " +
            "FROM user_group ug " +
            "JOIN Buser bu ON ug.user_no = bu.user_no " +
            "JOIN Consume c ON ug.user_no = c.user_no " +
            "LEFT JOIN Bcomment bc ON c.c_no = bc.c_no " +
            "WHERE ug.g_no = #{groupNo} " +
            "GROUP BY c.c_no, c.user_no, c.c_date, c.c_money, c.c_categoryid, c.c_image, c.c_content, bu.user_name, c.c_like " +
            "ORDER BY c.c_date DESC")
    public List<ConsumeForFeed> selectConsumesWithCommentNumByGroupNo(@Param("groupNo") int groupNo);

    /*
        consumeNo로 소비글 가져오기 - 사용X
     */
    @Select("SELECT TO_CHAR(c.c_date, 'YYYY\"년\"MM\"월\"DD\"일\"') AS c_date, c.user_no, c.c_money, c.c_categoryid, c.c_image, c.c_content, c.c_like, buser.user_name " +
            "FROM consume c " +
            "JOIN buser ON c.user_no = buser.user_no " +
            "WHERE c.c_no = #{consumeNo}")
    public ConsumeWithUserName selectOneByConsumeNo(@Param("consumeNo") int consumeNo);

    /*
        g_no의 모든 user_no의 user_name과 consume을 date 오름차순으로 가져오기 - 사용X
    */
    @Select("SELECT C.*, B.user_name" +
            "        FROM Consume C JOIN Buser B ON C.user_no = B.user_no" +
            "        WHERE C.user_no IN (SELECT user_no FROM user_group WHERE g_no = #{groupNo})" +
            "        ORDER BY C.c_date ASC")
    public List<ConsumeWithUserName> selectConsumesByGroupNo(@Param("groupNo") int groupNo);

    /*
    좋아요 누르면 c_like +1
     */
    @Update("UPDATE Consume SET c_like = c_like + 1 WHERE c_no = #{consumeNo}")
    public int updateLike(@Param("consumeNo") int consumeNo);

}
