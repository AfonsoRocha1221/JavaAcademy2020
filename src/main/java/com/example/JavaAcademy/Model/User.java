package com.example.JavaAcademy.Model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type User.
 */
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


    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param userName the user name
     * @param password the password
     * @param name     the name
     */
    public User(Long id, String userName, String password, String name) {
        this.id = id;
        this.userName= userName;
        this.password = password;
        this.name = name;
    }

    /**
     * Gets create time stamp.
     *
     * @return the create time stamp
     */
    public LocalDateTime getCreateTimeStamp() {
        return createTimeStamp;
    }

    /**
     * Sets create time stamp.
     *
     * @param createTimeStamp the create time stamp
     */
    public void setCreateTimeStamp(LocalDateTime createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    /**
     * Gets update time stamp.
     *
     * @return the update time stamp
     */
    public LocalDateTime getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    /**
     * Sets update time stamp.
     *
     * @param updateTimeStamp the update time stamp
     */
    public void setUpdateTimeStamp(LocalDateTime updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


}
