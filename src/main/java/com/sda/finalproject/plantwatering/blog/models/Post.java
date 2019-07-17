package com.sda.finalproject.plantwatering.blog.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog_posts")
public class Post {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String body;
    private Date date = new Date();

    public Post() {
    }

    public Post(User author, Long id, String title, String body) {
        this.author = author;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author=" + author +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }
}
