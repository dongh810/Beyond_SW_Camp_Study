-- distinct
-- distinct는 해당 컬럼의 종류를 보여준다.
SELECT
		 DISTINCT category_code
	FROM tbl_menu;
	
-- distinct 사용 시에는 일반 컬럼을 사용할 수 없다.(distinct가 무의미해지기 때문에)
SELECT
		 DISTINCT category_code
--     ,menu_name
  FROM tbl_menu;

-- null값을 포함한 컬럼의 distinct
SELECT 
		 DISTINCT ref_category_code
	FROM tbl_category;
	
-- null을 나중으로 보내는 정렬
SELECT 
		 DISTINCT ref_category_code
	FROM tbl_category
 ORDER BY 1 DESC;
 
 SELECT 
 		 DISTINCT ref_category_code AS 'rcc'
 	FROM tbl_category
 ORDER BY -rcc DESC;
 
 -- 기본정렬의 개념(순번이나 별칭을 사용하지 않고는 정렬할 수 없다.)은
 -- syntax 에러(문법에러)가 발생한다.
 SELECT 
 		 DISTINCT ref_category_code
 	FROM tbl_category
 ORDER BY DISTINCT ref_category_code DESC; --에러발생
 
 -- ------------------------------
 -- 컬럼 두개 이상도 distinct로 묶을 수는 있지만 좋은 형태는 아니다.
 -- 컬럼 두개 이상부터는 이후 배울 group by절을 통해 중복 제거를 하자.
 SELECT 
 		 DISTINCT category_code, orderable_status
 	FROM tbl_menu;
