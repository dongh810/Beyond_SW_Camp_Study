-- between 연산자 활용하기
-- 가격이 5000원 이상 9000원 이하인 메뉴 전체 컬럼 조회
SELECT 
		 *
	FROM tbl_menu
	WHERE menu_price >= 5000
	AND menu_price <= 9000;
	
SELECT 
		 *
		 FROM tbl_menu
		WHERE menu_price BETWEEN 5000 AND 9000;
		
-- -----------------------
-- LIKE 검색 활용하기
SELECT 
		 *
 FROM tbl_menu
WHERE menu_name LIKE '%밥%';

-- 메뉴이름에 '밥'이 들어가지 않는 메뉴 조회하기
SELECT
		 *
	FROM tbl_menu
-- where menu_name not like '%밥%';
 WHERE NOT menu_name LIKE '%밥%';
 
 -- -------------------------------------------------
 -- in연산자
 SELECT * FROM tbl_category;
 
 -- or을 활용한 '중식','커피','기타' 카테고리의 메뉴 조회하기
 SELECT 
 		 *
 	FROM tbl_menu
 WHERE category_code = 5
 	 OR category_code = 8
 	 OR category_code = 10;
 	 
-- in연산자 활용
SELECT
		 *
	FROM tbl_menu
 WHERE category_code IN (5,8,10);
 
 -- --------------------------------
 -- is null 연산자 활용
 SELECT * FROM tbl_category;
 
 -- ref_category_code(상위 카테고리 번호)가 없는 카테고리 조회
 SELECT 
 		 *
 	FROM tbl_category 
 WHERE ref_category_code IS NULL;
 
 -- 반대도 해보자.
 SELECT
 		 * 
  FROM tbl_category
 WHERE ref_category_code IS NOT NULL;