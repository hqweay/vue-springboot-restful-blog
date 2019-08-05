package cn.hqweay.blog.entity;

import java.io.Serializable;

public class UserRoleKey implements Serializable {
    private String userEmail;

    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}