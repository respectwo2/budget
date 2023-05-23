package multicapmpus.kb3.kb3project.entity;
import java.util.Date;

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
}
