var cartApp = angular.module("cartApp", ['ngRoute']);
cartApp.service('BuyItemsService',
    function()  {
        var savedData = {};
        function set(data) {
            savedData = data;
        }
        function get() {
            return savedData;
        }
        return {
            set: set,
            get: get
        }
    }
);
cartApp.config(['$routeProvider',function($routeProvider) {
    $routeProvider.
        when('/viewBuyItems', {
            templateUrl: 'viewBuyItems.htm',
            controller: 'BuyItemsController'
        }).otherwise({
            redirectTo: '/viewBuyItems'
        });
}]);

cartApp.controller('BuyItemsController', function($scope, $http, $location, BuyItemsService) {
    $http.get("/api/cart/").success(function (response) {
        $scope.values = response;
    });

    $scope.refresh = function(){
        $http.get("/api/cart/").success(function (response) {
            $scope.values = response;
        });
        $http.get("/api/cart/price").success(function (response) {
            $scope.price = response;
        });
    };

    $http.get("/api/cart/price").success(function (response) {
        $scope.price = response;
    });

    $scope.deleteBuyItem = function(goods) {
        $http.delete("/api/cart/"+ goods.id).success(function (response) {
            $scope.refresh();
        });
    };
});
