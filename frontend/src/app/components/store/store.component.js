(function ()
{
    "use strict";

    var StoreComponent = {
        bindings   : {},
        templateUrl: 'app/components/store/store.html',
        controller : StoreController
    };

    StoreController.$inject = ["CartService", "$state"];

    function StoreController ( CartService, $state )
    {
        var ctrl = this;

        ctrl.onAddToCart = onAddToCart;
        ctrl.$onInit = function ()
        {
            return CartService.createCart( "123", "Iasi1" )
                              .then( function ( response )
                                     {
                                         ctrl.cart = response.data;
                                         ctrl.cart.items = [];
                                     } );
        };

        function onAddToCart ( $event )
        {
            CartService.addToCart( $event.item, ctrl.cart )
                       .then( updateCart )
                       .then( goToCart );
        }

        function updateCart ( response )
        {
            ctrl.cart = response.data;
        }

        function goToCart ()
        {
            $state.go( "store.cart" );
        }
    }

    StoreConfig.$inject = ["$stateProvider"];

    function StoreConfig ( $stateProvider )
    {
        $stateProvider.state( 'store',
                              {
                                  url      : '/store',
                                  component: 'store'
                              } );
    }

    angular.module( "FutureStore" )
           .component( "store", StoreComponent )
           .config( StoreConfig );
})();