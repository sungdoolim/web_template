package zx9.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pwchange.bouncy_change;
import zx9.web.dao.UserDao;
import zx9.web.vo.UserVO;

@Controller
public class RegisterController {

	
	
	@Autowired
	UserDao udao;
	bouncy_change crt = new bouncy_change();
	
	@RequestMapping("/register")
	public String register() {

		return "/register";
	}
	@RequestMapping("/register_ok")
	public String register_ok(UserVO a,Model m) {
		System.out.println("id"+a.getSid());
		System.out.println("name"+a.getSname());
		System.out.println("pw"+a.getSpw());
		System.out.println("major"+a.getSmajor());
		System.out.println("num"+a.getSnum());
		System.out.println("grade"+a.getSgrade());
		
		try {
		//System.out.println("?");
		
		if(a.getSid()==null||a.getSname()==null||a.getSpw()==null||a.getSmajor()==null||a.getSnum()==null||a.getSgrade()==0)
			{return "/index";}
					
		//System.out.println(a.toString());

		a.setSpw(crt.CryptoSHA3(a.getSpw(), 224));
		udao.register(a);
		return "/register/register_ok";}
		catch(Exception e) {

			String msg="공백은 불허 합니다";
			m.addAttribute("msg",msg);
			
			return "/errorhandle";
		}
	}
	
}
