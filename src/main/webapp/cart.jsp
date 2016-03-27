<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/table-style.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.min.js"></script>
    <script>
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
    cartApp.config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                    when('/viewBuyItems', {
                        templateUrl: 'viewBuyItems.htm',
                        controller: 'BuyItemsController'
                    }).
                    otherwise({
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
         };
         $scope.deleteBuyItem = function(buyItem) {
         $http.delete("/api/cart/"+buyItem.id).success(function (response) {
         $scope.refresh();
         });
         }
    });
    </script>
</head>
<body>
<div ng-app="cartApp">
    <div ng-view></div>
    <script type="text/ng-template" id="viewBuyItems.htm">
        <h2 align="center"> BuyItems list: </h2>
        <%--Search : <input type="text" ng-model="search"><br/><br/>--%>
        <table class="table table-hover">
            <tr class="info">
                <th>TITLE</th>
                <th>DESCRIPTION</th>
                <th>PRICE</th>
                <th>ACTION</th>
            </tr>
            <tr ng-repeat="buyItem in values.buyItemMap | filter : search">
                <td>{{ buyItem.goods.name }}</td>
                <td>{{ buyItem.goods.description }}</td>
                <td>{{ buyItem.goods.price }}$</td>
                <td><a href="" ng-click="deleteBuyItem(buyItem)"><img src="${pageContext.request.contextPath}/icons/remove.png" width="30" height="30"/></a></td>
            </tr>
            <tr ng-model="values">
                <td colspan="4" align="center" bgcolor="#00fa9a">TOTAL PRICE : <b>{{ values.totalPrice }}$</b> </td>
            </tr>
        </table>

    </script>
</div>
</body>
</html>