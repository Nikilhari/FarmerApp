package com.example.demo.services;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CartService {
@Autowired
    private CartRepo cartRepo;
    public List<Cart> getItemsByEmail(String email) {
        return cartRepo.findByEmail(email);
    }

    public Cart addOrUpdateCart(Cart cart) {
        return cartRepo.save(cart);
    }

    public void removeCartItem(Long cartId) {
        cartRepo.deleteById(cartId);
    }
}
