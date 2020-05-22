package com.mapcurtain.exleplat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mapcurtain.exleplat.entities.User;

@Service
public interface UserRepository extends JpaRepository<User, String> {

}
