package com.example.flightbookerapp.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final IUserRepository iUserRepository;

    public void addNewUser(User user) {
        iUserRepository.save(user);
    }
    public User findByEmail(String email){
        return iUserRepository.findOneByEmail(email).orElse(null);

    }

    public Optional<User> findById(Integer id) {
         return iUserRepository.findById(id);
    }
}
