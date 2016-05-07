/**
 * Created by fausto on 5/4/16.
 */

(function(app){

  app.provider('credentialManager', function(){

    var cookieKey = "";
    var expiredLogin = 1; //In minutes
    var expiredSession = 10;

    this.setCookieKey = function(_cookieKey){
      cookieKey = _cookieKey;
    };

    this.setExpiredLogin = function(_expiredLogin){
      expiredLogin = _expiredLogin;
    };

    this.$get = function($rootScope, $cookies){

      var cookieStore = function(credential){
        if(credential && credential.uid) {
          $cookies.putObject(cookieKey, credential);
          cookieExpireUpdate();
        }
      };

      var cookieExpireUpdate = function(){
        var credential = $cookies.getObject(cookieKey);
        if(credential && credential.uid) {
          var now = moment();
          var dateExpire;
          if (credential && credential.keep) {
            dateExpire = now.add(expiredLogin, 'minute').toDate();
          } else { // +3 minutos
            dateExpire = now.add(expiredSession, 'minute').toDate();
          }
          $cookies.putObject(cookieKey, credential, {expires: dateExpire});
        }
      };

      var cookieGet = function(){
        return $cookies.getObject(cookieKey);
      };

      var cookieRemove = function(){
        $cookies.remove(cookieKey);
      };

      var hasCredential = function(){
        return !!credential();
      };

      var user = function(userLogged){
        if(arguments.length){
          $rootScope.user = userLogged;
        }else{
          return $rootScope.user;
        }
      };

      var credential = function (credential) {
        if(arguments.length){
          $rootScope.credentials = credential;
          if(credential){
            cookieStore(credential);
          }else{
            cookieRemove();
          }
        }else{
          if(!$rootScope.credentials || ($rootScope.credentials && !$rootScope.credentials.uid)){
            $rootScope.credentials = cookieGet();
          }
          cookieExpireUpdate();
        }
        return $rootScope.credentials;
      };

      var authorizationHeader = function buildAuthorization(){
        var credentials = credential();
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

      var error = function(){
        $rootScope.authenticatedError = true;
      };

      var logout = function(){
        $rootScope.authenticated = false;
        $rootScope.authenticatedError = false;
        credential(null);
        user(null);
        return {
          withError: function(){
            error();
          }
        };
      };

      var login = function(_user){
        $rootScope.authenticated = true;
        $rootScope.authenticatedError = false;
        user(_user);
      };

      return {
        hasCredential: hasCredential,
        user: user,
        credential: credential,
        authorizationHeader: authorizationHeader,
        error: error,
        logout: logout,
        login: login
      };
    };
  });

})(angular.module('LCI.Login'));
