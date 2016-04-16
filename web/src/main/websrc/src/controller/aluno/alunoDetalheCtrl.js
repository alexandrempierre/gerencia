/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('alunoDetalheCtrl', function($scope,lciCrudScope, alunoAPI,caminho,registroTO, /*alterarSenhaModal,*/ validacaoAPI){
    lciCrudScope.Scope.call($scope,alunoAPI,caminho);
    
    /*$scope.abrirAlterarSenha = alterarSenhaModal.abrirModal;*/
    
    // Para validar o login
    $scope.loginUnico = validacaoAPI.loginUnico(alunoAPI);

    $scope.aluno = registroTO.data;

  });

})(angular.module('gerencia'));