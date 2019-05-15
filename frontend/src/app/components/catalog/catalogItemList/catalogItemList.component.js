(function ()
{
    "use strict";

    var CatalogItemListComponent = {
        bindings   : {},
        templateUrl: 'app/components/catalog/catalogItemList/catalogItemList.html',
        controller : CatalogItemListController
    };

    CatalogItemListController.$inject = ["CatalogService", "CartService"];

    function CatalogItemListController ( CatalogService, CartService )
    {
        var ctrl = this;

        ctrl.onAddToCart = onAddToCart;
        ctrl.$onInit = function ()
        {
            CatalogService.loadItems().then( function ( res )
                                             {
                                                 ctrl.catalog = res.data;
                                             } );
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

    angular.module( "FutureStore" )
           .component( "catalogItemList", CatalogItemListComponent );
})();