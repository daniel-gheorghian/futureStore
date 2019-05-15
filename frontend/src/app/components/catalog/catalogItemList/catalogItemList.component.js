(function ()
{
    "use strict";

    var CatalogItemListComponent = {
        bindings   : {
            items: '<'
        },
        templateUrl: 'app/components/catalog/catalogItemList/catalogItemList.html',
        controller : CatalogItemListController
    };

    CatalogItemListController.$inject = ["CartService"];

    function CatalogItemListController ( CartService )
    {
        var ctrl = this;

        ctrl.onAddToCart = onAddToCart;
        ctrl.$onChanges = function ( changes )
        {
            if ( changes.items )
            {
                ctrl.items = angular.copy( ctrl.items );
            }
        };

        function onAddToCart ( $event )
        {
            CartService.addToCart( $event.item );
        }
    }

    catalogItemListConfig.$inject = ["$stateProvider"];

    function catalogItemListConfig ( $stateProvider )
    {
        $stateProvider.state( 'catalogItemList.view',
                              {
                                  url      : '/',
                                  component: 'catalogItemList',
                                  params   : {
                                      cart: null
                                  },
                                  resolve  : {
                                      items: resolveItems
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