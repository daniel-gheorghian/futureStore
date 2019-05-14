//=================================================================================================
// Project:		TrainingSpring-Angular
// File :       CatalogItemSpec
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
public class CatalogItemSpec
{
    @Id
    @Column
    @Basic( optional = false )
    private long        id;

    @Column
    @Basic( optional = false )
    private String      spec;

    @ManyToOne
    @JsonBackReference
    private CatalogItem item;

    public String getSpec( )
    {
        return spec;
    }

    public void setSpec( String spec )
    {
        this.spec = spec;
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
        result = prime * result + (int)( id ^ ( id >>> 32 ) );
        result = prime * result + ( ( spec == null ) ? 0 : spec.hashCode( ) );
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
        CatalogItemSpec other = (CatalogItemSpec)obj;
        if( id != other.id )
        {
            return false;
        }
        if( spec == null )
        {
            if( other.spec != null )
            {
                return false;
            }
        }
        else if( !spec.equals( other.spec ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString( )
    {
        return "CatalogItemSpec [id=" + id + ", spec=" + spec + "]";
    }
}
