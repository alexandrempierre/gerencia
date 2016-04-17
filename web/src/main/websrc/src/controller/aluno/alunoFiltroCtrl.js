/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('alunoFiltroCtrl', function(lciCrudScope, $scope, alunoAPI, listaTO, caminho, lciCrudPageInfo, changePasswordModal){
    lciCrudScope.Scope.call($scope, alunoAPI, caminho);
    
    $scope.changePasswordModalOpen = changePasswordModal.openModal;
    $scope.filter = $scope.getFiltro();
    $scope.list = listaTO.data || [];

  });

})(angular.module('gerencia'));