-- 회원
CREATE TABLE Buser (
user_no	NUMBER(8)		NOT NULL,  -- pk, sequence = PK_BUSER
user_id	nvarchar2(50)		NOT NULL,  -- id
user_pwd	nvarchar2(100)		NULL,  -- pwd
user_name	nvarchar2(30)		NOT NULL,  -- 이름
user_nickname	nvarchar2(100)		NULL,  -- 닉네임
user_email	nvarchar2(100)		NOT NULL  -- 이메일
);

insert into buser (user_no, user_id, user_pwd, user_name, user_nickname, user_email)
    values (user_no_seq.nextval, 'alswn', 'fldk', '민주', '만쥬리아', 'alswn4980@naver.com');
insert into buser (user_no, user_id, user_pwd, user_name, user_nickname, user_email)
    values (user_no_seq.nextval, 'dong', 'ehddus', '동연', '동연쓰', 'ehddus00@naver.com');

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

-- ⚠️ g_leader: user_no 가져오기
insert into bgroup (g_no, g_name, g_maxpeople, g_content, g_tag, g_leader)
    values (g_no_seq.nextval, '개미들', 10, '저축에 관심있는 사람들이 모인 그룹', '직장인', 1);
insert into bgroup (g_no, g_name, g_maxpeople, g_content, g_tag, g_leader)
    values (g_no_seq.nextval, '돈마니', 50, '돈 좀 모으자', '대학생', 2);

-- ⚠️ 일단 임시로. 회원이 그룹 가입하기 눌렀을 때 이 쿼리 실행하면 될 듯
insert into user_group (userGroup, user_no, g_no)
    values (usergroup_no_seq.nextval, 1, 4);
insert into user_group (userGroup, user_no, g_no)
    values (usergroup_no_seq.nextval, 1, 5);

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

-- ⚠️ 미션 등록할 때 g_no 가져와서 쿼리에 넣어주기, 날짜값 가져오기,
insert into bgroupmission (bgm_no, g_no, bgm_name, bgm_content, bgm_start, bgm_end, bgm_goal)
    values (gms_no_seq.nextval, 4, '개미탈출', '돈 좀 모아봅시다. 열심히 아껴보자구용', DATE '2023-04-01', DATE '2023-04-01', 150000);

-- 소비
CREATE TABLE Consume (
c_no	NUMBER(8)		NULL,  -- pk, sequence = C_NO_SEQ
user_no	NUMBER(8)		NOT NULL,  -- fk: buser (user_no)
c_date	DATE		NULL,  -- 지출일
c_money	NUMBER(8)		NULL,  -- 금액
c_categoryid	NUMBER(8)		NULL,  -- 카테고리
c_image	NVARCHAR2(200)		NULL,  -- 이미지
c_content NVARCHAR2(500)    NULL  -- 작성내용
);

ALTER TABLE Consume ADD CONSTRAINT PK_CONSUME PRIMARY KEY (c_no);

ALTER TABLE Consume ADD CONSTRAINT FK_Buser_TO_Consume_1 FOREIGN KEY (user_no)
REFERENCES Buser (user_no);

-- 소비번호 시퀀스
CREATE SEQUENCE C_NO_SEQ
INCREMENT BY 1 --증감숫자 1
START WITH 1 --시작숫자 1
MINVALUE 1 --최소값 1
MAXVALUE 9999999999 --최대값
NOCYCLE --순한하지않음
NOCACHE; --메모리에 시퀀스값 미리할당


