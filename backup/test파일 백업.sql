SELECT * FROM wlop_status;
SELECT * FROM wlop_member;
SELECT * FROM memberadmin;

INSERT INTO memberadmin VALUES ('baekdonghyeon', 'N', 'N', 1, '2023.08.10', 'chosubin');

UPDATE billboard SET use_yn = 'Y'; 
UPDATE wlop_comment SET use_yn = 'Y';
UPDATE review SET use_yn = 'Y';
UPDATE information SET use_yn = 'Y';
UPDATE goodsshare SET use_yn = 'Y';
-- 탈퇴 휴면 처리(동현)
-- 4. 탈퇴
-- 5. 휴면

-- 회원이 탈퇴버튼을 누르면 회원관리의 사용여부코드가 탈퇴로 변하며 로그인을 못하게 된다.
SELECT member_id, status_code FROM memberadmin WHERE MEMBER_id = 'baekdonghyeon';

UPDATE memberadmin 
SET status_code = 3
WHERE MEMBER_id = 'baekdonghyeon';

UPDATE billboard SET use_yn = 'N' WHERE member_id = 'baekdonghyeon';
UPDATE wlop_comment SET use_yn = 'N' WHERE member_id = 'baekdonghyeon';
UPDATE review SET use_yn = 'N' WHERE member_id = 'baekdonghyeon';
UPDATE information SET use_yn = 'N' WHERE member_id = 'baekdonghyeon';
UPDATE goodsshare SET use_yn = 'N' WHERE member_id = 'baekdonghyeon';

-- 로그인 쿼리(baekdonghyeon id를 가진 사람이 로그인 할때 휴면과 탈퇴처리되면 못하도록 함 // 사용자가 입력한 아이디 값이 where절 member_id로 들어감)
SELECT a.member_id, status_code 
	FROM wlop_member a 
	join memberadmin b ON (a.member_id = b.member_id) 
  WHERE a.member_id = 'baekdonghyeon' AND b.status_code = 1;
  
-- 회원이 로그인을 안한지 한달이 넘으면 휴면상태로 넘어간다.

UPDATE memberadmin 
SET status_code = 2
WHERE DATEDIFF(NOW(),connection_date) > 31;

--------------------------------
SELECT * FROM memberadmin;

SELECT *,DATEDIFF(NOW(),connection_date) FROM memberadmin WHERE DATEDIFF(NOW(),connection_date) > 31;

SELECT DATEDIFF(NOW(),connection_date) FROM memberadmin WHERE DATEDIFF(NOW(),connection_date) > 31;

UPDATE memberadmin 
SET status_code = 2
WHERE DATEDIFF(NOW(),connection_date) > 31;


DROP TRIGGER IF EXISTS update_dormant_memberstatus; 
-- DELIMITER //
-- 
-- CREATE TRIGGER update_dormant_memberstatus
-- AFTER UPDATE ON memberadmin
-- FOR EACH ROW 
-- BEGIN 
-- 	IF DATEDIFF(NOW(),old.connection_date) > 31 THEN
-- 		 UPDATE memberadmin SET status_code = 2 ;
-- 	END IF;
-- END; //
-- 
-- DELIMITER ;


-- wlop_COMMENT , billboard, review, information, goodshare

ALTER TABLE 테이블명 ADD [추가컬럼] [속성];

ALTER TABLE TABLE_NAME ADD ADD_COLUMN VARCHAR(1) DEFAULT NULL COMMENT 'XXX';

ALTER TABLE wlop_comment ADD use_yn VARCHAR(255) NOT NULL;
ALTER TABLE billboard ADD use_yn VARCHAR(255) NOT NULL;
ALTER TABLE review ADD use_yn VARCHAR(255) NOT NULL;
ALTER TABLE information ADD use_yn VARCHAR(255) NOT NULL;
ALTER TABLE goodsshare ADD use_yn VARCHAR(255) NOT NULL;


