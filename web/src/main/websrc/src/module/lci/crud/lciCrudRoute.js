/**
 * Created by fausto on 2/11/16.
 */
(function(app) {

  app.provider('lciCrudRoute', function($routeProvider, lciMenuAPIProvider,lciCaminhoUrlProvider, crudConstants){

    function resolveCaminho(caminho, titulo){
      return function _resolveCaminho(lciMenuAPI){
        lciMenuAPI.setTitulo(titulo);
        return caminho;
      };
    }

    this.registrar = function _registrar(titulo, nome, pai, caminho, servicoAPI, pageInfo, filtroObj, editarObj, inserirObj) {
      caminho = lciCaminhoUrlProvider.removeSlashDoCaminho(caminho);
      if (!inserirObj) {
        inserirObj = editarObj;
      }

      if (!servicoAPI || !caminho || !filtroObj || !editarObj) {
        throw new Error('Objeto não instanciado em Criar Crud');
      }

      lciMenuAPIProvider.registrar(nome, '#/' + caminho, pai);

      // TODO: bom refactor seria criar um objeto default e coloca-lo como constant
      filtroObj.resolve = filtroObj.resolve || {};
      inserirObj.resolve = inserirObj.resolve || {};
      editarObj.resolve = editarObj.resolve || {};

      filtroObj.resolve[crudConstants.resolveVar.caminho] =
        editarObj.resolve[crudConstants.resolveVar.caminho] =
          inserirObj.resolve[crudConstants.resolveVar.caminho] =
            resolveCaminho(caminho, titulo);

      filtroObj.resolve[crudConstants.resolveVar.filtrar] = [servicoAPI, "lciCaminhoUrl", "lciMenuAPI",function (s, r, menu) {
        var filtro = r.buscarFiltroNaUrl() || {};
        return s.list(filtro);
      }];


      editarObj.resolve[crudConstants.resolveVar.editar] = [servicoAPI, "$route", "lciMenuAPI", function (s, r) {
        var id = r.current.params[crudConstants.url.editarIdCampoNome];
        if(id){
          return s.get(id);
        }else{
          return null;
        }
      }];

      var caminhoFiltrar = '/' + lciCaminhoUrlProvider.removeSlashDoCaminho(
        crudConstants.caminho.filtrar.format(caminho)
      );

      var caminhoEditar = '/' +
        lciCaminhoUrlProvider.removeSlashDoCaminho(
          crudConstants.caminho.editar.format(caminho)
        ) + '/:' + crudConstants.url.editarIdCampoNome;

      var caminhoInserir = '/' + lciCaminhoUrlProvider.removeSlashDoCaminho(
          crudConstants.caminho.inserir.format(caminho)
        );

      $routeProvider.when(caminhoFiltrar, filtroObj);
      $routeProvider.when(caminhoEditar, editarObj);
      $routeProvider.when(caminhoInserir, inserirObj);
    };

    this.$get = function _get(){
      return {};
    };

  });

})(angular.module('LCI.Crud'));