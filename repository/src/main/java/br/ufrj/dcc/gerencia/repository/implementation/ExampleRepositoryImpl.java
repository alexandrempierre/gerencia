package br.ufrj.dcc.gerencia.repository.implementation;

import br.ufrj.dcc.gerencia.dataaccess.entities.ExampleLDAPDataAccessBase;
import br.ufrj.dcc.gerencia.dataaccess.mapper.ExampleLdapMapper;
import br.ufrj.dcc.gerencia.domain.entities.Example;
import br.ufrj.dcc.gerencia.domain.specification.ExampleSpecification;
import br.ufrj.dcc.gerencia.repository.base.RepositoryImpl;
import br.ufrj.dcc.gerencia.repository.contract.ExampleRepository;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/4/16.
 */

@Component
public class ExampleRepositoryImpl extends
  RepositoryImpl<Example,ExampleLdapMapper,ExampleLDAPDataAccessBase,ExampleSpecification> implements ExampleRepository {

}
