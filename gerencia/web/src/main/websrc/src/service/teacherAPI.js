/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.service('teacherAPI', function($http){
    CrudAbstractService.call(this,$http);
    this.servicePath = 'teacher';
  });
})(angular.module('gerencia'));