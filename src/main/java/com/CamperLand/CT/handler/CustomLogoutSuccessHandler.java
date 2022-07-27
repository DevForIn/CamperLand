package com.CamperLand.CT.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authList = authentication.getAuthorities();
        Iterator it = authList.iterator();
        String roleName = it.next().toString();
        switch(roleName) {
            case "ROLE_NAVER":  break;
            case "ROLE_GOOGLE": break;
            case "ROLE_KAKAO": break;
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/");
    }

}