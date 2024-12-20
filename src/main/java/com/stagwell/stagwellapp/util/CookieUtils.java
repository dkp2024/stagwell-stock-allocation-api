package com.stagwell.stagwellapp.util;

import com.stagwell.stagwellapp.Constants;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class CookieUtils {
    public static  Map<String,String> getCookie(HttpServletRequest request,String cookeName) throws Exception {
        Cookie[] cookies = request.getCookies();

        String cookieVAL= null;
        Map<String,String> map =new HashMap<>();
        // If there are cookies in the request
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Check if the cookie's name is "AAA"
                if (cookeName.equals(cookie.getName())) {
                    // Return the cookie's value
                    cookieVAL=  cookie.getValue();
                }
            }
        }
        log.info("Cookies received:{}",cookieVAL);
        if(!ObjectUtils.isEmpty(cookieVAL)){
            String []values= cookieVAL.split("_"); //UserController for values what set
            map.put("userId",!ObjectUtils.isEmpty(values[0])?AESUtils.decrypt(values[0]):null);
            map.put("email",!ObjectUtils.isEmpty(values[1])?AESUtils.decrypt(values[1]):null);
        }

        // If cookie "AAA" is not found
        return map;
    }

}
