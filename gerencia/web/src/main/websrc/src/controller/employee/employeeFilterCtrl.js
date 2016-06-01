/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('employeeFilterCtrl', function(lciCrudScope, $scope, employeeAPI, listaTO, caminho, lciCrudPageInfo, changePasswordModal){
    lciCrudScope.Scope.call($scope, employeeAPI, caminho);
    
    $scope.changePasswordModalOpen = changePasswordModal.openModal;
    $scope.filter = $scope.getFiltro();
    $scope.list = listaTO.data || [];

  });

})(angular.module('gerencia'));