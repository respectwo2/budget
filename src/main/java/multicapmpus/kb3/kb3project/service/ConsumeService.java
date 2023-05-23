package multicapmpus.kb3.kb3project.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import multicapmpus.kb3.kb3project.entity.Consume;

public interface ConsumeService {
	public List<Consume> getConsumeList();
	public Consume getConsumeDetail(int c_no);
	public void create(String date, int amount, int category,String memo, String photo);
//	public List<Consume> getConsumeListByDate(String c_date);
	public List<Consume> getConsumeListByDate(String c_date,HttpSession session, Model model);
	
	
	////////////////////////////////////ys
	List<Consume> getMonthConsume(int user_no, String date);

	List<Consume> getDayConsume(int user_no, String date);

	int [] getSum(List<Consume> consumes);
}
