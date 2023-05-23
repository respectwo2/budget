package multicapmpus.kb3.kb3project.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;

@Mapper
public interface BudgetMapper {
	//버찌 등록
	int save(@Param("budget") Budget budget );
	//버찌 리스트
	List<BudgetList> findbudgetAll(@Param("user_no") int user_No);
	//버찌 별 소비 리스트
	List<Consume> findbudgetC(@Param("user_no") int user_No, @Param("bd_no") int bd_No);
	//Budget getBudgetById(@Param("user_no") int user_No);
	
}
