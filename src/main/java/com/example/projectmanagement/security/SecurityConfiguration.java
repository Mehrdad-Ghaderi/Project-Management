package com.example.projectmanagement.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;


//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {/*//extends WebSecurityConfigurerAdapter {



        @Bean
        public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
            http.authorizeRequests((authorize) -> authorize
                            .anyRequest().authenticated()
                    )
                    .httpBasic(Customizer.withDefaults())
                    .formLogin(Customizer.withDefaults());

            return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
            UserDetails userDetails = User.withDefaultPasswordEncoder()
                    .username("user")
                    .password("password")
                    .roles("USER")
                    .build();

            return new InMemoryUserDetailsManager(userDetails);
        }



    *//*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password("pass1")
                .roles("USER")
                .and()
                .withUser("user2")
                .password("pass2")
                .roles("USER")
                .and().withUser("manager").password("admin").roles("ADMIN");


        auth.inMemoryAuthentication()
                .withUser("user1").password("test").roles("USER")
                .and()
                .withUser("user2").password("test2").roles("USER")
                .and().
                withUser("manager").password("admin").roles("ADMIN");
    }

@Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/projects/new").hasRole("ADMIN")
                .antMatchers("/").authenticated().and().formLogin();

    }*/
}
