package com.erp.Coffee.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_order")  // Потому что "order" зарезервированное слово
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "status")
    private String status;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "order")
    private List<OrderComposition> menuItemsInOrder = new ArrayList<>();

    public Order() {}

    public Order(User user, String status, Date createdDate) {
        this.user = user;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Order(Long id, User user, String status, Date createdDate) {
        this(user, status, createdDate);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                ", orderCompositions=" + menuItemsInOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Objects.equals(id, order.id)
                && Objects.equals(user, order.user)
                && Objects.equals(status, order.status)
                && Objects.equals(createdDate, order.createdDate)
                && Objects.equals(menuItemsInOrder, order.menuItemsInOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, status, createdDate, menuItemsInOrder);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<OrderComposition> getMenuItemsInOrder() {
        return menuItemsInOrder;
    }

    public void setMenuItemsInOrder(List<OrderComposition> menuItemsInOrder) {
        this.menuItemsInOrder = menuItemsInOrder;
    }
}
