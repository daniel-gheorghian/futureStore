(function ()
{
    "use strict";

    CatalogController.$inject = ["$scope"];

    function CatalogController ( $scope )
    {
        $scope.catalog = [
            {
                itemDescription: 'Mist Pods',
                price          : 500,
                specs: ['Comfortable to wear', 'Almost no weight', 'High fidelity', 'Available in Misty Black and Bright White'],
                reviews: [100, 80, 99, 110]
            }, {
                itemDescription: 'Pineapple Watch',
                price          : 300,
                specs: ['Accurate time piece', 'Pleasant fragrance', 'Available in Misty Black and Bright White'],
                reviews: [60, 70, 30, 99, 80, 72]
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