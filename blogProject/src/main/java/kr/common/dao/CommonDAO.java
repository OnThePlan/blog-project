package kr.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
 
@Repository("commonDAO")
public class CommonDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getStaffList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("common.getStaffList", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getDepartmentList() {
		return (List<Map<String, Object>>)selectList("common.getDepartmentList");
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getJobList() {
		return (List<Map<String, Object>>)selectList("common.getJobList");
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getcustomerList() {
		return (List<Map<String, Object>>)selectList("common.getcustomerList");
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getStaffInfo(Map<String, Object> map) {
		return (Map<String, Object>)selectOne("common.getStaffInfo", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getStaffType(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("common.getStaffType", map);
	}
	
	public void fileUpload(Map<String, Object> map, Object object, Object object2) {
		map.put("me_no", object);
		map.put("board_no", object2);
		insert("common.fileUpload", map);
	}
	public void projectfileUpload(Map<String, Object> map) {
		insert("common.projectfileUpload", map);
	}
	
}
