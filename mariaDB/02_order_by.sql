-- 오름차순
SELECT 
		 menu_code
		,menu_name
		,menu_price
	FROM tbl_menu
 ORDER BY menu_price;

-- 내림차순
SELECT 
		 menu_code
		,menu_name
		,menu_price
	FROM tbl_menu
 ORDER BY menu_price desc;

-- 컬럼의 순번을 활용한 정령(실제 테이블의 순서가 아닌 조회할 때의 컬럼 순서 기준)
SELECT 
		 menu_price
		,menu_name
	FROM tbl_menu
 ORDER BY 1 ASC;
 
-- 별칭을 활요한 정렬
SELECT 
		 menu_code AS 'mc'
		,menu_name AS 'mn'
		,menu_price AS 'mp'
	FROM tbl_menu
 ORDER BY mc ASC; -- 별칭으로 정렬할 때는 별칭명에 single quatation(')을 붙이면 안된다.
 
-- 컬럼의 복수개로 정렬
SELECT 
       menu_price
      ,menu_name
   FROM tbl_menu
 ORDER BY 1 DESC, 2 ASC; -- '가격'으로 내림차순 후 같은 가격일 시, '메뉴이름'을 오름차순으로 조회
 
 -- -----------------------------------
 -- Field
 SELECT FIELD('a', 'b', 'a', 'b'); -- 2번째 이후 인자 중에 1번째 인자의 값이 위치하는 값이 나옴(=2)
 
 -- table에서 조회 시 field 활용
SELECT 
       FIELD(orderable_status,'N','Y')
      ,orderable_status
      ,menu_name
      ,menu_code
   FROM tbl_menu;
   
-- field를 활용한 order by
SELECT 
       menu_name
      ,orderable_status
   FROM tbl_menu
ORDER BY FIELD(orderable_status,'N','Y') DESC;

-- -------------------------
-- null 값에 대한 정렬
-- 오름차순 시: null값이 먼저나옴
SELECT
		 *
	FROM tbl_category
ORDER BY ref_category_code ASC;

-- 내림차순 시:null값이 나중에나옴
SELECT
		 *
	FROM tbl_category
ORDER BY ref_category_code DESC;

-- 오름차순에서 null이 나중에 나오도록 바꿈
SELECT 
		 *
	FROM tbl_category
	ORDER BY -ref_category_code DESC;  -- desc를 통해 null을 나중에 보냄 -> -로 null이 아닌 값을 asc로 바꿈
	
-- 내림차순에서 null이 처음에 오도록 바꿈
SELECT
		 * 
	FROM tbl_category
ORDER BY -ref_category_code ASC; -- asc를 통해 null을 처음으로 보냄 -> -로 null이 아닌값을 desc로 바꿈