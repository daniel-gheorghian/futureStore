(function ()
{
    "use strict";

    var CatalogItemComponent = {
        bindings   : {
            item: '<'
        },
        templateUrl: 'app/components/catalog/catalogItem/catalogItem.html',
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

        ctrl.activeTab = 1;
        ctrl.isActiveTab = isActiveTab;
        ctrl.setActiveTab = setActiveTab;

        function isActiveTab ( tabNo )
        {
            return ctrl.activeTab === tabNo;
        }

        function setActiveTab ( tabNo )
        {
            ctrl.activeTab = tabNo;
        }
    }

    angular.module( "FutureStore" )
           .component( "catalogItem", CatalogItemComponent );
})();