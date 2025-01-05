package thunderbirdsonly.thunderbirdsonly.DOT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {
    private Long userId;          // 用户ID
    private String oldPassword;   // 旧密码
    private String newPassword;   // 新密码

}