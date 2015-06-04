package com.application.business.service;

import com.application.business.domain.Entidade;
import com.application.business.jpa.EntityManagerFactoryWrapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbstractService<T extends Entidade> {

    protected EntityManager em;

    protected AbstractService() {

        super();
        em = EntityManagerFactoryWrapper.getEntityManager();
    }

    public void salvar(T entity) {

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            if (entity.getId() == null) {
                em.persist(entity);
            } else {
                em.merge(entity);
            }

            transaction.commit();

        } catch (Exception e) {
            try {
                transaction.rollback();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void deletar(Class<T> entityClass, Long entityId) {

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.remove(em.find(entityClass, entityId));
            transaction.commit();
        } catch (Exception e) {
            try {
                transaction.rollback();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
