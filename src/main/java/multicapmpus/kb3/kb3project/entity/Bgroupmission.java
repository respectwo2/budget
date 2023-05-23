package multicapmpus.kb3.kb3project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
-- 그룹미션
CREATE TABLE Bgroupmission (
bgm_no	NUMBER(8)		NOT NULL,  -- pk, sequence(PK_BGROUPMISSION)
g_no	NUMBER(8)		NOT NULL,  -- fk: bgroup (g_no)
bgm_name	nvarchar2(100)		NULL,  -- 미션명
bgm_content	nvarchar2(200)		NULL,  --
bgm_start	DATE		NULL,  -- 시작일
bgm_end	DATE		NULL,  -- 종료일
bgm_goal	NUMBER(10)		NULL  -- 목표금액
);
 */

@Data
@NoArgsConstructor
public class Bgroupmission {
    private int bgm_no;
    private int g_no;
    private String bgm_name;
    private String bgm_content;
    private LocalDate bgm_start;
    private LocalDate bgm_end;
    private int bgm_goal;
}

