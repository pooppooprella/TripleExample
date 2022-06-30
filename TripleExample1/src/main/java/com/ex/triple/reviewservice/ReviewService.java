package com.ex.triple.reviewservice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.triple.reviewdao.ReviewDao;
import com.ex.triple.reviewvo.Attach;
import com.ex.triple.reviewvo.PointLog;
import com.ex.triple.reviewvo.Review;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ReviewService {
	
	
	@Autowired
	protected ReviewDao reviewDao;
	
	JsonObject rtnObj_succ = (JsonObject) JsonParser.parseString("{code:1000, msg:success}");
	JsonObject rtnObj_fail = (JsonObject) JsonParser.parseString("{code:5000, msg:fail}");
	
	
	//-------------------------------------------
	//리뷰관리-등록,수정,삭제
	//-------------------------------------------
	public String review(String body) {
		System.out.println("review start step1");
		Review vo = new Review(body);
		 
		
		//리뷰등록
		if("ADD".equals(vo.getAction())) {
			return reviewAdd(body);
		}
		//리뷰수정
		if("MOD".equals(vo.getAction())) {
			return reviewMod(body);
		}
		//리뷰삭제
		if("DELETE".equals(vo.getAction())) {
			return reviewDelete(body);
		}
		
		return rtnObj_fail.toString();
	}
	
	/**
	 * 리뷰등록
	 */
	public String reviewAdd(String body) {
		try {
			//1.review 인서트
			//2.attach 인서트
			//3.pointlog 인서트
			Review vo_review = new Review(body);
			Attach vo_attach = new Attach(body);		
			PointLog vo_pointLog = new PointLog(body);
			//-------
			//-통제-
			//-------
			List<Review>  reviewListDup = reviewDao.selectListDupReview(vo_review);
			if(reviewListDup.size() > 0) {
				rtnObj_fail.addProperty("msg", "Duplicated of PlaceId,UserId");
				return rtnObj_fail.toString();
			}
			
			
			//---------------
			//-최초작성자 여부-
			//---------------
			List<Review> reviewList = reviewDao.selectListReview(vo_review);
			reviewDao.insertReview(vo_review);//리뷰
			
			JsonArray attachList = vo_attach.getAttachedphotoids();
			for (int i = 0; i < attachList.size(); i++) {
				vo_attach.setAttachedphotoid(vo_attach.getAttachedphotoids().get(i).getAsString());
				reviewDao.insertAttach(vo_attach);//첨부파일
			}
			
			
			//--------------
			//-추가포인트 처리-
			//--------------
			if(reviewList.size() == 0) {
				vo_pointLog.setAddpoint1(1l);//최초리뷰작성시 포인트+1
			}
			if(attachList.size() > 0) {
				vo_pointLog.setAddpoint2(1l);//첨부파일 등록
			}
			if(vo_review.getContent().length()>0) {
				vo_pointLog.setAddpoint3(1l);//내용등록시 포인트+1
			}
			
			reviewDao.insertPointLog(vo_pointLog);//포인트로그
			return rtnObj_succ.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return rtnObj_fail.toString();
		}
		
		
		 
	}
	
	/**
	 * 리뷰수정
	 */
	public String reviewMod(String body) {
		try {
			//1.review 업데이트
			//2.attach 업데이트
			//3.pointlog 업데이트
			Review vo_review = new Review(body);
			Attach vo_attach = new Attach(body);
			PointLog vo_pointLog = new PointLog(body);
			
			//--------------
			//-기존상태값 조회-
			//--------------
			Review review = reviewDao.selectOneReview(vo_review);
			List<Attach> attachList = reviewDao.selectListAttach(vo_review);
			PointLog pointLog = reviewDao.selectOnePointLog(vo_review);
			
			//--------------
			//-리뷰업데이트 -
			//--------------
			reviewDao.updateReview(vo_review);
			
			//--------------
			//-첨부파일상태업데이트 -
			//--------------
			reviewDao.updateDelAttach(vo_attach);//기뷰기존값 상태변경 삭제여부=Y
			JsonArray vo_attachList = vo_attach.getAttachedphotoids();
			for (int j = 0; j < vo_attachList.size(); j++) {
				vo_attach.setAttachedphotoid(vo_attach.getAttachedphotoids().get(j).getAsString());
				reviewDao.insertOrUpdateAttach(vo_attach);//첨부파일 새로입력 또는 업데이트 삭제여부=N
			}
			
			//--------------
			//-추가포인트 처리 -
			//--------------
//			if(reviewList.size() == 0) {
//				vo_pointLog.setAddpoint1(1l);//최초리뷰작성시 포인트 처리하지않음.
//			}
			if(vo_attachList.size() == 0 && attachList.size() > 0) {
				vo_pointLog.setAddpoint2(-1l);//첨부파일 등록
			}
			if(vo_attachList.size() > 0 && attachList.size() == 0) {
				vo_pointLog.setAddpoint2(1l);//첨부파일 등록
			}
			
			if(vo_review.getContent().length() == 0 && review.getContent().length() > 0) {
				vo_pointLog.setAddpoint3(-1l);//내용등록시 포인트
			}else if(vo_review.getContent().length() > 0 && review.getContent().length() == 0) {
				vo_pointLog.setAddpoint3(1l);//내용등록시 포인트
			}
			
			reviewDao.insertPointLog(vo_pointLog);
			
			
			return rtnObj_succ.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return rtnObj_fail.toString();
		}
		
	}

	/**
	 * 리뷰삭제
	 */
	public String reviewDelete(String body) {
		try {
			//1.review 업데이트
			//2.attach 업데이트
			//3.pointlog 업데이트
			Review vo_review = new Review(body);
			Attach vo_attach = new Attach(body);
			PointLog vo_pointLog = new PointLog(body);
			
			//--------------
			//-기존상태값 조회 -
			//--------------
			Review review = reviewDao.selectOneReview(vo_review);
			List<Attach> attachList = reviewDao.selectListAttach(vo_review);
			PointLog pointLog = reviewDao.selectOnePointLogFirst(vo_review);
							
			//--------------
			//-리뷰 삭제처리 -
			//--------------
			vo_review.setDelyn("Y");
			reviewDao.updateReview(vo_review);
			//--------------
			//-첨부파일 삭제처리 -
			//--------------
			vo_attach.setDelyn("Y");
			reviewDao.updateAttach(vo_attach);
			
			
			
			//--------------
			//-추가포인트 처리  -
			//--------------
			if(pointLog.getAddpoint1() == 1) {
				vo_pointLog.setAddpoint1(-1l);//최초리뷰작성시 포인트+1
			}
			if(attachList.size() > 0) {
				vo_pointLog.setAddpoint2(-1l);//첨부파일 등록
			}
			if(review.getContent().length() > 0) {
				vo_pointLog.setAddpoint3(-1l);//내용등록시 포인트
			}
			
			reviewDao.insertPointLog(vo_pointLog);
			
			return rtnObj_succ.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return rtnObj_fail.toString();
		}
		
	}
	
	//-------------------------------------------
	//포인트 조회
	//-------------------------------------------
	public List<PointLog> pointview() {
		return reviewDao.selectPointLogResult();
	}

}
