/**
 * Created by fausto on 4/26/16.
 */


(function(app){

  app.config(function(authenticationServiceProvider){

    authenticationServiceProvider.setUrlLogin('/authentication/login');
  });

})(angular.module('LCI.Login'));