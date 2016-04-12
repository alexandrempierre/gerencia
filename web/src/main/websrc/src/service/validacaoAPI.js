/**
 * Created by fausto on 2/16/16.
 */

(function(app){

  app.service('validacaoAPI', function(usuarioAPI, pessoaAPI, $q){

    var promisseBoba = $q(function(resolve, reject){
      return resolve();
    });

    this.loginUnico = function _loginUnico(login){
      if(login.length > 0){
        return usuarioAPI.get(login).then(
          function _resolve(loginTO){
            var usuario = loginTO.data;
            if(usuario){
              return $q.reject(usuario);
            }else{
              return $q.resolve(usuario);
            }
          }
        );
      }else{
        return promisseBoba;
      }
    };

    this.cpfUnico = function _cpfUnico(cpf){
      if(cpf.length > 0){
        return pessoaAPI.getByCPF(cpf).then(
          function _resolve(registro){
            if(registro){
              return $q.reject(registro);
            }else{
              return $q.resolve(registro);
            }
          }
        );
      }else{
        return promisseBoba;
      }
    };
  });

})(angular.module('gerencia'));