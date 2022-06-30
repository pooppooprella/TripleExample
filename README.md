# TripleExample

SpringFrameWork 를 사용하였습니다.
ApacheTomcat 을 사용하였습니다.
Mysql 8.* 을 사용하였습니다.
root-context.xml 파일 DB주소, 및 경로 설정하여 ddl 로 테이블 생성후 테스트가 가능합니다.



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
