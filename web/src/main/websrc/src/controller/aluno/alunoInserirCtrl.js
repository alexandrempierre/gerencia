/**
 * Created by fausto on 2/18/16.
 */

(function(app){
  app.controller('alunoInserirCtrl', function(lciCrudScope,$scope,alunoAPI, caminho,validacaoAPI){
    lciCrudScope.Scope.call($scope,alunoAPI,caminho);

    //Sobrecarregando o método salvar
    var salvarFn = $scope.salvar;
    $scope.salvar = function(registro){
      if(registro.usuario.infinito){
        registro.usuario.expiracao = null;
      }
      salvarFn(registro);
    };

    // Para validar o login
    $scope.loginUnico = validacaoAPI.loginUnico;

    //Deprecated
    // Para validar o CPF
    //$scope.cpfUnico = validacaoAPI.cpfUnico;

    $scope.aluno = {
      usuario:{
        ativo: true,
        infinito: false
      }
    };
  });

})(angular.module('gerencia'));