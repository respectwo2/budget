package multicapmpus.kb3.kb3project.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class GroupConsume {
	private int c_money;
	private int user_no;
	private String user_nickname;
	private LocalDate c_date;
	
}
