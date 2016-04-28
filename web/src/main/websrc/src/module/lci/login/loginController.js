/**
 * Created by fausto on 4/26/16.
 */

(function(app){
  app.controller('loginController', function($rootScope, $location, authenticationService){

    var vm = this;

    authenticationService.authenticate();
    vm.credentials = {};
    vm.login = function() {
      authenticationService.authenticate(vm.credentials, function() {
        if ($rootScope.authenticated) {
          $location.path("/");
          vm.error = false;
        } else {
          vm.error = true;
        }
      });
    };
  });
})(angular.module('LCI.Login'));