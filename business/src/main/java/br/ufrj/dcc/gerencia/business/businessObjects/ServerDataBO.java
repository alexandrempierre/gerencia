package br.ufrj.dcc.gerencia.business.businessObjects;

import br.ufrj.dcc.gerencia.business.util.StringUtil;
import br.ufrj.dcc.gerencia.domain.entities.ServerData;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import org.springframework.stereotype.Component;
import br.ufrj.dcc.gerencia.domain.auxiliar.GerenciaDefaultConstraint;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class ServerDataBO {

  public static ServerData createStudent(Student student) {
    ServerData serverData = new ServerData();

    serverData.setHomeDirectory(
      String.format(GerenciaDefaultConstraint.HOME_DIRECTORY_STUDENT_TEMPLATE, student.getUser().getLogin()));

    serverData.setGecos(
      StringUtil.removeAccent(student.getPerson().getName() + " " + student.getPerson().getSurname()));

    serverData.setLoginShellApplication(GerenciaDefaultConstraint.LOGIN_SHELL);

    serverData.setGidNumber(GerenciaDefaultConstraint.GID_NUMBER);

    //TODO: fazer o serverData.setUidNumber(); colocar o incremental


    return serverData;
  }

}
