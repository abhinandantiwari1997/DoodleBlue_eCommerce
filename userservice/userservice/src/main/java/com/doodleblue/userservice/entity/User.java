package com.doodleblue.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.Size;


@Entity
@Table(name = "UserTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Size(min = 5, max = 20, message = "User name should be minimum 5 character long")
    private String userName;
    private String email;
    @Size(min = 8, message = "Password should be of minimum 8 character long")
    private String userPassword;

    private String gender;

    private int age;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */

    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */

    public long getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }





    /**
     *
     * @return
     */
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public User(String userName, String email, String userPassword, String gender, int age) {
        this.userName = userName;
        this.email = email;
        this.userPassword = userPassword;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }
}
