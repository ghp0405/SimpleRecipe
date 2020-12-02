CREATE TABLE USER_INFO(
  USER_TB_NO NUMBER(5, 0) CONSTRAINT PK_USER_TB_NO PRIMARY KEY,
  USER_TB_NAME VARCHAR2(30),
  USER_TB_ID VARCHAR2(60) CONSTRAINT NN_USER_TB_ID NOT NULL,
  USER_TB_PWD VARCHAR2(60) CONSTRAINT NN_USER_TB_PWD NOT NULL,
  USER_TB_GENDER CHAR(1) DEFAULT 'M' CONSTRAINT NN_USER_TB_GENDER NOT NULL CONSTRAINT CK_USER_TB_GENDER CHECK(USER_TB_GENDER IN('M', 'F')),
  USER_TB_BIRTHDAY DATE CONSTRAINT NN_USER_TB_BIRTHDAY NOT NULL,
  USER_TB_EMAIL VARCHAR2(150) CONSTRAINT NN_USER_TB_EMAIL NOT NULL,
  USER_TB_PHONE VARCHAR2(13),
  USER_TB_JOIN_DATE DATE DEFAULT SYSDATE CONSTRAINT NN_USER_TB_JOIN_DATE NOT NULL,
  USER_TB_JOIN_PATH CHAR(1) DEFAULT 'C' CONSTRAINT NN_USER_TB_JOIN_PATH NOT NULL CONSTRAINT CK_USER_TB_JOIN_PATH CHECK(USER_TB_JOIN_PATH IN('C', 'K')),
  USER_TB_STATE CHAR(1) DEFAULT 'E' CONSTRAINT NN_USER_TB_STATE NOT NULL CONSTRAINT CK_USER_TB_STATE CHECK(USER_TB_STATE IN('E', 'D'))
);
ALTER TABLE USER_INFO ADD CONSTRAINT UNIQUE_USER_TB_ID UNIQUE (USER_TB_ID);

CREATE SEQUENCE SEQ_USER_TB_NO INCREMENT BY 1 START WITH 1 
NOCYCLE NOCACHE;

CREATE TABLE RECIPE(
  RECIPE_TB_NO NUMBER(5, 0) CONSTRAINT PK_RECIPE_TB_NO PRIMARY KEY,
  USER_TB_NO NUMBER(5, 0) NOT NULL, -- FOREIGN KEY
  RECIPE_TB_TITLE VARCHAR2(300) CONSTRAINT NN_RECIPE_TB_TITLE NOT NULL,
  RECIPE_TB_CONTENT_LINK VARCHAR2(300), -- TXT������ ������ ��Ƽ� �̸� ������
  RECIPE_TB_IMAGE_LINK VARCHAR2(300) DEFAULT '/resources/img/recipe/default_img.png'
);
ALTER TABLE RECIPE DROP CONSTRAINT FK_USER_TB_NO; -- �������� ���� �Ұ��� -> ���� �� �ٽ� �����������
ALTER TABLE RECIPE ADD CONSTRAINT FK_USER_TB_NO FOREIGN KEY(USER_TB_NO) REFERENCES USER_INFO(USER_TB_NO) ON DELETE CASCADE;

CREATE SEQUENCE SEQ_RECIPE_TB_NO INCREMENT BY 301 START WITH 1 
NOCYCLE NOCACHE;

CREATE TABLE INGREDIENT_LIST(
  RECIPE_TB_NO NUMBER(5, 0), -- FK(RECIPE)
  INGREDIENT_TB_NO NUMBER(5, 0), -- FK(INGREDIENT)
  INGREDIENT_LIST_TB_AMT VARCHAR2(150),
  CONSTRAINT PK_INGREDIENT_LIST PRIMARY KEY(RECIPE_TB_NO, INGREDIENT_TB_NO)
);
ALTER TABLE INGREDIENT_LIST DROP CONSTRAINT FK_RECIPE_TB_NO;
ALTER TABLE INGREDIENT_LIST DROP CONSTRAINT FK_INGREDIENT_TB_NO;
ALTER TABLE INGREDIENT_LIST ADD CONSTRAINT FK_RECIPE_TB_NO FOREIGN KEY(RECIPE_TB_NO) REFERENCES RECIPE(RECIPE_TB_NO) ON DELETE CASCADE;
ALTER TABLE INGREDIENT_LIST ADD CONSTRAINT FK_INGREDIENT_TB_NO FOREIGN KEY(INGREDIENT_TB_NO) REFERENCES INGREDIENT(INGREDIENT_TB_NO) ON DELETE CASCADE;

CREATE SEQUENCE SEQ_INGREDIENT_LIST_TB_NO INCREMENT BY 1 START WITH 1 
NOCYCLE NOCACHE;

CREATE TABLE INGREDIENT(
  INGREDIENT_TB_NO NUMBER(5, 0) CONSTRAINT PK_INGREDIENT_TB_NO PRIMARY KEY,
  INGREDIENT_TB_NAME VARCHAR2(120) CONSTRAINT NN_INGREDIENT_TB_NAME NOT NULL
);

CREATE SEQUENCE SEQ_INGREDIENT_TB_NO INCREMENT BY 1 START WITH 1 
NOCYCLE NOCACHE;

CREATE TABLE NOTICE(
  NOTICE_TB_NO NUMBER(5, 0) CONSTRAINT PK_NOTICE_TB_NO PRIMARY KEY,
  NOTICE_TB_TITLE VARCHAR2(300) CONSTRAINT NN_NOTICE_TB_TITLE NOT NULL,
  ADMIN_TB_ID VARCHAR2(60), -- FK NOT NULL
  NOTICE_TB_CONTENT VARCHAR2(4000),
  NOTICE_TB_REG_DATE DATE DEFAULT SYSDATE CONSTRAINT NN_NOTICE_TB_REG_DATE NOT NULL
);
ALTER TABLE NOTICE ADD CONSTRAINT FK_ADMIN_TB_ID FOREIGN KEY(ADMIN_TB_ID) REFERENCES ADMIN(ADMIN_TB_ID) ON DELETE CASCADE;

CREATE SEQUENCE SEQ_NOTICE_TB_NO INCREMENT BY 1 START WITH 1 
NOCYCLE NOCACHE;

CREATE TABLE QNA(
  QNA_TB_NO NUMBER(5, 0) CONSTRAINT PK_QNA_TB_NO PRIMARY KEY,
  QNA_TB_TITLE VARCHAR2(300) CONSTRAINT NN_QNA_TB_TITLE NOT NULL,
  USER_TB_ID VARCHAR2(60) NOT NULL, -- FK NOT NULL
  QNA_TB_CONTENT VARCHAR2(4000),
  QNA_TB_REG_DATE DATE DEFAULT SYSDATE CONSTRAINT NN_QNA_TB_REG_DATE NOT NULL
);
ALTER TABLE QNA ADD CONSTRAINT FK_USER_TB_ID FOREIGN KEY(USER_TB_ID) REFERENCES USER_INFO(USER_TB_ID) ON DELETE CASCADE;

CREATE SEQUENCE SEQ_QNA_TB_NO INCREMENT BY 1 START WITH 1 
NOCYCLE NOCACHE;

CREATE TABLE ADMIN(
  ADMIN_TB_NO NUMBER(5, 0) CONSTRAINT PK_ADMIN_TB_NO PRIMARY KEY,
  ADMIN_TB_ID VARCHAR2(60) CONSTRAINT NN_ADMIN_TB_ID NOT NULL,
  ADMIN_TB_PWD VARCHAR2(60) CONSTRAINT NN_ADMIN_TB_PWD NOT NULL,
  ADMIN_TB_POSITION VARCHAR2(30) CONSTRAINT NN_ADMIN_TB_POSITION NOT NULL
);
ALTER TABLE ADMIN ADD CONSTRAINT UNIQUE_ADMIN_TB_ID UNIQUE (ADMIN_TB_ID);

CREATE SEQUENCE SEQ_ADMIN_TB_NO INCREMENT BY 1 START WITH 1 
NOCYCLE NOCACHE;

CREATE TABLE COMMENT_INFO(
  COMMENT_TB_NO NUMBER(5, 0) CONSTRAINT PK_COMMENT_TB_NO PRIMARY KEY,
  USER_TB_NO NUMBER(5, 0) NOT NULL, -- FK
  RECIPE_TB_NO NUMBER(5, 0) NOT NULL, -- FK
  COMMENT_TB_CONTENT VARCHAR2(4000),
  COMMENT_TB_REF NUMBER(5, 0) DEFAULT 0 CONSTRAINT NN_COMMENT_TB_REF NOT NULL,
  COMMENT_TB_STEP NUMBER(5, 0) DEFAULT 0 CONSTRAINT NN_COMMENT_TB_STEP NOT NULL,
  COMMENT_TB_DEPTH NUMBER(5, 0) DEFAULT 0 CONSTRAINT NN_COMMENT_TB_DEPTH NOT NULL
);
-- ���߿� �۾��ϰԵ� ������Ʈ������ ������ �������� �����ϴ°� ���ڴ�.
-- COMMENT_INFO_FK_USER_TB_NO �Ǵ� ���⿡ ���� ���� ������ ���� ���°� ����. 
-- � ���̺��� ������ �ִ� ������������ �ѹ��� Ȯ���� �� �ְ�...
ALTER TABLE COMMENT_INFO ADD CONSTRAINT FK_USER_TB_NO_CMT FOREIGN KEY(USER_TB_NO) REFERENCES USER_INFO(USER_TB_NO) ON DELETE CASCADE;
ALTER TABLE COMMENT_INFO ADD CONSTRAINT FK_RECIPE_TB_NO_CMT FOREIGN KEY(RECIPE_TB_NO) REFERENCES RECIPE(RECIPE_TB_NO) ON DELETE CASCADE;

-- ������ mybatis�� �ݿ��� ������
WITH
RE2 AS (SELECT RECIPE_TB_NO, COUNT(RECIPE_TB_NO) AS CNT
  FROM INGREDIENT_LIST NATURAL JOIN INGREDIENT
  WHERE INGREDIENT_TB_NAME IN ('����', '����', '���', '��') 
  GROUP BY RECIPE_TB_NO),
RE3 AS (SELECT RECIPE_TB_NO, USER_TB_NO, RECIPE_TB_TITLE, RECIPE_TB_CONTENT_LINK, RECIPE_TB_IMAGE_LINK, RE2.CNT AS CNT
  FROM RECIPE RE1 NATURAL JOIN RE2
  ORDER BY CNT DESC),
RE4 AS (SELECT RECIPE_TB_NO, USER_TB_NO, RECIPE_TB_TITLE, RECIPE_TB_CONTENT_LINK, RECIPE_TB_IMAGE_LINK, CNT, ROWNUM AS RNUM 
  FROM RE3)
SELECT COUNT(*) 
FROM RE4
WHERE RNUM BETWEEN 1 AND 200;

SELECT COUNT(*) FROM INGREDIENT;



-- insert ó��(������, ��� ���, ��� 3���� ���̺��� ���� ó���� ���ÿ� �ϴ� ������ �޸�..)

-- 1�� ������ �������� ó��
-- �ű� ������ �߰�
INSERT INTO RECIPE(RECIPE_TB_NO, USER_TB_NO, RECIPE_TB_TITLE, RECIPE_TB_CONTENT_LINK, RECIPE_TB_IMAGE_LINK)
VALUES(SEQ_RECIPE_TB_NO.NEXTVAL, 1, '���ִ� ����', 
'txt/recipe/recipe_'|| SEQ_RECIPE_TB_NO.CURRVAL ||'.txt', 
'/resources/img/recipe/img_'|| SEQ_RECIPE_TB_NO.CURRVAL ||'.jpg');

DROP SEQUENCE SEQ_RECIPE_TB_NO;
CREATE SEQUENCE  "ADMIN"."SEQ_RECIPE_TB_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 301 NOCACHE  NOORDER  NOCYCLE ;
DROP SEQUENCE SEQ_INGREDIENT_TB_NO;
CREATE SEQUENCE  "ADMIN"."SEQ_INGREDIENT_TB_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 585 NOCACHE  NOORDER  NOCYCLE ;

WITH
SUB1 AS (SELECT ADMIN_TB_ID FROM ADMIN)
SELECT NOTICE_TB_NO, NOTICE_TB_TITLE, 
				ADMIN_TB_ID, ADMIN_TB_NO, NOTICE_TB_CONTENT, NOTICE_TB_REG_DATE 
FROM NOTICE NATURAL JOIN ADMIN;

-- �ش� plsql������ ���� ������ ����
-- ���ο� ��Ḧ �߰�
-- INGREDIENT�� ���� �߰��ϴ� ������
-- ����� -> ��� ������ �� ���, ��� ����� �߰��� �� ���� ���� �ű� ��Ḧ �����ؾ��ϴ� ��Ȳ�� ����
-- �ݴ��� ���, ��� ����� �߰��� �� ���� ��Ͽ� ���� �͸� �����ϸ� ��. ��, ������ ���� ��������
-- foreach���� �̿��Ͽ� ��� ���̸�ŭ �ݺ��� ��������
-- SET SERVEROUTPUT ON;

--DECLARE
--str varchar2(120);
--ING_NO NUMBER := 0;
--ING_NAME VARCHAR2(120);
--ING_CNT NUMBER := 0;
--BEGIN
--str := '�ڻ�����';
--ING_NAME := '';
--
--  SELECT COUNT(*)
--  INTO ING_CNT
--  FROM INGREDIENT
--  WHERE INGREDIENT_TB_NAME = str;
--  
--  IF ING_CNT = 0 THEN
--      INSERT INTO INGREDIENT(INGREDIENT_TB_NO, INGREDIENT_TB_NAME) 
--      VALUES(SEQ_INGREDIENT_TB_NO.NEXTVAL, str);
--    ING_NO := SEQ_INGREDIENT_TB_NO.CURRVAL;
--  ELSE
--      SELECT INGREDIENT_TB_NO, INGREDIENT_TB_NAME
--      INTO ING_NO, ING_NAME
--      FROM INGREDIENT
--      WHERE INGREDIENT_TB_NAME = str;
--  END IF;
--  INSERT INTO INGREDIENT_LIST(RECIPE_TB_NO, INGREDIENT_TB_NO)
--  VALUES(SEQ_RECIPE_TB_NO.NEXTVAL, ING_NO);
--  
--END;
    


SELECT INGREDIENT_TB_NO, INGREDIENT_TB_NAME 
FROM INGREDIENT 
WHERE INGREDIENT_TB_NO = 590;

-- ��¥ ���� �����ϴ� ���
alter session set nls_date_format = 'YYYY-MM-DD';