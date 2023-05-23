package multicapmpus.kb3.kb3project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class Bcomment {
    private int cmn_no;
    private int user_no;
    private int c_no;
    private LocalDate cmn_date;
    private String cmn_content;
}

/*
-- 댓글
CREATE TABLE Bcomment (
cmn_no	NUMBER(8)		NOT NULL,  -- pk, sequence = PK_BCOMMENT
user_no	NUMBER(8)		NOT NULL,  -- 회원no, fk: buser (user_no)
c_no	NUMBER(8)		NULL,  -- 소비no, fk: consume (c_no)
cmn_date	DATE		NULL,  -- 지출일
cmn_content	nvarchar2(200)		NULL,  -- 내용
);
 */