/**
 * Created by fausto on 2/13/16.
 */


(function(app){
  app.controller('lciUsuarioLogadoCtrl', function($scope, lciUsuarioLogadoConfig){
    angular.extend($scope,lciUsuarioLogadoConfig);
    this.templateUrl = lciUsuarioLogadoConfig.templateUrl;
  });
})(angular.module('LCI.UsuarioLogado'));