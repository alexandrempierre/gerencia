/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('professorDetalheCtrl', function($scope,lciCrudScope, teacherAPI,caminho,registroTO, changePasswordModal){
    lciCrudScope.Scope.call($scope,teacherAPI,caminho);

    $scope.changePasswordModalOpen = changePasswordModal.openModal;

    $scope.teacher = registroTO.data;
  });

})(angular.module('gerencia'));