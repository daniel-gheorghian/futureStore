(function ()
{
    "use strict";

    var CartComponent = {
        bindings   : {
            cart: '<'
        },
        templateUrl: 'app/components/cart/cart.html',
        controller : CartController
    };

    CartController.$inject = ["$state"];

    function CartController ( $state )
    {
        var ctrl = this;

        ctrl.backToCatalog = backToCatalog;
        ctrl.cartGrandTotal = cartGrandTotal;
        ctrl.$onChanges = function ( changes )
        {
            if ( changes.cart )
            {
                ctrl.cart = angular.copy( ctrl.cart );
            }
        };

        function backToCatalog ()
        {
            $state.go( "store.catalogItemList.view" );
        }

        function cartGrandTotal ()
        {
            return ctrl.cart.items.reduce( sum, 0 );
        }

        function sum ( total, item )
        {
            return total + (item.quantity * item.price);
        }
    }

    cartConfig.$inject = ["$stateProvider"];

    function cartConfig ( $stateProvider )
    {
        $stateProvider.state( 'store.cart',
                              {
                                  url      : '/cart',
                                  component: 'cart'
                              } );
    }

    angular.module( "FutureStore" )
           .component( "cart", CartComponent )
           .config( cartConfig );
})();