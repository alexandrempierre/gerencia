/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.service('alunoAPI', function($http){
    CrudAbstractService.call(this,$http);
    this.servicePath = 'aluno';
  });
})(angular.module('gerencia'));