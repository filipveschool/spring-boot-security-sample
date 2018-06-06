package com.filip.springbootsecuritysample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected SecurityConfig() {
        super();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password(bCryptPasswordEncoder().encode("user")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(bCryptPasswordEncoder().encode("admin")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("client").password(bCryptPasswordEncoder().encode("client")).roles("CLIENT");
    }
//
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        return super.userDetailsServiceBean();
//    }
//
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return super.userDetailsService();
//    }
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
// https://docs.spring.io/spring-security/site/docs/current/guides/html5/form-javaconfig.html#setting-up-the-sample
        // http://www.baeldung.com/spring-security-login
        http
                .authorizeRequests()
                .antMatchers("/login*").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .logoutSuccessUrl("/login");


    }


}
