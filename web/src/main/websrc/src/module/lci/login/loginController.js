/**
 * Created by fausto on 4/26/16.
 */

(function(app){
  app.controller('loginController', function($rootScope, $scope, $location){
    $rootScope.autheticated = true;
    if($rootScope.autheticated){
      $location.path('/');
    }
  });
})(angular.module('LCI.Login'));