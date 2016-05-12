/**
 * Created by fausto on 2/11/16.
 */


(function(app){
  app.constant('crudConstants',{
    caminho: {
      // {0} = caminho base
      filtrar: '{0}/',
      inserir: '{0}/inserir',
      editar: '{0}/editar'
    },
    url:{
      editarIdCampoNome: 'id'
    },
    resolveVar: {
      filtrar: 'listaTO',
      editar: 'registroTO',
      caminho: 'caminho'
    },
    deletar: {
      titulo:'Excluir',
      mensagem: "Deseja realmente deletar esse item?",
      btnOk: 'Sim',
      btnFechar:'Não'
    },
    salvar: {
      titulo:'Salvar',
      mensagem: "Deseja realmente salvar esse item?",
      btnOk: 'Sim',
      btnFechar:'Não'
    }
  });
})(angular.module('LCI.Crud'));