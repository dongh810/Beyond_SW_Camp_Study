INSERT 
	INTO tbl_menu
(
	menu_code
,  menu_name
,	menu_price
,	category_code
, 	orderable_status
)
VALUES
(
	NULL
,	'바나나해장국'
,	8500
,	4
,	'Y'
);

SELECT * FROM tbl_menu ORDER BY 1 DESC;

-- DELETE 
  FROM tbl_menu
 WHERE menu_code = 22;
-- ---------------------------
-- UPDATE
 
UPDATE tbl_menu
 	 SET menu_name = '딸기해장국'
 WHERE menu_code = 22;
 
-- ---------------------------
REPLACE  
  INTO tbl_menu
(
	menu_code
,  menu_name
,	menu_price
,	category_code
,	orderable_status
)
VALUES
(
	17,'아샷추매운탕',9000
	,4,'N'
);