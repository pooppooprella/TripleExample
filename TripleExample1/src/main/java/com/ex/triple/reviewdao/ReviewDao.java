package com.ex.triple.reviewdao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.triple.reviewvo.Attach;
import com.ex.triple.reviewvo.PointLog;
import com.ex.triple.reviewvo.Review;

@Repository
public class ReviewDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	//리뷰 select
	public List<Review> selectListReview(Review vo) {
		System.out.println("REVIEW 장소에대한 최초등록여부사용을 위한 조회 ");
		return sqlSession.selectList("REVIEW.ReviewSelect", vo);
	}
	//리뷰 select
	public List<Review> selectListDupReview(Review vo) {
		System.out.println("REVIEW 장소,사용자에대한 중복 리뷰 등록 여부 조회 ");
		return sqlSession.selectList("REVIEW.ReviewSelectDup", vo);
	}
	
	
	//리뷰 select
	public Review selectOneReview(Review vo) {
		System.out.println("REVIEW reviewid 기준 1개 조회");
		return sqlSession.selectOne("REVIEW.ReviewSelectOne", vo);
	}
	
	
	//첨부파일 select
	public List<Attach> selectListAttach(Review vo) {
		System.out.println("ATTACH reviewid 기준 1개 조회");
		return sqlSession.selectList("REVIEW.AttachSelect", vo);
	}
		
	//포인트로그 select
	public List<PointLog> selectListPointLog(Review vo) {
		System.out.println("POINTLOG reviewid 기준 1개 조회");
		return sqlSession.selectList("REVIEW.PointLogSelect", vo);
	}
	//포인트로그 select 
	public PointLog selectOnePointLog(Review vo) {
		System.out.println("POINTLOG reviewid 기준 1개 조회 가장 최신 데이터");
		return sqlSession.selectOne("REVIEW.PointLogSelectOne", vo);
	}
	//포인트로그 select 
	public PointLog selectOnePointLogFirst(Review vo) {
		System.out.println("POINTLOG reviewid 기준 1개 조회 가장 최초 데이터");
		return sqlSession.selectOne("REVIEW.PointLogSelectOneFirst", vo);
	}
	
		
	
	//리뷰 insert
	public int insertReview(Review vo) {
		System.out.println("REVIEW INSERT 문 기본 ");
		return sqlSession.insert("REVIEW.ReviewInsert", vo);
	}
	
	//첨부파일 insert
	public int insertAttach(Attach vo) {
		System.out.println("ATTACH INSERT 문 기본 ");
		return sqlSession.insert("REVIEW.AttachInsert", vo);
	}
	
	//포인트로그 insert
	public int insertPointLog(PointLog vo) {
		System.out.println("POINTLOG INSERT 문 기본 ");
		return sqlSession.insert("REVIEW.PointLogInsert", vo);
	}

	
	//리뷰
	public int updateReview(Review vo) {
		System.out.println("REVIEW UPDATE 문 삭제여부,내용 수정 ");
		return sqlSession.update("REVIEW.ReviewUpdate", vo);
	}
	
	//첨부파일
	public int updateAttach(Attach vo) {
		System.out.println("ATTACH UPDATE 문 삭제여부 수정 ");
		return sqlSession.update("REVIEW.AttachUpdate", vo);
	}
	
	
	/**첨부파일 업데이트 or 인서트
	 * ON DUPLICATE KEY
	 * 첨부파일
	*/
	public int insertOrUpdateAttach(Attach vo) {
		System.out.println("ATTACH UPDATE 기존의파일이아닐경우 인서트, 기존파일일경우 업데이트 ");
		return sqlSession.update("REVIEW.AttachInsertOrUpdate", vo);
	}
	
	/** 첨부파일 삭제상태 변경.
	 * 
	 */
	public int updateDelAttach(Attach vo) {
		System.out.println("ATTACH UPDATE reviewid 기준 삭제여부 Y ");
		return sqlSession.update("REVIEW.AttachUpdateDel", vo);
	}
		
}
