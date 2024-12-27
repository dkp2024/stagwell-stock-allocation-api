package com.stagwell.stagwellapp.controller;

import com.stagwell.stagwellapp.Constants;
import com.stagwell.stagwellapp.dto.SessionDto;
import com.stagwell.stagwellapp.dto.UserLeastInfoDto;
import com.stagwell.stagwellapp.dto.ValidateUserDto;
import com.stagwell.stagwellapp.entity.SwmUserCredentials;
import com.stagwell.stagwellapp.entity.SwmUserInfo;
import com.stagwell.stagwellapp.service.UserService;
import com.stagwell.stagwellapp.util.AESUtils;
import com.stagwell.stagwellapp.util.CookieUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("user")
    public ResponseEntity<UserLeastInfoDto> validateAndSave(HttpServletResponse servletResponse, @RequestBody ValidateUserDto validateUserDto) {
        UserLeastInfoDto userDto = new UserLeastInfoDto();
        log.info("validateUserDto:{}", validateUserDto.toString());
        log.info("getUser(-) email:{}", validateUserDto.getEmail());
        log.info("getUser(-) roles:{}", Arrays.stream(validateUserDto.getRoles()).toArray());
        try {
            if (ObjectUtils.isEmpty(validateUserDto.getEmail())) {
                throw new Exception("User email is not received!");
            }
            SwmUserCredentials userCredentials = userService.getUserByEmail(validateUserDto.getEmail());
            if (!ObjectUtils.isEmpty(userCredentials)) {
                userCredentials.setLastlogin(new Date());
                log.info("updating user with last login(-) :{}", validateUserDto.getEmail());
                SwmUserCredentials userCredentials1 = userService.saveUser(userCredentials);
                List<SwmUserInfo> userInfoList = this.userService.getUserInfoByEmail(validateUserDto.getEmail());
                log.info("User info size :{}", userInfoList.size());
                if (!ObjectUtils.isEmpty(userInfoList)) {
                    SwmUserInfo swmUserInfo = !userInfoList.isEmpty() ? (SwmUserInfo) userInfoList.get(0) : null;
                    if (Arrays.asList(validateUserDto.getRoles()).contains(swmUserInfo.getUserType())) {
                        userDto.setUserId(swmUserInfo.getUserId());
                        userDto.setUserType(swmUserInfo.getUserType());
                        userDto.setUserName(swmUserInfo.getEmailAddress());
                        String encryptedUserId = AESUtils.encrypt(String.valueOf(swmUserInfo.getUserId()));
                        String encryptedEmail = AESUtils.encrypt(String.valueOf(swmUserInfo.getEmailAddress()));
                        //swmUserInfo.ag
                        // set user activity session
                        this.userService.createSession(swmUserInfo.getEmailAddress());

                        String cookieDATA = encryptedUserId + "___" + encryptedEmail; //append another cookie value with separator "___" if required
                        log.info("cookieDATA {}:", cookieDATA);
                        Cookie cookie = new Cookie(Constants.COOKIENAME, cookieDATA);
                        // Set the cookie's max age (in seconds)
                        cookie.setMaxAge(60 * 60 * 24); // 1day
                        // Set the cookie's path (optional, defaults to "/")
                        cookie.setPath("/");
                        // Set the cookie to be HttpOnly (optional, recommended for security)
                        cookie.setHttpOnly(true);
                        // Add the cookie to the response
                        servletResponse.addCookie(cookie);
                    }

                }
            }

            log.info("Response:{}", userDto);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            log.info("Response:" + e.getMessage());
            return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("clearCookie")
    public void clearCookie(HttpServletRequest request, HttpServletResponse servletResponse) throws Exception {
        String email = CookieUtils.getCookie(request, Constants.COOKIENAME).get("email");
        log.info("clearCookie(-) User email: {}", email);
        this.userService.logoutSession(email);
        for (Cookie cookie : request.getCookies()) {
            if (Constants.COOKIENAME.equals(cookie.getName())) {
                cookie.setMaxAge(0);  // Expire the cookie
                cookie.setPath("/");  // Ensure the path matches the cookie's path
                servletResponse.addCookie(cookie);  // Add the cookie back to the response (it will be deleted)
                break;
            }
        }
    }

}



