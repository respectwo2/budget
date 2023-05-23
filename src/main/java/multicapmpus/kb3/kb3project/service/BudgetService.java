package multicapmpus.kb3.kb3project.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;

public interface BudgetService {
	//public List<Budget> getBudgetList();
	//Budget getBudgetByNo(int user_No);
	//버찌 등록
	int saveBudget(Budget budget);
	//버찌 리스트
	List<BudgetList> findbudgetAll(int user_No);
	//버찌 별 소비 리스트
	List<Consume> findbudgetC(int user_No, int bd_No);
}
