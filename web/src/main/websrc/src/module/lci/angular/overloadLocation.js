/**
 * Created by fausto.junqueira on 01/02/2016.
 */



(function(app){

  app.run(function($route, $rootScope, $location){
    var original = $location.path;
    $location.path = function (path, reload) {
      if (reload === false) {
        var lastRoute = $route.current;
        var un = $rootScope.$on('$locationChangeSuccess', function () {
          $route.current = lastRoute;
          un();
        });
      }
      return original.apply($location, [path]);
    };
  });

})(angular.module('LCI.Angular'));