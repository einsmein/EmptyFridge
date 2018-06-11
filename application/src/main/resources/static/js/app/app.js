angular.module('app', [])
    .controller('AppController', function AppController($scope, $http){
        $scope.menus = ["first dish", "second dish"];
        $scope.realMenus = [];
        $scope.response = null;

        var req = {
            method: "GET",
            url: "/recipe/all"
        };

        $http(req)
            .then(function (response) {
                $scope.realMenus = response.data;
                $scope.response = response;
            }, function (response) {
                $scope.response = response;
            });
    });