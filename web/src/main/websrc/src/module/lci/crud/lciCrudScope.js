/**
 * Created by fausto on 2/4/16.
 */

(function(app){

  app.factory('lciCrudScope', function($rootScope, $location, $route,lciDialogoAPI,lciCaminhoUrl,crudConstants){

    function criarCaminhos(caminhoRaiz){
      return {
        filtrar: crudConstants.caminho.filtrar.format(caminhoRaiz),
        inserir: crudConstants.caminho.inserir.format(caminhoRaiz),
        editar: crudConstants.caminho.editar.format(caminhoRaiz)
      };
    }

    function irPara(caminho, objeto){
      $location.path(caminho).search(objeto);
      if (!$rootScope.$$phase) $rootScope.$apply();
    }

    function GerarScope(serviceAPI,caminhoRaiz){

      var self = this;

      function setFiltro(filtro){
        _filtro = filtro;
        lciCaminhoUrl.marcarFiltroNaUrl(filtro);
      }

      if(!serviceAPI){
        throw new Error("ServiceAPI is null");
      }
      caminhoRaiz = lciCaminhoUrl.removeSlashDoCaminho(caminhoRaiz) || "";
      caminho = criarCaminhos(caminhoRaiz);

      var _filtro = lciCaminhoUrl.buscarFiltroNaUrl() || {};

      self.list = [];

      function _resultadoBuscaFn(filtro) {
        return function (resultado) {
          if (filtro.pageInfo) {
            filtro.pageInfo.totalRegistros = resultado.data.totalRegister;
          }
          setFiltro(filtro);
          self.list = resultado.data || [];
        };
      }

      var _redirecionamento = {
        inserir: function _inserir(){
          _acao.filtro.limpar(_filtro);
          return irPara(caminho.inserir, _filtro);
        },

        editar: function _editar(id){
          return irPara(caminho.editar+'/'+id, _filtro);
        },

        filtrar: function _filtrar(){
          return irPara(caminho.filtrar, _filtro);
        }
      };

      var _acao = {
        filtro: {
          buscar: function _buscar(filtro){
            if(self.mapFiltro) filtro = self.mapFiltro(filtro);
            if(filtro.pageInfo){
              filtro.pageInfo.pageIndex = 1;
            }
            return serviceAPI.list(filtro).then(_resultadoBuscaFn(filtro));
          },

          buscarPagina: function(filtro){
            if(self.mapFiltro) filtro = self.mapFiltro(filtro);
            return serviceAPI.list(filtro).then(_resultadoBuscaFn(filtro));
          },

          limpar: function _limpar(filtro){
            for(var i in filtro){
              filtro[i] = '';
            }
          }
        },

        deletar: function _deletar(id){
          return lciDialogoAPI.confirmacao(
            crudConstants.deletar.titulo,
            crudConstants.deletar.mensagem,
            crudConstants.deletar.btnOk,
            crudConstants.deletar.btnFechar).then(function(){
            serviceAPI.delete(id).then(function(){
              self.filtrar(_filtro);
            });
          });
        },

        salvar: function _salvar(registro){
          return lciDialogoAPI.confirmacao(
            crudConstants.salvar.titulo,
            crudConstants.salvar.mensagem,
            crudConstants.salvar.btnOk,
            crudConstants.salvar.btnFechar).then(function(){
            serviceAPI.save(registro).then(function(){
              _redirecionamento.filtrar();
            });
          });
        }
      };

      self.inserir = _redirecionamento.inserir;
      self.editar = _redirecionamento.editar;
      self.filtrar = _redirecionamento.filtrar;
      self.buscar = _acao.filtro.buscar;
      self.buscarPagina = _acao.filtro.buscarPagina;
      self.limpar = _acao.filtro.limpar;
      self.deletar = _acao.deletar;
      self.salvar = _acao.salvar;

      //Para ser implementado pelo controller
      //self.mapFiltro

      self.getFiltro = function(){
        return _filtro;
      };
    }

    return {
      Scope: GerarScope
    };

  });

})(angular.module('LCI.Crud'));