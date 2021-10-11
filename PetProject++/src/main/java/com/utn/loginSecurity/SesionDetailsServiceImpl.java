package com.utn.loginSecurity;

import java.util.ArrayList;
import java.util.List;

import com.utn.models.users.Authority;
import com.utn.models.users.Sesion;
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
    ISesionRepositoryAlt sesionRepository;
    //SesionRepository sesionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("123456789");
        Sesion appSesion = sesionRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
        System.out.println("USERNAME" + appSesion.getUsername());
        System.out.println("PASS" + appSesion.getPassword());

        //Mapear nuestra lista de Authority con la de spring security
        List grantList = new ArrayList();
        for (Authority authority: appSesion.getAuthority()) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
        }

        //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        UserDetails sesion = (UserDetails) new User(appSesion.getUsername(), appSesion.getPassword(), grantList);

        System.out.println("USERDETAILS NAME" + sesion.getUsername());
        System.out.println("USERDETAILS PASS" + sesion.getPassword());
        return sesion;
    }
}