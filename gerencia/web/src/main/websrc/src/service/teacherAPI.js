/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.service('teacherAPI', function($http){
    LCIAbstractService.call(this,$http,'teacher');
  });
})(angular.module('gerencia'));