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
public class HomeController {

	
	
	@Autowired
	UserDao udao;
	bouncy_change crt = new bouncy_change();
	
	@RequestMapping("/index")
	public String home() {

		return "/template/index";
	}
	
}
