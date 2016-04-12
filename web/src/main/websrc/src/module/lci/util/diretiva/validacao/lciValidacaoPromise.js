/**
 * Created by fausto on 2/16/16.
 */

(function(app){

  app.directive('lciValidacaoPromise', function(){

    return {
      require: 'ngModel',
      scope:{
        promiseFn: '='
      },
      link: function(scope, element, attr, ngModel){
        if(!scope.promiseFn){
          throw new Error('promise-fn não foi declarada!');
        }
        ngModel.$asyncValidators.validacaoPromise = function(modelValue, viewValue){
          var model = modelValue || viewValue;
          return scope.promiseFn(model);
        };
      }
    };
  });

})(angular.module('LCI.Util'));
