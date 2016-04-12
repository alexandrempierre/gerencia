/**
 * Created by fausto on 2/20/16.
 */

(function(app){

  app.provider('lciCaminhoUrl', function(){

    function AdicionaSlashNoCaminho(caminho){
      if(caminho[0] == '/') return caminho;
      else return '/' + caminho;
    }

    function AdicionaSharpNoCaminho(caminho){
      if(caminho[0] == '#'){
        return caminho;
      }else{
        return "#"+AdicionaSlashNoCaminho(caminho);
      }
    }

    function removeSlashDoCaminho(caminho){
      if(caminho[0] == '/')
        caminho = caminho.substring(1);
      if(caminho[caminho.length -1] == '/')
        caminho = caminho.substring(0, caminho.length-1);
      return caminho;
    }



    function getCaminho(){
      var caminhoCompleto = [];
      for(var i in arguments){
        if(arguments[i] && typeof arguments[i] == 'string'){
          caminhoCompleto.push(removeSlashDoCaminho(arguments[i]));
        }
      }
      return caminhoCompleto.join('/');
    }

    this.AdicionaSharpNoCaminho = AdicionaSharpNoCaminho;
    this.AdicionaSlashNoCaminho = AdicionaSlashNoCaminho;
    this.removeSlashDoCaminho = removeSlashDoCaminho;
    this.getCaminho = getCaminho;

    this.$get = function($route, $location){
      return {
        buscarFiltroNaUrl: function _buscarFiltroNaUrl(){
          var param = $location.search();
          if(param && param.obj){
            return JSON.parse(param.obj);
          } else {
            return {};
          }
        },
        getCaminho: getCaminho,
        marcarFiltroNaUrl: function _marcarFiltroNaUrl(filtro){
          if(filtro){
            $location.path($location.path(), false).search({obj: JSON.stringify(filtro)});
          }
        },
        AdicionaSharpNoCaminho: AdicionaSharpNoCaminho,
        AdicionaSlashNoCaminho: AdicionaSlashNoCaminho,
        removeSlashDoCaminho: removeSlashDoCaminho
      };
    };


  });

})(angular.module('LCI.Util'));