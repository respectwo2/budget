package multicapmpus.kb3.kb3project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
-- user-group 맵핑
CREATE TABLE user_group (
usergroup	NUMBER(8)		NOT NULL,  -- pk, sequence = PK_USER_GROUP
user_no	NUMBER(8)		NOT NULL,  -- 회원no, fk: buser (user_no)
g_no	NUMBER(8)		NOT NULL  -- 그룹no, fk: bgroup (g_no)
);
 */

@Data
@NoArgsConstructor
public class UserGroup {
    private int userGroup;
    private int user_no;
    private int g_no;
}
