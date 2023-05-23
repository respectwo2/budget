package multicapmpus.kb3.kb3project.entity;


import java.time.LocalDate;
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
//	private String c_date;
	private LocalDate c_date;
	private String c_image;
	private String c_content;
	private int c_like;
	
	public int getC_like() {
		return c_like;
	}
	public void setC_like(int c_like) {
		this.c_like = c_like;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getC_money() {
		return c_money;
	}
	public void setC_money(int c_money) {
		this.c_money = c_money;
	}
	public int getC_categoryid() {
		return c_categoryid;
	}
	public void setC_categoryid(int c_categoryid) {
		this.c_categoryid = c_categoryid;
	}
//	public String getC_date() {
//		return c_date;
//	}
	public LocalDate getC_date() {
		return c_date;
	}
//	public void setC_date(String c_date) {
//		this.c_date = c_date;
//	}
	public void setC_date(LocalDate c_date) {
		this.c_date = c_date;
	}
	public String getC_image() {
		return c_image;
	}
	public void setC_image(String c_image) {
		this.c_image = c_image;
	}

}
