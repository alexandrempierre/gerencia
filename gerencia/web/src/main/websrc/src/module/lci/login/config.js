/**
 * Created by fausto on 4/26/16.
 */


(function(app){

  app.config(function($httpProvider, credentialManagerProvider){
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $httpProvider.interceptors.push('authenticatorInterceptor');

    credentialManagerProvider.setCookieKey('lciauthkey');
    credentialManagerProvider.setExpiredLogin(7*24*60); //1 semana
  });

})(angular.module('LCI.Login'));