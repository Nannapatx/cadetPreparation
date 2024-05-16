package odds.saturn.demo2.services;

import odds.saturn.demo2.models.Users;
import odds.saturn.demo2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Users getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users createUser (Users newUser) {
        return userRepository.saveAndFlush(newUser);
    }
    public Users updateUser (Integer id, Users updatedUser) {
        Users user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        return userRepository.saveAndFlush(user);
    }
    public Users deleteUser (Integer id) {
        Users user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        userRepository.deleteById(id);
        return user;
    }
}
