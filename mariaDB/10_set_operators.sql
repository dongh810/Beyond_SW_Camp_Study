-- UNION(합집합)
SELECT 
		 menu_code
		,menu_name
		,menu_price
		,category_code
		,orderable_status
  FROM tbl_menu
 WHERE category_code = 10
 UNION 
SELECT 
 		 menu_code
		,menu_name
		,menu_price
		,category_code
		,orderable_status
  FROM tbl_menu
 WHERE menu_price< 9000;
 
-- UNION ALL(덧셈)
SELECT 
		 menu_code
		,menu_name
		,menu_price
		,category_code
		,orderable_status
  FROM tbl_menu
 WHERE category_code = 10
 UNION ALL
SELECT 
 		 menu_code
		,menu_name
		,menu_price
		,category_code
		,orderable_status
  FROM tbl_menu
 WHERE menu_price< 9000;
 
-- intersect(교집합)
SELECT 
		 menu_code
		,menu_name
		,menu_price
		,category_code
		,orderable_status
  FROM tbl_menu
 WHERE category_code = 10
 intersect 
SELECT 
 		 menu_code
		,menu_name
		,menu_price
		,category_code
		,orderable_status
  FROM tbl_menu
 WHERE menu_price< 9000;
 
-- minus(mySql과 mariaDB에서는 안먹힘)
SELECT
       a.menu_code
     , a.menu_name
     , a.menu_price
     , a.category_code
     , a.orderable_status
  FROM tbl_menu a
  LEFT JOIN (SELECT menu_code
                  , menu_name
                  , menu_price
                  , category_code
                  , orderable_status
               FROM tbl_menu
              WHERE menu_price < 9000) b ON (a.menu_code = b.menu_code)
 WHERE a.category_code = 10
   AND b.menu_code IS NULL;