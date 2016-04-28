/**
 * Created by fausto on 4/26/16.
 */

(function(app){
  app.controller('loginController', function($rootScope, $location, authenticationService){

    var vm = this;
    
    vm.templateUrl = '/assets/view/module/lci/login/login.html';

    var loginFailed = function(){
      console.log("Falhou");
      $rootScope.authenticated = false;
      $rootScope.authenticatedError = true;
    };

    authenticationService.authenticate();
    vm.credentials = {};
    vm.login = function() {
      authenticationService.authenticate(vm.credentials).then(function(response) {
        $rootScope.authenticated = !!response.data.uid;
        if($rootScope.authenticated){
          $rootScope.authenticatedError = false;
        }else{
          loginFailed();
        }
      },loginFailed);
    };
  });
})(angular.module('LCI.Login'));