package thunderbirdsonly.thunderbirdsonly.DOT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Integer role;
    private Date createTime;
    private Date updateTime;

}
