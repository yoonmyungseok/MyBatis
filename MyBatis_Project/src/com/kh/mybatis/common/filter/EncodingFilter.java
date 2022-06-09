package com.kh.mybatis.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(urlPatterns="/*") //모든 서블릿이 실행되기 전에 이 필터를 거쳐가겠다.
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//doFilter: 요청 내용이 컨트롤러로 들어가기 전에 선처리로 먼저 실행해야 할 코드들 작성
		request.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
		//현재 필터가 최종 필터일 경우: Servlet을 호출하는 구문
		//현재 필터가 최종 필터가 아닐 경우: 또 다른 필터를 호출하는 구문
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
