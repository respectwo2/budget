package multicapmpus.kb3.kb3project.entity.extra;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConsumeWithUserName {
    private int c_no;
    private int user_no;
    private String user_name;
    private String c_date;
    private int c_money;
    private int c_categoryId;
    private String c_content;
    private String c_image;
    private int c_like;
}
