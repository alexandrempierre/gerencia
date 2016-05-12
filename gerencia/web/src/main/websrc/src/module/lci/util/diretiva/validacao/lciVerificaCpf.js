/**
 * Created by fausto on 2/18/16.
 */


(function(app){

  // Referencia: http://www.devmedia.com.br/validar-cpf-com-javascript/23916
  function testaCPF(strCPF) {
    var Soma = 0;
    var Resto;

    if (strCPF == "00000000000") return false;

    for (i = 1; i <= 9; i++)
      Soma += parseInt(strCPF.substring(i - 1, i)) * (11 - i);

    Resto = (Soma * 10) % 11;
    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10))) return false;
    Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;
    if ((Resto == 10) || (Resto == 11)) Resto = 0;

    return Resto == parseInt(strCPF.substring(10, 11));
  }

  app.directive('lciVerificaCpf', function(){
    return {
      require: 'ngModel',
      link: function(scope, element, attr, ngModel){
        function verificaCPF(cpf){
          ngModel.$setValidity('verificaCpf', testaCPF(cpf));
          return cpf;
        }

        ngModel.$parsers.push(verificaCPF);
      }
    };
  });

})(angular.module('LCI.Util'));
