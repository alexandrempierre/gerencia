/**
 * Created by fausto on 2/18/16.
 */

(function(app){
  app.factory('alterarSenhaModal', function(usuarioAPI,$uibModal){

    function abrirModal(usuario){
      return $uibModal.open({
        animation: true,
        templateUrl: 'template/view/usuario/alterarSenha.html',
        controller: 'usuarioAlterarSenhaCtrl',
        resolve: {
          usuario: function () {
            return usuario;
          }
        }
      }).result;
    }

    return {
      abrirModal: abrirModal
    };
  });
})(angular.module('gerencia'));