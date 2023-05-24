package multicapmpus.kb3.kb3project.entity;

import java.time.LocalDate;


public class GroupConsume {
	private int c_money;
	private int user_no;
	private String user_nickname;
	private LocalDate c_date;
	public int getC_money() {
		return c_money;
	}
	public void setC_money(int c_money) {
		this.c_money = c_money;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public LocalDate getC_date() {
		return c_date;
	}
	public void setC_date(LocalDate c_date) {
		this.c_date = c_date;
	}
	@Override
	public String toString() {
		return "GroupConsume [c_money=" + c_money + ", user_no=" + user_no + ", user_nickname=" + user_nickname
				+ ", c_date=" + c_date + "]";
	}
	
	
	
}
