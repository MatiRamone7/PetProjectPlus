package com.utn.loginSecurity;

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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    //Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //quienes estan autorizados y de que manera
                .antMatchers(resources).permitAll()
                .antMatchers("/","/index").permitAll()
                .antMatchers("/Inicio*").permitAll()
                .antMatchers("/Mascota-Perdida*").permitAll()
                .antMatchers("/Formulario-Usuario*").permitAll()

                .antMatchers("/Hogares-Transito*").access("hasRole('ADMIN')")
                .antMatchers("/Editor-de-Formularios*").access("hasRole('ADMIN')")
                .antMatchers("/Admin-Perfiles-ONG*").access("hasRole('ADMIN')")
                .antMatchers("/Admin-Preguntas-ONG*").access("hasRole('ADMIN')")
                .antMatchers("/Mascotas-Encontradas*").access("hasRole('ADMIN') or hasRole('VOLUNTARIO')")

                .antMatchers("/Adopcion-de-Mascotas*").access("hasRole('USER')")
                .antMatchers("/Registrar-Mascota*").access("hasRole('USER')")
                .antMatchers("/Dar-en-Adopcion*").access("hasRole('USER')")
                .antMatchers("/Formulario-Quiero-Adoptar*").access("hasRole('USER')")
                .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN') or hasRole('VOLUNTARIO')")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/menu")
                    .failureUrl("/login?error=true")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/");
    }
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //El numero 4 representa que tan fuerte quieres la encriptacion.

        return bCryptPasswordEncoder;
    }

    @Autowired
    SesionDetailsServiceImpl userDetailsService;

    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
