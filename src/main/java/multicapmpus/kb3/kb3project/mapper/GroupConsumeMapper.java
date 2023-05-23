package multicapmpus.kb3.kb3project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import multicapmpus.kb3.kb3project.entity.GroupConsume;

@Mapper
public interface GroupConsumeMapper {
	
    @Select("SELECT C.C_MONEY, U.User_no, U.user_nickname, C.C_Date " +
            "FROM BUSER U " +
            "INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
            "INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " +
            "WHERE G.G_NO = #{g_no} " +
            "    AND TO_CHAR(C.C_DATE, 'YYYY-MM') = #{date} " +
            "    AND U.USER_NO = (" +
            "        SELECT U.USER_NO " +
            "        FROM BUSER U " +
            "        INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
            "        INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " +
            "        WHERE G.G_NO = #{g_no} " +
            "            AND TO_CHAR(C.C_DATE, 'YYYY-MM') = #{date} " +
            "        GROUP BY U.USER_NO, U.USER_nickname " +
            "        ORDER BY SUM(C.C_MONEY) DESC " +
            "        FETCH FIRST 1 ROW ONLY" +
            "    )")
    List<GroupConsume> getGroupMonthConsumes(@Param("g_no") Long g_no, @Param("date") String date);

    @Select("SELECT C.C_MONEY, U.User_no, U.user_nickname, C.C_Date " +
            "FROM BUSER U " +
            "INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
            "INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " +
            "WHERE G.G_NO = #{g_no} " +
            "    AND TO_CHAR(C.C_DATE, 'YYYY-MM-DD') = #{date} " +
            "    AND U.USER_NO = (" +
            "        SELECT U.USER_NO " +
            "        FROM BUSER U " +
            "        INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
            "        INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " +
            "        WHERE G.G_NO = #{g_no} " +
            "            AND TO_CHAR(C.C_DATE, 'YYYY-MM-DD') = #{date} " +
            "        GROUP BY U.USER_NO, U.USER_nickname " +
            "        ORDER BY SUM(C.C_MONEY) DESC " +
            "        FETCH FIRST 1 ROW ONLY" +
            "    )")
    List<GroupConsume> getGroupDayConsumes(@Param("g_no") Long g_no, @Param("date") String date);
    
    @Select("SELECT user_nickname " +
            "FROM BUSER U " +
            "INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
            "INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " +
            "WHERE G.G_NO = #{g_no} " +
            "    AND TO_CHAR(C.C_DATE, 'YYYY-MM-DD') = #{date} " +
            "GROUP BY U.user_nickname " +
            "ORDER BY SUM(C.C_MONEY) DESC " +
            "FETCH FIRST 1 ROW ONLY")
    String getTopUserNickname(@Param("g_no") long g_no, @Param("date") String date);

}
