<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Goods</title>
    <%--<link rel="stylesheet" href="css/table-style.css">--%>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.min.js"></script>
    <script src="js/goods-script.js"></script>
</head>
<body>
<%--<a href="/api/cartpage"><b>Cart</b></a><br>--%>

<div ng-app="mainApp">
    <p>
        <a href="#addGoods"><img src="${pageContext.request.contextPath}/icons/technology.png" width="50" height="50"/></a>    <a href="/api/cartpage"><img align="right" src="${pageContext.request.contextPath}/icons/commerce.png" width="50" height="50" alt="CART"></a>
    </p>
    <%--<a href="#addGoods">Add goods</a>--%>
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
                <th>TITLE</th>
                <th>DESCRIPTION</th>
                <th>PRICE</th>
                <th colspan="3" align="center">ACTION</th>
            </tr>
            <tr ng-repeat="goods in values | filter : search">
                <td>{{ goods.name }}</td>
                <td>{{ goods.description }}</td>
                <td>{{ goods.price }}$</td>
                <td><a href="" ng-click="editGoods(goods)"><img src="${pageContext.request.contextPath}/icons/edit.png" width="30" height="30"/></a></td>
                <td><a href="" ng-click="deleteGoods(goods)"><img src="${pageContext.request.contextPath}/icons/remove.png" width="30" height="30"/></a></td>
                <td><a href="" ng-click="buyGoods(goods)"><img src="${pageContext.request.contextPath}/icons/commerce.png" width="30" height="30"/></a></td>
            </tr>
        </table>
    </script>
</div>

</body>
</html>