/**
 * Created by fausto on 2/18/16.
 */

(function(app){
  app.controller('professorInserirCtrl', function(lciCrudScope,$scope, teacherAPI, caminho, validateAPI, defaultValues){
    lciCrudScope.Scope.call($scope,teacherAPI,caminho);

    // Para validar o login
    $scope.uniqueLogin = validateAPI.uniqueLogin;

    $scope.teacher = {
      user:{
        limitHDSpace: defaultValues.limitHDSpace
      },
      person: {}
    };

  });

})(angular.module('gerencia'));