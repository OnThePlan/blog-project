package kr.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")
public class FileUtils {
	private static  String filePath = "D:\\java\\eclipse\\eclipse\\worksapce\\nextpage\\src\\main\\webapp\\project";

	public List<Map<String, Object>>fileUpload(Map<String, Object> map, HttpServletRequest request)throws Exception{
        String s = System.getProperty("user.dir");

        System.out.println("현재 디렉토리는 " + s + " 입니다");
        
    	MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
         
        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;
         
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null; 
         
       while(iterator.hasNext()){
            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            if(multipartFile.isEmpty() == false){
                //originalFileName = multipartFile.getOriginalFilename();
                originalFileName = new String(multipartFile.getOriginalFilename().getBytes("8859_1"), "UTF-8");
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                storedFileName = CommonUtils.getRandomString() + originalFileExtension;
                File file = null; 
                
                boolean isLocal = new File("c:/Windows/").exists();
                
                if(isLocal == false){
                	String root_path = request.getSession().getServletContext().getRealPath("/");
                	filePath = root_path + "project/";
                	file = new File(root_path + "project/" + storedFileName);
                }else{
                	file = new File(filePath+ "\\" + storedFileName);
                }
                
                //file = new File(filePath + storedFileName);
                multipartFile.transferTo(file);
                 
                listMap = new HashMap<String,Object>();
                listMap.put("ORIGINAL_FILE_NAME", originalFileName);
                listMap.put("STORED_FILE_NAME", storedFileName);
                listMap.put("FILE_SIZE", multipartFile.getSize());
                listMap.put("FILE_PATH", "/project/" + storedFileName);
                list.add(listMap);
            }
        }
    	
    	return list;
    }

}
