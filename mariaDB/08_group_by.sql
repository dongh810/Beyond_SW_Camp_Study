-- 조회의 6가지 절을 모두 활용한 예제
-- select: group by 절에서 group을 묶는 조건으로 활용한 컬럼만 조회
--        또는 그룹 함수를 통해 조회한다.

-- from: 테이블 또는 join을 활용한 result set을 작성한다.

-- where: from절의 각 행마다 적용될 조건을 작성한다.

-- group by: where절까지 만족하는 행들에 대해 그룹이 될 컬럼을 작성한다.

-- having: 그룹별로 적용할 조건을 group by에서 작성한 컬럼 
--         또는 그룹 함수를 통해 조회한다.

-- order by: 제일 마지막에 해석되며 select의 결과(result set)의 순번,별칭,컬럼명
--           등으로 오름차순 또는 내림차순 한다.

SELECT
		 category_code
		,COUNT(*)							-- 모든 행 갯수 세기
		,COUNT(menu_price)				-- category_code가 null이 아닌 행만 갯수 세기
		,SUM(menu_price)
		,AVG(menu_price)
 FROM tbl_menu
 WHERE category_code IS NOT NULL
 GROUP BY category_code
HAVING SUM(menu_price) >= 24000
 ORDER BY 2;
 
-- -----------------------------------------
-- 메뉴가 없는 카테고리까지 셀껀지 구분해서 count해보기
SELECT 
		 COUNT(*)
		,COUNT(menu_name)
 FROM tbl_menu a
RIGHT JOIN tbl_category b ON (a.category_code = b.category_code);

-- -----------------------------------------
-- 함수의 종류
-- 단일행 함수: NVL또는 IFNULL과 같이 단일 행마다 적용되어 행의 갯수만큼 결과가 나오는 경우
-- 그룹함수: COUNT, SUM, AVG와 같이 그룹마다 적용되어 그룹의 갯수만큼 결과가 나오는 경우
--           (단, GROUP BY절이 없는 조회는 그룹 함수의 결과가 단일행(행 하나) 이다.

-- -----------------------------------------
-- ROLLUP
-- 중간 합계 및 최종 합계를 도출
-- GROUP BY에서 두개 이상의 컬럼으로 그룹형성시킴

SELECT
		 menu_price
		,category_code
		,SUM(menu_price)
  FROM tbl_menu
 GROUP BY menu_price, category_code
  WITH ROLLUP;
  
CREATE TABLE sales (
    CODE INT auto_increment,
    YEAR VARCHAR(4),
    MONTH VARCHAR(2),
    product VARCHAR(50),
    amount DECIMAL(1menudbmenudbmenudb0, 2),
    PRIMARY KEY(CODE)
);

INSERT 
  INTO sales
(
  CODE
, YEAR
, MONTH
, product
, amount
)
VALUES
(
  NULL
, '2023'
, LPAD('1',2,'0')
, 'Product A', 1000.00
),
(
  NULL
, '2023'
, LPAD('1',2,'0')
, 'Product B', 1500.00
),
(
  NULL
, '2023'
, LPAD('2',2,'0')
, 'Product A', 2000.00
),
(
  NULL
, '2023'
, LPAD('2',2,'0')
, 'Product B', 2500.00
),
(
  NULL
, '2023'
, LPAD('3',2,'0')
, 'Product A', 1200.00
),
(
  NULL
, '2023'
, LPAD('3',2,'0')
, 'Product B', 1700.00
);

-- 연,월,상품명을 모두 하나의 그룹으로 묶어
-- 견,월 중간합계 및 전체 합계를 rollup으로 구해보자.
SELECT
       year
     , month
     , product
     , SUM(amount) AS total_sales
  FROM sales
 GROUP BY YEAR,MONTH,product
  WITH roullup
