package multicapmpus.kb3.kb3project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import multicapmpus.kb3.kb3project.entity.Consume;



@Mapper
public interface ConsumeMapper {
	@Select("Select * from CONSUME ORDER BY c_no DESC")
	public List<Consume> getAll();

	@Insert
	("insert into CONSUME (c_no, user_no, c_money, c_categoryid, c_date, c_image,c_content) "
			+ "VALUES (#{csm.c_no},#{csm.user_no},#{csm.c_money},#{csm.c_categoryid},sysdate,#{csm.c_image},#{csm.c_content})")
	int save(@Param("csm") Consume csm);
	
}
