/**
 * 
 */

var app = angular.module("PessoaApp", []);

// Controller Part
app.controller("PessoaController", function($scope, $http, $window) {

	$scope.pessoas = [];
	$scope.pessoa;
	$scope.pessoasForm = {
		empId : 1,
		empNo : "",
		empName : ""
	};

	// Now load the data from server
	_listaPessoas();

	function reload() {
		$window.location.reload();
	}

	function _listaPessoas() {
		$http({
			method : 'GET',
			url : '/pessoas/all'
		}).then(function(res) { // success
			$scope.pessoas = res.data;
		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}

	$scope.deletaPessoa = function(pessoa) {
		/* $http.delete("/pessoa/delete"); */
		$http({
			method : 'DELETE',
			url : '/pessoas/pessoa/delete/{id}',
			params : {
				id : pessoa.id
			}
		});

		reload();

	};

	$scope.carregarPessoa = function(pessoa) {
		$scope.pessoa = angular.copy(pessoa);
	}

	$scope.buscarPessoa = function(pessoa) {
		return $http.post('/rest/pessoa/' + Id)
	}

	$scope.salvarPessoa = function() {
		// use $.param jQuery function to serialize data from JSON
		var data = angular.toJson($scope.pessoa);

		var config = {
			headers : {
				'Content-Type' : 'application/json;'
			}
		}

		$http.post('/pessoas', data, config)
		reload();
	};

});