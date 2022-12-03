package com.erp.Coffee.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "menu_item")
public class MenuItem implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "menuitem_has_category",
            joinColumns = @JoinColumn(name = "menuitem_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<MenuCategory> categories = new ArrayList<>();

    @OneToMany(mappedBy = "menuItem")
    private List<OrderComposition> orderCompositions = new ArrayList<>();

    public MenuItem() {}

    public MenuItem(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public MenuItem(Long id, String name, String description, BigDecimal price) {
        this(name, description, price);
        this.id = id;
    }

    public MenuItem(Long id, String name, String description, BigDecimal price, List<MenuCategory> categories) {
        this(id, name, description, price);
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        return Objects.equals(id, menuItem.id)
                && Objects.equals(name, menuItem.name)
                && Objects.equals(description, menuItem.description)
                && Objects.equals(price, menuItem.price)
                && Objects.equals(categories, menuItem.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, categories);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<MenuCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<MenuCategory> category) {
        this.categories = category;
    }
}
