//=================================================================================================
// Project:		TrainingSpring-Angular
// File :       CatalogService
//
// Created by:	daniel.gheorghian, 2017
//-------------------------------------------------------------------------------------------------
// Copyright:   MIND CTI Ltd.
//=================================================================================================

package com.mind.training.futureStore.catalog.service;

import java.util.ArrayList;
import java.util.List;

import com.mind.training.futureStore.catalog.entity.CatalogItem;
import com.mind.training.futureStore.catalog.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CatalogService
{
    @Autowired
    private CatalogRepository catalogRepository;

    public List<CatalogItem> loadCatalog( )
    {
        List<CatalogItem> catalog = new ArrayList<>( );

        catalogRepository.findAll( ).forEach( catalog::add );

        return catalog;
    }
}
