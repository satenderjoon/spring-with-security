package com.saten.service;

import java.util.List;
import java.util.Optional;

import com.saten.bean.User;


public interface UserService {

    public void createUser(User user);

    public List<User> getUser();

    public Optional<User> findById(long id);

    public User findByUsername(String email);

    // public User update(User user, long l);
    // public void deleteUserById(long id);
    // public User updatePartially(User user, long id);
}
