package multicapmpus.kb3.kb3project.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BgroupmissionInfo {
    private String bgm_content;
    private String bgm_name;
    private String bgm_start;
    private String bgm_end;
    private int bgm_goal;
    private List<Integer> userCList;
    private List<Integer> userNoList;
}
