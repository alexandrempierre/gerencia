/**
 * Created by fausto on 5/4/16.
 */


(function(app){

  app.service('authenticateService', function($http, credentialManager){
    CrudAbstractService.call(this,$http);
    this.servicePath = 'user';

    this.getUserByCredential = function(credentials){
      if(!credentials || (credentials && !credentials.uid)){
        credentials = credentialManager.credential();
      }else{
        credentialManager.credential(credentials);
      }

      var uid = credentials ? credentials.uid : "";

      return this.get(uid).then(function(response){
        credentialManager.login(response.data);
      });
    };

  });

})(angular.module('LCI.Login'));
