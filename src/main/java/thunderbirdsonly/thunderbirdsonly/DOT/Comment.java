package thunderbirdsonly.thunderbirdsonly.DOT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private Long postId;
    private Long userId;
    private Long parentId; // Can be null for top-level comments
    private String content;
    private Date createTime;
    private Date updateTime;

}
