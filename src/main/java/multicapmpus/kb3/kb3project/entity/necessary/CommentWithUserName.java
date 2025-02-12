package multicapmpus.kb3.kb3project.entity.necessary;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CommentWithUserName {
    private int cmn_no;
    private int user_no;
    private String user_name;
    private int c_no;
    private LocalDate cmn_date;
    private String cmn_content;
}
