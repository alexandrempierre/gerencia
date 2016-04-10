package br.ufrj.dcc.gerencia.service.entities;

import br.ufrj.dcc.gerencia.business.entities.StudentBO;
import br.ufrj.dcc.gerencia.contract.entities.StudentContract;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import br.ufrj.dcc.gerencia.domain.specification.StudentSpecification;
import br.ufrj.dcc.gerencia.repository.contract.StudentRepository;
import br.ufrj.dcc.gerencia.service.base.CrudRestAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fausto on 4/10/16.
 */

@RestController
@RequestMapping("/student")
public class StudentAPI extends
  CrudRestAPI<Student, StudentSpecification,StudentBO, StudentRepository> implements StudentContract {

  @RequestMapping("/teste")
  public Student teste(){
    return get("faustofjunqueira");
  }

}