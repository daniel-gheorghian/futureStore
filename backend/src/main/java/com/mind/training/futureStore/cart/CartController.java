package com.mind.training.futureStore.cart;

import com.mind.training.futureStore.cart.entity.Cart;
import com.mind.training.futureStore.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/cart" )
public class CartController
{
    @Autowired
    private CartService cartService;

    @RequestMapping( method = RequestMethod.GET )
    public Iterable<Cart> findAll( )
    {
        return cartService.findAllCarts( );
    }

    @RequestMapping( method = RequestMethod.POST )
    public Cart addCart( @RequestBody Cart cart )
    {
        return cartService.addCart( cart );
    }

    @RequestMapping( method = RequestMethod.GET, value = "/{cartId}" )
    public Cart getCartWithId( @PathVariable long cartId )
    {
        return cartService.findCartById( cartId );
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/{cartId}" )
    public Cart updateCartWithId( @PathVariable long cartId, @RequestBody Cart cart )
    {
        return cartService.updateCart( cartId, cart );
    }

    @RequestMapping( method = RequestMethod.PATCH, value = "/{cartId}" )
    public Cart updateStatus( @PathVariable long cartId, @RequestParam String status )
    {
        return cartService.updateStatus( cartId, status );
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/{cartId}" )
    public void deleteCart( @PathVariable long cartId )
    {
        cartService.deleteCart( cartId );
    }
}
