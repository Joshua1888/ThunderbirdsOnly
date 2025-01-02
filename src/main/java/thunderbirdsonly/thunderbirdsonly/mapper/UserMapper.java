package thunderbirdsonly.thunderbirdsonly.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import thunderbirdsonly.thunderbirdsonly.model.User;


@Mapper
public interface UserMapper {

    @Insert("INSERT INTO thunderbirds.user (username, email, password, role, create_time, update_time) " +
            "VALUES (#{username}, #{email}, #{password}, #{role}, NOW(), NOW())")
    public void insertUser(User user);

}
