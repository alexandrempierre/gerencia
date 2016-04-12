/**
 * Created by fausto on 2/16/16.
 */

(function(app){
  app.directive('lciMensagens', function(){
    return {
      scope:{
        expressao:'='//Caso mude o nome do expressao, veja na função registraMensagem que tem que mudar la tbm
      },
      controller: function($scope, $element, $attrs){
        var self = this;
        if(!$scope.expressao){
          throw new Error('LCIMensagens: Insira uma expressao nas mensagens');
        }

        var mensagens = [];

        function fecharTodasMensagens(mensagens){
          for(var i in mensagens){
            angular.element(mensagens[i].mensagem).hide();
          }
        }

        var renderizaMensagem = function(){
          fecharTodasMensagens(mensagens);
          for(var i in mensagens){
            if($scope.expressao[mensagens[i].chave]){
              angular.element(mensagens[i].mensagem).show();
              return;
            }
          }
        };

        this.registrarMensagem = function(chave, mensagem){
          mensagens.push({chave: chave, mensagem: mensagem});
          $scope.$watch('expressao.'+chave, renderizaMensagem);
        };
      }
    };
  });


})(angular.module('LCI.Mensagem'));