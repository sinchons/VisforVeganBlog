package com.sda.finalproject.plantwatering.blog.models;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "blog_user")
public class User {
@Id
@GeneratedValue
    private long id;
    private String username;
    private String nameSurname;
    private String email;
    private Blob img;
    private String password;

    @OneToMany (mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(long id, String username, String nameSurname, String email) {
        this.id = id;
        this.username = username;
        this.nameSurname = nameSurname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nameSurname='" + nameSurname + '\'' +
                ", email='" + email + '\'' +
                ", img=" + img +
                ", password='" + password + '\'' +
                '}';
    }
}
