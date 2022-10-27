package ru.job4j.accident.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource ds;

    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String pwd = passwordEncoder.encode("1");
        System.out.println(pwd);
        auth.jdbcAuthentication().dataSource(ds)
                .usersByUsernameQuery("select username, password, enabled "
                        + "from users "
                        + "where username = ?")
                .authoritiesByUsernameQuery(
                        " select u.username, a.authority "
                                + "from authorities as a, users as u "
                                + "where u.username = ? and u.authority_id = a.id");
    }

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(ds);
        /*
                .withUser(User.withUsername("user")
                        .password(passwordEncoder.encode("123456"))
                        .roles("USER"));

    }


    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("user").password(passwordEncoder.encode("123456"))
                .roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("123456"))
                .roles("USER", "ADMIN");
    }
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/reg")
                .permitAll()
                .antMatchers("/**")
                .hasAnyRole("ROLE_ADMIN", "ROLE_USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf()
                .disable();
    }

}
