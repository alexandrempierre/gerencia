/**
 * Created by fausto on 2/15/16.
 */


(function(app){
  app.directive('lciCapitalizeNome',function($filter){
    return {
      restrict: 'A',
      require:'ngModel',
      link: function(scope,element,attr,ngModel){

        function capitalize(nome){
          //Casos de preposições como do, de, da, das, dos devem ficar em minusculo
          var regexPreposicao = /^d(a|e|o|as|os)$/gi;

          var nomeSplitado = nome.split(' ');
          var nomeCapitalizado = nomeSplitado.map(function(nome){
            if(nome && nome !== ' '){
              if(regexPreposicao.test(nome)){
                return nome.toLowerCase();
              }else{
                return nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
              }
            }else{
              return nome;
            }
          });

          nomeCapitalizado = nomeCapitalizado || [];
          return nomeCapitalizado.join(' ');
        }

        element.on('change', function(){
          var nome = ngModel.$viewValue;
          if(nome !== ''){
            ngModel.$setViewValue(capitalize(nome));
            ngModel.$render();
          }
        });
      }
    };
  });

})(angular.module('LCI.Util'));