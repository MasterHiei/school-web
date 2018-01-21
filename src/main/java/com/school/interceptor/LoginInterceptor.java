package com.school.interceptor;

import com.mysql.jdbc.StringUtils;
import com.school.entity.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 调用Controller前的预处理（登录验证）
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception{
        // 获取请求地址
        String requestURL = request.getRequestURL().toString();
        // 判断是否为登录或注册关联的请求
        if (requestURL.contains("/login.do") || requestURL.contains("/register.do") || requestURL.contains("/forgotPwd.do")){
            // 是则允许访问
            return true;
        }
        else {
            // 否则验证session中的登录信息
            HttpSession session = request.getSession();
            Object userSession = session.getAttribute(UserEntity.USER_SESSION);
            if (userSession != null){
                // session存在，允许访问
                return true;
            }
        }
        // 未通过验证
        String requestType = request.getHeader("X-Requested-With");
        // 判断是否为Ajax请求
        if (requestType.equals("XMLHttpRequest")){
            // 是则返回前台处理
            response.getWriter().print("loginOut");
        }else {
            // 否则直接跳转至登录页面
            response.sendRedirect("/login.html");
        }
        return false;
    }

    /**
     * 执行Controller后的处理
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView){}

    /**
     * 完成DispatcherServlet请求后的处理
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception){}
}
