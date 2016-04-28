/**
 * Created by fausto on 4/26/16.
 */


(function(app){

  app.config(function($routeProvider,$httpProvider, $authenticationServiceProvider){

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    $routeProvider.when('/login',{
      controller: 'loginController',
      controllerAs: 'vm',
      templateUrl: '/assets/view/module/lci/login/login.html'
    });

    $authenticationServiceProvider.setUrlLogin('');

  });

})(angular.module('LCI.Login'));