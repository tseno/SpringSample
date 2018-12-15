package com.example.springsample;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

public class RestMacher implements RequestMatcher {

    private AntPathRequestMatcher matcher;

    public RestMacher(String url) {
        super();
        matcher = new AntPathRequestMatcher(url);
    }

    @Override
    public boolean matches(HttpServletRequest noCheckCsrfRequest) {

        // GETならCSRFのチェックはしない
        if("GET".equals(noCheckCsrfRequest.getMethod())) {
            return false;
        }

        // 特定のURLに該当する場合、CSRFはチェックしない
        return !matcher.matches(noCheckCsrfRequest);
    }
}
