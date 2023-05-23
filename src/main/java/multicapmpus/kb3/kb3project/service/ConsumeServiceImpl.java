package multicapmpus.kb3.kb3project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;

@Service
public class ConsumeServiceImpl implements ConsumeService {
	
	@Autowired
	ConsumeMapper mapper; 


	@Override
	public List<Consume> getMonthConsume(long user_no, String date) {
		return mapper.getMonthConsume(user_no, date);
	}

	@Override
	public List<Consume> getDayConsume(long user_no, String date) {
		System.out.println(date);
		return mapper.getDayConsume(user_no, date);
	}


	@Override
	public int[] getSum(List<Consume> consumes) {
		
		int [] arr = new int [32];  
		arr[0] = 0;
		
		for (Consume consume : consumes) {
			arr[0] += consume.getC_money();
			arr[consume.getC_date().getDayOfMonth()] += consume.getC_money();
		}
		
		return arr;
	}



}
