angular.module('app.view1', ['ngRoute'])

.config(['$routeProvider',function($routeProvider) {
	$routeProvider.when('/view1', {
		templateUrl: 'views/view1/view1.html',
		controller: 'primeiroController'
	});
}])

.controller('primeiroController',['$scope', '$filter', '$modal','view1Service', function ($scope, $filter, $modal, view1Service) {
    
    $scope.cliente = { nome  : '', cpf   : '', email : '' };

    $scope.respostas = [];

    var init = function(){
        $scope.buscar();
    };

    $scope.buscar = function(){
        view1Service.buscar(function(dados){
            $scope.respostas = dados;
        });
    };

    $scope.salvar = function() {
        var novoCliente = {
            nome  : $scope.cliente.nome,
            cpf   : $scope.cliente.cpf,
            email : $scope.cliente.email
        }

        view1Service.salvar(novoCliente, function(){
            $scope.buscar();
        });
    };

    $scope.deletar = function(id){
        view1Service.deletar(id, function(){
            $scope.buscar();
        });
    };

    $scope.abrirModal = function() {
        var modalInstance = $modal.open({
            templateUrl : 'views/view1/modal.html',
            size : 'sm'
        });
    };


    init();
}]);
