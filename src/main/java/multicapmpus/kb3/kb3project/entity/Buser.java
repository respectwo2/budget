package multicapmpus.kb3.kb3project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Buser {
    private int user_no;
    private String user_id;
    private String user_pwd;
    private String user_name;
    private String user_nickname;
    private String user_email;
}

/*
-- 회원
CREATE TABLE Buser (
user_no	NUMBER(8)		NOT NULL,  -- pk, sequence = PK_BUSER
user_id	nvarchar2(50)		NOT NULL,  -- id
user_pwd	nvarchar2(100)		NULL,  -- pwd
user_name	nvarchar2(30)		NOT NULL,  -- 이름
user_nickname	nvarchar2(100)		NULL,  -- 닉네임
user_email	nvarchar2(100)		NOT NULL  -- 이메일
);
 */