var mainApp = angular.module("mainApp", ['ngRoute']);
mainApp.service('GoodsService',
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

mainApp.config(['$routeProvider',
    function($routeProvider, $stateProvider, $urlRouterProvider) {
        $routeProvider.
            when('/addGoods', {
                templateUrl: 'addGoods.htm',
                controller: 'AddGoodsController'
            }).
            when('/editGoods', {
                templateUrl: 'editGoods.htm',
                controller: 'EditGoodsController'
            }).
            when('/viewGoods', {
                templateUrl: 'viewGoods.htm',
                controller: 'GoodsController'
            }).
            when('/buyGoods', {
                redirectTo: '/api/cartpage'
            }).
            otherwise({
                redirectTo: '/viewGoods'
            });
}]);

mainApp.controller('AddGoodsController', function($scope, $http, $location) {
    $scope.createGoods = function() {
        $http.post("api/goods/", $scope.goods).success(
            function (responce) {
                $location.path("/viewGoods");
            }
        );
    }
});

mainApp.controller('EditGoodsController', function($scope, $http, $location, GoodsService) {
    $scope.goods = GoodsService.get();
    $http.get("api/cart/").success(function (response) {
               $scope.values = response;
            });

    $scope.saveGoods = function(goods) {
        $http.put("api/goods/", goods).success(function (response) {
            $location.path("/viewGoods");
        });
    }
});

mainApp.controller('GoodsController', function($scope, $http, $location, GoodsService) {
    $http.get("api/goods/").success(function (response) {
        $scope.values = response;
    });

    $scope.refresh = function(){
        $http.get("api/goods/").success(function (response) {
            $scope.values = response;
        });
    };

    $scope.editGoods = function(goods) {
        GoodsService.set(goods);
        $location.path("/editGoods");
    };

    $scope.deleteGoods = function(goods) {
        $http.delete("api/goods/"+ goods.id).success(function (response) {
            $scope.refresh();
        });
    };

    $scope.buyGoods = function(goods) {
        $http.post("api/cart/", goods).success(function (response) {
            $location.path("/buyGoods");
        })
    };

    $scope.sortField = undefined;
    $scope.reverse = false;

    $scope.sort = function(fieldName) {
        if ($scope.sortField === fieldName) {
            $scope.reverse = !$scope.reverse;
        } else {
            $scope.sortField = fieldName;
            $scope.reverse = false;
        }
    }

    $scope.isSortUp = function(fieldName) {
        return $scope.sortField === fieldName && !$scope.reverse;
    }

    $scope.isSortDown = function(fieldName) {
        return $scope.sortField === fieldName && $scope.reverse;
    }
});



