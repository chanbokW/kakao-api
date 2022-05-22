package login.kakaoapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import login.kakaoapi.api.response.ResponseKakao;
import login.kakaoapi.service.KakaoService;

@Controller
public class LoginTestController {
	
	
	private final KakaoService kakaoService;
	
	@Autowired
	public LoginTestController(KakaoService kakaoService) {
		this.kakaoService = kakaoService;
	}
	
	@GetMapping("/kakaologin")
	public String login() {
		return "kakaoLogin";
	}
	
	@GetMapping("/kakao/token")
	public String token(HttpServletRequest request, Model model) {
		String code = request.getParameter("code");
		System.out.println(code);
		ResponseKakao response = kakaoService.getToken(code);
		model.addAttribute("response", response);
		return "token";
	}
}
