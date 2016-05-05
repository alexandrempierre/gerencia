/**
 * Created by fausto on 4/28/16.
 */


(function(app){

  app.factory('authenticatorInterceptor', function($q, credentialManager){

    return {
      request: function _requestAuthenticatorInterceptor(config){
        if(credentialManager.hasCredential()){
          config.headers.authorization = credentialManager.authorizationHeader(credentialManager.credential());
        }
        return config;
      },

      responseError: function _responseAuthenticatorInterceptor(response){
        if(response.status == 401){
          credentialManager.logout().withError();
          return $q.resolve(response);
        }else{
          return $q.reject(response);
        }
      }
    };

  });

})(angular.module('LCI.Login'));