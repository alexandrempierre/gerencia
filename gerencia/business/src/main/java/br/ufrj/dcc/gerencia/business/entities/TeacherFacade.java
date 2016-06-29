package br.ufrj.dcc.gerencia.business.entities;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.business.businessObjects.PersonBO;
import br.ufrj.dcc.gerencia.business.businessObjects.SambaBO;
import br.ufrj.dcc.gerencia.business.businessObjects.ServerDataBO;
import br.ufrj.dcc.gerencia.business.businessObjects.ShadowObjBO;
import br.ufrj.dcc.gerencia.domain.entities.SambaObj;
import br.ufrj.dcc.gerencia.domain.entities.Teacher;
import br.ufrj.dcc.gerencia.domain.specification.TeacherSpecification;
import br.ufrj.dcc.gerencia.repository.contract.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by fausto on 4/17/16.
 */

@Component
public class TeacherFacade extends CrudFacade<Teacher,TeacherSpecification,TeacherRepository>{


  @Autowired
  private SambaBO sambaBO;

  @Autowired
  private UserFacade userFacade;

  @Autowired
  private DirectoryFacade directoryFacade;

  @Override
  public Teacher save(Teacher register) {
    if (!register.isSaved()){
      populateRegister(register);
      try {
        directoryFacade.createTeacherDirectory(register.getUser().getLogin());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return super.save(register);
  }

  private void populateRegister(Teacher register){
    SambaObj sambaObj = sambaBO.create(register.getUser(), true);
    register.setSamba(sambaObj);
    register.setServerData(ServerDataBO.createTeacher(register, sambaObj.getSambaInfo().getUidNumber()));
    register.setShadow(ShadowObjBO.create(true));
    PersonBO.populate(register.getPerson());
    userFacade.hashPassword(register.getUser());
  }
}
