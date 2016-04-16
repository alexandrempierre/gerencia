package br.ufrj.dcc.gerencia.repository.implementation;

import br.ufrj.dcc.gerencia.dataaccess.entities.SambaInfoLDAPDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.SambaInfoLdapMapperUser;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.entities.SambaInfo;
import br.ufrj.dcc.gerencia.repository.base.RepositoryImpl;
import br.ufrj.dcc.gerencia.repository.contract.SambaInfoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/14/16.
 */

@Component
public class SambaInfoRepositoryImpl
  extends RepositoryImpl<SambaInfo, SambaInfoLdapMapperUser, SambaInfoLDAPDataAccess, LciLdapSpecification>
  implements SambaInfoRepository {

}
