package kr.common.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class LoginSuccess extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                   Authentication authentication) throws ServletException, IOException {
        request.getSession().setMaxInactiveInterval(60 * 60); //one hour
        System.out.println("Session set up for 60min");
        System.out.println(request.getParameter("j_username"));
        HttpSession session = request.getSession();
        
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("user_id", request.getParameter("j_username"));
    /*    int s_no = loginService.getSNO(param);*/
        session.setAttribute("user_id", request.getParameter("j_username"));
  /*      session.setAttribute("s_no", s_no);*/
        
        super.onAuthenticationSuccess(request, response, authentication);
     }
}
