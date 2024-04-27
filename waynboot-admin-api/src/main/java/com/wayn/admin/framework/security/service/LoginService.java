package com.wayn.admin.framework.security.service;

import com.wayn.admin.framework.security.model.LoginUserDetail;
import com.wayn.util.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class LoginService {

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;


    @SneakyThrows
    public String login(String username, String password) {
        // 用户验证
        Authentication authentication;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new BadCredentialsException(e.getMessage(), e);
            } else {
                throw new BusinessException(e.getMessage(), e);
            }
        }
        LoginUserDetail principal = (LoginUserDetail) authentication.getPrincipal();
        return tokenService.createToken(principal);
    }
}
