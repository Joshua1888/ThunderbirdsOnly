package thunderbirdsonly.thunderbirdsonly.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thunderbirdsonly.thunderbirdsonly.mapper.UserMapper;
import thunderbirdsonly.thunderbirdsonly.DOT.User;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public User login (User user) {
        User storedUser = userMapper.getUserByUsername(user.getUsername());
        if (storedUser == null) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(user.getPassword(), storedUser.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        return storedUser; // Verified Password
    }


    public void register(User register) {
        int count = userMapper.countByUsernameOrEmail(register);
        if (count > 0) {
            throw new IllegalArgumentException("Username or email already exists");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        register.setPassword(encoder.encode(register.getPassword()));
        userMapper.insertUser(register);
    }


    public boolean changePassword(Long userId, String oldPassword, String newPassword) {
        // Get User
        User user = userMapper.selectUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Verified Old Password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(oldPassword, user.getPassword())) {
            return false; // Incorrect Old Password
        }

        // Encode new password then update the database
        String hashedNewPassword = encoder.encode(newPassword);
        user.setPassword(hashedNewPassword);
        userMapper.updatePassword(user);
        return true;
    }

}
