package thunderbirdsonly.thunderbirdsonly.DOT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private Integer likesCount;
    private Integer favoritesCount;
    private Date createTime;
    private Date updateTime;

}
