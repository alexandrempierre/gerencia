package br.ufrj.dcc.gerencia.repository.base;

import br.ufrj.dcc.gerencia.dataaccess.base.CrudLdapDataAccess;
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
  PO extends LciModelPO<M>,
  DAO extends CrudLdapDataAccess<PO>,
  Spec extends LciLdapSpecification> implements Repository<M, Spec> {

  @Autowired
  protected DAO dataAccess;

  public DAO getDataAccess() {
    return dataAccess;
  }

  public M save(M register) {
    PO registerPO = register.toPO();
    if (!registerPO.isSaved()) {
      getDataAccess().insert(registerPO);
    } else {
      getDataAccess().update(registerPO);
    }

    registerPO.setSaved(true);
    return registerPO.toModel();
  }

  public List<M> query(Spec specification) {
    List<PO> list = getDataAccess().list(specification);
    List<M> listModel = new ArrayList<>(list.size());

    list.forEach((x) -> listModel.add(x.toModel()));
    return listModel;
  }

  public M get(String uid) {
    return getDataAccess().getByUid(uid).toModel();
  }

  public M delete(String uid) {
    PO register = getDataAccess().getByUid(uid);
    getDataAccess().delete(register);
    return register.toModel();
  }
}
