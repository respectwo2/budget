package multicapmpus.kb3.kb3project.entity;

<<<<<<< HEAD
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
	
=======
import java.time.LocalDate;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
public class Consume {
	private long c_no;
	private long user_no;
	private long c_money;
	private long c_categoryId;
	private LocalDate c_date;
	private String c_image;
>>>>>>> origin/ys
}
