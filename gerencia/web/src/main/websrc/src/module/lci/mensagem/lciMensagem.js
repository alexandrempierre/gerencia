/**
 * Created by fausto on 2/16/16.
 */

(function(app){
  app.directive('lciMensagem' ,function(){
    return {
      require: '^lciMensagens',
      retrict:'AE',
      scope:{
        caso: '@'
      },
      link:function(scope, element, attr, ctrl){
        ctrl.registrarMensagem(scope.caso, element);
      }
    };
  });
})(angular.module('LCI.Mensagem'));