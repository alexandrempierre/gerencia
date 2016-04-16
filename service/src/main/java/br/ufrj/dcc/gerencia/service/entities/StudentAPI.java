package br.ufrj.dcc.gerencia.service.entities;

import br.ufrj.dcc.gerencia.business.entities.StudentFacade;
import br.ufrj.dcc.gerencia.contract.entities.StudentContract;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import br.ufrj.dcc.gerencia.domain.specification.StudentSpecification;
import br.ufrj.dcc.gerencia.repository.contract.StudentRepository;
import br.ufrj.dcc.gerencia.service.base.CrudRestAPI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fausto on 4/10/16.
 */

@RestController
@RequestMapping("/api/student")
public class StudentAPI extends
  CrudRestAPI<Student, StudentSpecification, StudentFacade, StudentRepository> implements StudentContract {

  @RequestMapping(value="/save", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Student save(@RequestBody Student student) {
    return super.save(student);
  }
}