package com.example.springsecuritydemo.filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",
        initParams = @WebInitParam(name = "id", value = "109"))
public class AuditRequestFilter extends GenericFilterBean {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("request is " + httpRequest.getClass());
        System.out.println("request URL : " + httpRequest.getRequestURL());
        System.out.println("response is " + httpResponse.getClass());

        displayMessage();

        chain.doFilter(request, response);
    }

    private void displayMessage() {
        final WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        System.out.println(applicationContext.getBean("helloBean"));
    }
}
