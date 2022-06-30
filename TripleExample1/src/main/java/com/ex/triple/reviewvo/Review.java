package com.ex.triple.reviewvo;

import java.sql.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 리뷰 
 */
public class Review extends BaseObject{
	String type;/*동작 대분*/ /*REVIEW*/
	String action;/*ADD=추가 , MOD=수정 , DELETE=삭제 */
	String reviewId;/*리뷰아이디*/ /*ex = 240a0658-dc5f-4878-9381-ebb7b2667772 *//*36*/
	String content;/*내용*/ /*content*/
	JsonArray attachedPhotoIds;/*첨부파일아이디목록*/ /*ex = ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-851d-4a50-bb07-9cc15cbdc332"]*/
	String userId;/*사용자이이디*/ /*ex = 3ede0ef2-92b7-4817-a5f3-0c575361f745*/
	String placeId;/*리뷰작성장소 아이디*/ /*ex = 2e4baf1c-5acb-4efb-a1af-eddada31b00f*/
	String delyn;/*삭제여부*/
	Date credt;/*생성일자 */
	Date uptdt;/*수정일자 */
	
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(String body) {
		JsonObject obj = getConvertJsonObj(body);
		
		type = obj.get("type").getAsString();
		action = obj.get("action").getAsString();
		reviewId = obj.get("reviewId").getAsString();
		content = obj.get("content").getAsString();
		attachedPhotoIds = obj.get("attachedPhotoIds").getAsJsonArray();
		userId = obj.get("userId").getAsString();
		placeId = obj.get("placeId").getAsString();
		delyn = "N";
		credt = null;
		uptdt = null;
	}
	
	public String getDelyn() {
		return delyn;
	}
	public void setDelyn(String delyn) {
		this.delyn = delyn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public JsonArray getAttachedPhotoIds() {
		return attachedPhotoIds;
	}
	public void setAttachedPhotoIds(JsonArray attachedPhotoIds) {
		this.attachedPhotoIds = attachedPhotoIds;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userid) {
		this.userId = userid;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public Date getCredt() {
		return credt;
	}

	public void setCredt(Date credt) {
		this.credt = credt;
	}

	public Date getUptdt() {
		return uptdt;
	}

	public void setUptdt(Date uptdt) {
		this.uptdt = uptdt;
	}
	

	
	

	
	
}
