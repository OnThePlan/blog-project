package kr.common.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    Logger log = Logger.getLogger(this.getClass());
    
    //메인화면 출력
    @RequestMapping(value="/login.do")
    public ModelAndView login(Map<String,Object> commandMap, HttpServletRequest request) throws Exception{
    	HttpSession session = request.getSession();
    	    	
    	SecurityContext secureContext = SecurityContextHolder.getContext();
    	Authentication auth = secureContext.getAuthentication();
    	Object principal = auth.getPrincipal();

    	String userId = null;
    	String userPw = null;
    	if (principal instanceof UserDetails) {
    	    UserDetails userDetails = (UserDetails) principal;
    	    userId = userDetails.getUsername();
    	    userPw = userDetails.getPassword();
    	} else {
    		userId = principal.toString();
    	    userPw = principal.toString();
    	}    	
    	commandMap.put("userId", userId);
    	commandMap.put("userPw", userPw);
    	
    	/*Map<String, Object> b_no = weatherService.selectBabyNo(commandMap);
    	System.out.println("55555");*/
    	//jsp페이지 선언
        ModelAndView mv = new ModelAndView("/login/login");
        
        System.out.println("11111");
        
        /*mv.addObject("b_no", b_no);*/
        return mv;
    }
    
}