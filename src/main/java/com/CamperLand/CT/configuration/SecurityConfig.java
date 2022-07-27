package com.CamperLand.CT.configuration;

import com.CamperLand.CT.handler.CustomLoginSuccessHandler;
import com.CamperLand.CT.handler.CustomLogoutSuccessHandler;
import com.CamperLand.CT.logic.UserService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public SecurityExpressionHandler expressionHandler() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");

        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setRoleHierarchy(roleHierarchy);

        return handler;
    }

    @Bean
    public LogoutSuccessHandler customLogoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }
    //
//	@Bean
//	public UserDetailsService customUserService() {
//		return new CustomUserDetailsService();
//	}
//
//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
//		repo.setDataSource(dataSource);
//		return repo;
//	}
//
    @Setter(onMethod_ = {@Autowired})
    private DataSource dataSource;

    @Override
    public void configure(HttpSecurity http) throws Exception {
//		http.addFilterBefore(new LoggingFilter(), WebAsyncManagerIntegrationFilter.class);

        http.authorizeRequests()
                .antMatchers("/", "/users/**", "/socialJoin", "/socialLogin", "/google/*", "/naver/*","/kakao/*", "/resources/**", "/join", "/create", "/find_id_form", "/find_id",
                        "/findPwd", "/find_password_email", "/modifyPwd").permitAll()
                .anyRequest().authenticated()
                .expressionHandler(expressionHandler());

        http.formLogin()
                .loginPage("/login").permitAll();

        http.httpBasic();

        http.rememberMe()
                .userDetailsService(userService)
                .key("remember-me-sample");

        http.logout()
//        .logoutSuccessHandler(customLogoutSuccessHandler())
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
//
        http.csrf().disable();

        http.exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    String username = principal.getUsername();
                    System.out.println(username + " is denied to access " + request.getRequestURI());
                    response.sendRedirect("/access-denied");
                });

        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}