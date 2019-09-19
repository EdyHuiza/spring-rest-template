package com.rootnite.template.springrest.model.repository.security;

import com.rootnite.template.springrest.model.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
