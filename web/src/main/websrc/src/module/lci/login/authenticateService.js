/**
 * Created by fausto on 5/4/16.
 */


(function(app){

  app.service('authenticateService', function($http, credentialManager){
    CrudAbstractService.call(this,$http);
    this.servicePath = 'user';

    this.getUserByCredential = function(credentials){
      credentialManager.credential(credentials);
      this.get(credentials.uid).then(function(response){
        credentialManager.login(response.data);
      });
    };

  });

})(angular.module('LCI.Login'));
