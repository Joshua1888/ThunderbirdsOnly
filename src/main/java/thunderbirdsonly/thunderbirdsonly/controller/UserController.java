package thunderbirdsonly.thunderbirdsonly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import thunderbirdsonly.thunderbirdsonly.DOT.ChangePasswordRequest;
import thunderbirdsonly.thunderbirdsonly.Utility.JwtUtils;
import thunderbirdsonly.thunderbirdsonly.pojo.Result;
import thunderbirdsonly.thunderbirdsonly.DOT.User;
import thunderbirdsonly.thunderbirdsonly.service.UserService;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    public Result login(@RequestBody User user) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            return Result.error("Username cannot be empty");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return Result.error("Password cannot be empty");
        }
        try {
            User u = userService.login(user);
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("userName", u.getUsername());

            String jwt = JwtUtils.generateToken(claims);
            return Result.success(jwt);
        } catch (Exception e) {
            return Result.error("Invalid username or password");
        }

//        return Result.error("Invalid username or password");
    }

    @PostMapping("/api/register")
    public Result register(@RequestBody User user) {
        // 检查字段是否为空
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            return Result.error("Username cannot be empty");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return Result.error("Email cannot be empty");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return Result.error("Password cannot be empty");
        }

        try {
            userService.register(user);
            return Result.success("Registration successful");
        } catch (IllegalArgumentException e) {
            return Result.error(e.getMessage());
        } catch (Exception e) {
            return Result.error("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/api/logout")
    public Result logout() {
        return Result.success("byebye");
    }

    @PostMapping("/api/changePassword")
    public Result changePassword(@RequestBody ChangePasswordRequest request) {
        if (request.getNewPassword() == null || request.getNewPassword().trim().isEmpty()) {
            return Result.error("New password cannot be empty");
        }
        if (request.getOldPassword() == null || request.getOldPassword().trim().isEmpty()) {
            return Result.error("Old password cannot be empty");
        }

        try {
            boolean isChanged = userService.changePassword(request.getUserId(), request.getOldPassword(), request.getNewPassword());
            if (isChanged) {
                return Result.success("Password changed successfully");
            } else {
                return Result.error("Old password is incorrect");
            }
        } catch (Exception e) {
            return Result.error("Error changing password: " + e.getMessage());
        }
    }

}
