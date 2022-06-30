package com.ex.triple.reviewvo;

import java.sql.Date;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 첨부파일 
 */
public class Attach extends BaseObject{
	String attachedphotoid;/*첨부파일아이디 */
	JsonArray attachedphotoids;/*첨부파일아이디 */
	String userId;/*사용자아이디*/
	String reviewId;/*리뷰아이디*/
	Date credt;/*생성일자 */
	Date uptdt;/*수정일자 */
	String delyn;/*삭제여부 */
	
	
	public Attach() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Attach(String body) {
		JsonObject obj = getConvertJsonObj(body);
		attachedphotoids = obj.get("attachedPhotoIds").getAsJsonArray();
		userId = obj.get("userId").getAsString();
		reviewId = obj.get("reviewId").getAsString();
		credt = null;
		uptdt = null;
		delyn = "N";

		
	}
	
	
	public String getReviewId() {
		return reviewId;
	}


	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public JsonArray getAttachedphotoids() {
		return attachedphotoids;
	}
	public void setAttachedphotoids(JsonArray attachedphotoids) {
		this.attachedphotoids = attachedphotoids;
	}
	public String getReviewid() {
		return reviewId;
	}
	public void setReviewid(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getAttachedphotoid() {
		return attachedphotoid;
	}
	public void setAttachedphotoid(String attachedphotoid) {
		this.attachedphotoid = attachedphotoid;
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
	public String getDelyn() {
		return delyn;
	}
	public void setDelyn(String delyn) {
		this.delyn = delyn;
	}
	

	
}

