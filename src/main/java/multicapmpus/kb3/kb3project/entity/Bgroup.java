package multicapmpus.kb3.kb3project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
-- 그룹
CREATE TABLE Bgroup (
g_no	NUMBER(8)		NOT NULL,  -- pk, sequence(PK_BGROUP)
g_name	nvarchar2(150)		NOT NULL,  -- 그룹명
g_maxpeople	NUMBER(8)		NOT NULL,  -- 최대인원
g_content	nvarchar2(200)		NOT NULL,  -- 그룹 설명
g_tag	nvarchar2(100)	NULL,  -- 태그
g_leader	NUMBER(8)		NULL,  -- 그룹장의 user_no
g_date	date	DEFAULT SYSDATE NOT	NULL,  -- 그룹생성일, 기본값: sysdate
g_private	number(8)	DEFAULT 0	NULL  -- 일단 사용 X
);
 */

@Data
@NoArgsConstructor
public class Bgroup {
    private int g_no;
    private String g_name;
    private int g_maxpeople;
    private String g_tag;
    private int g_requiredTag;
    private int g_leader;
    private String g_date;
    private String g_content;
    private char g_private;
}