package com.erp.Coffee.model;

import javax.persistence.*;

@Entity
@Table(name = "order_has_menuitem")
public class OrderComposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menuitem_id", referencedColumnName = "id")
    private MenuItem menuItem;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Column(name = "menuitem_amount")
    private int menuItemAmount;

    public OrderComposition() {}

    public OrderComposition(MenuItem menuItem,  int menuItemAmount, Order order) {
        this.menuItem = menuItem;
        this.order = order;
        this.menuItemAmount = menuItemAmount;
    }

    public OrderComposition(MenuItem menuItem, int menuItemAmount) {
        this.menuItem = menuItem;
        this.menuItemAmount = menuItemAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMenuItemAmount() {
        return menuItemAmount;
    }

    public void setMenuItemAmount(int menuItemAmount) {
        this.menuItemAmount = menuItemAmount;
    }
}
