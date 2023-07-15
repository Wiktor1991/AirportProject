package com.example.flightbookerapp.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void addNew(User user){
        userRepository.addNewUser(user);

    }
    public User findByEmail(String email){
      return userRepository.findByEmail(email);
    }

    public User findById(Integer id) {
      return userRepository.findById(id).orElse(null);
    }
}
