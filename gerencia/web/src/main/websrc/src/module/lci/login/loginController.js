/**
 * Created by fausto on 4/26/16.
 */

(function(app){
  app.controller('loginController', function($rootScope, authenticateService, $location){
    var vm = this;
    vm.templateUrl = '/assets/view/module/lci/login/login.html';

    var loginSuccess = function(response){
      $location.path('/');
    };

    vm.credentials = {};
    vm.login = function() {
      return authenticateService.getUserByCredential(vm.credentials).then(loginSuccess);
    };

    //O login inicial, ele tenta logar, mas senão conseguir, nao deve apresentar o erro.
    vm.login().then(angular.noop, function(response){
      if(response.status == 401){
        $rootScope.authenticatedError = false;
      }
    });

  });
})(angular.module('LCI.Login'));