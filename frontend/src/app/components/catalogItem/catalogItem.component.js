(function ()
{
    "use strict";

    var CatalogItemComponent = {
        bindings   : {
            item: '<'
        },
        templateUrl: 'app/components/catalogItem/catalogItem.html',
        controller : CatalogItemController
    };

    CatalogItemController.$inject = [];

    function CatalogItemController (  )
    {
        var ctrl = this;

        ctrl.$onChanges = function ( changes )
        {
            if ( changes.item )
            {
                ctrl.item = angular.copy( ctrl.item );
            }
        };
    }

    angular.module( "FutureStore" )
           .component( "catalogItem", CatalogItemComponent );
})();