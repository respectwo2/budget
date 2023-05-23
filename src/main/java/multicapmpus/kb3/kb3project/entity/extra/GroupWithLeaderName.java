package multicapmpus.kb3.kb3project.entity.extra;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroupWithLeaderName {
    private int g_no;
    private String g_name;
    private int g_maxpeople;
    private String g_requiredTag;
    private String g_tag;
    private int g_leader;
    private String g_leaderName;
    private String g_date;
    private String g_content;
    private char g_private;
}