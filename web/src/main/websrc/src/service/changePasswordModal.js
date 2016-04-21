/**
 * Created by fausto on 2/18/16.
 */

(function(app){
  app.factory('changePasswordModal', function(userAPI,$uibModal){
    function openModal(user){

      return $uibModal.open({
        animation: true,
        templateUrl: '/assets/view/template/view/usuario/changePassword.html',
        controller: 'userChangePasswordCtrl',
        resolve: {
          userTO: function () {
            return userAPI.get(user.login);
          }
        }
      }).result;
    }

    return {
      openModal: openModal
    };
  });
})(angular.module('gerencia'));