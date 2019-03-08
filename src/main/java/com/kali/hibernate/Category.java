package com.kali.hibernate;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {

    private long id;
    private String name;

    private Set<Article> articles;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    public long getId() {
        return id;
    }

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CATEGORY_ARTICLE",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID")
    )*/

}
