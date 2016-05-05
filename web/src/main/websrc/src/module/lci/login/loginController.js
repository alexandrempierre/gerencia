/**
 * Created by fausto on 4/26/16.
 */

(function(app){
  app.controller('loginController', function(authenticateService){
    var vm = this;
    vm.templateUrl = '/assets/view/module/lci/login/login.html';

    vm.credentials = {};
    vm.login = function() {
      authenticateService.getUserByCredential(vm.credentials);
    };
  });
})(angular.module('LCI.Login'));