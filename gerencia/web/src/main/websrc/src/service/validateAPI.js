/**
 * Created by fausto on 2/16/16.
 */

(function(app){

  app.service('validateAPI', function(userAPI, $q){

    var promisseFoo = $q(function(resolve, reject){
      return resolve();
    });

    this.uniqueLogin = function _loginUnique(login){
        if(login.length > 0){
          return userAPI.get(login).then(
            function _resolve(loginTO){
              var user = loginTO.data;
              if(user){
                return $q.reject(user);
              }else{
                return $q.resolve(user);
              }
            }
          );
        }else{
          return promisseFoo;
        }
      };
  });

})(angular.module('gerencia'));