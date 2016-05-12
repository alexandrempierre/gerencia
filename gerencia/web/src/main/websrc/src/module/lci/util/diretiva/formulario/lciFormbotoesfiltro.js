/**
 * Created by fausto on 2/2/16.
 */

(function(app){
  app.directive('lciFormbotoesfiltro', function(){
    return {
      templateUrl:'/assets/view/module/lci/util/template/formulario/lciFormbotoesfiltro.html',
      restrict: 'E',
      require: 'ngModel',
      scope: {
        filtrar:'&',
        fnLimpar:'=',
        fnInserir:'&'
      },
      transclude: true,
      link: function(scope, element, attr, ctrl){
        element.find('.gerencia-formulario-botao-filtrar').on('click', function(){
          scope.filtrar();
        });
        element.find('.gerencia-formulario-botao-limpar').on('click', function(){
          var filtro = ctrl.$viewValue;
          scope.fnLimpar(filtro);
          ctrl.$setViewValue(filtro);
          ctrl.$render(filtro);
        });
      }
    };
  });

})(angular.module('LCI.Util'));
