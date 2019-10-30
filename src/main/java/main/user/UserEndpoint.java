package main.user;

import main.brand.Brand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserEndpoint {

    UserRepository userRepository;

    @PostMapping(path = "/login")
    public ResponseEntity<User> login(@Valid @RequestBody User user) {
        User response = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(response);
    }
}
