package thunderbirdsonly.thunderbirdsonly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thunderbirdsonly.thunderbirdsonly.mapper.UserMapper;
import thunderbirdsonly.thunderbirdsonly.model.User;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public User login (User user) {
        User u = userMapper.getbyUsernameandPass(user);
        return u;
    }


}
