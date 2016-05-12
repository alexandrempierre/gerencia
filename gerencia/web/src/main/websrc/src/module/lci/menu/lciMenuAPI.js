/**
 * Created by fausto on 2/11/16.
 */
(function(app){

  app.provider('lciMenuAPI', function(){
    var registrados = [];

    this.registrar = function(nome, link, pai){
      var menu = {nome: nome, link: link};
      if(pai){
        var filtrados = registrados.filter(function(x){ return x.nome == pai; });
        if (filtrados.length > 0){
          var paiEncontrado = filtrados[0];
          paiEncontrado.interno = paiEncontrado.interno || [];
          paiEncontrado.interno.push(menu);
        }else{
          throw new Error('Menu pai não encontrado!');
        }
      }else{
        registrados.push(menu);
      }
    };

    this.$get = function($rootScope){
      return {
        registrados: function registradosFn(){
          return registrados;
        },
        setTitulo: function _setTitulo(titulo){
          $rootScope.$emit('lciMenuCtrl.trocaTitulo', titulo);
        }
      };
    };
  });

  app.controller('lciMenuCtrl', function($rootScope, $scope, lciMenuAPI){
    this.templateUrl = 'module/lci/menu/template.html';
    this.listaMenu = lciMenuAPI.registrados();
    $scope.titulo = "";

    $rootScope.$on('lciMenuCtrl.trocaTitulo', function(e, titulo){
      $scope.titulo = titulo;
    });

  });

})(angular.module('LCI.Menu'));