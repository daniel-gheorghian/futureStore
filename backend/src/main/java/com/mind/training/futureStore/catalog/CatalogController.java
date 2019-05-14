//=================================================================================================
// Project:		TrainingSpring-Angular
// File :       CatalogController
//
// Created by:	daniel.gheorghian, 2017
//-------------------------------------------------------------------------------------------------
// Copyright:   MIND CTI Ltd.
//=================================================================================================

package com.mind.training.futureStore.catalog;

import java.util.List;

import com.mind.training.futureStore.catalog.entity.CatalogItem;
import com.mind.training.futureStore.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 */
@RestController
@RequestMapping( "/api/catalog" )
public class CatalogController
{
    @Autowired
    private CatalogService catalogService;
    
    @RequestMapping( method = RequestMethod.GET )
    public List<CatalogItem> loadCatalog( )
    {
        return catalogService.loadCatalog( );
    }
}
