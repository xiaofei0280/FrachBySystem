package com.qf.resolver;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println(ex.getClass());
        ex.printStackTrace();
        ModelAndView mv = new ModelAndView();
        if (ex instanceof UnauthenticatedException){
            //  没有合法身份
            mv.setViewName("redirect:/error_login.jsp");
        }else if (ex instanceof UnauthorizedException){
            // 没有权限或角色
            mv.setViewName("redirect:/error.jsp");
        }


        return mv;
    }
}
