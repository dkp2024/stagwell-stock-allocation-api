package com.stagwell.stagwellapp.util;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.Map;

@Slf4j
public class ValidateCookie {
    public static Boolean validateCookies(Map<String, String> map, @NonNull String[] names) {
        StringBuffer buffer = new StringBuffer();
        log.info("Names to search:{} and map:{}", names, map);
        Arrays.stream(names).forEach(n -> {
            if (map.get(n) == null) {
                log.info(" Null value found for name:{}", n);
                buffer.append(n);
            }
        });
        log.info("Is null found for names:{}", !buffer.isEmpty());
        return buffer.isEmpty() ; // If isEmpty means are names found in the map which are there in cookie
    }
}
