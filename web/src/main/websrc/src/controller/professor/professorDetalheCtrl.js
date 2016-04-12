/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('professorDetalheCtrl', function($scope,lciCrudScope, professorAPI,caminho,registroTO, alterarSenhaModal, validacaoAPI){
    lciCrudScope.Scope.call($scope,professorAPI,caminho);

    $scope.abrirAlterarSenha = alterarSenhaModal.abrirModal;

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

    $scope.professor = registroTO.data;
    $scope.professor.usuario.infinito = !$scope.professor.usuario.expiracao;

  });

})(angular.module('gerencia'));