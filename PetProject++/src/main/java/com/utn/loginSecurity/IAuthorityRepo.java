package com.utn.loginSecurity;

import com.utn.models.users.Authority;

public interface IAuthorityRepo {
    public Authority GetAuthorityById(Integer id); 
}
