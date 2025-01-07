package thunderbirdsonly.thunderbirdsonly.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import thunderbirdsonly.thunderbirdsonly.DOT.User;


@Mapper
public interface UserMapper {

    @Insert("INSERT INTO thunderbirds.user (username, email, password, role, create_time, update_time) " +
            "VALUES (#{username}, #{email}, #{password}, #{role}, NOW(), NOW())")
    public void insertUser(User user);

    @Select("SELECT * FROM thunderbirds.user WHERE username = #{username}")
    public User getUserByUsername(String username);


    @Select("SELECT * FROM thunderbirds.user WHERE id = #{id}")
    User selectUserById(Long id);


    // Search User Based on username and password
    @Select("SELECT * FROM thunderbirds.user WHERE username = #{username} and password = #{password}")
    User getbyUsernameAndPass(User user);

    @Select("SELECT COUNT(*) FROM thunderbirds.user WHERE username = #{username} OR email = #{email}")
    int countByUsernameOrEmail(User user);



    @Update("UPDATE thunderbirds.user SET password = #{password}, update_time = NOW() WHERE id = #{id}")
    void updatePassword(User user);

}
