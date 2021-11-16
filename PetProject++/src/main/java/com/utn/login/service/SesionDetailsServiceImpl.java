package com.utn.login.service;

import com.utn.login.repository.SesionRepository;
import com.utn.models.users.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SesionDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SesionRepository sesionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.utn.models.users.Sesion appSesion = sesionRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

        List grantList = new ArrayList();
        for (Authority authority: appSesion.getAuthority()) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
        }
        //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        UserDetails sesion = (UserDetails) new User(appSesion.getUsername(), appSesion.getPassword(), grantList);
        return sesion;
    }
}
