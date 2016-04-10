/**
 * Created by fausto on 2/2/16.
 */
(function(app){
  app.service('sistemaAPI', function($http){
    CrudAbstractService.call(this,$http);
    this.servicePath = 'sistema';
  });
})(angular.module('gerencia'));