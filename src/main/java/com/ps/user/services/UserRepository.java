package com.ps.user.services;

import com.ps.user.services.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
