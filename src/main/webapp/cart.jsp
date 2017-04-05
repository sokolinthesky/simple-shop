<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/cart-script.js"></script>
</head>
<body>
    <div ng-app="cartApp">
        <div ng-view></div>
        <script type="text/ng-template" id="viewBuyItems.htm">
            <h2 align="center"> BuyItems list:</h2>
            <table class="table table-hover">
                <tr class="info">
                     <th>TITLE</th>
                     <th>DESCRIPTION</th>
                     <th>PRICE</th>
                     <th>ACTION</th>
                </tr>
                <tr data-ng-repeat="buyItem in values | filter : search">
                    <td>{{ buyItem.goods.name }}</td>
                    <td>{{ buyItem.goods.description }}</td>
                    <td>{{ buyItem.goods.price | currency}}</td>
                    <td>
                        <a href="" data-ng-click="deleteBuyItem(buyItem)">
                            <img src="${pageContext.request.contextPath}/icons/remove.png" width="30" height="30"/>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" align="center" bgcolor="#00fa9a">
                        TOTAL PRICE :
                        <b>{{ price | currency}}</b>
                    </td>
                </tr>
            </table>
         </script>
    </div>
</body>
</html>