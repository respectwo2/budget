package multicapmpus.kb3.kb3project.service;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;

public interface BudgetService {
	//public List<Budget> getBudgetList();
	//Budget getBudgetByNo(int user_No);
	//踰꾩컡 �벑濡�
	int saveBudget(Budget budget);
	//踰꾩컡 由ъ뒪�듃
	List<BudgetList> findbudgetAll(int user_No);
	//踰꾩컡 蹂� �냼鍮� 由ъ뒪�듃
	List<Consume> findbudgetC(int user_No, int bd_No);

}