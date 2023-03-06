angular.module('goods', []).controller('indexController', function ($scope, $http) {
    let contextPath = 'http://localhost:8888/web_market/api/v1/products';
    let cartServicePath = 'http://localhost:8890/carts/api/v1';
    $scope.pageNumber = 1;
    $scope.totalPages = 1;

    $scope.loadProducts = function (page) {
        if (page > 0 && page <= $scope.totalPages) {
            $http.get(contextPath + '?pageNumber=' + page)
                .then(function (response) {
                    $scope.ProductsList = response.data.content;
                    $scope.pageNumber = response.data.number + 1;
                    $scope.totalPages = response.data.totalPages;
                    $scope.lastPosition = response.data.last && response.data.numberOfElements == 1;
                });
        }
    }

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/' + productId)
            .then(function (response) {
                if ($scope.lastPosition) {
                    $scope.pageNumber--;
                }
                $scope.loadProducts($scope.pageNumber);
            });
    }

    $scope.changeCart = function (productId, delta) {
        $http({
            url: cartServicePath + '/change_cart',
            method: 'GET',
            params: {
                id: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts($scope.pageNumber);
        });
    }

    $scope.loadProducts(1);
})