package multicapmpus.kb3.kb3project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.ConsumePlusCategory;
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
	public List<ConsumePlusCategory> findbudgetC(int user_No, int bd_No){
		return budgetMapper.findbudgetC(user_No, bd_No);
	}
	//버찌 정보
	@Override 
	public BudgetList getBudgetByNo(int bd_No) { 
		BudgetList bgl=budgetMapper.getBudgetByNo(bd_No); 
		return bgl; 
	}
	//버찌 날짜
	@Override
	public Budget getBdByNo(int bd_No) {
		Budget bd=budgetMapper.getBdByNo(bd_No);
		return bd;
	}
}
