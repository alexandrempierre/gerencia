/**
 * Created by fausto on 2/2/16.
 */

(function(app){
  app.controller('sistemaCtrl', function(lciCrudScope, $scope, sistemaAPI, listaTO, caminho, lciCrudPageInfo){
    lciCrudScope.Scope.call($scope, sistemaAPI, caminho);
    $scope.filtro = $scope.getFiltro();
    $scope.lista = listaTO.data.list || [];

    if(!$scope.filtro.pageInfo) $scope.filtro.pageInfo = lciCrudPageInfo;
    $scope.filtro.pageInfo.totalRegistros = listaTO.data.totalRegister;

  });
  
})(angular.module('gerencia'));