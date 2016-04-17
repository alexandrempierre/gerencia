/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('alunoDetalheCtrl', function($scope,lciCrudScope, alunoAPI,caminho,registroTO, changePasswordModal){
    lciCrudScope.Scope.call($scope,alunoAPI,caminho);

    $scope.changePasswordModalOpen = changePasswordModal.openModal;

    $scope.student = registroTO.data;

  });

})(angular.module('gerencia'));