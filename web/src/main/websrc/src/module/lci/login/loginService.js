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
        authenticate: function(credentials) {
          var headers =
            credentials ?
              {authorization : "Basic " + btoa(credentials.uid + ":" + credentials.password)} :
              {};

          $http.get(urlAuthentication, {headers : headers});
        }
      };
    };

  });

})(angular.module('LCI.Login'));