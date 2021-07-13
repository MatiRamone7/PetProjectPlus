package com.utn.repositories;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class BaseRepo<T> implements IBaseRepo<T>{

    protected EntityManager entityManager;
    private Class<T> type;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public BaseRepo() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    public T create(final T t) {

        entityManager.persist(t);
        return t;
    }


    public void delete(final Object objeto) {
        entityManager.remove(entityManager.merge(objeto));
    }

    public T find(final Object id) {
        return (T) entityManager.find(type, id);
    }

    public T update(final T t) {
        return entityManager.merge(t);
    }


    public Iterable<T> findAll() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}