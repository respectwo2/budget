package multicapmpus.kb3.kb3project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
-- 소비
CREATE TABLE Consume (
c_no	NUMBER(8)		NULL,  -- pk, sequence = C_NO_SEQ
user_no	NUMBER(8)		NOT NULL,  -- fk: buser (user_no)
c_date	DATE		NULL,  -- 지출일
c_money	NUMBER(8)		NULL,  -- 금액
c_categoryid	NUMBER(8)		NULL,  -- 카테고리
c_content   NVARCHAR2(500)     NULL,  -- 작성내용
c_image	NVARCHAR2(200)		NULL  -- 이미지
);
 */

@Data
@NoArgsConstructor
public class Consume {
    private int c_no;
    private int user_no;
    private LocalDate c_date;
    private int c_money;
    private int c_categoryid;
    private String c_content;
    private String c_image;
    private int c_like;
}

/*
 private int c_no;
	private int user_no;
	private int c_money;
	private int c_categoryid;
	private LocalDate c_date;
	private String c_image;
	private String c_content;
	private int c_like;
 */


