/**
 * Created by fausto on 2/4/16.
 */



(function(app){
  app.provider('lciDialogoAPI',function(){

    var modalInstDefault = null;

    var modalContentDefault = null;

    var ModalContent = {
      Confirmacao: function(titulo, mensagem, btnTituloOk, btnTituloFechar){
        angular.copy(modalContentDefault, this);

        this.titulo = titulo || this.titulo;
        this.mensagem = mensagem || this.mensagem;
        this.botao.fechar.titulo = this.botao.fechar.titulo || btnTituloFechar;
        this.botao.ok.titulo = this.botao.ok.titulo || btnTituloOk;
      },
      Alerta: function(titulo, mensagem, btnTituloOk) {
        ModalContent.Confirmacao.call(this, titulo, mensagem, btnTituloOk || 'Ok', '');
        delete this.botao.fechar;
      }
    };

    this.setContentDefault = function(obj){
      modalContentDefault = obj;
    };

    this.setInstanceDefault = function(obj){
      modalInstDefault = obj;
    };

    this.$get = function($uibModal){
      function criar(modalContentObj, modalInstObj){
        var modalContentObjModificado = {};
        angular.copy(modalContentDefault, modalContentObjModificado);
        angular.extend(modalContentObjModificado, modalContentObj);

        var modalInstObjModificado = {};
        angular.copy(modalInstDefault, modalInstObjModificado);
        angular.extend(modalInstObjModificado, modalInstObj);

        if(!modalInstObjModificado.resolve) modalInstObjModificado.resolve = {};
        modalInstObjModificado.resolve.modalContentObj = function(){
          return modalContentObjModificado;
        };
        return $uibModal.open(modalInstObjModificado).result;
      }

      function confirmacao(titulo, mensagem, btnTituloOk, btnTituloFechar){
        var content = new ModalContent.Confirmacao(titulo, mensagem, btnTituloOk, btnTituloFechar);
        return criar(content, modalInstDefault);
      }

      function alerta(titulo, mensagem, btnTituloOk){
        var content = new ModalContent.Alerta(titulo, mensagem, btnTituloOk);
        return criar(content, modalInstDefault);
      }

      return {
        criar: criar,
        confirmacao: confirmacao,
        alerta: alerta
      };
    };
  });

})(angular.module('LCI.Dialogo'));