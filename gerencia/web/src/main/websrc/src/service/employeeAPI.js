/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.service('employeeAPI', function($q, $http){
    LCIAbstractService.call(this,$http,'employee');
  });
})(angular.module('gerencia'));