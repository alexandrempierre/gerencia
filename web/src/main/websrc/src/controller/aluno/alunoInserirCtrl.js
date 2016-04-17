/**
 * Created by fausto on 2/18/16.
 */

(function(app){
  app.controller('alunoInserirCtrl', function(lciCrudScope,$scope,alunoAPI, caminho, validateAPI, defaultValues){
    lciCrudScope.Scope.call($scope,alunoAPI,caminho);

    // Para validar o login
    $scope.uniqueLogin = validateAPI.uniqueLogin;

    $scope.student = {
      user:{
        limitHDSpace: defaultValues.limitHDSpace
      },
      person: {}  
    };
  });

})(angular.module('gerencia'));