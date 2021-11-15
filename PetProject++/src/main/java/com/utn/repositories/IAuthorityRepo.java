package com.utn.repositories;

import com.utn.models.users.Authority;

public interface IAuthorityRepo {
    public Iterable<Authority> GetAuthority();

    public Authority GetAuthorityById(Integer id);
}
