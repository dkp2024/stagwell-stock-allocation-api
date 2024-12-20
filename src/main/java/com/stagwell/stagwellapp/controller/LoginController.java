/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.LoginReqDto
 *  com.stagwell.stagwellapp.dto.SessionDto
 *  com.stagwell.stagwellapp.service.UserService
 *  jakarta.servlet.http.Cookie
 *  jakarta.servlet.http.HttpServletResponse
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestAttribute
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.RestController
 */
package com.stagwell.stagwellapp.controller;

import com.stagwell.stagwellapp.Constants;
import com.stagwell.stagwellapp.dto.LoginReqDto;
import com.stagwell.stagwellapp.dto.SessionDto;
import com.stagwell.stagwellapp.service.UserService;
import com.stagwell.stagwellapp.util.CookieUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    UserService userService;
    /* // this cod eno longer being used because Okta integrated for login
    @PostMapping("login")
    public SessionDto login(@RequestBody LoginReqDto loginReq, HttpServletResponse response) {
        boolean validated = this.userService.validateCredentials(loginReq.getEmail(), loginReq.getPassword());
        if (!validated) {
            throw new RuntimeException("Invalid user credentials");
        }
        SessionDto sessionDto = this.userService.createSession(loginReq.getEmail());
        Cookie cookie = new Cookie("SESSIONID", sessionDto.getSessionId());
        response.addHeader("SESSIONID", sessionDto.getSessionId());
        response.addCookie(cookie);
        return sessionDto;
    }
    @GetMapping("login")
    public SessionDto login(@RequestParam(value="email") String email, @RequestParam(value="password") String password, HttpServletResponse response) {
        boolean validated = this.userService.validateCredentials(email, password);
        if (!validated) {
            throw new RuntimeException("Invalid user credentials");
        }
        SessionDto sessionDto = this.userService.createSession(email);
        Cookie cookie = new Cookie("SESSIONID", sessionDto.getSessionId());
        response.addHeader("SESSIONID", sessionDto.getSessionId());
        response.addCookie(cookie);
        return sessionDto;
    }
    */


}
