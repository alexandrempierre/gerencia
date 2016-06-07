/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('employeeDetailCtrl', function($scope,lciCrudScope, employeeAPI,caminho,registroTO, changePasswordModal){
    lciCrudScope.Scope.call($scope,employeeAPI,caminho);

    $scope.changePasswordModalOpen = changePasswordModal.openModal;

    $scope.employee = registroTO.data;
  });

})(angular.module('gerencia'));