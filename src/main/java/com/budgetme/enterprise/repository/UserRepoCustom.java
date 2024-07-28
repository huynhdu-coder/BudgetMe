package com.budgetme.enterprise.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertUser(String username, String password) {
        entityManager.createNativeQuery("INSERT INTO user (username, password) VALUES (?, ?)")
                .setParameter(1, username)
                .setParameter(2, password)
                .executeUpdate();
        }
    }
