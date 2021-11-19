package com.utn.login.config;

import com.utn.login.service.SesionDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
                .antMatcher("/api/**")
                .authorizeRequests() //quienes estan autorizados y de que manera
                .antMatchers(resources).permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/Sign-Up*").permitAll()
                .antMatchers("/Mascota-Perdida*").permitAll() //TODO probar en localhost como se ve esquina superior, logeado vs no
                .antMatchers("/Hogares-Transito*").permitAll()
                .antMatchers("/Formulario-Usuario*").permitAll()
                .antMatchers("/Inicio*").permitAll()
                .antMatchers("/Mascotas-Encontradas*").permitAll()
                .antMatchers("/Adopcion-de-Mascotas*").permitAll()
                .antMatchers("/users*").permitAll()
                .antMatchers("/pets*").permitAll()
                .antMatchers("/ongs*").permitAll()
                .antMatchers("/forms*").permitAll()
                .antMatchers("/caracteristicas*").permitAll()
                .antMatchers("/forms*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/users*").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/users*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users*").permitAll()

                .antMatchers("/Editor-de-Formularios*").access("hasRole('ADMIN')")
                .antMatchers("/Admin-Perfiles-ONG*").access("hasRole('ADMIN')")
                .antMatchers("/Admin-Preguntas-ONG*").access("hasRole('ADMIN')")

                .antMatchers("/Registrar-Mascota*").access("hasRole('USER')")
                .antMatchers("/Dar-en-Adopcion*").access("hasRole('USER')")
                .antMatchers("/Formulario-Quiero-Adoptar*").access("hasRole('USER')")
                .antMatchers("/Perfil*").access("hasRole('USER') ")

                .antMatchers("/Preguntas-Mascotas*").access("hasRole('USER') or hasRole('ADMIN')")

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
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
/*
public class WebSecurityConfig{

}*/

