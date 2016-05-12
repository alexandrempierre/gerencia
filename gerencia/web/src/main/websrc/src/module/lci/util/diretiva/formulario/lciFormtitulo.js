/**
 * Created by fausto on 2/2/16.
 */

(function(app){
  app.directive('lciFormtitulo',function(){
    return {
      template: '<div class="gerencia-formulario-header"><p class="lead"><span ng-transclude></span></p></div>',
      restrict: 'E',
      scope: {},
      transclude: true
    };
  });

})(angular.module('LCI.Util'));
