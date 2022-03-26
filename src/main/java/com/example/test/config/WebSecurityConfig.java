package com.example.test.config;

import com.example.test.infra.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(
            @Autowired CustomUserDetailsService customUserDetailsService){
        userDetailsService = customUserDetailsService;


    }


    @Override                   //사용자 관리를 한다
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);

//        auth.inMemoryAuthentication()
//                .withUser("user1")
//                .password(passwordEncoder().encode("user1pass"))
//                .roles("USER")
//        .and()
//                .withUser("admin1")
//                .password(passwordEncoder().encode("admin1pass"))
//                .roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .mvcMatchers(
                        "/",
                        "/css/**",
                        "/scripts/**",
                        "/plugin/**",
                        "/fonts/**",
                        "/docs/**",
                        "/webjars/**",
                        "/cover.css",
                        "/signin.css"
                )
                .permitAll();

        http
                .authorizeRequests() //url 기반의 권한 확인
                .antMatchers("/home/**", "/user/signup/**","/css/**")
//                .anonymous()
                .permitAll()
                .anyRequest()
                .authenticated()
              .and()
                .formLogin()
                .loginPage("/user/login") //만든 페이지 이동
                .defaultSuccessUrl("/home")
                .permitAll()
              .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/home")
                .deleteCookies("JSEESIONID")
                .invalidateHttpSession(true)
                .permitAll()
    ;


    }



}
