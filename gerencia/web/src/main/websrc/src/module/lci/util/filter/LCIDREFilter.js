/**
 * Created by fausto on 2/21/16.
 */

angular.module('LCI.Util').filter('lciDREFilter', function () {
  return function (input) {
    var str = input + '';
    str = str.replace(/\D/g, '');
    str = str.replace(/(\d{8})(\d)$/, '$1-$2');
    return str;
  };
});

