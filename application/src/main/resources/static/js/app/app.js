angular.module('app', [])
    .controller('AppController', function AppController($scope, $http){
        $scope.recipes = [];
        $scope.ingredients = []; //product name, price, leftover, score
        $scope.suggestions = []; //change from, to, waste diff, reduced score

//        $scope.chosenMenus = [];
        $scope.recipeSelection = [];

        $scope.response = null;

        // Select / deselect recipe
        $scope.onClickRecipe = function(recipeName){
            var found = $scope.recipeSelection.find(function(element) {
              return element.name == recipeName;
            });

            found.chosen = (found.chosen + 1)%2;
        }

        $scope.getChosenMenus = function(){
            var chosenMenus = [];
            $scope.recipeSelection.forEach(function(selection) {
                if(selection.chosen) {
                    chosenMenus.push(selection.name);
                }
            });
            console.log(chosenMenus);
            return chosenMenus;
        }

        // Get recipe from database
        $scope.getRecipes = function(){
            var req = {
                method: "GET",
                url: "/recipe/all"
            };
            $http(req)
                .then(function (response) {
                    $scope.recipes = angular.fromJson(response.data);
                    $scope.response = response.data;

                    $scope.recipes.forEach(function(recipe) {
                        $scope.recipeSelection.push({
                            name: recipe.name,
                            chosen: 0
                        })
                    })
                    console.log($scope.recipeSelection);
                }, function (response) {
                    $scope.response = response;
                });
        }

        // Submit chosen recipe to calculate waste
        $scope.chooseRecipes = function(){
            var req = {
                method: "POST",
                data: $scope.getChosenMenus(),
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

        $scope.btnSettings = [
            { color: 'btn-success', text: 'Select' }, // selecting button
            { color: 'btn-danger', text: 'Remove' } // deselection button
        ]

        $scope.getRecipes();
    })
    .component('recipes', {
        templateUrl: 'recipes.component.html',
        bindings: {
            recipe: '=',
            btnSettings: '=',
            onClickRecipe: '<'
        }
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