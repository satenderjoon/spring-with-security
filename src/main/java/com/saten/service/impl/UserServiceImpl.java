package com.saten.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saten.bean.User;
import com.saten.repository.UserRepository;
import com.saten.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    /*
     * public User update(User user, long l) { // TODO Auto-generated method stub
     * return userRepository.save(user); }
     * 
     * public void deleteUserById(long id) { // TODO Auto-generated method stub
     * userRepository.delete(id); }
     * 
     * public User updatePartially(User user, long id) { // TODO Auto-generated
     * method stub User usr = findById(id); usr.setCountry(user.getCountry());
     * return userRepository.save(usr); }
     */

}
