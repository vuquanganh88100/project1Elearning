package com.example.doan1.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.Objects;

@Data
@Entity
@Table(name = "users",schema = "doan1",catalog = "")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="password")
    private String password;
    @Column(name="user_type")
    private String userType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity that)) return false;
        return getUserId() == that.getUserId() && getUserName().equals(that.getUserName()) && getUserEmail().equals(that.getUserEmail()) && getPassword().equals(that.getPassword()) && getUserType().equals(that.getUserType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserName(), getUserEmail(), getPassword(), getUserType());
    }
}
