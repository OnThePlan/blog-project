package kr.co.blog.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {

	//공지사항 리스트 데이터
	List<Map<String, Object>> getNoticeList();
	int noticeAdd(Map<String, Object> map);
	Map<String, Object> memberAdd(Map<String, Object> map);
	Map<String, Object> noticeDetail(Map<String, Object> map);
	void noticeDeleted(Map<String, Object> map) throws Exception;
	void noticeUpdate(Map<String, Object> map);
	List<Map<String, Object>> sgTb();
	//void sgAdd(Map<String, Object> map);
	Map<String, Object> sgDetail(Map<String, Object> map);
	List<Map<String, Object>> apTb();
	Map<String, Object> apDetail(Map<String, Object> map);
	List<Map<String, Object>> rwiTb();
	void rwiAdd(Map<String, Object> map);
	Map<String, Object> rwiDetailPage(Map<String, Object> map);
	Map<String, Object> rwiUpdatePage(Map<String, Object> map);
	void rwiDeleted(Map<String, Object> map);
	void rwiUpdate(Map<String, Object> map);
	
}
