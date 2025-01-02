package thunderbirdsonly.thunderbirdsonly.model;
import java.util.Date;

public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private Date createTime;
    private Date updateTime;


    // Default Constructor
    public Post() {
    }

    // Parameterized Constructor
    public Post(Long id, Long userId, String title, String content, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
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
