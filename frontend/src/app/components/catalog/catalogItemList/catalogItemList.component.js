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
            CartService.createCart( "123", "Iasi1" )
                       .then( addItemToCart.bind( null, $event.item ) )
                       .then( CartService.updateCart );
        }

        function addItemToCart ( item, response )
        {
            var cart = response.data;

            cart.items = [];
            cart.items.push( {
                                 "itemCode"       : item.itemCode,
                                 "itemDescription": item.itemDescription,
                                 "itemType"       : item.itemType,
                                 "price"          : item.price,
                                 "quantity"       : 1
                             } );

            return cart;
        }
    }

    catalogItemListConfig.$inject = ["$stateProvider"];

    function catalogItemListConfig ( $stateProvider )
    {
        $stateProvider.state( 'catalogItemList.view',
                              {
                                  url      : '/',
                                  component: 'catalogItemList',
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