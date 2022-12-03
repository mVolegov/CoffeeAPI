package com.erp.Coffee.security;

import com.erp.Coffee.filter.CustomAuthenticationFilter;
import com.erp.Coffee.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        var customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/v1/login");

        httpSecurity
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/api/v1/users/**")
                    .permitAll()
                .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/api/v1/users/token/refresh/**")
                    .permitAll()
                .and()
                    .authorizeRequests()
                    .antMatchers("/api/v1/menu-categories/**", "/api/v1/menu-items/**")
                    .permitAll()
                .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/api/v1/orders/**")
                    .permitAll()
                .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/api/v1/orders/**")
                    .hasAnyAuthority("ROLE_CUSTOMER")
                .and()
                    .authorizeRequests()
                    .antMatchers("/api/v1/menu-items")
                    .hasAnyAuthority("ROLE_CUSTOMER")
                .and()
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                .and()
                    .addFilter(customAuthenticationFilter)
                    .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


//        httpSecurity
//                    .csrf().disable()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        httpSecurity
//                    .authorizeRequests().antMatchers("/api/v1/login/**", "/api/v1/users/**", "/api/v1/menu-categories").permitAll();
//        httpSecurity
//                    .authorizeRequests()
//                    .anyRequest()
//                    .authenticated();
//        httpSecurity
//                    .addFilter(customAuthenticationFilter);
//        httpSecurity
//                    .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
