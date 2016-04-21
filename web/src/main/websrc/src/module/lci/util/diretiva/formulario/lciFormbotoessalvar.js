/**
 * Created by fausto on 2/2/16.
 */

(function(app){
  app.directive('lciFormbotoessalvar', function(){
    return {
      templateUrl:'/assets/view/module/lci/util/template/formulario/lciFormbotoessalvar.html',
      restrict: 'E',
      scope: {
        fnSalvar:'&',
        fnCancelar:'&',
        lciDisabled:'='
      },
      transclude: true,
      link: function(scope, element){
        element.find('.gerencia-formulario-botao-salvar').on('click', function(){
          scope.fnSalvar();
        });
        element.find('.gerencia-formulario-botao-voltar').on('click', function(){
          scope.fnCancelar();
        });
      }
    };
  });

})(angular.module('LCI.Util'));
