/**
 * Created by fausto on 6/2/16.
 */

(function(app){

  app.config(function($httpProvider){
    $httpProvider.interceptors.push('loadingHttpInterceptor');
  });

})(angular.module('LCI.Loading'));