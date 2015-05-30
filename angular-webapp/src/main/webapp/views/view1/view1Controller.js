angular.module('app.view1', ['ngRoute'])

.config(['$routeProvider',function($routeProvider) {
	$routeProvider.when('/view1', {
		templateUrl: 'views/view1/view1.html',
		controller: 'primeiroController'
	});
}])

.controller('primeiroController',['$scope', '$filter', '$modal', function ($scope, $filter, $modal) {
    
    $scope.cliente = {
        nome : '',
        cpf : '',
        email : ''
    };

    $scope.abrirModal = function() {
        $modal.open({
            templateUrl : 'views/view1/modal.html',
            size : 'sm'
        });
    }

    $scope.funcao = function(param, callback){
        console.info('dento da funcao');

        param += " alterado";

        callback(param);
    };

    $scope.respostas = [
        { nome: 'Guilherme'  , idade : 20, salario: 1000 },
        { nome: 'Guilherme 2', idade : 21, salario: 2000 },
        { nome: 'Guilherme 3', idade : 22, salario: 3000 },
        { nome: 'Guilherme 4', idade : 23, salario: 4000 },
        { nome: 'Guilherme 5', idade : 25, salario: 5000 }
    ];

    /*$scope.filter = $filter('meuFiltro');*/

    $scope.salvar = function() {
        console.info($scope.cliente);

        $scope.funcao('parametro', function(resposta){
            console.info('executando callback');
            console.info(resposta);
        });
    }
}]);
