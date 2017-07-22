package kr.common.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public interface CommonService {

	List<Map<String, Object>> getDepartmentList();

	List<Map<String, Object>> getJobList();

	List<Map<String, Object>> getStaffList(Map<String, Object> map);

	List<Map<String, Object>> getcustomerList();
	
	Map<String, Object> getStaffInfo(Map<String, Object> map);

	List<Map<String, Object>> getStaffType(Map<String, Object> map);

	void fileUpload(Map<String, Object> map, HttpServletRequest request) throws Exception;
	void projectfileUpload(Map<String, Object> map) throws Exception;
}
