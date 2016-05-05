/**
 * Created by fausto on 2/13/16.
 */


(function(app){
  app.controller('lciUsuarioLogadoCtrl', function($scope, lciUsuarioLogadoConfig, credentialManager){
    angular.extend($scope,lciUsuarioLogadoConfig);
    this.templateUrl = lciUsuarioLogadoConfig.templateUrl;
    $scope.logout = function(){
      credentialManager.logout();
    };

  });
})(angular.module('LCI.UsuarioLogado'));