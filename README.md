# TripleExample

SpringFrameWork 를 사용하였습니다.
ApacheTomcat 을 사용하였습니다.
Mysql 8.* 을 사용하였습니다.
root-context.xml 파일 DB주소, 및 경로 설정하여 ddl 로 테이블 생성후 테스트가 가능합니다.
테이블 DDL 1.attach 2.pointlog 3.review 문서 하단에 있습니다.


테스트방법


1. 포인트조회
크롬 : http://localhost:8080/pointview
URL 입력시 포인트가조회되어 화면에 표출됩니다.

2. 리뷰 입력,수정,삭제 
크롬 : http://localhost:8080/events
URL 입력시 포인트가조회되어 화면에 표출됩니다.

	POSTMAN 을 사용하여 진행
	
  body-raw 에 샘플을 넣어 테스트하였습니다.
	{
	"type": "REVIEW",
	"action": "ADD", 
	"reviewId": "240a0658-dc5f-4878-9381-ebb7b2667774",
	"content": "23233dsfdsfsd332!",
	"attachedPhotoIds": ["e4d1a64e-a531-43de-88d0-ff0ed70c0bb6","afb0cef2-851d-4a50-bb07-9cc15cbdc315"],
	 "userId": "3ede0ef2-92b7-4817-a5f3-0c575361f746",
	 "placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b006"
	}
	
	action값을 ADD, MOD, DELETE 로 변경하여 사용합니다.
	reviewId, attachedPhotoIds, userId, placeId 를 변경하여 사용합니다.

테이블 DDL 입니다.

CREATE TABLE `attach` (
  `attachedphotoid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '첨부파일',
  `userid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '사용자아이디',
  `reviewid` varchar(36) NOT NULL COMMENT '리뷰아이디',
  `credt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '생성일자',
  `uptdt` date DEFAULT NULL COMMENT '수정일자',
  `delyn` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'N' COMMENT '삭제여부YN',
  UNIQUE KEY `attachedphotoid` (`attachedphotoid`),
  KEY `attach_reviewid_IDX` (`attachedphotoid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='첨부파일'
;


CREATE TABLE `pointlog` (
  `reviewid` varchar(36) NOT NULL COMMENT '리뷰아이디',
  `pointseq` bigint NOT NULL COMMENT '일련번호',
  `userid` varchar(36) DEFAULT NULL COMMENT '사용자아이디',
  `type` varchar(10) DEFAULT NULL COMMENT 'REVIEW',
  `addpoint1` bigint DEFAULT NULL COMMENT '추가포인트 최초',
  `addpoint2` bigint DEFAULT NULL COMMENT '추가포인트 첨부파일',
  `addpoint3` bigint DEFAULT NULL COMMENT '추가포인트 내용 1자이상',
  `totalpoint` bigint DEFAULT NULL COMMENT '최종금액',
  `credt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '생성일자',
  `uptdt` date DEFAULT NULL COMMENT '수정일자',
  UNIQUE KEY `reviewid` (`reviewid`,`pointseq`,`userid`),
  KEY `pointlog_userid_IDX` (`userid`) USING BTREE,
  KEY `pointlog_reviewid_IDX` (`reviewid`) USING BTREE,
  KEY `pointlog_pointseq_IDX` (`pointseq`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='포인트로그'
;

CREATE TABLE `review` (
  `reviewid` varchar(36) NOT NULL COMMENT '리뷰아이디',
  `type` varchar(10) DEFAULT NULL COMMENT 'REVIEW',
  `action` varchar(10) DEFAULT NULL COMMENT 'ADD,MOD,DELETE',
  `content` varchar(100) DEFAULT NULL COMMENT '내용',
  `placeid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '리뷰작성장소',
  `credt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '생성일자',
  `uptdt` datetime DEFAULT NULL COMMENT '수정일자',
  `delyn` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'N' COMMENT '삭제여부YN',
  `userid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '사용자아이디',
  UNIQUE KEY `reviewid` (`reviewid`),
  KEY `review_reviewid_IDX` (`reviewid`,`type`,`action`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='리뷰'
;
