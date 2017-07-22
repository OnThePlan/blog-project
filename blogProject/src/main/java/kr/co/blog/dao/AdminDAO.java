package kr.co.blog.dao;

import java.util.List;
import java.util.Map;

import kr.common.dao.AbstractDAO;

import org.springframework.stereotype.Repository;
 
@Repository("adminDAO")
public class AdminDAO extends AbstractDAO{	

	//공지사항 리스트 데이터
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getNoticeList() {
		return (List<Map<String, Object>>)selectList("admin.getNoticeList");
	}
	public int noticeAdd(Map<String, Object> map) {
		return insert("admin.noticeAdd", map);
		
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> memberAdd(Map<String, Object> map) {
		return  (Map<String, Object>)selectOne("admin.memberAdd");
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> noticeDetail(Map<String, Object> map) {
		return  (Map<String, Object>)selectOne("admin.noticeDetail", map);
	}
	public void noticeDeleted(Map<String, Object> map )throws Exception{
		update("admin.noticeDeleted", map);
	}
	public void noticeUpdate(Map<String, Object> map) {
		update("admin.noticeUpdate", map);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> sgTb() {
		return (List<Map<String, Object>>)selectList("admin.sgTb");
	}
	/*public void sgAdd(Map<String, Object> map) {
		insert("admin.sgAdd", map);
	}*/
	@SuppressWarnings("unchecked")
	public Map<String, Object> sgDetail(Map<String, Object> map) {
		return (Map<String, Object>)selectOne("admin.sgDetail", map);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> apTb() {
		return (List<Map<String, Object>>)selectList("admin.apTb");
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> apDetail(Map<String, Object> map) {
		return (Map<String, Object>)selectOne("admin.apDetail", map);
	}
	public void rwiUpdate(Map<String, Object> map) {
		update("admin.rwiUpdate", map);
	}
	public void rwiDeleted(Map<String, Object> map) {
		update("admin.rwiDeleted", map);
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> rwiUpdatePage(Map<String, Object> map) {
		return (Map<String, Object>)selectOne("admin.rwiUpdatePage", map);
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> rwiDetailPage(Map<String, Object> map) {
		return (Map<String, Object>)selectOne("admin.rwiDetailPage", map);
	}
	public void rwiAdd(Map<String, Object> map) {
		insert("admin.rwiAdd", map);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> rwiTb() {
		return (List<Map<String, Object>>)selectList("admin.rwiTb");
	}

}
