package multicapmpus.kb3.kb3project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import multicapmpus.kb3.kb3project.entity.Consume;

@Mapper
public interface ConsumeMapper {
	
	@Select("SELECT * FROM CONSUME WHERE USER_NO=#{user_no} AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date}")
	List<Consume> getMonthConsume(@Param("user_no") long user_no, @Param("date") String date);
	
	@Select("SELECT * FROM CONSUME WHERE USER_NO=#{user_no} AND TO_CHAR(C_DATE, 'YYYY-MM-DD') = #{date}")
	List<Consume> getDayConsume(@Param("user_no") long user_no, @Param("date") String date);
	
	@Select("SELECT buser.user_nickname " +
	        "FROM CONSUME " +
	        "JOIN user_group ON CONSUME.USER_NO = user_group.USER_NO " +
	        "JOIN buser ON user_group.USER_NO = buser.USER_NO " +
	        "WHERE user_group.G_NO = #{g_no} " +
	        "AND TO_CHAR(CONSUME.C_DATE, 'YYYY-MM-DD') = #{date} " +
	        "GROUP BY buser.user_nickname " +
	        "ORDER BY SUM(CONSUME.c_money) deSC") 
	List<String> getUserNicknames(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT SUM(CONSUME.c_money) AS total_money " +
	        "FROM CONSUME " +
	        "JOIN user_group ON CONSUME.USER_NO = user_group.USER_NO " +
	        "JOIN buser ON user_group.USER_NO = buser.USER_NO " +
	        "WHERE user_group.G_NO = #{g_no} " +
	        "AND TO_CHAR(CONSUME.C_DATE, 'YYYY-MM-DD') = #{date} " +
	        "GROUP BY buser.user_nickname " +
	        "ORDER BY total_money deSC") 
	List<Integer> getTotalMoneyList(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT * " + 
	        "FROM (" +
	        "    SELECT user_no, SUM(c_money) AS total_money " +
	        "    FROM CONSUME " + 
	        "    WHERE USER_NO IN ( " + 
	        "        SELECT ug.user_no " + 
	        "        FROM user_group ug " + 
	        "        JOIN bgroup bg ON ug.g_no = bg.g_no " + 
	        "        WHERE bg.g_no = #{g_no} " + 
	        "    ) AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date} " +
	        "    GROUP BY user_no " +
	        "    ORDER BY total_money DESC " +
	        ") " +
	        "WHERE ROWNUM = 1")
	List<Consume> getMemberMonthConsume(@Param("g_no") long g_no, @Param("date") String date);
	
	@Select("SELECT * " + 
	        "FROM (" +
	        "    SELECT user_no, SUM(c_money) AS total_money " +
	        "    FROM CONSUME " + 
	        "    WHERE USER_NO IN ( " + 
	        "        SELECT ug.user_no " + 
	        "        FROM user_group ug " + 
	        "        JOIN bgroup bg ON ug.g_no = bg.g_no " + 
	        "        WHERE bg.g_no = #{g_no} " + 
	        "    ) AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date} " +
	        "    GROUP BY user_no " +
	        "    ORDER BY total_money DESC " +
	        ") " +
	        "WHERE ROWNUM = 1")
	List<Consume> getMemberDayConsume(@Param("g_no") long g_no, @Param("date") String date);
	
	@Select("SELECT b.user_nickname, c.c_money, c.c_content, c.c_like " +
	        "FROM CONSUME c " +
	        "JOIN user_group ug ON c.USER_NO = ug.USER_NO " +
	        "JOIN buser b ON c.USER_NO = b.USER_NO " +
	        "WHERE ug.G_NO = #{g_no} " +
	        "AND TO_CHAR(c.C_DATE, 'YYYY-MM-DD') = #{date}")
	List<Consume> getGroupConsumeByDate(@Param("g_no") long g_no, @Param("date") String date);

	
}
