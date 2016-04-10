/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('alunoFiltroCtrl', function(lciCrudScope, $scope, alunoAPI, listaTO, caminho, lciCrudPageInfo, alterarSenhaModal){
    lciCrudScope.Scope.call($scope, alunoAPI, caminho);
    $scope.abrirAlterarSenha = alterarSenhaModal.abrirModal;

    $scope.filtro = $scope.getFiltro();
    $scope.lista = listaTO.data.list || [];

    if(!$scope.filtro.pageInfo) $scope.filtro.pageInfo = lciCrudPageInfo;
    $scope.filtro.pageInfo.totalRegistros = listaTO.data.totalRegister;

    $scope.mapFiltro = function(filtro){
      if(filtro.infinito){
        filtro.expiracaoAte = filtro.expiracaoDe = null;
      }
      return filtro;
    };

  });

})(angular.module('gerencia'));