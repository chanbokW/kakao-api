package login.kakaoapi.api;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


import login.kakaoapi.api.response.ResponseKakao;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
public class KakaoAuthApi {
	private final WebClient webClient;
	
	//RESTAPIKEY
	private static final String REST_API_KEY ="REST_API_KEY";
	private static final String CLIENT_SECRET = "CLIENT_SECRET";
	private final String URL_PATH = "/oauth/token";
	
	
	public KakaoAuthApi() {
		this.webClient = WebClient.builder()
                .baseUrl("https://kauth.kakao.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .build();
	}
	
	public ResponseKakao getToken(String code, String redirect) {
		log.info(redirect);
		log.info(code);
		return webClient.post()
				.uri(URL_PATH)
                .body(BodyInserters.fromFormData("grant_type", "authorization_code")
                        .with("client_id", REST_API_KEY)
                        .with("redirect_uri", redirect)
                        .with("code", code)
                        .with("client_secret", CLIENT_SECRET)
                ).retrieve()
                .bodyToFlux(ResponseKakao.class)
                .onErrorMap(e -> {
                    log.error("카카오 인증 서버 요청에 실패하였습니다.", e);
                    return new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "카카오 인증 서버 요청에 실패하였습니다.");
                })
                .blockLast();
	}
	
	
}
