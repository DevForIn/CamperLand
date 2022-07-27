package com.CamperLand.CT.handler;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication auth) throws IOException, ServletException {

        System.out.println("onAuthenticationSuccess");
        System.out.println(auth);

        response.sendRedirect("/");
    }

}