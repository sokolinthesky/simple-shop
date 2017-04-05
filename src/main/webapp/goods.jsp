<html lang="en">
<head>
    <title>Goods list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/goods-script.js"></script>
</head>
<body>

<div ng-app="mainApp">
    <p>
        <a href="#addGoods"><img src="${pageContext.request.contextPath}/icons/technology.png" width="50" height="50"/></a>
        <a href="api/cartpage"><img align="right" src="${pageContext.request.contextPath}/icons/commerce.png" width="50" height="50" alt="CART"></a>
    </p>
    <div ng-view></div>
    <script type="text/ng-template" id="addGoods.htm">
        <h2> Add goods </h2>
        Name : <input type="text" ng-model="goods.name" required><br/><br/>
        Description : <input type="text" ng-model="goods.description" required><br/><br/>
        Price : <input type="number" ng-model="goods.price" required><br/><br/>
        <input type="button" ng-click="createGoods()" value="Save"><br/><br/>
    </script>
    <script type="text/ng-template" id="editGoods.htm">
        <h2> Edit goods </h2>
        <input type="hidden" ng-model="goods.id">
        Name : <input type="text" ng-model="goods.name" required><br/><br/>
        Description : <input type="text" ng-model="goods.description" required><br/><br/>
        Price : <input type="number" ng-model="goods.price" required><br/><br/>
        <input type="button" ng-click="saveGoods(goods)" value="Save"><br/><br/>
    </script>
    <script type="text/ng-template" id="viewGoods.htm">
        <h2 align="center"> Goods list: </h2>
        <div align="center">SEARCH : <input type="text" ng-model="search" placeholder="Enter the product name"><br/><br/></div>
        <table class="table table-hover">
            <tr class="info">
                <th>
                    <a href="" ng-click="sort('name')">TITLE</a>
                    <i class="glyphicon" ng-class="{'glyphicon-chevron-up' : isSortUp('name'), 'glyphicon-chevron-down' : isSortDown('name')}"></i>
                </th>
                <th>
                    <a href="" ng-click="sort('description')">DESCRIPTION</a>
                    <i class="glyphicon" ng-class="{'glyphicon-chevron-up' : isSortUp('description'), 'glyphicon-chevron-down' : isSortDown('description')}"></i>
                </th>
                <th>
                    <a href="" ng-click="sort('price')">PRICE</a>
                    <i class="glyphicon" ng-class="{'glyphicon-chevron-up' : isSortUp('price'), 'glyphicon-chevron-down' : isSortDown('price')}"></i>
                </th>
                <th colspan="3" align="center">ACTION</th>
            </tr>
            <tr ng-repeat="goods in values | filter:search | orderBy:sortField:reverse">
                <td>{{ goods.name }}</td>
                <td>{{ goods.description }}</td>
                <td>{{ goods.price | currency}}</td>
                <td><a href="" ng-click="editGoods(goods)"><img src="${pageContext.request.contextPath}/icons/edit.png" width="30" height="30"/></a></td>
                <td><a href="" ng-click="deleteGoods(goods)"><img src="${pageContext.request.contextPath}/icons/remove.png" width="30" height="30"/></a></td>
                <td><a href="" ng-click="buyGoods(goods)"><img src="${pageContext.request.contextPath}/icons/commerce.png" width="30" height="30"/></a></td>
            </tr>
        </table>
    </script>

    <script type="text/ng-template" id="viewBuyItems.htm">
        <h2 align="center"> BuyItems list:</h2>
        <table class="table table-hover">
            <tr class="info">
            </tr>
            <tr data-ng-repeat="buyItem in values | filter : search">
                <td>{{ buyItem.goods.name }}</td>
                <td>{{ buyItem.goods.description }}</td>
                <td>{{ buyItem.goods.price }}$</td>
                <td>
                    <a href="" data-ng-click="deleteBuyItem(buyItem)">
                        <img src="${pageContext.request.contextPath}/icons/remove.png" width="30" height="30"/>
                    </a>
                </td>
            </tr>
            <tr>
                <td colspan="4" align="center" bgcolor="#00fa9a">
                    TOTAL PRICE :
                    <b>{{ price }}$</b>
                </td>
            </tr>
        </table>
    </script>
</div>
</body>
</html>