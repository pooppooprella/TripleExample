package com.ex.triple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.triple.reviewservice.ReviewService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	protected ReviewService reviewService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/REVIEW" )
	public String home(Locale locale, HttpServletRequest request) throws IOException {
		logger.info("Triple Mileage Task Start Step 1 Start {}.", locale);
		String body = getBody(request);
		
		logger.info("request action {}.", body);
		
		logger.info("Triple Mileage Task Start Step 1 End {}.", locale);
		return reviewService.review(body);
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
