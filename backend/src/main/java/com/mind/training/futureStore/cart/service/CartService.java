package com.mind.training.futureStore.cart.service;

import com.mind.training.futureStore.cart.entity.Cart;
import com.mind.training.futureStore.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CartService
{
    @Autowired
    private CartRepository cartRepository;

    public Cart addCart( Cart cart )
    {
        Cart savedCart = cartRepository.save( cart );

        return savedCart;
    }

    public Cart findCartById( long id )
    {
        return cartRepository.findById( id ).orElseThrow( ( ) -> new RuntimeException( "No cart with id " + id + " found!" ) );
    }

    public Cart updateCart( long id, Cart newCart )
    {
        Cart oldCart = cartRepository.findById( id ).orElseGet( Cart::new );

        oldCart.setId( id );
        oldCart.setAccountCode( newCart.getAccountCode( ) );
        oldCart.setStatus( newCart.getStatus( ) );
        oldCart.setStore( newCart.getStore( ) );
        oldCart.setItems( newCart.getItems( ) );

        return cartRepository.save( oldCart );
    }

    public Cart updateStatus( long id, String status )
    {
        Cart cart = findCartById( id );

        cart.setStatus( status );

        return cartRepository.save( cart );
    }

    public void deleteCart( long id )
    {
        cartRepository.deleteById( id );
    }

    public Iterable<Cart> findAllCarts( )
    {
        return cartRepository.findAll( );
    }
}