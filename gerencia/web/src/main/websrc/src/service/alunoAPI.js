/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.service('alunoAPI', function($q, $http){
    var self = this;
    LCIAbstractService.call(this,$http,'student');

    self.validateUniqueDRE = function _uniqueDRE(dre){
      return self.list({dre: dre}).then(function _uniqueDREcb(dataTO){
        if(dataTO.data && dataTO.data.length){
          return $q.reject(dataTO.data[0]);
        }else {
          return $q.resolve();
        }
      });
    };
  });
})(angular.module('gerencia'));