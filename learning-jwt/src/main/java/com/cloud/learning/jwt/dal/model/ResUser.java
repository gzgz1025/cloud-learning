package com.cloud.learning.jwt.dal.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "res_user")
public class ResUser implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 业务ID
     */
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "open_id")
    private Long openId;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "is_valid")
    private Boolean valid;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取业务ID
     *
     * @return user_id - 业务ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置业务ID
     *
     * @param userId 业务ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return open_id
     */
    public Long getOpenId() {
        return openId;
    }

    /**
     * @param openId
     */
    public void setOpenId(Long openId) {
        this.openId = openId;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return is_valid
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", openId=").append(openId);
        sb.append(", mobile=").append(mobile);
        sb.append(", password=").append(password);
        sb.append(", username=").append(username);
        sb.append(", valid=").append(valid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}