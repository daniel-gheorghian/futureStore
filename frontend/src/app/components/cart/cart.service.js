(function ()
{
    "use strict";

    CartService.$inject = ["$http", "$stateParams", "$q", "$state"];

    function CartService ( $http, $stateParams, $q, $state )
    {
        this.addToCart = addToCart;

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

        function addToCart ( item )
        {
            getCart().then( addItemToCart.bind( null, item ) )
                     .then( updateCart )
                     .then( viewCart );
        }

        function getCart ()
        {
            if ( $stateParams.cart === null )
            {
                return createCart( "123", "Iasi1" ).then( function ( response )
                                                          {
                                                              var cart = response.data;
                                                              cart.items = [];
                                                              return cart;
                                                          } );
            }
            else
            {
                return $q.resolve( $stateParams.cart );
            }
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

        function viewCart ( response )
        {
            $state.go( "cart", { "cart": response.data } );
        }
    }

    angular.module( "FutureStore" )
           .service( "CartService", CartService );
})();