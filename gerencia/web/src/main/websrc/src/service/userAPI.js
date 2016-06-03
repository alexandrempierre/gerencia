/**
 * Created by fausto on 4/16/16.
 */

(function(app){
  app.service('userAPI', function($http){
    LCIAbstractService.call(this,$http,'user');

    //Troca a senha, basta salvar!
    this.changePassword = this.save;

  });
})(angular.module('gerencia'));