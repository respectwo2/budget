package multicapmpus.kb3.kb3project.service;

import java.util.List;
import java.util.Map;

import multicapmpus.kb3.kb3project.entity.Consume;

public interface ConsumeService {
	
	List<Consume> getMonthConsume(long user_no, String date);
	
	List<Consume> getDayConsume(long user_no, String date);
	
	int [] getSum(List<Consume> consumes);
}
