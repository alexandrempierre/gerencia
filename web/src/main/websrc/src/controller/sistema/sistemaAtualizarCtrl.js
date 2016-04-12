/**
 * Created by fausto on 2/2/16.
 */

(function(app){
  app.controller('sistemaAtualizarCtrl', function(lciCrudScope, $scope, sistemaAPI, registroTO, caminho){
    lciCrudScope.Scope.call($scope,sistemaAPI,caminho);
    $scope.sistema = !registroTO ? {} : registroTO.data;
  });
  
})(angular.module('gerencia'));