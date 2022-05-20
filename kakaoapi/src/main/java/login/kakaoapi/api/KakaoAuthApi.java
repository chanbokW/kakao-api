package login.kakaoapi.api;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class KakaoAuthApi {
	private final WebClient webClient;
	private final ObjectMapper objectMapper;
	
	//RESTAPIKEY
	private static final String REST_API_KEY ="restApi_key";
	
	
	
	
	public KakaoAuthApi(ObjectMapper objectMapper) {
		this.webClient = WebClient.builder()
				.baseUrl("https://kauth.kakao.com")
				.defaultHeader(org.springframework.http.HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.build();
		this.objectMapper = objectMapper;
	}
	
	
}
