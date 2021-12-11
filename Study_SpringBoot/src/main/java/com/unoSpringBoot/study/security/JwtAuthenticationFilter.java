package com.unoSpringBoot.study.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private TokenProvider tokenProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 요청에서 토큰 가져오기
			String token = parseBearerToken(request);
			log.info("필터를 가동하고 있습니다.");
			// 토큰 검사히고. JWT 이므로 인가 서버에 요청하지 않고도 검증 가능
			if (token != null && !token.equalsIgnoreCase("null")) {
				// userId 가져오기 . 위조된 경우 예외 처리된다.
				String userId = tokenProvider.validateAndGetUserId(token);
				log.info("<권한> id : " + userId);
				// 인증완료. SecurityContexHolder에 등록해야 인증된 사용자라고 생각한다.
				AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(//
						userId//
						// 인증된 사용자의 정보, 문자열이 아니어도 아무것이나 넣을 수 있다.
						// 보통 UserDetails라는 오브젝를 넣는다.
						, null, AuthorityUtils.NO_AUTHORITIES);
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
				securityContext.setAuthentication(authenticationToken);
				SecurityContextHolder.setContext(securityContext);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("정상적으로 실행 할 수가 없습니다.");
		}
		filterChain.doFilter(request, response);
	}

	private String parseBearerToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// HTTP 요청의 헤더를 파싱해 Bearer 토큰을 리턴한다.
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			return bearerToken.substring(7);
		}
		return null;

	}

}
