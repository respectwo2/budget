package multicapmpus.kb3.kb3project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.mapper.BudgetMapper;
import multicapmpus.kb3.kb3project.service.BudgetService;

@SpringBootApplication
public class Kb3projectApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Kb3projectApplication.class, args);
		context.getBean(Kb3projectApplication.class).execute();
	}

	private void execute() {
		//insert();
	}


//	private void insert() {
//		Budget budget = new Budget();
//		budget.setBd_name("2주동안 5만원쓰기");
//		budget.setBd_goal(50000);
//		budget.setBd_content("아자자 화이팅이다 !");
//		budget.setBd_start("2023-05-16");
//		budget.setBd_end("2023-05-30");
//		budget.setBd_goalnow(10000);
//		budget.setUser_no(1);
//		mapper.save(budget);	
//	}

}
