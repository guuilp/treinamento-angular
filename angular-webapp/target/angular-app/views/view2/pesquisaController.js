angular.module('app.pesquisa', ['ngRoute'])

.config(['$routeProvider',function($routeProvider) {
	$routeProvider.when('/view2', {
		templateUrl: 'views/view2/pesquisa.html',
		controller: 'pesquisaController'
	});
}])

.controller('pesquisaController', ['$scope', function($scope) {
    $scope.pesquisa = {
    	codigo: '',
    	nome: '',
    	cpf: ''
    };

    $scope.salvar = function(){
    	console.info($scope.pesquisa);
        alert('Salvo');
    }
}]);