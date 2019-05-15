(function ()
{
    "use strict";

    CatalogService.$inject = ["$http"];

    function CatalogService ( $http )
    {
        this.loadItems = loadItems;

        function loadItems ()
        {
            return $http.get( "/api/catalog" );
        }
    }

    angular.module( "FutureStore" )
           .service( "CatalogService", CatalogService );
})();