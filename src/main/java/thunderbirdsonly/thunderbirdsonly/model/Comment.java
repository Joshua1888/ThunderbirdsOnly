package thunderbirdsonly.thunderbirdsonly.model;
import java.util.Date;

public class Comment {
    private Long id;
    private Long postId;
    private Long userId;
    private Long parentId; // Can be null for top-level comments
    private String content;
    private Date createTime;
    private Date updateTime;

    public Comment() {
    }

    // Parameterized Constructor
    public Comment(Long id, Long postId, Long userId, Long parentId, String content, Date createTime, Date updateTime) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.parentId = parentId;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getParentId() {
        return parentId;
    }

    public String getContent() {
        return content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}
