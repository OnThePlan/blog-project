package kr.common.util;



import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

public class CommonUtils {

	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static Gson gson;

	public static Gson getGson() {
		if (gson == null) {
			try {
				gson = new Gson();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return gson;
	}
	
	// json등을 직접 출력하기 위해 response의 output을 직접 컨트롤한다. 
 	public static ModelAndView directWrite(HttpServletResponse res, String str) throws Exception {
 		res.setHeader("Content-Type", "text/plain;charset=UTF-8");
 		PrintWriter pw = res.getWriter();
 		pw.print(str);
 		pw.close();
 		return null;
 	}
}