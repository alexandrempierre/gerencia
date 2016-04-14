/**
 * Created by fausto on 2/18/16.
 */

(function(app){
  app.controller('alunoInserirCtrl', function(lciCrudScope,$scope,alunoAPI, caminho, validacaoAPI, $http){
    lciCrudScope.Scope.call($scope,alunoAPI,caminho);

    //Sobrecarregando o método salvar
    var salvarFn = $scope.salvar;
    $scope.salvar = function(registro){
      salvarFn(registro);
    };

    // Para validar o login
    $scope.loginUnico = validacaoAPI.loginUnico(alunoAPI);

    $scope.aluno = {
      usuario:{
        ativo: true,
        infinito: false
      }
    };
  });

})(angular.module('gerencia'));