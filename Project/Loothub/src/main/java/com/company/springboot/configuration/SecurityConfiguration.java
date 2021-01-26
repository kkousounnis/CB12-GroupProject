package com.company.springboot.configuration;

import com.company.springboot.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableGlobalMethodSecurity(
  prePostEnabled = true, 
  securedEnabled = true, 
  jsr250Enabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserService iuserService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(iuserService);
        auth.setPasswordEncoder(passwordEncoder());
        
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      
        auth.authenticationProvider(authenticationProvider());
        
        auth.userDetailsService(iuserService);
        
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                "/registration**",
                "/buy**",
                "/paypal**",
                "/error**",
                "/order/{id}",
                "/order**",
                "/products**",
                "/api/productList**",
                "/js/**",
                "/css/**",
                "/img/**").permitAll()
                .antMatchers("/admin/**",
                        "/api/getAllUsers/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable().cors()
                .and()
                .formLogin()
                .loginPage("/loginsignup") //HERE I WILL ADD MY LOGIN PAGE
                .defaultSuccessUrl("/")
                .failureUrl("/loginsignup?error")
                .permitAll()
                .and()
                .rememberMe()
                .tokenValiditySeconds(2592000)
                .key("QaHry98A5iWM3iH")
                .rememberMeParameter("checkRememberMe")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/loginsignup?logout")
                .permitAll();

    }

}
