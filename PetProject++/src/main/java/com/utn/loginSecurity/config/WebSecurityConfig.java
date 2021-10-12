package com.utn.loginSecurity.config;

import com.utn.loginSecurity.service.SesionDetailsServiceImpl;
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
                .antMatchers("/","/index2").permitAll() //HTML
                .antMatchers("/Sign-Up*").permitAll() //anotar como en el formulario
                .antMatchers("/Mascota-Perdida*").permitAll() //TODO probar en localhost como se ve esquina superior, logeado vs no 
                .antMatchers("/Hogares-Transito*").permitAll()
                .antMatchers("/Formulario-Usuario*").permitAll()
                
                .antMatchers("/Editor-de-Formularios*").access("hasRole('ADMIN')")
                .antMatchers("/Admin-Perfiles-ONG*").access("hasRole('ADMIN')") //pantallaAdmin
                .antMatchers("/Admin-Preguntas-ONG*").access("hasRole('ADMIN')") //pantallaAdmin2
                
                .antMatchers("/Adopcion-de-Mascotas*").access("hasRole('USER')")
                .antMatchers("/Registrar-Mascota*").access("hasRole('USER')")
                .antMatchers("/Dar-en-Adopcion*").access("hasRole('USER')")
                .antMatchers("/Formulario-Quiero-Adoptar*").access("hasRole('USER')")

                //TODO fALTA pantalal de aprobar formularios como voluntario
                
                .antMatchers("/Inicio*").access("hasRole('USER') or hasRole('ADMIN')") //HTML
                .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')") //HTML
                .antMatchers("/Mascotas-Encontradas*").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/Perfil*").access("hasRole('USER') or hasRole('ADMIN')") 
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/menu")
                    .failureUrl("/Mascota-Perdida") //TODO cambiar
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login?logout=true");
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
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
