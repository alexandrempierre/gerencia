package br.ufrj.dcc.gerencia.service.entities;

import br.ufrj.dcc.gerencia.business.entities.StudentFacade;
import br.ufrj.dcc.gerencia.contract.entities.StudentContract;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import br.ufrj.dcc.gerencia.domain.specification.StudentSpecification;
import br.ufrj.dcc.gerencia.repository.contract.StudentRepository;
import br.ufrj.dcc.gerencia.service.base.CrudRestAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fausto on 4/10/16.
 */

@RestController
@RequestMapping("/api/student")
public class StudentAPI extends
  CrudRestAPI<Student, StudentSpecification, StudentFacade, StudentRepository> implements StudentContract {

  @Override
  @RequestMapping(value="/save", method= RequestMethod.POST)
  public Student save(Student register) {
    System.out.println("register.getUser().getLimitHDSpace(): " + register.getUser().getLimitHDSpace());
    System.out.println("register.getUser().getLogin(): " + register.getUser().getLogin());
    System.out.println("register.getUser().getPassword(): " + register.getUser().getPassword());
    System.out.println("register.getUser().getMail(): " + register.getUser().getMail());
    System.out.println("register.getPerson().getName(): " + register.getPerson().getName());
    System.out.println("register.getPerson().getSurname(): " + register.getPerson().getSurname());
    System.out.println("register.getPerson().getExternMail(): " + register.getPerson().getExternMail());
    System.out.println("register.getPerson().getPhoneNumber(): " + register.getPerson().getPhoneNumber());
    System.out.println("register.getPerson().getDisplayName(): " + register.getPerson().getDisplayName());
    System.out.println("register.getShadow()getShadowExpire(): " + register.getShadow().getShadowExpire());
    System.out.println("register.getShadow()getShadowFlag(): " + register.getShadow().getShadowFlag());
    return register;
    //return super.save(register);
  }
}