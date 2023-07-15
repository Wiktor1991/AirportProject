package com.example.flightbookerapp.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/add")
    public void addNewUser(@RequestBody User user){
        userService.addNew(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable("email")String email){
        return ResponseEntity
                .status(200)
                        .body(userService.findByEmail(email));
    }
    @GetMapping("find/{id}")
            public ResponseEntity findById(@PathVariable("id") Integer id){
        return ResponseEntity.status(200)
                .body(userService.findById(id));
    }
}
