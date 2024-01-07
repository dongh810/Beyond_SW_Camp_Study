
CREATE TABLE `WLOP_Member` (
   `member_id`   varchar(255)   NOT NULL PRIMARY KEY,
   `member_pw`   varchar(255)   NOT NULL,
   `member_name`   varchar(255)   NOT NULL,
   `member_address`   varchar(255)NOT NULL,
   `member_call`   varchar(255)   NOT NULL,
   `member_email`   varchar(255)   NOT NULL,
   `member_nick`   varchar(255)   NOT NULL,
   `member_date`   varchar(255)   NOT NULL,
   `report_num`   int   NOT NULL   COMMENT '신고접수 후 관리자가 삭제한 횟수',
   `grade_code`   int   NOT NULL
);

CREATE TABLE `WLOP_Type` (
   `type_code`   int   NOT NULL PRIMARY KEY,
   `type_info`   varchar(255)   NOT NULL
);

CREATE TABLE `Review` (
   `review_code`   int   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `review_star`   int   NOT NULL,
   `review_content`   VARCHAR(255)   NOT NULL,
   `review_updown`   int   NULL,
   `review_date`   VARCHAR(255)   NOT NULL,
   `info_code`   int   NOT NULL,
   `review_writer`   varchar(255)   NOT NULL,
   `use_yn` VARCHAR(255) NOT NULL
);

CREATE TABLE `WLOP_Comment` (
   `comment_code` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `comment_content`   varchar(255)   NOT NULL,
   `comment_writer`   varchar(255)   NOT NULL,
   `review_code`   int   NULL,
   `share_code`   int   NULL,
   `freeboard` INT NULL, 
   `use_yn` VARCHAR(255) NOT NULL
);

CREATE TABLE `Information` (
   `info_code`   int   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `info_name`   varchar(255)   NOT NULL,
   `info_address`   varchar(255)   NOT NULL,
   `info_call`   varchar(255)   NOT NULL,
   `info_date`   varchar(255)   NOT NULL,
   `type_code`   int   NOT NULL,
   `info_writer`   varchar(255)   NOT NULL,
   `use_yn` VARCHAR(255) NOT NULL
);

CREATE TABLE `GoodsShare` (
    `goods_code` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `goods_name`   varchar(255)   NOT NULL,
   `goods_feature`   varchar(255)   NOT NULL COMMENT'상품 설명',
   `goods_date`   varchar(255)   NOT NULL,
   `goods_writer`   varchar(255)   NOT NULL,
   `goods_category`   int   NOT NULL,
   `use_yn` VARCHAR(255) NOT NULL
);

CREATE TABLE `MemberGrade` (
   `grade_code`   int   NOT NULL PRIMARY KEY,
   `grade_content`   varchar(255)   NOT NULL
);

CREATE TABLE `QNA` (
   `Q_id`   int   NOT NULL AUTO_INCREMENT PRIMARY key,
   `Q_content`   varchar(255)   NOT NULL,
   `Q_date`   varchar(255)   NOT NULL,
   `A_content`   varchar(255)   NULL COMMENT '답변 내용',
   `Q_writer`   varchar(255)   NOT NULL
);

CREATE TABLE `Administer` (
   `admin_id`   varchar(255)   NOT NULL PRIMARY KEY,
   `admin_pss`   varchar(255)   NOT NULL,
   `admin_nickname`   varchar(255)   NOT NULL
);

CREATE TABLE `Report` (
   `report_number` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
   `report_content`   varchar(255)   NOT NULL,
   `report_date`   varchar(255)   NOT NULL,
   `report_code`   int   NOT NULL,
   `report_now_code`   int   NOT NULL,
   `report_subject`   varchar(255)   NOT NULL,
   `report_writer`   varchar(255)   NOT NULL,
   `freeboard` INT    NULL,
   `goods_code` INT    NULL,
   `review_code` INT  NULL,
   `comment_code` INT  NULL
);

CREATE TABLE `WLOP_Profile` (
   `Member_ID`   varchar(255)   NOT NULL PRIMARY KEY,
   `location`   varchar(255)   NULL   COMMENT '주인의 거주지역',
   `my_introduce`   varchar(255)   NULL,
   `my_nickname`   varchar(255)   NOT NULL
);

CREATE TABLE `Blacklist` (
   `black_id`   varchar(255)   NOT NULL PRIMARY KEY,
   `black_reason`   varchar(255)   NOT NULL,
   `black_ candidate`   varchar(255)   NULL
);

CREATE TABLE `Report_Type` (
   `Report_code`   int   NOT NULL PRIMARY KEY,
   `report_category`   varchar(255)   NOT NULL
);

CREATE TABLE `Report_Status` (
   `Status_code`   int   NOT NULL PRIMARY KEY,
   `Status_category`   varchar(255)   NOT NULL
);

CREATE TABLE `AnimalCategory` (
   `animal_code`   int   NOT NULL PRIMARY KEY,
   `animal_code_feature`   varchar(255)   NOT NULL
);

CREATE TABLE `Billboard` (
   `freeboard`   int   NOT NULL   AUTO_INCREMENT PRIMARY KEY COMMENT '게시판 일련번호',
   `board_content`   varchar(255)   NOT NULL,
   `board_date`   varchar(255)   NOT NULL,
   `board_check`   int   NOT NULL,
   `board_recommend`   int   NOT NULL,
   `member_id`   varchar(255)   NOT NULL,
   `use_yn` VARCHAR(255) NOT NULL
);

CREATE TABLE `MemberAdmin` (
   `Member_ID`   varchar(255)   NOT NULL PRIMARY KEY,
   `business_code`   VARCHAR(255)   NOT NULL,
   `blacklist_code`   VARCHAR(255)   NOT NULL,
   `status_code`   int   NOT NULL,
   `connection_date`   varchar(255)   NOT NULL,
   `admin_id`   varchar(255)   NOT NULL
);

CREATE TABLE `WLOP_Status` (
   `status_code`   int   NOT NULL PRIMARY KEY,
   `status_code_feature`   varchar(255)   NOT NULL
);

CREATE TABLE `Pet` (
   `pet_number`   int   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `pet_id`   varchar(255)   NOT NULL,
   `pet_type`   varchar(255)   NULL,
   `pet_name`   varchar(255)   NOT NULL,
   `pet_birth`   varchar(255)   NULL,
   `pet_sex`   varchar(255)   NULL
);

CREATE TABLE `Notification` (
   `notification_num`   int   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `notification_text`   varchar(255)   NOT NULL,
   `admin_id`   varchar(255)   NOT NULL
);

CREATE TABLE `Animal_type_category` (
   `type_code`   int   NOT NULL,
   `animal_code`   int   NOT NULL
);

CREATE TABLE `Goods` (
   `goods_category`   int   NOT NULL PRIMARY KEY,
   `goods_category_feature`   varchar(255)   NOT NULL
);

CREATE TABLE `Photo` (
   `photo_code`   int   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `photo_name`   varchar(255)   NOT NULL,
   `photo_directory`   varchar(255)   NOT NULL,
   `photo_rename`   varchar(255)   NULL,
   `notification_num` INT  NULL,
   `info_code` INT  NULL,
   `review_code` INT  NULL,
   `pet_number` INT    NULL,
   `pet_id` VARCHAR(255) NULL,
   `goods_code` INT  NULL,
   `freeboard` INT  NULL,
   `Member_ID` VARCHAR(255)  NULL 
);


ALTER TABLE `WLOP_Member` ADD CONSTRAINT `FK_MemberGrade_TO_Member_1` FOREIGN KEY (
   `grade_code`
)
REFERENCES `MemberGrade` (
   `grade_code`
);

ALTER TABLE `Review` ADD CONSTRAINT `FK_Information_TO_Review_1` FOREIGN KEY (
   `info_code`
)
REFERENCES `Information` (
   `info_code`
);

ALTER TABLE `Review` ADD CONSTRAINT `FK_Member_TO_Review_1` FOREIGN KEY (
   `review_writer`
)
REFERENCES `WLOP_Member` (
   `member_id`
);


ALTER TABLE `WLOP_Comment` ADD CONSTRAINT `FK_Review_TO_Comment_1` FOREIGN KEY (
   `review_code`
)
REFERENCES `Review` (
   `review_code`
);

ALTER TABLE `WLOP_Comment` ADD CONSTRAINT `FK_Billboard_TO_Comment_1` FOREIGN KEY (
   `freeboard`
)
REFERENCES `Billboard`(
   `freeboard`
);

ALTER TABLE `WLOP_Comment` ADD CONSTRAINT `FK_Member_TO_Comment_1` FOREIGN KEY (
   `comment_writer`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `WLOP_Comment` ADD CONSTRAINT `FK_GoodsShare_TO_Comment_1` FOREIGN KEY (
   `share_code`
)
REFERENCES `GoodsShare` (
   `goods_code`
);

ALTER TABLE `Information` ADD CONSTRAINT `FK_Type_TO_Information_1` FOREIGN KEY (
   `type_code`
)
REFERENCES `WLOP_Type` (
   `type_code`
);

ALTER TABLE `Information` ADD CONSTRAINT `FK_Member_TO_Information_1` FOREIGN KEY (
   `info_writer`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `GoodsShare` ADD CONSTRAINT `FK_Member_TO_GoodsShare_1` FOREIGN KEY (
   `goods_writer`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `GoodsShare` ADD CONSTRAINT `FK_Goods_TO_GoodsShare_1` FOREIGN KEY (
   `goods_category`
)
REFERENCES `Goods` (
   `goods_category`
);

ALTER TABLE `QNA` ADD CONSTRAINT `FK_Member_TO_QNA_1` FOREIGN KEY (
   `Q_writer`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `Report` ADD CONSTRAINT `FK_Report_Type_TO_Report_1` FOREIGN KEY (
   `report_code`
)
REFERENCES `Report_Type` (
   `Report_code`
);

ALTER TABLE `Report` ADD CONSTRAINT `FK_Report_Status_TO_Report_2` FOREIGN KEY (
   `report_now_code`
)
REFERENCES `Report_Status` (
   `Status_code`
);

ALTER TABLE `Report` ADD CONSTRAINT `FK_wlop_member_TO_Report_3` FOREIGN KEY (
   `report_subject`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `Report` ADD CONSTRAINT `FK_wlop_member_TO_Report_4` FOREIGN KEY (
   `report_writer`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `Report` ADD CONSTRAINT `FK_Billboard_TO_Report_5` FOREIGN KEY (
   `freeboard`
)
REFERENCES `Billboard` (
   `freeboard`
);

ALTER TABLE `Report` ADD CONSTRAINT `FK_GoodsShare_TO_Report_6` FOREIGN KEY (
   `goods_code`
)
REFERENCES `GoodsShare` (
   `goods_code`
);

ALTER TABLE `Report` ADD CONSTRAINT `FK_Review_TO_Report_7` FOREIGN KEY (
   `review_code`
)
REFERENCES `Review` (
   `review_code`
);

ALTER TABLE `Report` ADD CONSTRAINT `FK_WLOP_Comment_TO_Report_8` FOREIGN KEY (
   `comment_code`
)
REFERENCES `WLOP_Comment` (
   `comment_code`
);

ALTER TABLE `WLOP_Profile` ADD CONSTRAINT `FK_Member_TO_Profile_1` FOREIGN KEY (
   `Member_ID`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `Blacklist` ADD CONSTRAINT `FK_Member_TO_Blacklist_1` FOREIGN KEY (
   `black_id`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `Billboard` ADD CONSTRAINT `FK_Member_TO_Billboard_1` FOREIGN KEY (
   `member_id`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `MemberAdmin` ADD CONSTRAINT `FK_Member_TO_MemberAdmin_1` FOREIGN KEY (
   `Member_ID`
)
REFERENCES `WLOP_Member` (
   `member_id`
);

ALTER TABLE `MemberAdmin` ADD CONSTRAINT `FK_Status_TO_MemberAdmin_1` FOREIGN KEY (
   `status_code`
)
REFERENCES `WLOP_Status` (
   `status_code`
);

ALTER TABLE `MemberAdmin` ADD CONSTRAINT `FK_Administer_TO_MemberAdmin_1` FOREIGN KEY (
   `admin_id`
)
REFERENCES `Administer` (
   `admin_id`
);

ALTER TABLE `Pet` ADD CONSTRAINT `FK_Profile_TO_Pet_1` FOREIGN KEY (
   `pet_id`
)
REFERENCES `WLOP_Profile` (
   `Member_ID`
);

ALTER TABLE `Notification` ADD CONSTRAINT `FK_Administer_TO_Notification_1` FOREIGN KEY (
   `admin_id`
)
REFERENCES `Administer` (
   `admin_id`
);

ALTER TABLE `Animal_type_category` ADD CONSTRAINT `FK_Type_TO_Animal_type_category_1` FOREIGN KEY (
   `type_code`
)
REFERENCES `WLOP_Type` (
   `type_code`
);

ALTER TABLE `Animal_type_category` ADD CONSTRAINT `FK_AnimalCategory_TO_Animal_type_category_1` FOREIGN KEY (
   `animal_code`
)
REFERENCES `AnimalCategory` (
   `animal_code`
);

ALTER TABLE `Photo` ADD CONSTRAINT `FK_Notification_TO_Photo_1` FOREIGN KEY (
   `notification_num`
)
REFERENCES `Notification`(
   `notification_num`
);

ALTER TABLE `Photo` ADD CONSTRAINT `FK_Information_TO_Photo_1` FOREIGN KEY (
   `info_code`
)
REFERENCES `Information`(
   `info_code`
);

ALTER TABLE `Photo` ADD CONSTRAINT `FK_Review_TO_Photo_1` FOREIGN KEY (
   `review_code`
)
REFERENCES `Review`(
   `review_code`
);

ALTER TABLE `Photo` ADD CONSTRAINT `FK_Pet_TO_Photo_1` FOREIGN KEY (
   `pet_number`
)
REFERENCES `Pet`(
   `pet_number`
);

ALTER TABLE `Photo` ADD CONSTRAINT `FK_Pet_TO_Photo_2` FOREIGN KEY (
   `pet_id`
)
REFERENCES `Pet`(
   `pet_id`
);

ALTER TABLE `Photo` ADD CONSTRAINT `FK_GoodsShare_TO_Photo_1` FOREIGN KEY (
   `goods_code`
)
REFERENCES `GoodsShare`(
   `goods_code`
);

ALTER TABLE `Photo` ADD CONSTRAINT `FK_Billboard_TO_Photo_1` FOREIGN KEY (
   `freeboard`
)
REFERENCES `Billboard`(
   `freeboard`
);

ALTER TABLE `Photo` ADD CONSTRAINT `FK_WLOP_Profile_TO_Photo_1` FOREIGN KEY (
   `Member_ID`
)
REFERENCES `WLOP_Profile`(
   `Member_ID`
);