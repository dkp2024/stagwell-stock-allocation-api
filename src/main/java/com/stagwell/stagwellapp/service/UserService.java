/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.stagwell.stagwellapp.dto.SessionDto
 *  com.stagwell.stagwellapp.entity.SwmUserCredentials
 *  com.stagwell.stagwellapp.entity.SwmUserInfo
 *  com.stagwell.stagwellapp.entity.UserSession
 *  com.stagwell.stagwellapp.repo.UserCredentialsRepo
 *  com.stagwell.stagwellapp.repo.UserRepository
 *  com.stagwell.stagwellapp.repo.UserSessionRepository
 *  org.apache.commons.lang3.RandomStringUtils
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.stagwell.stagwellapp.service;

import com.stagwell.stagwellapp.dto.SessionDto;
import com.stagwell.stagwellapp.entity.SwmUserCredentials;
import com.stagwell.stagwellapp.entity.SwmUserInfo;
import com.stagwell.stagwellapp.entity.UserSession;
import com.stagwell.stagwellapp.repo.UserCredentialsRepo;
import com.stagwell.stagwellapp.repo.UserRepository;
import com.stagwell.stagwellapp.repo.UserSessionRepository;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger log = LogManager.getLogger(UserService.class);
    @Autowired
    private UserSessionRepository userSessionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCredentialsRepo userCredentialsRepo;

    public boolean logoutSession(String email) {
        log.info("logoutSession(-)...{}",email);
        List<UserSession> sessions = this.userSessionRepository.getUserSessionByEmailAndIsActive(email, true);
        UserSession  session = sessions.stream().filter(UserSession::isActive)
                // Sort the sessions by date (descending order)
                .max(Comparator.comparing(UserSession::getLoginTime)).orElse(null);
        log.info("sessions setting deactivated...{}",sessions);
        if(!ObjectUtils.isEmpty(session)) {
            session.setActive(false);
            session.setLastHeartBeat(new Date());
            this.userSessionRepository.save(session);
        }
        log.info("logoutSession(-)...exit");
        return true;
    }

    public SessionDto createSession(String email) {
        log.info("createSession(-)...{}",email);
        SwmUserInfo userInfo;
        List<UserSession> sessions = this.userSessionRepository.getUserSessionByEmailAndIsActive(email, true);
        UserSession session = sessions.stream().filter(UserSession::isActive)
                // Sort the sessions by date (descending order)
                .max(Comparator.comparing(UserSession::getLoginTime)).orElse(null);
        List userInfoList = this.userRepository.getSwmUserInfoByEmailAddress(email);
        SwmUserInfo swmUserInfo = userInfo = userInfoList != null && userInfoList.size() > 0 ? (SwmUserInfo)userInfoList.get(0) : null;
        if (userInfo == null) {
            throw new IllegalStateException("userInfo is null for user:" + email);
        }
        SwmUserCredentials swmUserCredentials = this.userCredentialsRepo.getSwmUserCredentialsByUserId(userInfo.getUserId());
        if (session == null || !session.isActive()) {
            String sessionId = RandomStringUtils.random((int)16, (boolean)true, (boolean)true);
            session = new UserSession();
            session.setEmail(email);
            session.setSessionId(sessionId);
            session.setUserId(userInfo.getUserId());
            session.setActive(true);
            this.userSessionRepository.saveAndFlush(session);
            log.info("session saved - {}", (Object)sessionId);
        }
        SessionDto sessionDto = new SessionDto(session.getSessionId(), userInfo != null ? userInfo.getUserType() : "", swmUserCredentials != null ? swmUserCredentials.getUserName() : null);
        return sessionDto;
    }

    public boolean validateCredentials(String username, String password) {

        return this.userSessionRepository.validateCredentials(username, password) != null;
    }
    public SwmUserCredentials saveUser(SwmUserCredentials swmUserCredentials) {

        return this.userCredentialsRepo.save(swmUserCredentials);
    }
    public SwmUserCredentials getUserByEmail(String email) {

        return this.userCredentialsRepo.getSwmUserCredentialsByUserName(email);
    }

    public List<SwmUserInfo> getUserInfoByEmail(String email) {
        return  this.userRepository.getSwmUserInfoByEmailAddress(email);
    }


    public UserSession isSessionExisting(String sessionId) {
        UserSession session = this.userSessionRepository.getUserSessionBySessionIdAndIsActive(sessionId, true);
        if (session != null) {
            return session;
        }
        return null;
    }
}
