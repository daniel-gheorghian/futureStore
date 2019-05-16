(function ()
{
    "use strict";

    CartService.$inject = ["$http", "$state"];

    function CartService ( $http, $state )
    {
        this.addToCart = addToCart;
        this.createCart = createCart;
        this.loadCart = loadCart;

        function createCart ( accountCode, store )
        {
            return $http.post( "/api/cart", {
                "status"     : "OPEN",
                "accountCode": accountCode,
                "store"      : store
            } );
        }

        function updateCart ( cart )
        {
            return $http.put( "/api/cart/" + cart.id, cart );
        }

        function loadCart ( cartId )
        {
            return $http.get( "/api/cart/" + cartId );
        }

        function addToCart ( item, cart )
        {
            addItemToCart( item, cart );

            return updateCart( cart );
        }

        function addItemToCart ( item, cart )
        {
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
           .service( "CartService", CartService );
})();