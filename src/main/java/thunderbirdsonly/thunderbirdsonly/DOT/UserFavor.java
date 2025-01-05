package thunderbirdsonly.thunderbirdsonly.DOT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFavor {
    private Long id;
    private Long userId;
    private Long postId;
    private Date createTime;
}
