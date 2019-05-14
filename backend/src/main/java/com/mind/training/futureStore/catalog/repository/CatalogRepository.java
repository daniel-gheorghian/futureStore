//=================================================================================================
// Project:		TrainingSpring-Angular
// File :       CatalogRepository
//
// Created by:	daniel.gheorghian, 2017
//-------------------------------------------------------------------------------------------------
// Copyright:   MIND CTI Ltd.
//=================================================================================================

package com.mind.training.futureStore.catalog.repository;

import com.mind.training.futureStore.catalog.entity.CatalogItem;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 */
public interface CatalogRepository extends CrudRepository<CatalogItem, String>
{
    
}