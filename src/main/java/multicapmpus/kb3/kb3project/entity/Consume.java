package multicapmpus.kb3.kb3project.entity;

public class Consume {
	private int c_money;
	private int c_categoryId;
	

	public int getC_money() {
		return c_money;
	}
	public void setC_money(int c_money) {
		this.c_money = c_money;
	}
	public int getC_categoryId() {
		return c_categoryId;
	}
	public void setC_categoryid(int c_categoryId) {
		this.c_categoryId = c_categoryId;
	}
	
	@Override
	public String toString() {
		return "Consume [c_money=" + c_money + ", c_categoryId=" + c_categoryId + "]";
	}
	
}
