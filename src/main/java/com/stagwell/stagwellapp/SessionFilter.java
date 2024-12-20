/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.servlet.Filter
 *  jakarta.servlet.FilterChain
 *  jakarta.servlet.FilterConfig
 *  jakarta.servlet.ServletContext
 *  jakarta.servlet.ServletException
 *  jakarta.servlet.ServletRequest
 *  jakarta.servlet.ServletResponse
 *  jakarta.servlet.http.Cookie
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.core.annotation.Order
 *  org.springframework.stereotype.Component
 */
package com.stagwell.stagwellapp;

import com.stagwell.stagwellapp.entity.UserSession;
import com.stagwell.stagwellapp.service.UserService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(value=1)
//public class SessionFilter implements Filter {
public class SessionFilter{
   /* private static final Logger log = LogManager.getLogger(SessionFilter.class);
    @Autowired
    UserService userService;
    @Autowired
    ServletContext context;

//    public void init(FilterConfig filterConfig) throws ServletException {
//        super.init(filterConfig);
//    }
//
//    public void destroy() {
//        super.destroy();
//    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        log.info("Starting a filter req : {},{}", (Object)req.getRequestURI(), (Object)this.context.getContextPath());
        if (req.getRequestURI().equals(this.context.getContextPath() + "/api/external")){
            chain.doFilter(req,res);
        }else if (!req.getRequestURI().equals(this.context.getContextPath() + "/login") && !req.getRequestURI().equals(this.context.getContextPath() + "/login/logout")) {
            this.setReqAttributesAfterSessionValidation(req, res);
            chain.doFilter((ServletRequest)req, servletResponse);
        } else if (req.getRequestURI().equals(this.context.getContextPath() + "/login/logout")) {
            this.setReqAttributesAfterSessionValidation(req, res);
            chain.doFilter((ServletRequest)req, servletResponse);
            Cookie c = new Cookie("SESSIONID", "");
            c.setMaxAge(0);
            ((HttpServletResponse)servletResponse).addCookie(c);
        } else {
            chain.doFilter((ServletRequest)req, servletResponse);
        }
        log.info("Exiting a filter req : {}", (Object)req.getRequestURI());
    }

    void setReqAttributesAfterSessionValidation(HttpServletRequest req, HttpServletResponse res) {
        UserSession userSession;
        Cookie[] cookies;
        String sessionId = null;
        for (Cookie c : cookies = req.getCookies()) {
            sessionId = c.getName().equals("SESSIONID") ? c.getValue() : null;
        }
        if (sessionId != null) {
            userSession = this.userService.isSessionExisting(sessionId);
            if (userSession == null) {
                throw new RuntimeException("Invalid session in header");
            }
        } else {
            throw new RuntimeException("Invalid session in header");
        }
        req.setAttribute("sessionEmail", (Object)userSession.getEmail());
        req.setAttribute("sessionUserId", (Object)userSession.getUserId());
    }

    */
}
