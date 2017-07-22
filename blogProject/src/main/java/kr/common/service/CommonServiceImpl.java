package kr.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.common.common.FileUtil;
import kr.common.dao.CommonDAO;
import kr.common.util.FileUtils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("commonService")
public class CommonServiceImpl implements CommonService{
	Logger log = Logger.getLogger(this.getClass());
    
	@Resource(name="fileUtil")
    private FileUtil fileUtil;
	
    @Resource(name="commonDAO")
    private CommonDAO commonDAO;
	
    @Resource(name="fileUtils")
	private FileUtils fileUtils;

	@Override
	public List<Map<String, Object>> getDepartmentList() {
		return commonDAO.getDepartmentList();
	}

	@Override
	public List<Map<String, Object>> getJobList() {
		return commonDAO.getJobList();
	}

	@Override
	public List<Map<String, Object>> getStaffList(Map<String, Object> map) {
		return commonDAO.getStaffList(map);
	}
	
	@Override
	public List<Map<String, Object>> getcustomerList() {
		return commonDAO.getcustomerList();
	}

	@Override
	public Map<String, Object> getStaffInfo(Map<String, Object> map) {
		return commonDAO.getStaffInfo(map); 
	}

	@Override
	public List<Map<String, Object>> getStaffType(Map<String, Object> map) {
		return commonDAO.getStaffType(map);
	}
	
	//파일업로드
	@Override
	public void fileUpload(Map<String, Object> map, HttpServletRequest request) throws Exception {
		List<Map<String,Object>> list = fileUtil.fileUpload(map, request);
        for(int i=0, size=list.size(); i<size; i++){
        	commonDAO.fileUpload(list.get(i), map.get("me_no"), map.get("ct_no"));
        }
	}

	@Override
	public void projectfileUpload(Map<String, Object> map) throws Exception {
		commonDAO. projectfileUpload(map); 
	}
}