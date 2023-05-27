package multicapmpus.kb3.kb3project.entity;

import java.time.LocalDate;

public class BudgetList {
	private int bd_no;
	private String bd_name;
	private int bd_goal;
	private int bd_goalleft;
	private String bd_dateleft;
	
	public String getBd_name() {
		return bd_name;
	}
	public void setBd_name(String bd_name) {
		this.bd_name = bd_name;
	}
	public int getBd_goal() {
		return bd_goal;
	}
	public void setBd_goal(int bd_goal) {
		this.bd_goal = bd_goal;
	}
	public int getBd_goalleft() {
		return bd_goalleft;
	}
	public void setBd_goalleft(int bd_goalleft) {
		this.bd_goalleft = bd_goalleft;
	}
	
	
	public String getBd_dateleft() {
		return bd_dateleft;
	}
	public void setBd_dateleft(String bd_dateleft) {
		this.bd_dateleft = bd_dateleft;
	}
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	@Override
	public String toString() {
		return "BudgetList [bd_no=" + bd_no + ", bd_name=" + bd_name + ", bd_goal=" + bd_goal + ", bd_goalleft="
				+ bd_goalleft + ", bd_dateleft=" + bd_dateleft + "]";
	}
	
	
	
}
