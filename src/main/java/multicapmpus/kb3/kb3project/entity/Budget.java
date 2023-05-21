package multicapmpus.kb3.kb3project.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Budget {
	private int bd_no;
	private String bd_name;
	private int bd_goal;
	private String bd_content;
	private Date bd_start;
	private Date bd_end;
	private int bd_goalnow;
	private int user_no;
}	
