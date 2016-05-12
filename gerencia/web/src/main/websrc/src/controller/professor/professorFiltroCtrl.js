/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('professorFiltroCtrl', function(lciCrudScope, $scope, teacherAPI, listaTO, caminho, lciCrudPageInfo, changePasswordModal){
    lciCrudScope.Scope.call($scope, teacherAPI, caminho);

    $scope.changePasswordModalOpen = changePasswordModal.openModal;
    $scope.filter = $scope.getFiltro();
    $scope.list = listaTO.data || [];

  });

})(angular.module('gerencia'));