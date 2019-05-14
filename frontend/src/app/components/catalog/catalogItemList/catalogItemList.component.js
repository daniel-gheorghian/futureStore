(function ()
{
    "use strict";

    var CatalogItemListComponent = {
        bindings   : {},
        templateUrl: 'app/components/catalog/catalogItemList/catalogItemList.html',
        controller : CatalogItemListController
    };

    CatalogItemListController.$inject = ["$http"];

    function CatalogItemListController ( $http )
    {
        var ctrl = this;

        ctrl.$onInit = function ()
        {
            $http.get( "/api/catalog" ).then( function ( res )
                                              {
                                                  ctrl.catalog = res.data;
                                              } );
        };
    }

    angular.module( "FutureStore" )
           .component( "catalogItemList", CatalogItemListComponent );
})();