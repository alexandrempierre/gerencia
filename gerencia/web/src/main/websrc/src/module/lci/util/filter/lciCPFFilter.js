/**
 * Created by fausto on 2/21/16.
 */

angular.module('LCI.Util').filter('lciCPFFilter', function () {
  return function (input) {
    var str = input + '';
    str = str.replace(/\D/g, '');
    str = str.replace(/(\d{3})(\d)/, '$1.$2');
    str = str.replace(/(\d{3})(\d)/, '$1.$2');
    str = str.replace(/(\d{3})(\d{1,2})$/, '$1-$2');
    return str;
  };
});