package multicapmpus.kb3.kb3project.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class Bgroupmission {
    private int bgm_no;
    private int bgm_goal;
    private String bgm_content;
    private String bgm_start;
    private String bgm_end;
    private String bgm_name;
    
	public int getBgm_no() {
		return bgm_no;
	}
	public void setBgm_no(int bgm_no) {
		this.bgm_no = bgm_no;
	}
	public int getBgm_goal() {
		return bgm_goal;
	}
	public void setBgm_goal(int bgm_goal) {
		this.bgm_goal = bgm_goal;
	}
	public String getBgm_content() {
		return bgm_content;
	}
	public void setBgm_content(String bgm_content) {
		this.bgm_content = bgm_content;
	}
	public String getBgm_start() {
		return bgm_start;
	}
	public void setBgm_start(String bgm_start) {
		this.bgm_start = bgm_start;
	}
	public String getBgm_end() {
		return bgm_end;
	}
	public void setBgm_end(String bgm_end) {
		this.bgm_end = bgm_end;
	}
	public String getBgm_name() {
		return bgm_name;
	}
	public void setBgm_name(String bgm_name) {
		this.bgm_name = bgm_name;
	}
	@Override
	public String toString() {
		return "Bgroupmission [bgm_no=" + bgm_no + ", bgm_goal=" + bgm_goal + ", bgm_content=" + bgm_content
				+ ", bgm_start=" + bgm_start + ", bgm_end=" + bgm_end + ", bgm_name=" + bgm_name + "]";
	}
    
    
}
