package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{email}")
    public ResponseEntity<List<Cart>> getCartItemsByEmail(@PathVariable String email)
    {
        List<Cart> cartItems = cartService.getItemsByEmail(email);
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addItems(@RequestBody Cart cart)
    {
        Cart savedItems = cartService.addOrUpdateCart(cart);
        return ResponseEntity.ok(savedItems);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id)
    {
        cartService.removeCartItem(id);
        return ResponseEntity.ok("Item removed successfully");
    }
}
