/**
 * Created by fausto on 2/16/16.
 */

(function(app){

  app.directive('lciValidacaoRepetirSenha', function(){

    return {
      require: 'ngModel',
      scope:{
        senha:'='
      },
      link: function(scope, element, attr, ngModel){

        function senhasIguais(repetirSenha){
          var validade = true;
          if(typeof repetirSenha === 'string' && scope.senha !== '' && repetirSenha !== ''){
            validade = scope.senha === repetirSenha;
          }
          ngModel.$setValidity('validacaoRepetirSenha', validade);
          return repetirSenha;
        }

        ngModel.$parsers.push(senhasIguais);
      }
    };
  });

})(angular.module('LCI.Util'));
