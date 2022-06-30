package com.ex.triple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.triple.reviewservice.ReviewService;
import com.ex.triple.reviewvo.PointLog;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	protected ReviewService reviewService;
	
//	
	/** 리뷰등록,수정,삭제 관리 POST 
	 * http://localhost:8080/events
	 * @param locale
	 * @param post : 과제로 받은 Json 형태의 값을 body 에 넣어서 테스트합니다.
	 * 				postman 을 사용하여 진행하였습니다.
	 * 				Body-raw 부분 에 넣고 진행하였습니다. 
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/events" )
	public String home(Locale locale, HttpServletRequest request) throws IOException {
		logger.info("Triple Mileage Task Start Step 1 Start {}.", locale);
		String body = getBody(request);
		
		logger.info("request action {}.", body);
		
		logger.info("Triple Mileage Task Start Step 1 End {}.", locale);
		return reviewService.review(body);
	}
	
	/** 리뷰 조회 관리 GET
	 * http://localhost:8080/pointview
	 * @param locale
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pointview" )
	public String pointview(Locale locale, HttpServletRequest request, Model model) throws IOException {
		logger.info("Triple Mileage Task Start Step 1 Start {}.", locale);
		StringBuffer sb = new StringBuffer();
		
		List<PointLog> pointLogList = reviewService.pointview();
		model.addAttribute("list", pointLogList);
		
		logger.info("Triple Mileage Task Start Step 1 End {}.", locale);
		return "home";
	}
	
	
	/**
	 * POST통신 Body to String
	 * @param request
	 * @return
	 * @throws IOException
	 */
    public String getBody(HttpServletRequest request) throws IOException {
    	 
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
 
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
 
        body = stringBuilder.toString();
        return body;
    }
	
	
	
}
