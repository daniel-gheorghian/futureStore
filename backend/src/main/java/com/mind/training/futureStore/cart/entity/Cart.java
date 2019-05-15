package com.mind.training.futureStore.cart.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mind.training.futureStore.catalog.entity.CatalogItemReview;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 *
 */
@Entity
@Table
public class Cart
{
    @Id
    @Basic( optional = false )
    @SequenceGenerator( name = "SEQ_CART_ID", sequenceName = "SEQ_CART_ID", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_CART_ID" )
    private Long   id;

    @Column
    @Basic( optional = false )
    private String status;

    @Column
    @Basic( optional = false )
    private String accountCode;

    @Column
    @Basic( optional = false )
    private String store;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "cart" )
    @JsonManagedReference
    private List<CartItems> items;

    public Long getId( )
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getStatus( )
    {
        return status;
    }

    public void setStatus( String status )
    {
        this.status = status;
    }

    public String getAccountCode( )
    {
        return accountCode;
    }

    public void setAccountCode( String accountCode )
    {
        this.accountCode = accountCode;
    }

    public String getStore( )
    {
        return store;
    }

    public void setStore( String store )
    {
        this.store = store;
    }

    public List<CartItems> getItems( )
    {
        return items;
    }

    public void setItems( List<CartItems> items )
    {
        this.items = items;
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
        Cart cart = (Cart)o;
        return Objects.equals( id, cart.id ) &&
               Objects.equals( status, cart.status ) &&
               Objects.equals( accountCode, cart.accountCode ) &&
               Objects.equals( store, cart.store );
    }

    @Override
    public int hashCode( )
    {
        return Objects.hash( id, status, accountCode, store );
    }

    @Override
    public String toString( )
    {
        return "Cart [id=" + id + ", status=" + status + ", accountCode=" + accountCode + ", store=" + store + "]";
    }
}
