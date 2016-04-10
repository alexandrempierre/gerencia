/**
 * Created by fausto.junqueira on 02/17/2016.
 */

angular.module('LCI.Angular',['ngRoute']);
angular.module('LCI.Mensagem', []);
angular.module('LCI.Menu', []);
angular.module('LCI.UsuarioLogado', []);
angular.module('LCI.Util',['LCI.Angular']);
angular.module('LCI.Dialogo',[
  'ui.bootstrap',
  'LCI.Angular'
]);
angular.module('LCI.Crud',['LCI.Angular','LCI.Util', 'LCI.Menu','LCI.Dialogo']);

angular.module('LCI',[
  'LCI.Angular',
  'LCI.Crud',
  'LCI.Dialogo',
  'LCI.Mensagem',
  'LCI.Menu',
  'LCI.UsuarioLogado',
  'LCI.Util'
]);