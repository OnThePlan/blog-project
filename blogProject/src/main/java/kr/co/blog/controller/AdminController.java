package kr.co.blog.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.blog.service.AdminService;
import kr.common.common.CommandMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class AdminController {
    Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="adminService")
    private AdminService adminService;
    
    //세션 로그인 정보
    @RequestMapping(value="/admin/loginName.do")
    public ModelAndView loginName(Map<String,Object> commandMap, HttpServletRequest request, HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	mv.addObject("s_no", session.getAttribute("user_id"));
        return mv;
    }
    
    //실시간 복지정보 리스트 페이지
    @RequestMapping(value="/admin/rwi/rwiList.do")
    public ModelAndView stayList(Map<String,Object> commandMap, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("/admin/RealtimeWelfareInformation/rwiList");
        mv.addObject("menu","1");
        return mv;
    }
    
}