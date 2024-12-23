package com.shoptemplate.service;

import com.shoptemplate.model.Cart;

import java.util.Optional;

public interface CartService {

    Optional<Cart> getCartById(Long id);

    void createCart(Cart cart);

    void updateCart(Cart cart);

    void deleteCart(Cart cart);
}
