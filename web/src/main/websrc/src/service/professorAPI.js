/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.service('professorAPI', function($http){
    CrudAbstractService.call(this,$http);
    this.servicePath = 'professor';
  });
})(angular.module('gerencia'));