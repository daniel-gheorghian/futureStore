//=================================================================================================
// Project:		TrainingSpring-Angular
// File :       Catalog
//
// Created by:	daniel.gheorghian, 2017
//-------------------------------------------------------------------------------------------------
// Copyright:   MIND CTI Ltd.
//=================================================================================================

package com.mind.training.futureStore.catalog.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 */
@Entity
@Table
public class CatalogItem
{
    @Column
    @Basic( optional = false )
    private String                  itemType;

    @Column
    @Id
    @Basic( optional = false )
    private String                  itemCode;

    @Column
    @Basic( optional = false )
    private String                  itemDescription;

    @Column
    @Basic( optional = false )
    private double                  price;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "item" )
    @JsonManagedReference
    private List<CatalogItemReview> reviews;
    
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "item" )
    @JsonManagedReference
    private List<CatalogItemSpec> specs;

    public List<CatalogItemReview> getReviews( )
    {
        return reviews;
    }

    public void setReviews( List<CatalogItemReview> itemReviews )
    {
        this.reviews = itemReviews;
    }
    
    public List<CatalogItemSpec> getSpecs( )
    {
        return specs;
    }

    public void setSpecs( List<CatalogItemSpec> itemSpecs )
    {
        this.specs = itemSpecs;
    }

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

    public double getPrice( )
    {
        return price;
    }

    public void setPrice( double price )
    {
        this.price = price;
    }

    @Override
    public int hashCode( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( itemCode == null ) ? 0 : itemCode.hashCode( ) );
        result = prime * result + ( ( itemDescription == null ) ? 0 : itemDescription.hashCode( ) );
        result = prime * result + ( ( reviews == null ) ? 0 : reviews.hashCode( ) );
        result = prime * result + ( ( itemType == null ) ? 0 : itemType.hashCode( ) );
        long temp;
        temp = Double.doubleToLongBits( price );
        result = prime * result + (int)( temp ^ ( temp >>> 32 ) );
        return result;
    }

    @Override
    public boolean equals( Object obj )
    {
        if( this == obj )
        {
            return true;
        }
        if( obj == null )
        {
            return false;
        }
        if( getClass( ) != obj.getClass( ) )
        {
            return false;
        }
        CatalogItem other = (CatalogItem)obj;
        if( itemCode == null )
        {
            if( other.itemCode != null )
            {
                return false;
            }
        }
        else if( !itemCode.equals( other.itemCode ) )
        {
            return false;
        }
        if( itemDescription == null )
        {
            if( other.itemDescription != null )
            {
                return false;
            }
        }
        else if( !itemDescription.equals( other.itemDescription ) )
        {
            return false;
        }
        if( reviews == null )
        {
            if( other.reviews != null )
            {
                return false;
            }
        }
        else if( !reviews.equals( other.reviews ) )
        {
            return false;
        }
        if( itemType == null )
        {
            if( other.itemType != null )
            {
                return false;
            }
        }
        else if( !itemType.equals( other.itemType ) )
        {
            return false;
        }
        if( Double.doubleToLongBits( price ) != Double.doubleToLongBits( other.price ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString( )
    {
        return "CatalogItem [itemType=" + itemType + ", itemCode=" + itemCode + ", itemDescription=" + itemDescription + ", price=" + price
               + ", itemReviews=" + reviews + "]";
    }
}
