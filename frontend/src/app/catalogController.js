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

        $scope.activeTab = 1;
        $scope.isActiveTab = isActiveTab;
        $scope.setActiveTab = setActiveTab;

        function isActiveTab ( tabNo )
        {
            return $scope.activeTab === tabNo;
        }

        function setActiveTab ( tabNo )
        {
            $scope.activeTab = tabNo;
        }
    }

    angular.module( "FutureStore" ).controller( "CatalogController",
                                                CatalogController );
})();