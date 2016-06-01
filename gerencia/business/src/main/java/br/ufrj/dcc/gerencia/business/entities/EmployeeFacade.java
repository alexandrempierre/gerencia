package br.ufrj.dcc.gerencia.business.entities;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.business.businessObjects.PersonBO;
import br.ufrj.dcc.gerencia.business.businessObjects.SambaBO;
import br.ufrj.dcc.gerencia.business.businessObjects.ServerDataBO;
import br.ufrj.dcc.gerencia.business.businessObjects.ShadowObjBO;
import br.ufrj.dcc.gerencia.domain.entities.Employee;
import br.ufrj.dcc.gerencia.domain.entities.SambaObj;
import br.ufrj.dcc.gerencia.domain.specification.EmployeeSpecification;
import br.ufrj.dcc.gerencia.repository.contract.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by fausto on 5/31/16.
 */

@Component
public class EmployeeFacade extends CrudFacade<Employee,EmployeeSpecification,EmployeeRepository> {

  @Autowired
  private SambaBO sambaBO;

  @Autowired
  private UserFacade userFacade;

  @Autowired
  private DirectoryFacade directoryFacade;

  @Override
  public Employee save(Employee register) {
    if (!register.isSaved()){
      populateRegister(register);
      try {
        directoryFacade.createTeacherDirectory(register.getUser().getLogin());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return getRepository().save(register);
  }

  private void populateRegister(Employee register){
    SambaObj sambaObj = sambaBO.create(register.getUser(), true);
    register.setSamba(sambaObj);
    register.setServerData(ServerDataBO.createEmployee(register, sambaObj.getSambaInfo().getUidNumber()));
    register.setShadow(ShadowObjBO.create(true));
    PersonBO.populate(register.getPerson());
    userFacade.hashPassword(register.getUser());
  }

}
