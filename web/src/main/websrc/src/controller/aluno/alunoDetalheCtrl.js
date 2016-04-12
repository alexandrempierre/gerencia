/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('alunoDetalheCtrl', function($scope,lciCrudScope, alunoAPI,caminho,registroTO, alterarSenhaModal, validacaoAPI){
    lciCrudScope.Scope.call($scope,alunoAPI,caminho);

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

    $scope.aluno = registroTO.data;
    $scope.aluno.usuario.infinito = !$scope.aluno.usuario.expiracao;

  });

})(angular.module('gerencia'));