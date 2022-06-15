package com.api.web.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.web.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
