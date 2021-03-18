package com.example.JavaAcademy.Model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true, length = 20)
    private String userName;

    @NotNull
    @Column(nullable = false, length = 20)
    private String password;

    @NotNull
    @Column( nullable = false, length = 20)
    private String name;

    @NotNull
    @Column (nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createTimeStamp;

    @NotNull
    @Column (nullable = false, updatable = true)
    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;


    public User() {

    }

    public User(Long id, String userName, String password, String name) {
        this.id = id;
        this.userName= userName;
        this.password = password;
        this.name = name;
    }

    public LocalDateTime getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(LocalDateTime createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public LocalDateTime getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(LocalDateTime updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
