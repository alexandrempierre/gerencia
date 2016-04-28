/**
 * Created by fausto on 4/28/16.
 */


(function(app){

  app.provider('authenticationService', function(){
    var urlAuthentication = '';

    this.setUrlLogin = function(url){
      urlAuthentication = url;
    };

    this.$get = function($http){
      return {
        authenticate: function(credentials, callback) {
          var headers = credentials ? {
            authorization : "Basic " + btoa(credentials.name + ":" + credentials.password)
          } : {};

          $http.get('user', {headers : headers}).then(function(response) {
            $rootScope.authenticated = !!response.data.name;
            callback && callback();
          }, function() {
            $rootScope.authenticated = false;
            callback && callback();
          });
        }
      };
    };

  });

})(angular.module('LCI.Login'));