package multicapmpus.kb3.kb3project.service;

import java.util.List;


import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.mapper.BudgetMapper;

public class BudgetServiceImpl implements BudgetService {
	
	private final BudgetMapper budgetMapper;
	
//	@Autowired
    public BudgetServiceImpl(BudgetMapper budgetMapper) {
        this.budgetMapper = budgetMapper;
    }

    @Override
    public List<Budget> getBudgetList() {
        return budgetMapper.getBudgetList();
    }

}
