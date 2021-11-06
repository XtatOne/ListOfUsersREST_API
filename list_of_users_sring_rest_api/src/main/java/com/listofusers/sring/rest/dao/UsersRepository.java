package com.listofusers.sring.rest.dao;

import com.listofusers.sring.rest.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
