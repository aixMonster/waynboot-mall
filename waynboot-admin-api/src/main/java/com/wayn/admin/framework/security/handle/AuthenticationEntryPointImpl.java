package com.wayn.admin.framework.security.handle;

import com.wayn.util.constant.Constants;
import com.wayn.util.util.R;
import com.wayn.util.util.json.JsonUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

/**
 * 失败处理类
 */
@Slf4j
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
    @Serial
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        log.error(e.getMessage(), e);
        int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String msg = e.getMessage();
        try {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json");
            response.setCharacterEncoding(Constants.UTF_ENCODING);
            response.getWriter().print(JsonUtil.marshal(R.error(code, msg)));
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }

}
