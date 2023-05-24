package multicapmpus.kb3.kb3project.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import multicapmpus.kb3.kb3project.entity.Consume;

public interface ConsumeService {
	
	List<Consume> getMonthConsume(long user_no, String date);
	
	List<Consume> getDayConsume(long user_no, String date);
	
	int [] getSum(List<Consume> consumes);
	
	List<Consume> getGroupDayConsume(long g_no, String date);
	
	List<String> getUserNicknames(long g_no, String date);
	
	List<Integer> getTotalMoneyList(long g_no, String date);

	List<Consume> getMemberMonthConsume(long g_no, String date);
	
	List<Consume> getMemberDayConsume(long g_no, String date);
	
	
}
