-- VIEW
SELECT 
		 menu_name
	  , menu_price
	FROM tbl_menu;
	
CREATE or replace VIEW v_menu  -- or replace라는 옵션이 있어서 계속 수정 가능
AS
SELECT
		 menu_name '메뉴 이름'
	  , menu_price '메뉴 가격'
  FROM tbl_menu;
  
SELECT * FROM v_menu;

-- view는 원본테이블을 참조해서 보여주는 용도이고 실제 보여지는건
-- 원본 테이블의 데이터이다.

-- 원본인 tbl_menu의 11번 메뉴 가격을 10원으로 수정해보자.
UPDATE tbl_menu
	SET menu_price = 10
 WHERE menu_code = 11;
 
-- v_menu(뷰)로 확인해보자.
SELECT * FROM v_menu;

-- --------------------------------------
SELECT * FROM tbl_menu;

-- VIEW 생성
CREATE VIEW hansik AS
SELECT 
       menu_code 
     , menu_name
     , menu_price
     , category_code
     , orderable_status
  FROM tbl_menu 
 WHERE category_code = 4;

-- 생성된 VIEW 조회
SELECT * FROM hansik;

-- -----------------
INSERT 
  INTO tbl_menu 
VALUES (null, '식혜맛국밥', 5500, 4, 'Y');
SELECT * FROM hansik;

-- -------------------
INSERT 
  INTO hansik
VALUES (99, '수정과맛국밥', 5500, 4, 'Y');   
SELECT * FROM hansik;
SELECT * FROM tbl_menu;

-- ---------------------
UPDATE hansik
   SET menu_name = '버터맛국밥', menu_price = 5700 
 WHERE menu_code = 99;
SELECT * FROM hansik;
SELECT * FROM tbl_menu;

-- ---------------------
DELETE FROM hansik WHERE menu_code = 99;
SELECT * FROM hansik;
SELECT * FROM tbl_menu;

-- -------------
DROP VIEW hansik;