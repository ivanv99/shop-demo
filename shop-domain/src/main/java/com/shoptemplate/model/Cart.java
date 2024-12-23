package com.shoptemplate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart", schema = "shop")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    // Add an item to the cart, handling quantity
    public void addItem(Item item, int quantity) {
        CartItem cartItem = findCartItem(item);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);  // Update quantity
        } else {
            cartItem = new CartItem();
            cartItem.setItem(item);
            cartItem.setQuantity(quantity);
            cartItem.setCart(this);
            this.cartItems.add(cartItem);  // Add new item
        }
    }

    // Remove an item from the cart
    public void removeItem(Item item) {
        CartItem cartItem = findCartItem(item);
        if (cartItem != null) {
            this.cartItems.remove(cartItem);
        }
    }

    // Find CartItem by Item
    private CartItem findCartItem(Item item) {
        for (CartItem cartItem : this.cartItems) {
            if (cartItem.getItem().equals(item)) {
                return cartItem;
            }
        }
        return null;
    }

    // Calculate total price for all items in the cart
    public double calculateTotal() {
        double total = 0;
        for (CartItem cartItem : this.cartItems) {
            total += cartItem.getTotalPrice();
        }
        return total;
    }

    // Clear all items from the cart
    public void clearCart() {
        this.cartItems.clear();
    }
}
