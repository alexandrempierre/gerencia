/**
 * Created by fausto on 2/11/16.
 */
(function(app){

  app.controller('lciMenuCtrl', function($rootScope, $scope, lciMenuAPI){
    this.templateUrl = '/view/module/lci/menu/template.html';
    this.listaMenu = lciMenuAPI.registrados();
    $scope.titulo = "";

    $rootScope.$on('lciMenuCtrl.trocaTitulo', function(e, titulo){
      $scope.titulo = titulo;
    });

  });

})(angular.module('LCI.Menu'));