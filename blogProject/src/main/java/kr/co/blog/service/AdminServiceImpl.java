package kr.co.blog.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.blog.dao.AdminDAO;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="adminDAO")
    private AdminDAO adminDAO;


	//공지사항 리스트 데이터
	@Override
	public List<Map<String, Object>> getNoticeList() {
		return adminDAO.getNoticeList();
	}

	@Override
	public int noticeAdd(Map<String, Object> map) {
		return adminDAO.noticeAdd(map);
	}

	@Override
	public Map<String, Object> memberAdd(Map<String, Object> map) {
		return adminDAO.memberAdd(map);
	}

	@Override
	public Map<String, Object> noticeDetail(Map<String, Object> map) {
		return adminDAO.noticeDetail(map);
	}

	@Override
	public void noticeDeleted(Map<String, Object> map) throws Exception {
		adminDAO.noticeDeleted(map);
		
	}

	@Override
	public void noticeUpdate(Map<String, Object> map) {
		adminDAO.noticeUpdate(map);
	}

	//건의사항
	@Override
	public List<Map<String, Object>> sgTb() {
		return adminDAO.sgTb();
	}

/*	@Override
	public void sgAdd(Map<String, Object> map) {
		adminDAO.sgAdd(map);
	}*/

	@Override
	public Map<String, Object> sgDetail(Map<String, Object> map) {
		return adminDAO.sgDetail(map);
	}
	
	//사연신청
	@Override
	public List<Map<String, Object>> apTb() {
		return adminDAO.apTb();
	}

	@Override
	public Map<String, Object> apDetail(Map<String, Object> map) {
		return adminDAO.apDetail(map);
	}

	@Override
	public List<Map<String, Object>> rwiTb() {
		return adminDAO.rwiTb();
	}

	@Override
	public void rwiAdd(Map<String, Object> map) {
		 adminDAO.rwiAdd(map);
	}

	@Override
	public Map<String, Object> rwiDetailPage(Map<String, Object> map) {
		return adminDAO.rwiDetailPage(map);
	}

	@Override
	public Map<String, Object> rwiUpdatePage(Map<String, Object> map) {
		return adminDAO.rwiUpdatePage(map);
	}

	@Override
	public void rwiDeleted(Map<String, Object> map) {
		adminDAO.rwiDeleted(map);
	}

	@Override
	public void rwiUpdate(Map<String, Object> map) {
		adminDAO.rwiUpdate(map);
	}
}