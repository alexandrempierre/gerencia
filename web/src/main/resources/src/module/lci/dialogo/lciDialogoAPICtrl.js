/**
 * Created by fausto on 2/11/16.
 */

(function(app){
  
  app.controller('lciDialogoAPICtrl', function($scope, $uibModalInstance, modalContentObj){
    angular.extend($scope, modalContentObj);

    $scope.fnOk = function(){
      $uibModalInstance.close(null);
    };

    $scope.fnFechar = function(){
      $uibModalInstance.dismiss('cancelar');
    };

  });

})(angular.module('LCI.Dialogo'));