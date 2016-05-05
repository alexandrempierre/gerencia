/**
 * Created by fausto on 5/4/16.
 */

(function(app){

  app.service('credentialManager', function($rootScope){

    this.hasCredential = function(){
      return !!$rootScope.credentials;
    };

    this.user = function(userLogged){
      if(arguments.length){
        $rootScope.user = userLogged;
      }else{
        return $rootScope.user;
      }
    };

    this.credential = function (credential) {
      if(arguments.length){
        $rootScope.credentials = credential;
      }
      return $rootScope.credentials;
    };

    this.authorizationHeader = function buildAuthorization(){
      var credentials = this.credential();
      if(credentials){
        try {
          //authorization
          return "Basic " + btoa(credentials.uid + ":" + credentials.password);
        }catch (e){
          return null;
        }
      }else{
        return null;
      }
    };

    this.error = function(){
      $rootScope.authenticatedError = true;
    };

    this.logout = function(){
      var that = this;
      $rootScope.authenticated = false;
      $rootScope.authenticatedError = false;
      that.credential(null);
      this.user(null);
      return {
        withError: function(){
          that.error();
        }
      };
    };

    this.login = function(user){
      $rootScope.authenticated = true;
      $rootScope.authenticatedError = false;
      this.user(user);
    };

  });

})(angular.module('LCI.Login'));
