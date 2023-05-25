package multicapmpus.kb3.kb3project.mapper;

import java.util.List;
import java.util.Optional;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import multicapmpus.kb3.kb3project.entity.Consume;

@Mapper
public interface ConsumeMapper {
	@Select("Select * from CONSUME ORDER BY c_no DESC")
	public List<Consume> getAll();

	@Select("SELECT * FROM CONSUME WHERE C_NO= #{c_no}")
	Optional<Consume> findByCno(@Param("c_no") int c_no);

	@Insert("insert into CONSUME (c_no, user_no, c_money, c_categoryid, c_date, c_image,c_content) "
			+ "VALUES (C_NO_SEQ.nextval,#{csm.user_no},#{csm.c_money},#{csm.c_categoryid},#{csm.c_date},#{csm.c_image},#{csm.c_content})")
	int save(@Param("csm") Consume csm);

	// SELECT * FROM Consume WHERE c_date >= TO_DATE('2023-05-17', 'YYYY-MM-DD') and
	// c_date <= TO_DATE('2023-05-17', 'YYYY-MM-DD')+1;
	@Select("SELECT * FROM consume WHERE TRUNC(c_date) = TO_DATE(#{date}, 'YYYY-MM-DD') " + "AND user_no=#{user_no}")
	// ("select * from consume where c_date >= TO_DATE( #{date}, 'YYYY-MM-DD') and
	// c_date <= TO_DATE(#{date}, 'YYYY-MM-DD')+1")
	// ("select * from consume where c_date >= TO_DATE( #{date}, 'YYYY-MM-DD') and
	// c_date <= TO_DATE(#{date}, 'YYYY-MM-DD')+1")
	public List<Consume> findByDate(@Param("date") String date, @Param("user_no") int user_no);

	////////////// 예슬님
	@Select("SELECT * FROM CONSUME WHERE USER_NO=#{user_no} AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date}")
	List<Consume> getMonthConsume(@Param("user_no") int user_no, @Param("date") String date);

	@Select("SELECT * FROM CONSUME WHERE USER_NO=#{user_no} AND TO_CHAR(C_DATE, 'YYYY-MM-DD') = #{date}")

	List<Consume> getDayConsume(@Param("user_no") long user_no, @Param("date") String date);

	@Select("SELECT buser.user_nickname " + "FROM CONSUME " + "JOIN user_group ON CONSUME.USER_NO = user_group.USER_NO "
			+ "JOIN buser ON user_group.USER_NO = buser.USER_NO " + "WHERE user_group.G_NO = #{g_no} "
			+ "AND TO_CHAR(CONSUME.C_DATE, 'YYYY-MM-DD') = #{date} " + "GROUP BY buser.user_nickname "
			+ "ORDER BY SUM(CONSUME.c_money) deSC")
	List<String> getUserNicknames(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT SUM(CONSUME.c_money) AS total_money " + "FROM CONSUME "
			+ "JOIN user_group ON CONSUME.USER_NO = user_group.USER_NO "
			+ "JOIN buser ON user_group.USER_NO = buser.USER_NO " + "WHERE user_group.G_NO = #{g_no} "
			+ "AND TO_CHAR(CONSUME.C_DATE, 'YYYY-MM-DD') = #{date} " + "GROUP BY buser.user_nickname "
			+ "ORDER BY total_money deSC")
	List<Integer> getTotalMoneyList(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT * " + "FROM (" + "    SELECT user_no, SUM(c_money) AS total_money " + "    FROM CONSUME "
			+ "    WHERE USER_NO IN ( " + "        SELECT ug.user_no " + "        FROM user_group ug "
			+ "        JOIN bgroup bg ON ug.g_no = bg.g_no " + "        WHERE bg.g_no = #{g_no} "
			+ "    ) AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date} " + "    GROUP BY user_no "
			+ "    ORDER BY total_money DESC " + ") " + "WHERE ROWNUM = 1")
	List<Consume> getMemberMonthConsume(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT * " + "FROM (" + "    SELECT user_no, SUM(c_money) AS total_money " + "    FROM CONSUME "
			+ "    WHERE USER_NO IN ( " + "        SELECT ug.user_no " + "        FROM user_group ug "
			+ "        JOIN bgroup bg ON ug.g_no = bg.g_no " + "        WHERE bg.g_no = #{g_no} "
			+ "    ) AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date} " + "    GROUP BY user_no "
			+ "    ORDER BY total_money DESC " + ") " + "WHERE ROWNUM = 1")
	List<Consume> getMemberDayConsume(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT b.user_nickname, c.c_money, c.c_content, c.c_like " + "FROM CONSUME c "
			+ "JOIN user_group ug ON c.USER_NO = ug.USER_NO " + "JOIN buser b ON c.USER_NO = b.USER_NO "
			+ "WHERE ug.G_NO = #{g_no} " + "AND TO_CHAR(c.C_DATE, 'YYYY-MM-DD') = #{date}")
	List<Consume> getGroupConsumeByDate(@Param("g_no") long g_no, @Param("date") String date);

}
