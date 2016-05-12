/**
 * Created by fausto on 4/16/16.
 */

(function(app){
  app.service('userAPI', function($http){
    CrudAbstractService.call(this,$http);
    this.servicePath = 'user';

    //Troca a senha, basta salvar!
    this.changePassword = this.save;

  });
})(angular.module('gerencia'));