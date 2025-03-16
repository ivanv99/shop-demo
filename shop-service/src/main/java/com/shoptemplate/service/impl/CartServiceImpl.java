package com.shoptemplate.service.impl;

import com.shoptemplate.model.Cart;
import com.shoptemplate.repositories.CartRepository;
import com.shoptemplate.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void createCart(Cart cart) {
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }
}
