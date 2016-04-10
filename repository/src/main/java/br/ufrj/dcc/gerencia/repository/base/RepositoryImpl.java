package br.ufrj.dcc.gerencia.repository.base;

import br.ufrj.dcc.gerencia.dataaccess.base.CrudLdapDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.base.LCIAbstractContextMapper;
import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.base.LciModelPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fausto on 4/3/16.
 */

@Component
public abstract class RepositoryImpl<
  M extends LCIModel,
  Mapper extends LCIAbstractContextMapper<M>,
  DAO extends CrudLdapDataAccess<M, Mapper>,
  Spec extends LciLdapSpecification> implements Repository<M, Spec> {

  @Autowired
  protected DAO dataAccess;

  public DAO getDataAccess() {
    return dataAccess;
  }

  public M save(M register) {
    if (!register.isSaved()) {
      getDataAccess().create(register);
    } else {
      getDataAccess().update(register);
    }
    register.setSaved(true);
    return register;
  }

  public List<M> query(Spec specification) {
    List<M> list = getDataAccess().find(specification);
    list.forEach((x) -> x.setSaved(true));
    return list;
  }

  public M get(String uid) {
    M register = getDataAccess().findByKey(uid);
    register.setSaved(true);
    return register;
  }

  public M delete(String uid) {
    M register = getDataAccess().findByKey(uid);
    getDataAccess().delete(uid);
    register.setSaved(false);
    return register;
  }
}
