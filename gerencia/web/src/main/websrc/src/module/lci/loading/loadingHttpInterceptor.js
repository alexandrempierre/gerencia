/**
 * Created by fausto on 6/2/16.
 */

(function(app){

  app.factory('loadingHttpInterceptor', function($q, blockUI){

    function checkBlockUi(config, fn){
      if(config.blockUi){
        if(fn) fn();
      }
    }

    function applyBlockUi(config){
      checkBlockUi(config, function(){
        blockUI.start("Carregando ...");
      });
    }

    function removeBlockUi(config){
      checkBlockUi(config, function(){
        blockUI.stop();
      });
    }

    return {
      'request': function(config) {
        applyBlockUi(config);
        return config;
      },
      'requestError': function(rejection) {
        removeBlockUi(rejection.config);
        return $q.reject(rejection);
      },
      'response': function(response) {
        removeBlockUi(response.config);
        return response;
      },
      'responseError': function(rejection) {
        removeBlockUi(rejection.config);
        return $q.reject(rejection);
      }
    };

  });

})(angular.module('LCI.Loading'));