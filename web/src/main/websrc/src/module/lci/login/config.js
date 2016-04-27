/**
 * Created by fausto on 4/26/16.
 */


(function(app){

  app.config(function($routeProvider){

    $routeProvider.when('/login',{
      controller: 'loginController',
      controllerAs: 'vm',
      templateUrl: '/assets/view/module/lci/login/login.html'
    });

    $routeProvider.otherwise('/login');

  });

})(angular.module('LCI.Login'));