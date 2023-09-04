package com.example.doan1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // need         http.csrf().disable() it's working because crsf is enabled on default in Spring
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeRequests -> authorizeRequests
//                        .requestMatchers(adminRequestMatcher()).authenticated() // Use adminRequestMatcher for path matching
                        .requestMatchers(adminRequestMatcher()).hasRole("admin")
                        .requestMatchers(userRequestMatcher()).hasAnyRole("admin","user")
                        .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/study/home/login")
                        .usernameParameter("userEmail")
                        .passwordParameter("password")
                        .loginProcessingUrl("/doLogin")
                        .defaultSuccessUrl("/study/admin/backend/home")
                        .failureUrl("/study/home/login?error=true")
                        .permitAll()
                )
                .logout((logout) ->
                        logout
                                .logoutUrl("/study/home/logout")
                                .logoutSuccessUrl("/study/home")
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")// key duy nhất xđ ng dùng tương tác vs hệ thống
                                .permitAll()
                );
        return http.build();
    }

    @Bean
    public RequestMatcher adminRequestMatcher() {
        // Use RegexRequestMatcher to specify the paths that need authentication.
        // Here, any path that starts with "/study/admin/" requires authentication.
        return
                new RegexRequestMatcher("^/study/admin/.*", null);
}
@Bean
    public  RequestMatcher userRequestMatcher() {
    return new RegexRequestMatcher("^/study/home/course/.*", null);
}

}