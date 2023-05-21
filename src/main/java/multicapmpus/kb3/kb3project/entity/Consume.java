package multicapmpus.kb3.kb3project.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class Consume {
	private int c_no;
	private int user_no;
	private int c_money;
	private int c_categoryid;
	private Date c_date;
	private String c_image;
	private String c_content;
	
}
