/**
 * Created by fausto.junqueira on 01/02/2016.
 */


(function(app){

  app.config(function(lciDialogoAPIProvider){

    lciDialogoAPIProvider.setContentDefault({
      titulo: 'Sem titulo',
      mensagem: 'Sem mensagem',
      botaoFechar: true,
      iconeClass: 'glyphicon glyphicon-warning-sign',
      botao: {
        fechar: { titulo: 'Não'},
        ok: { titulo: 'Sim'}
      }
    });
    lciDialogoAPIProvider.setInstanceDefault({
      animation: true,
      size: 'sm',
      templateUrl: '/view/module/lci/dialogo/template.html',
      controller: 'lciDialogoAPICtrl'
    });
  });

})(angular.module('LCI.Dialogo'));