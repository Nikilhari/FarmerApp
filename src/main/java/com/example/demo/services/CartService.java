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
        Cart existingCartItem = cartRepo.findByEmailAndVegetableName(cart.getEmail(), cart.getVegetableName());

        if (existingCartItem != null) {
            // If the item already exists, update the quantity
            existingCartItem.setQuantity(cart.getQuantity());
            existingCartItem.setPrice(cart.getPrice()); // Update price if needed
            return cartRepo.save(existingCartItem);
        } else {
            // If item is new, save as is
            return cartRepo.save(cart);
        }
    }

    public void removeCartItem(Long cartId) {
        cartRepo.deleteById(cartId);
    }
}
