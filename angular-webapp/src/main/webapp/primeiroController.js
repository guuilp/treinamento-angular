angular.module('app').controller('primeiroController',['$scope', function ($scope) {
    
    $scope.cliente = {
        nome : '',
        cpf : '',
        email : ''
    };

    $scope.salvar = function() {
        console.info($scope.cliente);
    }
}]);
