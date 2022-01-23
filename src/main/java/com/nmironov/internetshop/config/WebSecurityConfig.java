package com.nmironov.internetshop.config;



import com.nmironov.internetshop.service.admin.SpringUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@Configuration

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    SpringUserDetailsService springUserDetailsService;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        /* turn off restrictions */
   // httpSecurity.csrf().disable().authorizeRequests().antMatchers("/admin/**").permitAll();
   // httpSecurity.csrf().disable().authorizeRequests().antMatchers("/customer/**").permitAll();


    //Basic Security Restrictions

        httpSecurity
            .authorizeRequests()
            //Доступ только для пользователей с ролью Администратор
            .antMatchers("/admin/**").hasRole("ADMIN")

            //Доступ разрешен всем пользователям
            .antMatchers("/resources/**").permitAll()

                .antMatchers("/customer/**").permitAll()
            //Все остальные страницы требуют аутентификации
            .and()
            //Настройка для входа в систему
            .formLogin()
            .loginPage("/login").permitAll()
            //Перенапhавление на главную страницу после успешного входа
            .defaultSuccessUrl("/admin/goods/")
            .permitAll()// possibly make authenticated or clear session correctly
            .and()
            .logout()
            .logoutSuccessUrl("/login")
            .invalidateHttpSession(true);


    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(springUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }


}






