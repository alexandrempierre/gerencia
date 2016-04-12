/**
 * Created by fausto on 2/16/16.
 */

(function(app){

  app.directive('lciValidacaoSenha', function(){

    return {
      require: 'ngModel',
      link: function(scope, element, attr, ngModel){

        var regexNumero = /\d/g;
        var regexMinusculo = /[a-z]/g;
        var regexMaiusculo = /[A-Z]/g;

        function setValidade(minuscula,maiuscula,numero){
          ngModel.$setValidity('validacaoSenhaMinuscula', minuscula);
          ngModel.$setValidity('validacaoSenhaMaiuscula', maiuscula);
          ngModel.$setValidity('validacaoSenhaNumero', numero);
        }

        function politicaDeSenha(senha){
          if(typeof senha !== 'string'){
            return senha;
          }

          var maiuscula,minuscula,numero;
          maiuscula = minuscula = numero = false;
          if(senha !== ""){
            for(var i = 0; i < senha.length; i++){
              var letra = senha[i];
              var ehNumero = regexNumero.test(letra);
              numero = ehNumero || numero;
              minuscula = !ehNumero && regexMinusculo.test(letra) || minuscula;
              maiuscula = !ehNumero && regexMaiusculo.test(letra) || maiuscula;
            }
          }

          setValidade(minuscula,maiuscula,numero);
          return senha;
        }

        ngModel.$parsers.push(politicaDeSenha);
      }
    };
  });

})(angular.module('LCI.Util'));
