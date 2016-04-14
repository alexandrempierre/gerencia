package br.ufrj.dcc.gerencia.business.entities;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.business.businessObjects.PersonBO;
import br.ufrj.dcc.gerencia.business.businessObjects.SambaBO;
import br.ufrj.dcc.gerencia.business.businessObjects.ServerDataBO;
import br.ufrj.dcc.gerencia.business.businessObjects.ShadowObjBO;
import br.ufrj.dcc.gerencia.business.util.PasswordUtil;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import br.ufrj.dcc.gerencia.domain.specification.StudentSpecification;
import br.ufrj.dcc.gerencia.repository.contract.StudentRepository;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class StudentFacade extends CrudFacade<Student,StudentSpecification,StudentRepository> {

  @Override
  public Student save(Student register) {
    if (register.isSaved()){
      populateRegister(register);
    }
    return getRepository().save(register);
  }

  private void populateRegister(Student register){
    register.setServerData(ServerDataBO.createStudent(register));
    register.setSamba(SambaBO.create(register.getUser()));
    register.setShadow(ShadowObjBO.create());
    PersonBO.populate(register.getPerson());
    hashUserPassword(register);
  }

  private void hashUserPassword(Student register){
    register.getUser().setPassword(PasswordUtil.passowordHash(register.getUser().getPassword()));
  }

}
