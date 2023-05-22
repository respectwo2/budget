package multicapmpus.kb3.kb3project.entity.extra;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CommentWithUserName {
    private int cmn_no;
    private int user_no;
    private String user_name;
    private int c_no;
    private Date cmn_date;
    private String cmn_content;
}
