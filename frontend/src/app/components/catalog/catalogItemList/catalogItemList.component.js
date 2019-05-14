(function ()
{
    "use strict";

    var CatalogItemListComponent = {
        bindings   : {},
        templateUrl: 'app/components/catalog/catalogItemList/catalogItemList.html',
        controller : CatalogItemListController
    };

    function CatalogItemListController ()
    {
        var ctrl = this;

        ctrl.$onInit = function ()
        {
            ctrl.catalog = [
                {
                    itemDescription: 'Mist Pods',
                    price          : 500,
                    specs          : ['Comfortable to wear', 'Almost no weight', 'High fidelity', 'Available in Misty Black and Bright White'],
                    reviews        : [100, 80, 99, 110]
                }, {
                    itemDescription: 'Pineapple Watch',
                    price          : 300,
                    specs          : ['Accurate time piece', 'Pleasant fragrance', 'Available in Misty Black and Bright White'],
                    reviews        : [60, 70, 30, 99, 80, 72]
                }];
        };
    }

    angular.module( "FutureStore" )
           .component( "catalogItemList", CatalogItemListComponent );
})();