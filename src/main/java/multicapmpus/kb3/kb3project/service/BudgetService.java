package multicapmpus.kb3.kb3project.service;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.ConsumePlusCategory;

public interface BudgetService {
	//public List<Budget> getBudgetList();
	//Budget getBudgetByNo(int user_No);
	
	//버찌 등록
	int saveBudget(Budget budget);
	//버지 리스트 보여주기
	List<BudgetList> findbudgetAll(int user_No);
	//버찌 별 소비 리스트 보여주기
	List<ConsumePlusCategory> findbudgetC(int user_No, int bd_No);
	//버찌 정보
	BudgetList getBudgetByNo(int bd_No);
	//버찌 수행 날짜 보여주기
	Budget getBdByNo(int bd_No);

}