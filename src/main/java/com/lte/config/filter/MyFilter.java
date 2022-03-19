package com.lte.config.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: laite
 * @Date: 2022/3/19 - 03 - 19 - 22:11
 * @Description: com.lte.config.filter
 * @version: 1.0
 */
@Component
public class MyFilter implements Filter {
    /**
     * 由于代码注册了一个ServletFilter，URL模式必须符合Servlet/Filters支持的URL映射，如Servlet规范中所指定的：
     *
     * 12.2映射规范
     *
     * 在Web应用程序部署描述符中，以下语法用于定义映射：
     *
     * 以 / 字符开头、以 /*后缀结尾的字符串用于路径映射。
     * 以*.前缀开头的字符串用作扩展映射。
     * 空字符串（“”）是一种特殊的URL模式，它精确地映射到应用程序的上下文根，即http://host:port/<context-root>/形式的请求。在本例中，路径信息是/，servlet路径和上下文路径是空字符串（“”）。
     * 只包含/字符的字符串表示应用程序的“默认”servlet。在本例中，servlet路径是请求URI减去上下文路径，路径信息为空。
     * 所有其他字符串仅用于精确匹配。
     * 因此，URL只能有一个通配符，并且必须是第一个或最后一个：
     * /some/path/*
     * *.ext
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        String s = requestURL.toString();
        System.out.println("requestURL = " + s);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
