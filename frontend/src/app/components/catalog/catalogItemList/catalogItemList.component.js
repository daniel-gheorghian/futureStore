(function ()
{
    "use strict";

    var CatalogItemListComponent = {
        bindings   : {
            items      : '<',
            onAddToCart: '&'
        },
        templateUrl: 'app/components/catalog/catalogItemList/catalogItemList.html',
        controller : CatalogItemListController
    };

    CatalogItemListController.$inject = ["CartService"];

    function CatalogItemListController ( CartService )
    {
        var ctrl = this;

        ctrl.$onChanges = function ( changes )
        {
            if ( changes.items )
            {
                ctrl.items = angular.copy( ctrl.items );
            }
        };

        ctrl.onAddItemToCart = function ( $event )
        {
            ctrl.onAddToCart( { "$event": $event } );
        };
    }

    catalogItemListConfig.$inject = ["$stateProvider"];

    function catalogItemListConfig ( $stateProvider )
    {
        $stateProvider.state( 'store.catalogItemList.view',
                              {
                                  url: '/',
                                  resolve: {
                                      items: resolveItems
                                  },
                                  views  : {
                                      "$default@^.^": {
                                          component: 'catalogItemList'
                                      }
                                  }
                              } );

        resolveItems.$inject = ["catalogItems"];

        function resolveItems ( catalogItems )
        {
            return catalogItems;
        }
    }

    angular.module( "FutureStore" )
           .component( "catalogItemList", CatalogItemListComponent )
           .config( catalogItemListConfig );
})();