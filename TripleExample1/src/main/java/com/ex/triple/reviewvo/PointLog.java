package com.ex.triple.reviewvo;

import java.sql.Date;

import com.google.gson.JsonObject;


/**
 * 포인트로그
 */
 public class PointLog extends BaseObject{

	String reviewId;/*리뷰아이디 */
	String userId;/*사용자아이*/
	String type;/*only REVIEW*/
	Long addpoint1;/*추가포인트 최초*/
	Long addpoint2;/*추가포인트 첨부파일*/
	Long addpoint3;/*추가포인트 내용 1자이상*/
	Long totalpoint;/*최종포인트 */
	Date credt;/*생성일자 */
	Date uptdt;/*수정일자 */
	Long pointSeq;/*로그순서 */
	
	public PointLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PointLog(String body) {
		JsonObject obj = getConvertJsonObj(body);
		
		reviewId = obj.get("reviewId").getAsString();
		userId = obj.get("userId").getAsString();
		type = obj.get("type").getAsString();
		addpoint1 = 0l;
		addpoint2 = 0l;
		addpoint3 = 0l;
		totalpoint = 0l;
		credt = null;
		uptdt = null;
		
	}
	
	public Long getPointSeq() {
		return pointSeq;
	}
	public void setPointSeq(Long pointSeq) {
		this.pointSeq = pointSeq;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public void setUserid(String userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Long getAddpoint1() {
		return addpoint1;
	}
	public void setAddpoint1(Long addpoint1) {
		this.addpoint1 = addpoint1;
	}
	public Long getAddpoint2() {
		return addpoint2;
	}
	public void setAddpoint2(Long addpoint2) {
		this.addpoint2 = addpoint2;
	}
	public Long getAddpoint3() {
		return addpoint3;
	}
	public void setAddpoint3(Long addpoint3) {
		this.addpoint3 = addpoint3;
	}
	public Long getTotalpoint() {
		return totalpoint;
	}
	public void setTotalpoint(Long totalpoint) {
		this.totalpoint = totalpoint;
	}
	
	
	
}
