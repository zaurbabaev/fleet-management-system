package com.kindsonthegenius.fleetms.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/resources/**", "/css/**", "/fonts/**", "/img/**").permitAll()
                .antMatchers("/register", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
                .antMatchers("/usersAddNew", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
                .antMatchers("/register/verify", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
                .antMatchers("/security/user/Edit/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/index")
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/login", "/resources/**", "/css/**", "/fonts/**", "/img/**").permitAll()
//                                .requestMatchers("/register", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
//                                .requestMatchers("/usersAddNew", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
//                                .requestMatchers("/register/verify", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
//                                .requestMatchers("/security/user/Edit/**").hasAuthority("ADMIN")
//                                .anyRequest().authenticated()
//                )
//                .formLogin(formLogin ->
//                        formLogin.loginPage("/login").permitAll()
//                                .defaultSuccessUrl("/index")
//                )
//                .logout(logout ->
//                        logout.invalidateHttpSession(true)
//                                .clearAuthentication(true)
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .logoutSuccessUrl("/login").permitAll()
//                ).exceptionHandling(exception -> exception.accessDeniedPage("/accessDenied"));
//
//        return http.build();
//
//    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }
}
