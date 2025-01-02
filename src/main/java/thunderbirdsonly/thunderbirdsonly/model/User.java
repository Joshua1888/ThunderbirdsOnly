package thunderbirdsonly.thunderbirdsonly.model;

import java.util.Date;

public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Integer role;
    private Date createTime;
    private Date updateTime;


    public User() {
    }

    // Parameterized constructor for initialization
    public User(Long id, String username, String email, String password, Integer role, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Integer role) {
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getRole() {
        return role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }



}
