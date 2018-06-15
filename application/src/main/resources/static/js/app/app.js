angular.module('app', [])
    .controller('AppController', function AppController($scope, $http){
        $scope.menus = [];
        $scope.ingredients = []; //product name, price, leftover, score
        $scope.suggestions = []; //change from, to, waste diff, reduced score

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
                data: $scope.chosenMenus,
                url: "/calculator/calculate"
            };
            $http(req)
                .then(function (response) {
                    data = angular.fromJson(response.data);
                    $scope.ingredients = data["ingredientsSummary"];
                    $scope.suggestions = data["suggestionList"];
                    $scope.response = response;
                }, function (response) {
                    $scope.response = response;
                });
        }

        $scope.getRecipes();
    })
    .component('ingredients', {
        templateUrl: 'ingredients.component.html',
        bindings: {
            ingredient: '='
        }
    })
    .component('suggestions', {
        templateUrl: 'suggestions.component.html',
        styleUrls: ['suggestions.component.css'],
        bindings: {
            suggestion: '='
        }
    })
//    .run(function($templateCache) {
//          var template = '<h1> LoginComponent </h1>';
//          $templateCache.put( 'suggestions.component.html' , template );
//    })
    ;