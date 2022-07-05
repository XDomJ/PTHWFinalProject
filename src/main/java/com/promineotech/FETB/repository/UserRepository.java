package com.promineotech.FETB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineotech.FETB.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
