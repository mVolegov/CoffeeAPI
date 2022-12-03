package com.erp.Coffee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "menu_category")
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuCategory() {}

    public MenuCategory(String title) {
        this.title = title;
    }

    public MenuCategory(Long id, String title) {
        this(title);
        this.id = id;
    }

    public MenuCategory(Long id, String title, List<MenuItem> menuItems) {
        this(id, title);
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "MenuCategory{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuCategory that = (MenuCategory) o;

        return Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
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

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
