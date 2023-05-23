package multicapmpus.kb3.kb3project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.mapper.BudgetMapper;

@Service
public class BudgetServiceImpl implements BudgetService {

	private final BudgetMapper budgetMapper;

	@Autowired 
	public BudgetServiceImpl(BudgetMapper budgetMapper) {	
		this.budgetMapper = budgetMapper; }
	//버찌 등록
	@Override 
	public int saveBudget(Budget budget) {
		int bbudget=budgetMapper.save(budget);
		return bbudget;
	}
	//버찌 리스트
	@Override
	public List<BudgetList> findbudgetAll(int user_No) {
		return budgetMapper.findbudgetAll(user_No);
	}
	//버찌 별 소비 리스트
	@Override
	public List<Consume> findbudgetC(int user_No, int bd_No){
		return budgetMapper.findbudgetC(user_No, bd_No);
	}
	
//	@Override 
	//public Budget getBudgetByNo(int user_No) { 
		//Budget budget=budgetMapper.getBudgetById(user_No); 
		//return budget; 
//	}
}

