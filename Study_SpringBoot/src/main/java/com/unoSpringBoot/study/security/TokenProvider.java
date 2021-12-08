package com.unoSpringBoot.study.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.unoSpringBoot.study.model.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenProvider {
	private static final String SECRET_KEY = "NMA8JPcFuna59f5";

	public String create(UserEntity userEntity) {
		Date expirDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
		/*
		 * {//header "alg" : "HS512" }. 
		 * { //payload 
		 * 		"sub" : "40288093784915d201784916a40c001"
		 * , 	"iss" : "demo app"
		 * , 	"iat" : 1595733657
		 * ,	"exp" : 1596597657
		 *  }.
		 */
		//JWT 토큰 생성
		return Jwts.builder()
				//header에 들어갈 내용 및 서명을 하기 위한 secret_key
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				//payload에 들어갈 내용
				.setSubject(userEntity.getId())
				.setIssuer("demo app").setIssuedAt(new Date()).setExpiration(expirDate).compact();
	}

	public String validateAndGetUserId(String token) {
		// parseClaimsJwt 매서드가 Base64로 디코딩 및 파싱
		// 해더와 페이로드를 setSigninKey 로 넘어온 시크릿을 이용해 서명한 후 token의 서명과 비교
		// 위조 되지 않았다면 페이로드(Claims)리턴, 위조라면 예외를 날림
		// 그중 우리는 userId가 필요하므로 getBody를 부른다.
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
}
