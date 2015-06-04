angular.module('app.view1Service', []).service('view1Service', function($http){
	this.buscar = function(callback){
		$http.get('/angular/rs/cliente')
			 .success(callback)
			 .error(function(){
			 	console.error('Erro ao executar o GET cliente');
			 });
	}

	this.salvar = function(cliente, callback){
		$http.post('/angular/rs/cliente', cliente)
			 .success(callback)
			 .error(function(){
			 	console.error('Erro ao executar o POST para incluir cliente');
			 });
	}

	this.deletar = function(id, callback){
		$http.delete('/angular/rs/cliente/' + id)
			 .success(callback)
			 .error(function(){
			 	console.error('Erro ao excluir cliente');
			 });
	}
});