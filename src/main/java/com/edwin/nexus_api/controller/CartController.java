package com.edwin.nexus_api.controller;

import com.edwin.nexus_api.DTO.CartItemDTO;
import com.edwin.nexus_api.DTO.NewCartItemDTO;
import com.edwin.nexus_api.DTO.UserCartDTO;
import com.edwin.nexus_api.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public UserCartDTO getUserCartItems(@PathVariable Integer userId){
        return this.cartService.getUserCartItems(userId);
    }

    @PostMapping("")
    public List<CartItemDTO> addToUserCart(@RequestBody NewCartItemDTO newCartItem){
        return this.cartService.addToUserCart(
               newCartItem
        );
    }
}
