package com.example.web_ban_hang.config;
//import codegym.service.AppUserService;
import com.example.web_ban_hang.service.ServiceNguoiDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired

    ServiceNguoiDung serviceNguoiDung;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home/show").permitAll()
                .and().authorizeRequests().antMatchers("/home/dung").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .and().authorizeRequests().antMatchers("/home/product").hasRole("ADMIN")
                .and()
                .formLogin().successHandler(new SuccessHandler())
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(serviceNguoiDung).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}