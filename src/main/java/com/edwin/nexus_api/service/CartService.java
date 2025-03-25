package com.edwin.nexus_api.service;

import com.edwin.nexus_api.model.Cart;
import com.edwin.nexus_api.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getUserCartItems(){

    }

    public List<Cart> addToUserCart(){

    }

    public List<Cart> deleteFromUserCart(){

    }

}
