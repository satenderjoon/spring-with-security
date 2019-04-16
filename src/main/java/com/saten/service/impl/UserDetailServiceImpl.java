
package com.saten.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saten.bean.User;
import com.saten.service.UserService;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserService userService;

    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        user.getAuthorities();
        return user;
    }
}
