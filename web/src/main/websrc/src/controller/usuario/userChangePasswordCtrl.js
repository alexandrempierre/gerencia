/**
 * Created by fausto on 2/18/16.
 */

(function(app){

  app.controller('userChangePasswordCtrl', function($scope, $uibModalInstance,userAPI,userTO){
    $scope.user = userTO.data;
    $scope.user.password = '';
    $scope.user.rpassword = '';

    $scope.save = function(register){
      userAPI.changePassword(register).then(function(){
        $uibModalInstance.close(register);
      });
    };

    $scope.cancel = function(){
      $uibModalInstance.dismiss('cancel');
    };

  });

})(angular.module('gerencia'));