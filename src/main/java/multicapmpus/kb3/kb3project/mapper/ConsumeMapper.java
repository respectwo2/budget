package multicapmpus.kb3.kb3project.mapper;

import java.util.List;

<<<<<<< HEAD
import org.apache.ibatis.annotations.Insert;
=======
>>>>>>> origin/ys
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import multicapmpus.kb3.kb3project.entity.Consume;

<<<<<<< HEAD


@Mapper
public interface ConsumeMapper {
	@Select("Select * from CONSUME ORDER BY c_no DESC")
	public List<Consume> getAll();

	@Insert
	("insert into CONSUME (c_no, user_no, c_money, c_categoryid, c_date, c_image,c_content) "
			+ "VALUES (#{csm.c_no},#{csm.user_no},#{csm.c_money},#{csm.c_categoryid},sysdate,#{csm.c_image},#{csm.c_content})")
	int save(@Param("csm") Consume csm);
=======
@Mapper
public interface ConsumeMapper {
	
	@Select("SELECT * FROM CONSUME WHERE USER_NO=#{user_no} AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date}")
	List<Consume> getMonthConsume(@Param("user_no") long user_no, @Param("date") String date);
	
	@Select("SELECT * FROM CONSUME WHERE USER_NO=#{user_no} AND TO_CHAR(C_DATE, 'YYYY-MM-DD') = #{date}")
	List<Consume> getDayConsume(@Param("user_no") long user_no, @Param("date") String date);
>>>>>>> origin/ys
	
}
