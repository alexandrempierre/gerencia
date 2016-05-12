package br.ufrj.dcc.gerencia.business.businessObjects;

import br.ufrj.dcc.gerencia.domain.entities.Person;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/14/16.
 */

@Component
public class PersonBO {

  public static void populate(Person person){
    person.setDisplayName(String.format("%s %s", person.getName(), person.getSurname()));
  }

}
