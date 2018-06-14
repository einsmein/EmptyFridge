angular.module('app', [])
    .controller('AppController', function AppController($scope, $http){
        $scope.menus = [];
        $scope.ingredients = []; //product name, price, leftover, score
        $scope.suggestions = [1,2,3,4]; //change from, to, waste diff, reduced score

        $scope.chosenMenus = [];

        $scope.response = null;


        $scope.getRecipes = function(){
            var req = {
                method: "GET",
                url: "/recipe/all"
            };
            $http(req)
                .then(function (response) {
                    $scope.menus = angular.fromJson(response.data);
                    $scope.response = response.data;
                }, function (response) {
                    $scope.response = response;
                });
        }

        $scope.chooseRecipes = function(){
            var req = {
                method: "POST",
                url: "/calculator/calculate"
            };
            $http(req)
                .then(function (response) {
                    $scope.response = response;
                }, function (response) {
                    $scope.response = response;
                });
        }

        $scope.getRecipes();
    })
    .component('suggestions', {
        templateUrl: 'suggestions.component.html',
        bindings: {
            suggestions: '='
        }
    }).run(function($templateCache) {
          var template = '<h1> LoginComponent </h1>';
          $templateCache.put( 'suggestions.component.html' , template );
    });;