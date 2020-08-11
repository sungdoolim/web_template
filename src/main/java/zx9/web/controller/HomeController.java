package zx9.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.scribejava.core.model.OAuth2AccessToken;

import pwchange.bouncy_change;
import zx9.web.dao.UserDao;
import zx9.web.vo.UserVO;

@Controller
public class HomeController {

	
	
	@Autowired
	UserDao udao;
	bouncy_change crt = new bouncy_change();
	
	@RequestMapping("/index.do")
	public String home() {

		return "/template/index";
	}
	
	@RequestMapping("/naverToAnd.do")
	public @ResponseBody String naverToAnd(String name,String id,HttpServletRequest request ) {
		System.out.println("ntoand");
		System.out.println(id);
		System.out.println(name);
		HttpSession session=request.getSession();
		session.setAttribute("bid", id);
		session.setAttribute("bname", name);
	//	Object result= session.getAttribute("result");
		
	//	String rid=((OAuth2AccessToken) result).getParameter("name");
	//	System.out.println("rerid : "+ rid);
				
		
			 JSONObject jsonMain = new JSONObject(); // json 
			
			 jsonMain.put("Bpw", name);
			 jsonMain.put("Bid",id);
			// System.out.println(pwd);		
	  
				
				return jsonMain.toJSONString();
				
	}
	@RequestMapping("/androidtest.do")
	public @ResponseBody String andr(String id,String pw) {
		System.out.println("오오ㅗ오오오오ㅗ오오");
		System.out.println(id+","+pw);
        // json-simple 라이브러리 추가 필요(JSON 객체 생성)
        JSONObject jsonMain = new JSONObject(); // json 객체
        // {변수명:값, 변수명:값}
        // {sendData:[{변수명:값},{변수명:값},...]}
        List<UserVO> items = new ArrayList<>();
        JSONArray jArray = new JSONArray(); // json배열
        
        
    	for(int i=0;i<10;i++) {
    		UserVO vo=new UserVO();
			vo.setSid(""+i);
			vo.setSname("sejong");
		
			items.add(vo);
		}
    	
    	
        for(int i=0; i<items.size(); i++){
        	UserVO dto = items.get(i);
            JSONObject row = new JSONObject();
            // json객체.put("변수명",값)
       
            row.put("f", dto.getSid());
            row.put("l", dto.getSname());
      
            // 배열에 추가
            // json배열.add(인덱스,json객체)
            jArray.add(i,row);
        }
        // json객체에 배열을 넣음
        jsonMain.put("sendData", jArray);
        return jsonMain.toJSONString();
	}
	@RequestMapping("/andtest.do")
	public @ResponseBody String andtest(String id,String pw, HttpServletResponse response,HttpServletRequest request ) throws IOException {
		System.out.println("andtest");
		HttpSession session=request.getSession();
		String bid= session.getAttribute("bid").toString();
		String name= session.getAttribute("bname").toString();
		
		System.out.println(bid);
		System.out.println(name);
			 JSONObject jsonMain = new JSONObject(); // json 
		//	 String pwd="Abdeok odielswo dj244 d";
			 
			 
			 
			 
			 jsonMain.put("Bpw", name);
			 jsonMain.put("Bid",bid);
			// System.out.println(pwd);		
	  
				
				return jsonMain.toJSONString();
				
		//	return jsonMain;
	
	}
	
}
