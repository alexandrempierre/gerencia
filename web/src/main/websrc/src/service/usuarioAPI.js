/**
 * Created by fausto on 2/17/16.
 */

(function(app){

  app.service('usuarioAPI', function($http){
    var self = this;
    CrudAbstractService.call(this, $http);
    this.servicePath = 'usuario';

    this.alterarSenha = function(registro){
      return $http.post("/" + self.servicePath + '/alterarSenha', registro);
    };

  });

})(angular.module('gerencia'));