/**
 * Created by fausto on 6/3/16.
 */

var LCIAbstractService = function($http, pathModule){

  var parent = new CrudAbstractService($http);
  parent.servicePath = pathModule;

  var defaultConfig = {
    blockUi: true
  };

  function applyConfig(config){
    return angular.extend(angular.copy(defaultConfig,{}), config);
  }

  this.get = function(id, config) {
    config = applyConfig(config);
    return parent.get(id,config);
  };

  this.list = function(filter, config){
    config = applyConfig(config);
    return parent.list(filter,config);
  };

  this.save = function(register, config){
    config = applyConfig(config);
    return parent.save(register,config);
  };

  this.delete = function(id, config){
    config = applyConfig(config);
    return parent.delete(id,config);
  };
};
