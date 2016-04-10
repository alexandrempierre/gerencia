/**
 * Created by fausto on 2/18/16.
 */

(function(app){

  app.service('pessoaAPI', function($http, $q){
    CrudAbstractService.call(this, $http);
    this.servicePath = 'pessoa';

    this.getByCPF = function _getByCPF(CPF){
      return this.list({cpf: CPF}).then(function(registrosTO){
        return $q.resolve(registrosTO.data[0] || null);
      });
    };

  });

})(angular.module('gerencia'));