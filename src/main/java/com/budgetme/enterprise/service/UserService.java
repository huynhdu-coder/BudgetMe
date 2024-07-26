package com.budgetme.enterprise.service;
import com.budgetme.enterprise.dao.User;
import com.budgetme.enterprise.repository.UserRepoCustom;
import com.budgetme.enterprise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepoCustom userRepositoryCustom;

    public void createUser(String username, String password) {
        userRepositoryCustom.insertUser(username, password);
    }
}
