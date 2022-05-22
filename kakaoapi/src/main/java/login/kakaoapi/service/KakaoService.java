package login.kakaoapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import login.kakaoapi.api.KakaoAuthApi;
import login.kakaoapi.api.response.ResponseKakao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakaoService {
	
	
	@Value("${kakao.auth.rediect.url}")
	private String redirectUrl;
	
	private final KakaoAuthApi kakaoAuthApi;
	
	public ResponseKakao getToken(String code) {
		return kakaoAuthApi.getToken(code, redirectUrl);
	}
	
	
}
