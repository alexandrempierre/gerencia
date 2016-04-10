/**
 * Created by fausto on 2/18/16.
 */

(function(app){

  app.controller('usuarioAlterarSenhaCtrl', function($scope, $uibModalInstance,usuarioAPI,usuario){
    $scope.usuario = usuario;
    $scope.usuario.senha = '';
    $scope.usuario.rsenha = '';

    $scope.salvar = function(registro){
      usuarioAPI.alterarSenha(registro).then(function(){
        $uibModalInstance.close(registro);
      });
    };

    $scope.cancelar = function(){
      $uibModalInstance.dismiss('cancelado');
    };

  });

})(angular.module('gerencia'));