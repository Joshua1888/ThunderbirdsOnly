package thunderbirdsonly.thunderbirdsonly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import thunderbirdsonly.thunderbirdsonly.mapper.UserMapper;
import thunderbirdsonly.thunderbirdsonly.model.Result;
import thunderbirdsonly.thunderbirdsonly.model.User;
import thunderbirdsonly.thunderbirdsonly.service.UserService;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User u = userService.login(user);
        if (u != null) {
            return Result.success(u);
        } else {
            return Result.error("Invalid username or password");
        }
    }

}
