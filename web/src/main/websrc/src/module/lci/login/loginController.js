/**
 * Created by fausto on 4/26/16.
 */

(function(app){
  app.controller('loginController', function(authenticateService, $location){
    var vm = this;
    vm.templateUrl = '/assets/view/module/lci/login/login.html';

    vm.credentials = {};
    vm.login = function() {
      authenticateService.getUserByCredential(vm.credentials).then(function(response){
        $location.path('/');
      });
    };
  });
})(angular.module('LCI.Login'));