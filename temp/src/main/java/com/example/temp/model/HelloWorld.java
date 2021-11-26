package com.example.temp.model;

import javax.persistence.*;

@Entity
@Table(name = "HelloWorld")
public class HelloWorld {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String text;

    public HelloWorld(){}

    public HelloWorld(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
