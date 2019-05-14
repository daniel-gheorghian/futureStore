//=================================================================================================
// Project:		TrainingSpring-Angular
// File :       CatalogItemReview
//
// Created by:	daniel.gheorghian, 2017
//-------------------------------------------------------------------------------------------------
// Copyright:   MIND CTI Ltd.
//=================================================================================================

package com.mind.training.futureStore.catalog.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 */
@Entity
@Table
public class CatalogItemReview
{
    
    @Column
    @Id
    @Basic( optional = false )
    private long id;

    @Column
    @Basic( optional = false )
    private long   review;
    
    @ManyToOne
    @JsonBackReference
    private CatalogItem item;

    public long getReview( )
    {
        return review;
    }

    public void setReview( long review )
    {
        this.review = review;
    }
    
    public CatalogItem getItem( )
    {
        return item;
    }

    public void setItem( CatalogItem item )
    {
        this.item = item;
    }

    @Override
    public int hashCode( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)( review ^ ( review >>> 32 ) );
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
        CatalogItemReview other = (CatalogItemReview)obj;

        if( review != other.review )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString( )
    {
        return "CatalogItemReview [review=" + review + "]";
    }
}
