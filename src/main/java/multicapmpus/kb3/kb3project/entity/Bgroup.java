package multicapmpus.kb3.kb3project.entity;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Bgroup {
    private int g_no;
    private int g_maxpeople;
    private String g_content;
    private int g_private;
    private String g_tag;
    private Date g_date;
    private int g_leader;
    private String g_name;
}
