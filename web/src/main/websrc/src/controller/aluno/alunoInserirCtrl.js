/**
 * Created by fausto on 2/18/16.
 */

(function(app){
  app.controller('alunoInserirCtrl', function(lciCrudScope,$scope,alunoAPI, caminho, validacaoAPI, defaultValues){
    lciCrudScope.Scope.call($scope,alunoAPI,caminho);

    // Para validar o login
    $scope.loginUnico = validacaoAPI.loginUnico(alunoAPI);

    $scope.aluno = {
      user:{
        limitHDSpace: defaultValues.limitHDSpace
      },
      person: {}  
    };
  });

})(angular.module('gerencia'));