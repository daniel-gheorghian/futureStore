(function ()
{
    "use strict";

    CatalogController.$inject = ["$scope"];

    function CatalogController ( $scope )
    {
        $scope.catalog = [
            {
                itemDescription: 'Mist Pods',
                price          : 500
            }, {
                itemDescription: 'Pineapple Watch',
                price          : 300
            }];
    }

    angular.module( "FutureStore" ).controller( "CatalogController",
                                                CatalogController );
})();