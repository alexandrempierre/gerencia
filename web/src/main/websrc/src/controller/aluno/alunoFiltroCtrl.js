/**
 * Created by fausto on 2/14/16.
 */

(function(app){
  app.controller('alunoFiltroCtrl', function(lciCrudScope, $scope, alunoAPI, listaTO, caminho, lciCrudPageInfo, alterarSenhaModal){
    lciCrudScope.Scope.call($scope, alunoAPI, caminho);
    $scope.abrirAlterarSenha = alterarSenhaModal.abrirModal;

    $scope.filtro = $scope.getFiltro();
    $scope.lista = listaTO.data || [];

    $scope.mapFiltro = function(filtro){
      if(filtro.infinito){
        filtro.from = filtro.to = null;
      }
      return filtro;
    };

  });

})(angular.module('gerencia'));