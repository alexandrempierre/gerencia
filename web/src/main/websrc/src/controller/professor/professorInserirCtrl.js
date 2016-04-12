/**
 * Created by fausto on 2/18/16.
 */

(function(app){
  app.controller('professorInserirCtrl', function(lciCrudScope,$scope,professorAPI, caminho,validacaoAPI){
    lciCrudScope.Scope.call($scope,professorAPI,caminho);

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
    // Para validar o CPF
    $scope.cpfUnico = validacaoAPI.cpfUnico;

    $scope.professor = {
      usuario:{
        ativo: true,
        infinito: false
      }
    };
  });

})(angular.module('gerencia'));