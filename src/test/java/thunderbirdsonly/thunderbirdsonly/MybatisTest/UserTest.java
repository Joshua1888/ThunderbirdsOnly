package thunderbirdsonly.thunderbirdsonly.MybatisTest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import thunderbirdsonly.thunderbirdsonly.mapper.UserMapper;
import thunderbirdsonly.thunderbirdsonly.model.User;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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


    @Test
    public void loginTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "Tom");
        String jwt= Jwts.builder().
                signWith(SignatureAlgorithm.HS256, "Thunderbirdsonly198964tiaanmenUBCTESTTESThfggdfgdfg" +
                        "fsadfadsfsadfdsafrewrwerew" +
                        "fsadfadsfasdfasdrewrew" +
                        "fasdfadsfadsfasdtreewthkfgdmhkgfh345430593409gfdsf" +
                        "sdafasdfadsfasdFSDIFU")
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }
}
