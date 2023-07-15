package com.example.flightbookerapp.users;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {



    @Query(value="select * from Users where email= :email", nativeQuery = true)
    Optional<User> findOneByEmail(@Param("email")String email);

}
