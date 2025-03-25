package com.edwin.nexus_api.service;

import com.edwin.nexus_api.DTO.*;
import com.edwin.nexus_api.model.Cart;
import com.edwin.nexus_api.model.Product;
import com.edwin.nexus_api.model.User;
import com.edwin.nexus_api.repository.CartRepository;
import com.edwin.nexus_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    public UserCartDTO getUserCartItems(Integer userId){
        List<Cart> cartItems = this.cartRepository.findByUserId(userId);
        float itemTotal = (float) cartItems.stream().mapToDouble(cart -> cart.getProduct().getPrice() * cart.getQuantity()).sum();
        List <CartItemDTO> cartItemDTOs = cartItems.stream().map(cart -> {
            CartItemDTO cartItemDTO = new CartItemDTO();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setDescription(cart.getProduct().getDescription());
            productDTO.setName(cart.getProduct().getName());
            productDTO.setPrice(cart.getProduct().getPrice());
            productDTO.setId(cart.getProduct().getId());
            cartItemDTO.setProduct(productDTO);
            cartItemDTO.setId(cart.getId());
            cartItemDTO.setQuantity(cart.getQuantity());
            return cartItemDTO;
        }).toList();

        return new UserCartDTO(
                cartItemDTOs,
                itemTotal
        );
    }

    public List<CartItemDTO> addToUserCart(NewCartItemDTO newCartItemDTO){
        User user = this.userRepository.findById(newCartItemDTO.getUserId()).orElseThrow();
        Product product = this.productService.getProductById(newCartItemDTO.getProductId());

        Cart newItem = new Cart(
                null,
                user,
                product,
                newCartItemDTO.getQuantity());
        this.cartRepository.save(newItem);
        List<Cart> createdItem = this.cartRepository.findByUserId(user.getId());
        return createdItem.stream().map(cart -> {
            CartItemDTO cartItemDTO = new CartItemDTO();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setDescription(cart.getProduct().getDescription());
            productDTO.setName(cart.getProduct().getName());
            productDTO.setPrice(cart.getProduct().getPrice());
            productDTO.setId(cart.getProduct().getId());
            cartItemDTO.setProduct(productDTO);
            cartItemDTO.setId(cart.getId());
            cartItemDTO.setQuantity(cart.getQuantity());
            return cartItemDTO;
        }).toList();
    }

//    public List<Cart> deleteFromUserCart(){
//
//    }

}
