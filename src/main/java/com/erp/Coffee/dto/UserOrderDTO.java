package com.erp.Coffee.dto;

import com.erp.Coffee.model.MenuItem;

import java.util.Map;
import java.util.Objects;

public class UserOrderDTO {

    private String username;

    private Map<Long, Integer> cart;

    public UserOrderDTO() {}

    public UserOrderDTO(String username, Map<Long, Integer> cart) {
        this.username = username;
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "UserOrderDTO{" +
                "username='" + username + '\'' +
                ", cart=" + cart.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserOrderDTO that = (UserOrderDTO) o;

        return Objects.equals(username, that.username) && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, cart);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Long, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Long, Integer> cart) {
        this.cart = cart;
    }
}
