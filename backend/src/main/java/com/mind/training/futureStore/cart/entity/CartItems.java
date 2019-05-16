package com.mind.training.futureStore.cart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class CartItems
{
    @Id
    @Basic( optional = false )
    @SequenceGenerator( name = "SEQ_CART_ITEM_ID", sequenceName = "SEQ_CART_ITEM_ID", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_CART_ITEM_ID" )
    private Long id;

    @Column
    @Basic( optional = false )
    private String itemType;

    @Column
    @Basic( optional = false )
    private String itemCode;

    @Column
    @Basic( optional = false )
    private String itemDescription;

    @Column
    @Basic( optional = false )
    private int quantity;

    @Column
    @Basic( optional = false )
    private BigDecimal price;

    public Long getId( )
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    @ManyToOne
    @JsonBackReference
    private Cart cart;

    public String getItemType( )
    {
        return itemType;
    }

    public void setItemType( String itemType )
    {
        this.itemType = itemType;
    }

    public String getItemCode( )
    {
        return itemCode;
    }

    public void setItemCode( String itemCode )
    {
        this.itemCode = itemCode;
    }

    public String getItemDescription( )
    {
        return itemDescription;
    }

    public void setItemDescription( String itemDescription )
    {
        this.itemDescription = itemDescription;
    }

    public int getQuantity( )
    {
        return quantity;
    }

    public void setQuantity( int quantity )
    {
        this.quantity = quantity;
    }

    public BigDecimal getPrice( )
    {
        return price;
    }

    public void setPrice( BigDecimal price )
    {
        this.price = price;
    }

    public Cart getCart( )
    {
        return cart;
    }

    public void setCart( Cart cart )
    {
        this.cart = cart;
    }

    @Override
    public boolean equals( Object o )
    {
        if( this == o )
        {
            return true;
        }
        if( o == null || getClass( ) != o.getClass( ) )
        {
            return false;
        }
        CartItems cartItems = (CartItems)o;
        return quantity == cartItems.quantity &&
               Objects.equals( id, cartItems.id ) &&
               Objects.equals( itemType, cartItems.itemType ) &&
               Objects.equals( itemCode, cartItems.itemCode ) &&
               Objects.equals( itemDescription, cartItems.itemDescription ) &&
               Objects.equals( price, cartItems.price );
    }

    @Override
    public int hashCode( )
    {
        return Objects.hash( id, itemType, itemCode, itemDescription, quantity, price );
    }

    @Override
    public String toString( )
    {
        return "CartItems{" +
               "id=" + id +
               ", itemType='" + itemType + '\'' +
               ", itemCode='" + itemCode + '\'' +
               ", itemDescription='" + itemDescription + '\'' +
               ", quantity=" + quantity +
               ", price=" + price +
               '}';
    }
}
