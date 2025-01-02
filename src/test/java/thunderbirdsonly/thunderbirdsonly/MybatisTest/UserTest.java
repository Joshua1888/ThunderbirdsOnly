package thunderbirdsonly.thunderbirdsonly.MybatisTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import thunderbirdsonly.thunderbirdsonly.mapper.UserMapper;
import thunderbirdsonly.thunderbirdsonly.model.User;
import java.util.Date;


@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void test() {
        User user = new User();
        user.setId(null);
        user.setEmail("fasdf@gamil.com");
        user.setUsername("fsadf3333");
        user.setPassword("fsadf3333");
        user.setRole(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertUser(user);
    }
}
