package com.example.springsecuritydemo.filter;

import com.example.springsecuritydemo.components.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component(value = "basicFilter")
public class BasicFilter implements Filter {

    @Autowired
    private UserManager userManager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("In basicFilter: userManager is " + userManager);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
