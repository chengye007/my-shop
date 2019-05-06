package com.zheng.my.shop.web.interceptor;

import com.zheng.my.shop.commons.constant.ConstantUtils;
import com.zheng.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 该方法的返回值是布尔值 Boolean 类型的，当它返回为 false 时，表示请求结束，后续的 Interceptor 和 Controller 都不会再执行；
        // 当返回值为 true 时，就会继续调用下一个 Interceptor
        // 的 preHandle 方法，如果已经是最后一个 Interceptor 的时候，就会是调用当前请求的 Controller 中的方法。

        // login interceptor
        User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        // not login redirect to login page
        if (user == null) {
            httpServletResponse.sendRedirect("/login");
        }

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
