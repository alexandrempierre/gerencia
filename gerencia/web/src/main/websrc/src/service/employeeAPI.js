/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.service('employeeAPI', function($q, $http){
    CrudAbstractService.call(this,$http);
    this.servicePath = 'employee';
  });
})(angular.module('gerencia'));