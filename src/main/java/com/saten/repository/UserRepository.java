package com.saten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saten.bean.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(@Param("email") String email);

}
