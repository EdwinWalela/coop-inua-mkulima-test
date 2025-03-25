package com.edwin.nexus_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotBlank(message = "email address required")
    private String emailAddress;

    @NotBlank(message = "password is required")
    private String password;

    @Column(updatable = false)
    private Date createdAt;

    public User() {
    }

    public User(Integer id, String emailAddress, String password, Date createdAt) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist(){
        this.createdAt = new Date();
        // TODO: hash password
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}