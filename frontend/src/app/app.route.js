(function ()
{
    "use strict";

    States.$inject = ["$stateProvider", "$urlRouterProvider"];

    function States ( $stateProvider, $urlRouterProvider )
    {
        $urlRouterProvider.otherwise( "store/catalogItemList/" );

        $stateProvider.state( 'store.catalogItemList',
                              {
                                  abstract: true,
                                  url     : '/catalogItemList',
                                  resolve : {
                                      catalogItems: loadCatalogItems
                                  }
                              } );
    }

    loadCatalogItems.$inject = ['CatalogService'];

    function loadCatalogItems ( CatalogService )
    {
        return CatalogService.loadItems().then( function ( res )
                                                {
                                                    return res.data;
                                                } );
    }

    angular.module( "FutureStore" )
           .config( States );
})();