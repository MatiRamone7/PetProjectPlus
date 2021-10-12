package com.utn.loginSecurity.service;

import java.util.ArrayList;
import java.util.List;

import com.utn.models.users.Authority;
import com.utn.models.users.Sesion;
import com.utn.loginSecurity.repository.SesionRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesionDetailsServiceImpl implements UserDetailsService {

    @Autowired
    //ISesionRepositoryAlt sesionRepository;
    SesionRepository sesionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("inicio de sesion details");

        com.utn.models.users.Sesion appSesion = sesionRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

        System.out.println("USERNAME " + appSesion.getUsername());
        System.out.println("PASS " + appSesion.getPassword());

        //Mapear nuestra lista de Authority con la de spring security
        List grantList = new ArrayList();
        for (Authority authority: appSesion.getAuthority()) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            System.out.println("AUTHORITY " + authority.getAuthority());
            grantList.add(grantedAuthority);
        }
        System.out.println("DESPUES DEL FOR");

        //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
       UserDetails sesion = (UserDetails) new User(appSesion.getUsername(), appSesion.getPassword(), grantList);

        System.out.println("USERDETAILS NAME " + sesion.getUsername());
        System.out.println("USERDETAILS PASS " + sesion.getPassword());
        return sesion;

       // List<SimpleGrantedAuthority> auths = appSesion.getAuthority().stream().map(rol -> new SimpleGrantedAuthority(rol)).collect(Collectors.toList());
       // return (UserDetails) new User(appSesion.getUsername(), appSesion.getPassword(), grantList);
    }
}