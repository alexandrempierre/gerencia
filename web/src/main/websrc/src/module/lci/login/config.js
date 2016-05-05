/**
 * Created by fausto on 4/26/16.
 */


(function(app){

  app.config(function($httpProvider){
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $httpProvider.interceptors.push('authenticatorInterceptor');
  });

})(angular.module('LCI.Login'));