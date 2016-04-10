/**
 * Created by fausto on 2/15/16.
 */


(function(app){

  app.directive('lciDate',function($filter){
    return {
      restrict: 'A',
      require:'ngModel',
      link: function(scope,element,attr,ctrl){
        element.on('change', function(){
          var dateStr = ctrl.$viewValue;
          if(/^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/g.test(dateStr)){
            ctrl.$setViewValue(dateStr);
            ctrl.$render();
          }
        });

        ctrl.$parsers.push(function(valor){
          var dataSplitado = valor.split('/');
          if(valor.length == 10){
            return new Date(dataSplitado[2], dataSplitado[1] - 1, dataSplitado[0]).getTime();
          }
        });

        ctrl.$formatters.push(function(valor) {
          if(!isNaN(valor=parseInt(valor))){
            return $filter('date')(valor, 'dd/MM/yyyy');
          }
        });

      }
    };
  });

})(angular.module('LCI.Util'));