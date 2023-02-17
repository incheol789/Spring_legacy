package com.sh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sh.spring.member.controller.MemberController;
import com.sh.spring.member.model.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Member logimMember = (Member) session.getAttribute("loginMember");
		
		log.debug((logimMember != null ? "로그인한 상태에서 요청!" : "비로그인 상태에서 요청"));
		
		if(logimMember == null) {
			// FlashMap 사용 - RedirectAttribute 여기서는 못씀 ㅠ
			FlashMap flashMap = new FlashMap();
			flashMap.put("msg", "로그인후 이용할 수 있습니다.");
			FlashMapManager manager = RequestContextUtils.getFlashMapManager(request);
			manager.saveOutputFlashMap(flashMap, request, response);
			
			response.sendRedirect(request.getContextPath() + "/");
			
			return false; // handler 호출하지 않음.
		}
		return super.preHandle(request, response, handler);
	}

}
