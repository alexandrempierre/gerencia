package br.ufrj.dcc.gerencia.dataaccess.mapper;

import br.ufrj.dcc.gerencia.dataaccess.base.LCIAbstractContextMapper;
import br.ufrj.dcc.gerencia.domain.entities.Example;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class ExampleLdapMapper extends LCIAbstractContextMapper<Example>{

  @Override
  protected Example doMapFromContext(DirContextOperations ctx) {
    Example example = new Example();
    example.setName(ctx.getStringAttribute("cn"));
    example.setId(ctx.getStringAttribute("uid"));
    return example;
  }
}
