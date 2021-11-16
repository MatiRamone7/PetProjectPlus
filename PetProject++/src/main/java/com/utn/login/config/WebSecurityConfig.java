package com.utn.login.config;

import com.utn.login.service.SesionDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    //Necesario para evitar que la seguridad se aplique a los resources como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //quienes estan autorizados y de que manera
                .antMatchers(resources).permitAll()
                .antMatchers("/Sign-Up*").permitAll() //anotar como en el formulario

                .antMatchers("/Adopcion-de-Mascotas*").access("hasRole('USER')")
                .antMatchers("/Registrar-Mascota*").access("hasRole('USER')")
                .antMatchers("/Dar-en-Adopcion*").access("hasRole('USER')")
                .antMatchers("/Formulario-Quiero-Adoptar*").access("hasRole('USER')")
                .antMatchers("/Perfil*").access("hasRole('USER') ")

                .antMatchers("/Inicio*").access("hasRole('USER') or hasRole('ADMIN')")

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/Inicio")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);

        return bCryptPasswordEncoder;
    }

    @Autowired
    SesionDetailsServiceImpl userDetailsService;

    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}*/

public class WebSecurityConfig{

}

