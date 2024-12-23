package com.shoptemplate.controller.rest;

import com.shoptemplate.model.Cart;
import com.shoptemplate.model.CartItem;
import com.shoptemplate.model.Item;
import com.shoptemplate.service.CartService;
import com.shoptemplate.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final ItemService itemService;

    @Autowired
    public CartController(CartService cartService, ItemService itemService) {
        this.cartService = cartService;
        this.itemService = itemService;
    }

    // Add an item to the cart
    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestParam Long cartId, @RequestParam Long itemId, @RequestParam int quantity) {
        Cart cart = cartService.getCartById(cartId).orElseThrow();
        Item item = itemService.getItemById(itemId).orElseThrow();
        cart.addItem(item, quantity);
        cartService.updateCart(cart);  // Save updated cart
        return ResponseEntity.ok("Item added to cart.");
    }

    // Remove an item from the cart
    @PostMapping("/remove")
    public ResponseEntity<String> removeItemFromCart(@RequestParam Long cartId, @RequestParam Long itemId) {
        Cart cart = cartService.getCartById(cartId).orElseThrow();
        Item item = itemService.getItemById(itemId).orElseThrow();
        cart.removeItem(item);
        cartService.updateCart(cart);  // Save updated cart
        return ResponseEntity.ok("Item removed from cart.");
    }

    // View all items in the cart
    @GetMapping("/{cartId}")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long cartId) {
        Cart cart = cartService.getCartById(cartId).orElseThrow();
        return ResponseEntity.ok(cart.getCartItems());
    }

    // Calculate total price for the cart
    @GetMapping("/{cartId}/total")
    public ResponseEntity<Double> calculateTotal(@PathVariable Long cartId) {
        Cart cart = cartService.getCartById(cartId).orElseThrow();
        double total = cart.calculateTotal();
        return ResponseEntity.ok(total);
    }

    // Clear the cart
    @PostMapping("/{cartId}/clear")
    public ResponseEntity<String> clearCart(@PathVariable Long cartId) {
        Cart cart = cartService.getCartById(cartId).orElseThrow();
        cart.clearCart();
        cartService.updateCart(cart);  // Save updated cart
        return ResponseEntity.ok("Cart cleared.");
    }
}

