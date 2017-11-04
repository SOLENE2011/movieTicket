package com.hotsix.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter{
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);

	// 전처리기 : 컨트롤러가 호출되기 전에 실행 (현재 호출된 URI가 무엇인지 보여주도록 한다.)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(log.isDebugEnabled()){
			log.debug("============================= START =============================");
			log.debug(" Request URI \t:" + request.getRequestURI());
		}
		
		return super.preHandle(request, response, handler);
	}
	
	// 후처리기 : 컨트롤러가 실행되고 난 후에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if(log.isDebugEnabled()){
			log.debug("============================= END =============================");
		}
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
