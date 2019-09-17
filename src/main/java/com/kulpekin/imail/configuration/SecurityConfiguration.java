package com.kulpekin.imail.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final CustomLoginSuccessHandler successHandler;

    private final DataSource dataSource;

    @Autowired
    public SecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder,
                                 CustomLoginSuccessHandler successHandler,
                                 DataSource dataSource) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.successHandler = successHandler;
        this.dataSource = dataSource;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // URLs matching for access rights
                .antMatchers("/forgot").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("iMail/home/**").hasAuthority( "SITE_USER")
                .anyRequest().authenticated()
                .and()
                // form login
                .csrf().disable().formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .successHandler(successHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                // logout
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/resources/**","/templates/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }


}
