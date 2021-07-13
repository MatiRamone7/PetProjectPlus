package com.utn.repositories;

public interface IBaseRepo<T>{

    T create(T t);

    void delete(T t);

    T find(T t);

    T update(T t);

    Iterable<T> findAll();
}
