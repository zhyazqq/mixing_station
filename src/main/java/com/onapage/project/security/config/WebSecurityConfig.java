package com.onapage.project.security.config;

import com.onapage.project.security.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //登录成功处理逻辑
    @Resource
    CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;

    //登录失败处理逻辑
    @Resource
    CustomizeAuthenticationFailureHandler authenticationFailureHandler;

    //权限拒绝处理逻辑
    @Resource
    CustomizeAccessDeniedHandler accessDeniedHandler;

    //匿名用户访问无权限资源时的异常
    @Resource
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    //会话失效(账号被挤下线)处理逻辑
    @Resource
    CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    //登出成功处理逻辑
    @Resource
    CustomizeLogoutSuccessHandler logoutSuccessHandler;

    //访问决策管理器
    @Resource
    CustomizeAccessDecisionManager accessDecisionManager;

    //实现权限拦截
    @Resource
    CustomizeFilterInvocationSecurityMetadataSource securityMetadataSource;

    @Resource
    private CustomizeAbstractSecurityInterceptor securityInterceptor;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(corsConfigurationSource()).and().csrf().disable();
        http.authorizeRequests().

//                antMatchers("/api/query").hasAuthority("query_user").
////                antMatchers("/**").fullyAuthenticated().
                        withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(accessDecisionManager);//决策管理器
                        o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
                        return o;
                    }
                }).
                anyRequest().authenticated().
        //登出
        and().logout().
                permitAll().//允许所有用户
                logoutUrl("/api/logout").
                logoutSuccessHandler(logoutSuccessHandler).//登出成功处理逻辑
                deleteCookies("JSESSIONID").//登出之后删除cookie
        //登入
        and().formLogin().
                permitAll().
                loginProcessingUrl("/api/login").
                usernameParameter("username").
                passwordParameter("password").
                //允许所有用户
                        successHandler(authenticationSuccessHandler).//登录成功处理逻辑
                failureHandler(authenticationFailureHandler).//登录失败处理逻辑
        //异常处理(权限拒绝、登录失效等)
                and().exceptionHandling().
                accessDeniedHandler(accessDeniedHandler).//权限拒绝处理逻辑
                authenticationEntryPoint(authenticationEntryPoint).//匿名用户访问无权限资源时的异常处理
        //会话管理
                and().sessionManagement().
                maximumSessions(10).//同一账号同时登录最大用户数
                expiredSessionStrategy(sessionInformationExpiredStrategy);//会话失效(账号被挤下线)处理逻辑
        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
    }
    private CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");    //同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
        corsConfiguration.addAllowedHeader("*");//header，允许哪些header，本案中使用的是token，此处可将*替换为token；
        corsConfiguration.addAllowedMethod("*");    //允许的请求方法，PSOT、GET等
        corsConfiguration.setAllowCredentials(true);
        source.registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url

        return source;
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**","/js/**","/index.html","/img/**","/fonts/**","/favicon.ico","/verifyCode");
//    }
}