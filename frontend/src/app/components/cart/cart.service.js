(function ()
{
    "use strict";

    CartService.$inject = ["$http"];

    function CartService ( $http )
    {
        this.createCart = createCart;
        this.updateCart = updateCart;

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
    }

    angular.module( "FutureStore" )
           .service( "CartService", CartService );
})();