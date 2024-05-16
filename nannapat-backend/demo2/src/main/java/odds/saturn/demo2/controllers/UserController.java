package odds.saturn.demo2.controllers;
import odds.saturn.demo2.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import odds.saturn.demo2.services.UserService;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("")
    public Users createUser(@RequestBody Users newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Integer id, @RequestBody Users updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

}
