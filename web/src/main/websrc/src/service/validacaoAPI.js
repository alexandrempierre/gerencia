/**
 * Created by fausto on 2/16/16.
 */

(function(app){

  app.service('validacaoAPI', function($q){

    var promisseBoba = $q(function(resolve, reject){
      return resolve();
    });

    this.loginUnico = function(usuarioAPI){
      return function _loginUnico(login){
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
    };
  });

})(angular.module('gerencia'));