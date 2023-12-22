SELECT 
		*
	FROM tbl_menu
	JOIN tbl_category ON tbl_menu.category_code = tbl_category.category_code;
	
-- ---------------------------
-- 조인 할 두테이블 각각 전체 조회
SELECT 
		 *
	FROM tbl_menu;
	
SELECT 
		 *
	FROM tbl_category;
	
-- 메뉴명과 카테고리명만 조회
SELECT
		 menu_name
		,category_name 
	FROM tbl_menu
	JOIN tbl_category ON (tbl_menu.category_code = tbl_category.category_code);
	
-- 테이블명도 별칭(alias)을 붙일 수 있다.
SELECT 
		 menu_name
		,category_name
	FROM tbl_menu a
	JOIN tbl_category b ON (a.category_code = b.category_code);
	
-- 두 테이블에 같은 컬럼명이 있는 상태에서 조인 시 주의할 점(컬럼명이 양쪽 테이블에 다있을경우 꼭 별칭 붙여야함)
SELECT 
		 menu_name
		,category_name
	FROM tbl_menu a
	JOIN tbl_category b ON (category_code = category_code); -- 별칭 붙여야함

SELECT
		 menu_name
		,category_name
		,category_code -- 별칭 붙여야함
	FROM tbl_menu a
	JOIN tbl_category b ON(a.category_code = b.category_code);
	
-- 관례상 join시에는 쿼리에 사용되는 모든 컬럼에 별칭을 다는 것을 원칙으로 한다.
SELECT
		 a.menu_name
		,b.category_name
		,a.category_code -- 별칭 붙여야함
	FROM tbl_menu a
	JOIN tbl_category b ON(a.category_code = b.category_code)
  WHERE b.category_code = 8; 
  
-- ----------------------------------
-- 1) inner join: on 또는 using 뒤에 오는 join의 조건을 만족하여 매칭되는 결과들만 join됨.
SELECT
		 *
	FROM tbl_menu a
	JOIN tbl_category b ON (a.category_code = b.category_code);
  WHERE b.category_code = 7; -- 조회결과 없음(7번 카테고리는 존재하지만 join에는 존재X)

-- 2) left join: join 키워드 기준 왼쪽 테이블의 행이 모두 나오도록 join

-- 카테고리가 없는 메뉴를 만들기 위해
-- a. 메뉴 카테고리에 null이 들어갈 수 있게 not null 제약 조건 해제
SELECT * FROM tbl_menu WHERE menu_code = 1;
ALTER TABLE tbl_menu CHANGE category_code category_code INTEGER DEFAULT NULL;
-- ALTER TABLE tbl_menu MODIFY COLUMN category_code INTEGER NOT NULL; -- NOT NULL로 재설정

-- b. 1번 메뉴의 메뉴 카테고리가 null로 변경 되게 설정
UPDATE tbl_menu
   SET category_code = null
 WHERE menu_code = 1;
 
-- c. 1번 메뉴의 메뉴 카테고리가 없는 상태에서 inner join vs left join 비교하기   
SELECT
       *
  FROM tbl_menu a
  JOIN tbl_category b ON (a.category_code = b.category_code);
  
SELECT
       *
  FROM tbl_menu a
  LEFT JOIN tbl_category b ON (a.category_code = b.category_code);

-- 3) right join: join 키워드 기분 오늘쪽 테이블의 행이 모두 나오도록 join
SELECT
       *
  FROM tbl_menu a
  JOIN tbl_category b ON (a.category_code = b.category_code);
  
SELECT
       *
  FROM tbl_menu a
 RIGHT JOIN tbl_category b ON (a.category_code = b.category_code);

-- 4) cross join
SELECT 
		 *
	FROM tbl_menu a
	JOIN tbl_category b ON (1=1);
	
SELECT 
		 *
	FROM tbl_menu a
	CROSS JOIN tbl_category b;

-- 5) self join
-- 카테고리안에 상위와 하위의 개념이 나뉘어있을때 사용
-- self join은 하나의 테이블에 상위 개념과 하위 개념이 모두 들어있을 때 자기 자신 테이블을 
-- join하게 되는 경우에 사용한다.
-- (ex: 신입사원 vs 사수(선배사원),
-- 하위 카테고리 vs 상위 카테고리
-- 댓글 vs 대댓글 등)
SELECT 
		 *
	FROM tbl_category;
	
SELECT
		 a.category_name
		,b.category_name 
	FROM tbl_category a
	JOIN tbl_category b ON (a.ref_category_code = b.category_code);
	
