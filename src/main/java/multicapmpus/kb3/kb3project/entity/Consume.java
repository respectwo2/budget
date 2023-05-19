package multicapmpus.kb3.kb3project.entity;

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
}
